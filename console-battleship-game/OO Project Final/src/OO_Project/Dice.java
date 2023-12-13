package OO_Project;
import java.util.Arrays;
import java.io.*;

public class Dice implements Serializable {
	private String DiceName;
	private int[] DiceValues;
	private String DiceDesc;
	public Dice() {
		this("A", new int[]{1,2,3,4,5,6}, "placeholder.");
		
	}
	
	public Dice(String dicename, int[] dicevalues, String dicedesc) {
		DiceName = dicename;
		DiceValues = dicevalues;
		DiceDesc = dicedesc;
	}
	
	public String getDiceName() {
		return DiceName;
	}
	
	public int[] getDiceValues() {
		return DiceValues;
	
	}
	public String getDiceDesc() {
		return DiceDesc;
	}
	@Override
	public String toString() {
		return String.format("The Dice called %s has 6 sides. The list of values on each side are: %s \n %s \n", DiceName, Arrays.toString(DiceValues));
	}
}


