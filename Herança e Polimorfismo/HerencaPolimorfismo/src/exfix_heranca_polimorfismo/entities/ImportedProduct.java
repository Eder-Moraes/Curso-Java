package exfix_heranca_polimorfismo.entities;

public class ImportedProduct extends Product{
	
	private Double customFee;
	
	public ImportedProduct() {}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	public Double totalPrice() {
		return this.getPrice() + customFee;
	}
	
	@Override
	public String priceTag() {
		return this.getName()+" $ "+String.format("%.2f", totalPrice())+" (Customs fee: $ "+String.format("%.2f", customFee)+")";
	}
	
}
