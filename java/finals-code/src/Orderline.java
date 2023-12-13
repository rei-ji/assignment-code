//each line in the order
public class Orderline {
	private Item item;
	private int quantity;
	
	public Orderline() {
		
	}
	
	public Orderline(Item item, int quantity) {
		setItem(item);
		setQuantity(quantity);
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return String.format("Title: %s\nPrice: RM%.2f\nQuantity: %s\n", item.getTitle(), item.getPrice(), getQuantity());
	}
}
