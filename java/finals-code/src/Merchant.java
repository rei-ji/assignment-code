//subclass to User
public class Merchant extends User {
	private String location;
	
	public Merchant() {
		super();
	}
	
	public Merchant(String name, String email, String password, String location) {
		super(name, email, password);
		setLocation(location);
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
