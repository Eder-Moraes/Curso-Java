package aula130_heranca.application;

import aula130_heranca.entities.Account;
import aula130_heranca.entities.BusinessAccount;
import aula130_heranca.entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//UPCASTING
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 0.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		//DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);
		
		//InstanceOf
		
		//BusinessAccount acc5 = (BusinessAccount) acc3;
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		//SOBRECRITA
		acc.deposit(1000.0);
		acc.withdraw(200.0);
		System.out.println(acc.getBalance());
		
		acc3.deposit(1000.0);
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
		
		acc2.deposit(1000.0);
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
	}

}
