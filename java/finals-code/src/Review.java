//reviews in review page
public class Review {
	private int rating;
	private String comment;
	private Customer customer;
	
	//constructors
	public Review(){
		
	}
	
	public Review(int rating, String comment, Customer customer) {
		setRating(rating);
		setComment(comment);
		setCustomer(customer);
	}

	//setter/getters
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String toString() {
		return String.format("Customer: %s\nRating: %d Stars\n%s\n", customer.getName(), getRating(), getComment());
	}
	
}
