package aulaClasseAbstrata.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import aulaClasseAbstrata.entities.Account;
import aulaClasseAbstrata.entities.BusinessAccount;
import aulaClasseAbstrata.entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<>();
	
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.00, 400.00));
		list.add(new SavingsAccount(1003, "Bob", 300.00, 0.01));
		list.add(new BusinessAccount(1005, "Anna", 500.00, 500.00));
		
		double sum = 0.0;
		
		for (Account account : list) {
			sum += account.getBalance();
		}
		
		System.out.printf("Total Balance: %.2f%n", sum);
		
		for (Account account : list) {
			account.deposit(10);
		}
		for (Account account : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", account.getNumber(), account.getBalance());
		}
	}

}
