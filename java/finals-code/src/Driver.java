//class with main method

public class Driver {
	
	public static void main (String []args) {
		//generate customers
		Customer cust1 = new Customer("John Doe", "thejohnd@gmail.com", "1&onlyJ");
		Customer cust2 = new Customer("Mary Sue", "mary5@gmail.com", "onlyPerfection");
		Customer cust3 = new Customer("Gary Sue", "gsue@gmail.com", "ba5ic");
		Customer cust4 = new Customer("Joe Herrington", "avgj@gmail.com", "inDcrowd");
		Customer cust5 = new Customer("Alexander Great", "alexdg@gmail.com", "inWar3000");
		
		//generate merchants
		Merchant merc1 = new Merchant("Pasta House", "pastahouse@gmail.com", "phouse1000", "Kelana Jaya");
		Merchant merc2 = new Merchant("Grill Station", "grillstats@gmail.com", "burgerFries345", "Subang Jaya");
		Merchant merc3 = new Merchant("Nasi Lemak Corner", "nlc@gmail.com", "nasiLemak&12", "Subang Jaya");
		Merchant merc4 = new Merchant("Picky Pizza Palace", "ppp3@gmail.com", "forP1cky3aters", "Subang Jaya");
		Merchant merc5 = new Merchant("La Campanella", "lacamp@gmail.com", "debu55y", "Kelana Jaya");
		
		//generate reviews
		ReviewPage page1 = new ReviewPage();
		Review review1 = new Review(5, "The food was very fresh and tasty. Definitely worth thre price. Come and try their pasta. Really recommended.", cust2);
		Review review2 = new Review(5, "My favourite pasta place! Bought from them many times and the taste is the same everytime.", cust3);
		Review review3 = new Review(4, "Great place to get pasta. Only issue is that the portion is a little small. Otherwise everything is good.", cust4);
		page1.addReview(review1);
		page1.addReview(review2);
		page1.addReview(review3);
		
		//generate items
		Item item1 = new Item("Pasta Mania SS100", "Ham Carbonara & Pepsi", "Meal", merc1, 15.00, 0.666666666, page1);
		Item item2 = new Item("Burgertown Grill", "Chicken Burger & Fries", "Meal", merc2, 20.00, 0.6);
		Item item3 = new Item("Nasi Lemak Rendang", "Nasi Lemak with Chicken Rendang", "Meal", merc3, 14.00, 0.4);
		Item item4 = new Item("Beef Supreme", "Pizza Topped with Beef, Cheese and Tomato Sauce", "Meal", merc4, 38.00, 0.5);
		Item item5 = new Item("Royal Slice", "A Single Slice of Red Velvet Cake", "Baked Goods", merc5, 12.00, 0.4);
		
		//generate and add to menu
		Menu menu = new Menu();
		menu.addItem(item1);
		menu.addItem(item2);
		menu.addItem(item3);
		menu.addItem(item4);
		menu.addItem(item5);
		
		menu.printMenu();
		
		//make orders
		Order order1 = new Order(1, cust1);
		Orderline line1 = new Orderline(item1, 2);
		Orderline line2 = new Orderline(item4, 1);
		order1.addOrderline(line1);
		order1.addOrderline(line2);
		
		//add points after order
		cust1.addPoints(100);
		
		//print review page
		System.out.printf("Review page for %s\n", merc1.getName());
		page1.printReviews();
		
		//print order
		order1.printOrder();
	}

}
