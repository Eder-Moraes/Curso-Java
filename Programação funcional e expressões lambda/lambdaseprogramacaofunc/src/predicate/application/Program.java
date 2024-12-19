package predicate.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import predicate.entities.Product;
public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		//Reference method
		//list.removeIf(Product::nonstaticProductPredicate);
		
		//Lambda declarada
		double min = 100.0;
//		Predicate<Product> predicate = (p) -> p.getPrice()>=min;
//		list.removeIf(predicate);
		
		//Lambda inline
		list.removeIf((p) -> p.getPrice()>=min);
		
		for(Product p:list) {
			System.out.println(p);
		}
		
	}

}
