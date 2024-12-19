package consumer.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import consumer.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// Instância de Classe que implementa Consumer
		//list.forEach(new PriceUpdate());
		
		//Reference method
		//list.forEach(Product::staticPriceUpdate);
		//list.forEach(Product::nonstaticPriceUpdate);
		
		// Lambda declarada
		double factor = 1.1;
		//Consumer<Product> cons = product -> product.setPrice(product.getPrice()*factor);
		//list.forEach(cons);
		
		// Lambda inline
		list.forEach(p -> p.setPrice(p.getPrice()*factor));
		
		list.forEach(System.out::println);
		
	}

}
