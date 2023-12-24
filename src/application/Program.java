package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		int n;
				
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), fmt1);
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(LocalDateTime.now(), orderStatus, client);
		
		System.out.print("How many items to this order? ");
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.printf("Enter item #%d data:\n", i);
			System.out.print("Product: ");
			String productName = sc.next();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			System.out.print("Quantity: ");		
			int quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(quantity, productPrice, product);
			
			order.addItems(item);
		}
		
		System.out.println(order);
		
		sc.close();
	}
}