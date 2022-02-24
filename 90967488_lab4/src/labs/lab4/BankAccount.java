package labs.lab4;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	protected double balance;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		System.out.println(balance);
		return balance;
	}
	
	public static void main (String[] args) {
		BankAccount account = new BasicAccount(100.00); // creates a BasicAccount with an initial balance of 100.00
		account.getBalance();
		account.withdraw(80.00); // no overdraft, so no penalty
		account.getBalance(); // returns 20.0
		account.withdraw(50.00); // charge $30 penalty for overdraft
		account.getBalance(); // returns -60.0
		account.withdraw(50.00); // charge $30 penalty for overdraft
		account.getBalance(); // returns -140.0
	}
}