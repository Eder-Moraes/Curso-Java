package exfixacao.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> a = new HashSet<Integer>();
		Set<Integer> b = new HashSet<Integer>();
		Set<Integer> c = new HashSet<Integer>();
		
		
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			b.add(sc.nextInt());
		}
		
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			c.add(sc.nextInt());
		}
		
		Set<Integer> all = new HashSet<Integer>(a);
		all.addAll(b);
		all.addAll(c);
		
		System.out.println("Total students: "+all.size());
		
		sc.close();

	}

}
