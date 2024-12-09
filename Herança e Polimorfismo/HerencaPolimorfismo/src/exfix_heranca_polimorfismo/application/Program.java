package exfix_heranca_polimorfismo.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exfix_heranca_polimorfismo.entities.ImportedProduct;
import exfix_heranca_polimorfismo.entities.Product;
import exfix_heranca_polimorfismo.entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			switch(typeProduct) {
			case 'i':
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product productImportado = new ImportedProduct(name, price, customsFee);
				products.add(productImportado);
				break;
			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.next();
				Product productUsado = new UsedProduct(name, price, sdf.parse(manufactureDate));
				products.add(productUsado);
				break;
			default:
				Product product = new Product(name, price);
				products.add(product);
				break;
			}
				
		}
		
		
		System.out.println("\nPRICE TAGS: ");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
