package OO_Project;

import java.util.Random;

public class RiverObject {
	private int value;
	private int position;
	private char symbol;
	private Random r = new Random();
	
	//constructor
	public RiverObject() {
		setSymbol(' ');
		generateValue(1, 5);
	}
	
	//setter/getter
	public int getValue() {
		return value;
	}
	public int getPosition() {
		return position;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	//generate random value
	public void generateValue(int start, int end) {
		value = start + r.nextInt((end - start) + 1);
	}
	
	//generate random position
	public void generatePosition(int start, int end) {
		position = start + r.nextInt((end - start) + 1);
	}
	
	//toString() method
	public String toString() {
		return String.format("Parent class.");
	}
}
