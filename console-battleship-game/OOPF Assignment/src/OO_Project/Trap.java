package OO_Project;
public class Trap extends RiverObject{
	//constructor
	public Trap(int start, int end) {
		setSymbol('#');
		generateValue(start, end);
		generatePosition(1, 98);
	}
	
	@Override
	public String toString() {
		if (getValue() < 4) {
			return "trap";
		}
		
		else {
			return "strong trap";
		}
	}
	
}

