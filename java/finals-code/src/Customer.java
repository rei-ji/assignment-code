//subclass to User
public class Customer extends User {
	private int points;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String email, String password) {
		super(name, email, password);
		setPoints(0);
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addPoints(int points) {
		this.points += points; 
	}
	
	public void subtractPoints(int points) {
		this.points -= points;
	}
	
	public String toString() {
		return String.format("Customer name: %s", getName());
	}
}
