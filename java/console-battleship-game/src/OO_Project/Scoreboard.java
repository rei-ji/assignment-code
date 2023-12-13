package OO_Project;

import java.util.*;
import java.io.*;

public class Scoreboard {
	private ArrayList<Player> scores = new ArrayList<Player>();
	
	public Scoreboard(){
		readFile();
	}
	
	public void addScore(Player player) {
		scores.add(player);
	}
	
	public void sortScore() {
		Collections.sort(scores);
	}
	
	public void printScoreBoard() {
		int place = 1;
		
		System.out.println("Score Board");
		
		for (Player p:scores) {
			System.out.printf("%d\t%s\t%d", place, p.getPlayerName(), p.getScore());
			place ++;
		}
	}
	
	public void writeFile() {
		try {
			FileOutputStream writeData = new FileOutputStream("TopScore.ser");
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
		
			writeStream.writeObject(scores);
			writeStream.flush();
			writeStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		try {
			FileInputStream readData = new FileInputStream("TopScore.ser");
			ObjectInputStream readStream = new ObjectInputStream(readData);
			
			scores = (ArrayList<Player>) readStream.readObject();
			readStream.close();
			System.out.println(scores.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
