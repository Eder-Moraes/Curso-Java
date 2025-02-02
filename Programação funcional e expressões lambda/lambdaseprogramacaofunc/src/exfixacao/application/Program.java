package exfixacao.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exfixacao.entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			List<Employee> list = new ArrayList<Employee>();
			
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			sc.nextLine();
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			List<Employee> MoreSalaryList = list.stream()
					.filter((e) -> e.getSalary() > salary )
					.sorted((e1, e2) -> e1.getEmail().toUpperCase().compareTo(e2.getEmail().toUpperCase()))
					.toList();
			Double result = list.stream()
					.filter((e) -> e.getName().startsWith("M"))
					.map((e) -> e.getSalary())
					.reduce(0.0, (e1, e2) -> e1 + e2);
			
			System.out.println("Email of people whose salary is more than "+String.format("%.2f", salary)+":");
			MoreSalaryList.stream().forEach((e) -> System.out.println(e.getEmail()));
			System.out.println("Sum of salary of people whose name starts with 'M': "+String.format("%.2f", result));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		
	}
	
}
