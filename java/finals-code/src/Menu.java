//menu to display all the items

import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Menu() {
		
	}
	
	public Menu(ArrayList<Item> items) {
		setItems(items);
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	//other methods
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void printMenu() {
		int count = 1;
		for (Item i: items) {
			System.out.printf("Item %d:\n", count);
			System.out.println(i);
			count ++;
		}
	}
}
