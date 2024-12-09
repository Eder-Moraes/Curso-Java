package ExFixacaoGeral.entities;

public class Company extends Payer{

	private Integer numberEmplyees;
	
	public Company() {
		super();
	}
	
	
	public Company(String name, Double anualIncome, Integer numberEmplyees) {
		super(name, anualIncome);
		this.numberEmplyees = numberEmplyees;
	}


	public Integer getNumberEmplyees() {
		return numberEmplyees;
	}


	public void setNumberEmplyees(Integer numberEmplyees) {
		this.numberEmplyees = numberEmplyees;
	}


	@Override
	public double taxePaid() {
		double taxe = 0;
		if(numberEmplyees>10) {
			taxe = getAnualIncome()*0.14;
		} else {
			taxe = getAnualIncome()*0.16;
		}
		return taxe;
	}

}
