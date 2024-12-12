package solucao01.models.services;

import java.time.Duration;

import solucao01.models.entities.CarRental;
import solucao01.models.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hour = minutes / 60;
		
		double basicPayment = 0;
		if(hour <= 12) {
			basicPayment = pricePerHour * Math.ceil(hour);
		} else {
			basicPayment = pricePerDay * Math.ceil(hour/24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}
