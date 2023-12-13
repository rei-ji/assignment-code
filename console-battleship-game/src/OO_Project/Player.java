package OO_Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//player has a dice
public class Player implements Comparable<Player>{

	private String PlayerName; 
	private int[] MyDice;
	private int score;
	
	
	public Player() {
		
		this("null", new int[]{0,0,0,0,0,0});
	}

	public Player(String p, int[] mydice) {
		
		PlayerName = p;
		MyDice = mydice;
		
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return PlayerName;
	}
	
	public void setPlayerName() {
		Scanner input = new Scanner(System.in);
		System.out.printf("please input a 5 character name: \n");
		String name = input.next().toUpperCase();
		
		while (name.length() != 5) {
			System.out.println("Error, input a 5 character name. Please input again.");
			name = input.next().toUpperCase();
		}
	        
	        PlayerName = name;
	        
	}

	public int[] getMyDice() {
		return MyDice;
		
	}

	public void setMyDice() {
	
	    Scanner input = new Scanner(System.in);
		ArrayList<Dice> dicelist = new ArrayList<Dice>();
		int p1 = 0;
		int dtest = 0;
		
	       
		Dice Dice1 = new Dice("Captain Holt's Favourite", new int[]{1,2,3,4,5,6},"\nHow original!" );
		Dice Dice2 = new Dice("S.S. Harvey", new int[]{1,1,1,5,6,6},"\nHeads, I win...");
		Dice Dice3 = new Dice("Ol' Reliable", new int[]{2,2,3,5,5,5},"\nPatrick, there is one more thing I want you to have...");
		Dice Dice4 = new Dice("Rushing Roulette", new int[]{0,0,4,4,6,7},"\nNever tell me the odds!");
		Dice Dice5 = new Dice("The Wimp of WallStreet", new int[]{0,0,0,0,7,10},"\nThe definition of insanity is doing the same thing over and over and expecting different results.");
		Dice Dice6 = new Dice("Move-Fastinator", new int[]{1,1,1,1,0,3},"\nYou'll never catch me Krabs, not when I shift into MAXIMUM OVERDRIVE.");
		
		dicelist.add(Dice1);
		dicelist.add(Dice2);
		dicelist.add(Dice3);
		dicelist.add(Dice4);
		dicelist.add(Dice5);
		dicelist.add(Dice6);

	    System.out.println("Pick a dice by entering a number between 1 and " + dicelist.size() + ":\n");
	    for (int i = 0; i < dicelist.size(); i++) {
	        System.out.printf("[%d] %s, ", i + 1, dicelist.get(i).getDiceName());
	        System.out.println("which has the dice values: " + Arrays.toString(dicelist.get(i).getDiceValues()));
	    }
	    
        System.out.println();
    
        while (p1 == 0) {
            try {
                dtest = input.nextInt();

                if (dtest > 6 || dtest == 0) {
                    System.out.println("Error, there is no such boat. Select a boat by entering a number between 1 and 6.");
                } else {
                    Dice selectedDice = dicelist.get(dtest - 1);
                    System.out.println("\nYou picked the boat \"" + selectedDice.getDiceName() + "\" which faces have the values:" + Arrays.toString(selectedDice.getDiceValues()));
 
                    System.out.println("\n" + selectedDice.getDiceDesc());
                    p1 = 1;
                    System.out.println();
                    System.out.println();
                    
                    int[] diceValues = selectedDice.getDiceValues();
                    
                    for (int i = 0; i < diceValues.length; i++) {
                        MyDice[i] = diceValues[i];
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please select again.");
                input.nextLine(); 
            }
            
  
        }
     	
	}

	@Override
	public String toString() {
		return String.format("players [PlayerName=%s, MyDice=%s]", PlayerName, Arrays.toString(MyDice));
	}

	@Override
	public int compareTo(Player comparePlayer) {
		int compareScore = ((Player)comparePlayer).getScore();
		
		return this.score - compareScore;
	}
}


