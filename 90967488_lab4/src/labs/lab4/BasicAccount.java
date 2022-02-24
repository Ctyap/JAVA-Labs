package labs.lab4;

public class BasicAccount extends BankAccount {
	
	BasicAccount(double amount){
		super(amount);
	}
	
	public void withdraw(double amount) {
		if(balance - amount < 0) {
			double newBalance = balance - amount;
			newBalance -= 30;
			balance = newBalance;
		}else {
			double newBalance = balance - amount;
			balance = newBalance;
		}
	}

}
