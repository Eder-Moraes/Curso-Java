package map.application;

import java.util.HashMap;
import java.util.Map;

import map.entities.Product;

public class Program {

	public static void main(String[] args) {
		
//		Map<String, String> cookeis = new TreeMap<String, String>();
//		
//		cookeis.put("username", "Maria");
//		cookeis.put("email", "maria@gmail.com");
//		cookeis.put("phone", "19 99393-3211");
//		
//		cookeis.remove("phone");
//		cookeis.put("email", "maria2@gmail.com");
//		
//		System.out.println("Contains 'email' key: "+cookeis.containsKey("email"));
//		System.out.println("Email: "+cookeis.get("email"));
//		System.out.println("phone: "+cookeis.get("phone"));
//		System.out.println("Size: "+cookeis.size());
//		
//		System.out.println("ALL COOKEIS: ");
//		for(String key: cookeis.keySet()) {
//			System.out.println(key + ": " + cookeis.get(key));
//		}
		
		Map<Product, Double> stock = new HashMap<>();
		
		Product p1 = new Product("Tv", 900.0);
		Product p2 = new Product("Notebook", 1200.0);
		Product p3 = new Product("Tablet", 400.0);
		
		stock.put(p1, 10000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 15000.0);
		
		Product ps = new Product("Tv", 900.0);
		
		System.out.println("Contains 'ps' key: " + stock.containsKey(ps));

	}

}
