package exresolvidostream.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import exresolvidostream.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<Product>(); 
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] filds = line.split(",");
				list.add(new Product(filds[0], Double.parseDouble(filds[1])));
				line = br.readLine();
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		double sum = list.stream().map(x -> x.getPrice()).reduce(0.0, (x, y) -> x+y);
		double avg = sum/list.size();
		
		System.out.println("Average price: "+String.format("%.2f", avg));
		
		Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		
		List<String> avgList = list.stream()
				.filter(x -> x.getPrice() < avg)
				.map(x -> x.getName())
				.sorted(comp.reversed())
				.collect(Collectors.toList());
		
		avgList.forEach(System.out::println);
		
		sc.close();

	}

}
