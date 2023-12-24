package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus orderStatus;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void addItems (OrderItem item) {
		items.add(item);
	}
	
	public void removeItems (OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem i : items) {
			sum += i.subtotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order momment: " + fmt.format(moment) + "\n");
		sb.append("Order status: " + orderStatus + "\n");
		sb.append("Client: " + client.toString() + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items) {
			sb.append(item.toString());
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}