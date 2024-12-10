package solucaoRuim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import solucaoRuim.model.entities.Reservetion;
import solucaoRuim.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservetion reservetion = new Reservetion(number, checkIn, checkOut);
			System.out.println("Reservetion: "+reservetion);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservetion.updateDates(checkIn, checkOut);
			System.out.println("Reservetion: "+reservetion);
		} catch(ParseException e) {
			System.out.println("Invalid date format");
		} catch(DomainException e) {
			System.out.println("Error in reservation: "+e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		sc.close();
	}

}
