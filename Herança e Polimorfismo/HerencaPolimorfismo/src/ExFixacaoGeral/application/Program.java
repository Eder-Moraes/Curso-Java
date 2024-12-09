package ExFixacaoGeral.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import ExFixacaoGeral.entities.Company;
import ExFixacaoGeral.entities.Individual;
import ExFixacaoGeral.entities.Payer;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Payer> payers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Tax payer #"+i+" data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				Payer payer = new Individual(name, anualIncome, healthExpenditures);
				payers.add(payer);
			}
			else {
				System.out.print("Number of employees: ");
				int numberEmployees = sc.nextInt();
				Payer payer = new Company(name, anualIncome, numberEmployees);
				payers.add(payer);
			}
		}
		
		System.out.println("\nTAXES PAID:");
		double sum = 0;
		
		for (Payer payer : payers) {
			System.out.println(payer);
			sum += payer.taxePaid();
		}
		
		System.out.printf("\nTOTAL TAXES: %.2f%n", sum);
		
		sc.close();
	}
}
