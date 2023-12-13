package OO_Project;

import java.util.Random;
import java.util.Scanner;

//class to put everything together
//game has a player, board, boat
public class Game {
	private int turn;
	private int coinflip;
	private double score;
	private Player player1;
	private Player player2;
	private Board board;
	private Boat boat1;
	private Boat boat2;
	private Scanner input;
	
	//starts up the game, prompts player name and dice, determines turn sequence
	public void startGame(){
		input = new Scanner(System.in);
		turn = 1;
		
		System.out.print("Player 1, ");
		player1 = new Player();
		player1.setPlayerName();
		
		System.out.print("\nPlayer 2, ");
		player2 = new Player();
		player2.setPlayerName();
		
		System.out.println("\nPlayer 1's name is " + player1.getPlayerName());
		player1.setMyDice();
		
		System.out.println("Player 2's name is " + player2.getPlayerName() + "\n");
		player2.setMyDice();
		
		boat1 = new Boat(player1);
		boat2 = new Boat(player2);
		
		board = new Board(boat1, boat2);
		
		determineTurnSequence();
	}
	
	//determine which player goes first
	public void determineTurnSequence() {
		Random r = new Random();
		coinflip = r.nextInt(2);
		
		System.out.println("Flipping a coin to determine who goes first...");
		
		if (coinflip == 0) {
			System.out.println("Heads! " + player1.getPlayerName() + " goes first.\n");
		}
		
		else if (coinflip == 1) {
			System.out.println("Tails! " + player2.getPlayerName() + " goes first.\n");
		}
	}
	
	//loops game until one player wins
	public void runGame() {
		System.out.println(player1.getPlayerName() + " - X		" + player2.getPlayerName() + " - O");
		board.printRiver();
		
		while ((boat1.getWin() == false) && boat2.getWin() == false) {
			System.out.println("\nTurn " + turn);
			if (coinflip == 0) {
				playerTurn(player1, boat1);
				
				if (boat1.getWin() == true) {
					break;
				}
				
				playerTurn(player2, boat2);
				
				if (boat2.getWin() == true) {
					break;
				}
			}	
			
			else if (coinflip == 1) {
				playerTurn(player2, boat2);
				
				if (boat2.getWin() == true) {
					break;
				}
				
				playerTurn(player1, boat1);
				
				if (boat1.getWin() == true) {
					break;
				}
			}
			turn ++;
		}
	}	
	
	//ends the game when one player wins and announces the winner and score
	public void endGame() {
		if (boat1.getWin() == true) {
			announceWinner(player1, boat1);
		}
		
		else if (boat2.getWin() == true) {
			announceWinner(player2, boat2);
		}
		input.close();
	}
	
	//prompt player to press enter to roll the dice to move
	public void promptRollDice(Player player) {
		System.out.println(player.getPlayerName() + "'s turn");
		System.out.println("Press enter to roll dice");
		input.nextLine();
	}
	
	//runs processes needed in a single player's turn
	public void playerTurn(Player player, Boat boat) {
		promptRollDice(player);
		boat.rollDiceAndMove();
		board.triggerRiverObject(player, boat);
		board.printRiver();
		System.out.println();
	}
	
	//announce results of the match
	public void announceWinner(Player player, Boat boat) {
		System.out.println(player.getPlayerName() + " has won in " + turn + " turns.\n");
		System.out.println(boat);
		calculateScore(player, boat);
		System.out.printf("Total Score: %.0f", score);
	}
	
	//calculate score of the player based on turn and traps and currents encountered
	public void calculateScore(Player player, Boat boat) {
		double multiplier = 0;
		
		if (turn <= 25) {
			multiplier = 2;
		}
		
		else if ((turn > 25) && (turn <=30)) {
			multiplier = 1.5;
		}
		
		else {
			multiplier = 1.25;
		}
		
		score = (boat.getCurrentsEncountered() * 2000 - boat.getTrapsEncountered() * 1000) * multiplier;
	}
}
