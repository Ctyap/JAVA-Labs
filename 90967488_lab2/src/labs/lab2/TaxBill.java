package labs.lab2;

public class TaxBill {
	private boolean married;
	private double income;
	private double taxDue;
	
	/**
	 * Constructs a TaxBill
	 * 
	 * @param married is whether the person is married (true) or not (false)
	 * @param income is the person's taxable income
	 */
	public TaxBill(boolean married, double income) {
		this.married = married;
		this.income = income;
	}
	
	/**
	 * Gets the amount of tax due
	 * 
	 * @return the amount of tax due
	 */
	public double getAmountDue() {
		if (married == false) {
			if (income > 0 && income <= 8000) {
				taxDue = (income * .10);
			}else if (income > 8000 && income <= 32000) {
				taxDue = 800 + .15 * (income - 8000);
			}else {
				taxDue = 4400 + .25 * (income - 32000);
			}
			
		}else if (married == true) {
			if (income > 0 && income <= 16000) {
				taxDue = (income * .10);
			}else if (income > 1600 && income <= 64000) {
				taxDue = 1600 + .15 *(income - 16000);
			}else{
				taxDue = 8800 + .25 *(income - 64000);
			}
		}
		return taxDue;
	}
	}