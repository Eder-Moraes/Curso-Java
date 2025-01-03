package aula126_ExEnum3.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import aula126_ExEnum3.entities.Order;
import aula126_ExEnum3.entities.OrderItem;
import aula126_ExEnum3.entities.Product;
import aula126_ExEnum3.entities.enums.OrderStatus;
import aula126_ExEnum3.entities.Client;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String bithDate = sc.next();
		Client client = new Client(name, email, sdf.parse(bithDate));
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			Product product = new Product(nameProduct, priceProduct);
			OrderItem item = new OrderItem(quantityProduct, product);
			order.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
