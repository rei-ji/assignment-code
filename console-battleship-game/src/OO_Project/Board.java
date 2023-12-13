package OO_Project;

import java.util.ArrayList;

//board has a boat
public class Board {
	private ArrayList<RiverObject> river = new ArrayList<RiverObject>();
	private Boat boat1;
	private Boat boat2;
	
	public Board(Boat boat1, Boat boat2) {
		this.boat1 = boat1;
		this.boat2 = boat2;
		//generate empty river
		for(int i=0;i<100;i++) {
			river.add(null);
		}
		
		//generate traps
		generateTrap(10, 1, 3);
		//generate strong traps
		generateTrap(5, 4, 5);
			
		//generate currents
		generateCurrent(10, 1, 3);
		//generate strong currents
		generateCurrent(5, 4, 5);
	}
	
	//generate traps
	//quantity controls number of traps generated, valueStart and valueEnd controls the lowest and highest strength to generate for the trap
	//allows us to control the type and number of traps randomly generated
	public void generateTrap(int quantity, int valueStart, int valueEnd) {
		for(int i=0;i<quantity;i++) {
			Trap t = new Trap(valueStart, valueEnd);
			
			if(river.get(t.getPosition()) == null) {
				 river.set(t.getPosition(), t);
			}
			
			else {
				i--;
			}
		}
	}
	
	//generate currents
	//quantity controls number of traps generated, valueStart and valueEnd controls the lowest and highest strength to generate for the current
	//allows us to control the type and number of current randomly generated
	public void generateCurrent(int quantity, int valueStart, int valueEnd) {
		for(int i=0;i<quantity;i++) {
			Current c = new Current(valueStart, valueEnd);
			
			if(river.get(c.getPosition()) == null) {
				 river.set(c.getPosition(), c);
			}
			
			else {
				i--;
			}
		}
	}
	
	public void printRiver() {
		int counter = 0;
		while (counter < 2) {
			for (int i=0;i<100;i++) {
				System.out.print("|");
				
				if ((counter == 0) && (boat1.getPosition() == i)) {
					System.out.print("X");
				}
				
				else if ((counter == 1) && (boat2.getPosition() == i)) {
					System.out.print("O");
				}
				
				else if (river.get(i) instanceof Trap) {
					System.out.print(((Trap)river.get(i)).getSymbol());
				}
				
				else if (river.get(i) instanceof Current) {
					System.out.print(((Current)river.get(i)).getSymbol());
				}
				
				else {
					System.out.print(" ");
				}
			}
			
			System.out.print("|");
			System.out.println();
			
			counter ++;
		}
	}
	
	//trigger RiverObject
	public void triggerRiverObject(Player player, Boat boat) {
		//send player back if hit trap
		while (river.get(boat.getPosition()) != null) {
			if (river.get(boat.getPosition()) instanceof Trap) {
				int trapValue = ((Trap)river.get(boat.getPosition())).getValue();
				System.out.println("Ouch! Hit a " + river.get(boat.getPosition()) + ". Going back " + trapValue + " spaces.");
				//disable trap after triggeredcheckBoatPosition(player, boat);
				river.set(boat.getPosition(), null);
				boat.setPosition(boat.getPosition() - trapValue);
				boat.checkPosition();
				boat.incrementTrapsEncountered();
			}
		
			//send player front if hit current
			else if (river.get(boat.getPosition()) instanceof Current) {
				int currentValue = ((Current)river.get(boat.getPosition())).getValue();
				System.out.println("Whee! Riding a " + river.get(boat.getPosition()) + ". Going forward " + currentValue + " spaces.");
				boat.setPosition(boat.getPosition() + currentValue);
				boat.checkPosition();
				boat.incrementCurrentsEncountered();
			}
		}
	}
	
}

