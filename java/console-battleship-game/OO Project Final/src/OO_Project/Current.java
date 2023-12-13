package OO_Project;

public class Current extends RiverObject{
	//constructor
	public Current(int start, int end) {
		setSymbol('C');
		generateValue(start, end);
		generatePosition(1, 98);
	}
	
	@Override
	public String toString() {
		if (getValue() < 4) {
			return "current";
		}
		
		else {
			return "strong current";
		}
	}
	
}
