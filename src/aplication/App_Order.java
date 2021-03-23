package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.enuns.OrderStatus;

public class App_Order {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc =new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Order order;
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email =sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date bithDate = sdf.parse(sc.next());
		Client client = new Client(name, email, bithDate);
		
		System.out.println();
		
		System.out.println("Enter order data: ");
		System.out.println("Status: "+OrderStatus.PROCESSING);
		System.out.print("How many items to this order? ");
		int n =sc.nextInt();
		order = new Order(new Date(), OrderStatus.PROCESSING,client);
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Enter #"+i +" item data: ");
			System.out.print("Product Name: ");
			String productName = sc.next();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem items = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			order.addItem(items);
			
			System.out.println("");
			
			
			
		}
		
		System.out.println(order);
		
		sc.close();

	}

}
