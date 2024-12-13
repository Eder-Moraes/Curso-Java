package exercicioFix.models.services;

import java.time.LocalDate;

import exercicioFix.models.entities.Contract;
import exercicioFix.models.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double subTotal = contract.getTotalValue()/months;
		for(int i=1; i<=months; i++) {
			double interest = onlinePaymentService.interest(subTotal, i);
			double paymentFee = onlinePaymentService.paymentFee(subTotal+interest);
			double amount = subTotal+interest+paymentFee;
			
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			Installment installment = new Installment(dueDate, amount);
			contract.addInstallment(installment);
		}
	}
	
}
