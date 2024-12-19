package function.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import function.entities.Product;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		// Method de primeira ordem/classe
		//List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
		
		// Reference Method
		//List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		//List<String> names = list.stream().map(Product::nonstaticUpperCaseName).collect(Collectors.toList());
		
		// Lambda declarada
		//Function<Product, String> funct = p -> p.getName().toUpperCase();
		//List<String> names = list.stream().map(funct).collect(Collectors.toList());
		
		// Lambda inline
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		names.forEach(System.out::println);
	}

}
