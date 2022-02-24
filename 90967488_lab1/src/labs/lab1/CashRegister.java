package labs.lab1;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private int itemCount;
	private String receipt = "";
	private double totalCost;
	private int salesCount;
	private double totalSales;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
	}


	public void recordPurchase(double amount) {
		purchase = purchase + amount;
		itemCount += 1;
		receipt += String.valueOf(amount) + "\n";
		totalCost += amount;
	}


	public void receivePayment(double amount) {
		payment = payment + amount;
		salesCount += 1;
	
		
	}


	public double giveChange() {
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		itemCount = 0;
		receipt = "";
		totalSales += totalCost;
		totalCost = 0;


		return change;
	}
	


	public int getItemCountInPurchase() {
		return itemCount; // FIX ME
	}

	
	public double getSalesTotal() {
		return totalSales; // FIX ME
	}


	public int getSalesCount() {
		return salesCount; // FIX ME
	}


	public void reset() {
		itemCount = 0;
		receipt = "";
		totalCost = 0;
		salesCount = 0;
	}

	public String getReceipt() {
		String finalReceipt = receipt + String.valueOf(totalCost);
		return finalReceipt; // FIX ME
	}
	
	public static void main(String args[]) {
		CashRegister register = new CashRegister();

		// transaction #1:
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		System.out.println(register.getItemCountInPurchase()); // returns 2
		register.receivePayment(50.00);
		System.out.println(register.getReceipt()); // returns:
		// 29.5
		// 9.25
		// 38.75
		register.giveChange();

		// transaction #2:
		register.recordPurchase(30);
		System.out.println(register.getReceipt()); // returns:
		register.recordPurchase(10);
		register.receivePayment(50);
		//System.out.println(register.getItemCountInPurchase()); // returns 2
		System.out.println(register.getReceipt());
		register.giveChange();

		// transaction #3:
		register.recordPurchase(20);
		register.receivePayment(20);
		//System.out.println(register.getItemCountInPurchase()); // returns 2
		register.giveChange();
		System.out.println(register.getSalesTotal());// returns 98.75
		System.out.println(register.getSalesCount()); // returns 3
	}


}
