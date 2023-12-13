package OO_Project;

import java.util.Random;

//boat has a player
public class Boat {
	private int position;
	private int trapsEncountered;
	private int currentsEncountered;
	private boolean win;
	private Player player;


	public Boat(Player player) {
		this.player = player;
	    position = 0;
	    trapsEncountered = 0;
	    currentsEncountered = 0;
	    win = false;
	}

	public int getPosition() {
	    return position;
	}
		
	public void setPosition(int position) {
	    this.position = position;
	}
		
	public boolean getWin() {
		return win;
	}
		
	public void setWin(boolean win) {
		this.win = win;
	}
		
	public int getTrapsEncountered() {
	    return trapsEncountered;
	}
		
	public int getCurrentsEncountered() {
	    return currentsEncountered;
	}
		
	public void incrementTrapsEncountered() {
		trapsEncountered ++;
	}
		
	public void incrementCurrentsEncountered() {
		currentsEncountered ++;
	}
		
	// Method to simulate rolling a dice and get a random dice value
	private int rollDice() {
		Random random = new Random();
	    int randomIndex = random.nextInt(player.getMyDice().length);
	    int rollDiceValue = player.getMyDice()[randomIndex];
	    System.out.println("Rolled a " + rollDiceValue + ".");
	    return rollDiceValue; // Update player location
	}
		
	// Method to roll dice and move boat
	public void rollDiceAndMove() {
	    int rollValue = rollDice();
	    System.out.println("Moving forward " + rollValue + " spaces.");
	    position += rollValue;
	    checkPosition();
	}
		
	// method to check boat position to keep boat within the board and determine win condition
	public void checkPosition() {
		if ((position > 99) || (position == 99)) {
			position = 99;
			win = true;
			System.out.println(player.getPlayerName() + " has passed the finishing line!");
		}
		
		else if ((position < 0) || position == 0) {
			position = 0;
			System.out.println("Back at Start.");
		}
	}

	@Override
	public String toString() {
		return String.format("%s's boat\nTraps Encountered: %d\nCurrents Encountered: %d", player.getPlayerName(), getTrapsEncountered(), getCurrentsEncountered());
	}
			
}


