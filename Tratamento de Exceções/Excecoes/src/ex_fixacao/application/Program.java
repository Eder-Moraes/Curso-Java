package ex_fixacao.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import ex_fixacao.models.entities.Account;
import ex_fixacao.models.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println("New Balance: "+String.format("%.2f", acc.getBalance()));
		} catch(InputMismatchException e) {
			System.out.println("Invalid input type!");
		} catch(WithdrawException e) {
			System.out.println("Withdraw error: "+e.getMessage());
		} catch(RuntimeException e){
			System.out.println("Unexpected error!");
		}
		

		sc.close();
	}

}
