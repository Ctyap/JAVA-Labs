package labs.lab4;

public class Customer {
	private double moneySpent = 0;
	private double temp;
	private double totalMoneySpent = 0;
	private int numDiscount = 0;
	private double discount;
	
	Customer(){}  
	
	public void makePurchase(double amount) {
		if (numDiscount > 0) {
			discount = amount * .10;
			amount -= discount;
			numDiscount--;
		}
		
		moneySpent += amount;
		totalMoneySpent += amount;
		
		if (moneySpent >= 100) {
			temp = moneySpent / 100;
			int numberOfDiscounts = (int) Math.floor(temp);
			numDiscount += numberOfDiscounts;
			moneySpent -= (numberOfDiscounts * 100);
		}

	}
	
	public int getNumDiscountsToUse() {
		System.out.println(numDiscount);
		return numDiscount;
	}
	
	public double getTotalAmountSpent() {
		System.out.println(totalMoneySpent);
		return totalMoneySpent;
	}
	
	public static void main(String[] args) {
		Customer c = new Customer();
		c.makePurchase(300);
		c.getNumDiscountsToUse();
		c.makePurchase(10);
		c.makePurchase(10);
		c.makePurchase(10);
		c.getTotalAmountSpent(); // 327.0





		
	}

}
