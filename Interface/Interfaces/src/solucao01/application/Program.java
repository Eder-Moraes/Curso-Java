package solucao01.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import solucao01.models.entities.CarRental;
import solucao01.models.entities.Vehicle;
import solucao01.models.services.BrasilTaxService;
import solucao01.models.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrasilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento básico: "+ String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Imposto: "+String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Pagamento total: "+String.format("%.2f", carRental.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
