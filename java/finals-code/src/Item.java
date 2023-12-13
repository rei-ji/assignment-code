//items on the menu
public class Item {
	private String title;
	private String description;
	private String category;
	private Merchant merchant;
	private double price;
	private double discount;
	private double discountedPrice;
	private ReviewPage reviews;
	
	//constructors
	public Item() {
		
	}
	
	public Item(String title, String description, String category, Merchant merchant, double price, double discount) {
		setTitle(title);
		setDescription(description);
		setCategory(category);
		setMerchant(merchant);
		setPrice(price);
		setDiscount(discount);
		setDiscountedPrice(calcDiscountedPrice());
	}
	
	public Item(String title, String description, String category, Merchant merchant, double price, double discount, ReviewPage reviews) {
		setTitle(title);
		setDescription(description);
		setCategory(category);
		setMerchant(merchant);
		setPrice(price);
		setDiscount(discount);
		setDiscountedPrice(calcDiscountedPrice());
		setReviews(reviews);
	}

	//setter/getter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public ReviewPage getReviews() {
		return reviews;
	}

	public void setReviews(ReviewPage reviews) {
		this.reviews = reviews;
	}
	
	//other methods
	public double calcDiscountedPrice() {
		return price - (price * discount);
	}
	
	public String toString() {
		return String.format("Title: %s\nDescription: %s\nPrice: RM%.2f\nDiscounted Price: RM%.2f\n", getTitle(), getDescription(), getPrice(), getDiscountedPrice());
	}
}
