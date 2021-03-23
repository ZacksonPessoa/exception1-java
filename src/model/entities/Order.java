package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.enuns.OrderStatus;


public class Order {

	private Date monent;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> items =new ArrayList<OrderItem>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
		
	}

	public Order(Date monent, OrderStatus status, Client client) {
	
		this.monent = monent;
		this.status = status;
		this.client = client;
		
	}
	
	public Date getMonent() {
		return monent;
	}

	public void setMonent(Date monent) {
		this.monent = monent;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum =0;
		for(OrderItem x : items) {
			sum +=x.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: ");
		sb.append(sdf.format(monent) + "\n");
		sb.append("Order status: ");
		sb.append(OrderStatus.PROCESSING + "\n");
		sb.append("Client: ");
		sb.append(client.getName() +" (");
		sb.append(client.getBithDate());
		sb.append(") - ");
		sb.append(client.getEmail()+"\n");
		sb.append("Order Items: \n");
		
		for(OrderItem x: items) {
			sb.append(x.getProduct().getName()+", ");
			sb.append(x.getProduct().getPrice()+", ");
			sb.append("Quantity: ");
			sb.append(x.getQuantity()+", ");
			sb.append("Subtotal: $");
			sb.append(String.format("%.2f",x.subTotal()));
			sb.append("\n");
		}
		sb.append("Total Price: $");
		sb.append(String.format("%.2f", total()));
		
				
		return sb.toString();
	}
	

}
