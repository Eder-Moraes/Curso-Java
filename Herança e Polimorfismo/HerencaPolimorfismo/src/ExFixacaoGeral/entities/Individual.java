package ExFixacaoGeral.entities;

public class Individual extends Payer{

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}


	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}


	@Override
	public double taxePaid() {
		double taxe = 0;
		if(getAnualIncome()<20000) taxe = getAnualIncome()*0.15 - healthExpenditures * 0.50;
		else taxe = getAnualIncome()*0.25 - healthExpenditures * 0.50;
		return taxe;
	}

}
