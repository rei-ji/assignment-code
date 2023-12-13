//order/invoice that holds orderlines

import java.util.ArrayList;

public class Order {
	private int orderNum;
	private ArrayList<Orderline> orderlines = new ArrayList<Orderline>();
	private Customer customer;
	private double totalPrice;
	
	public Order() {
		
	}
	
	public Order(int orderNum, Customer customer) {
		setOrderNum(orderNum);
		setCustomer(customer);
	}
	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public ArrayList<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(ArrayList<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addOrderline(Orderline orderline) {
		orderlines.add(orderline);
	}
	
	//other methods
	public void calcTotalPrice() {
		for (Orderline o: orderlines) {
			totalPrice += o.getItem().getDiscountedPrice() * o.getQuantity();
		}
	}
	
	public void printOrder() {
		int count = 1;
		calcTotalPrice();
		System.out.printf("Order Number: %d\n", orderNum);
		System.out.printf("Customer Name: %s\n", customer.getName());
		
		
		for (Orderline o: orderlines) {
			System.out.printf("Line %d: \n", count);
			System.out.println(o);
			count ++;
		}
		
		System.out.printf("Total Price: RM%.2f\n", getTotalPrice());
	}
	
}
