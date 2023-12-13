package OO_Project;

//main method class
public class Driver {
	public static void main (String [] args) {
		Game game = new Game();
		game.startGame();
		game.runGame();
		game.endGame();
        game.printTop5Scores();
	}

}
