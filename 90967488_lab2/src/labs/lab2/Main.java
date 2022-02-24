package labs.lab2;
import java.util.Scanner;
import java.lang.Math;
//Copy and paste this template into your Main.java file
class Main {

	/**
	 * Returns a string representing the number of hours and minutes between two
	 * military times.
	 * 
	 * @param time1 first time in military format
	 * @param time2 second time in military format
	 */
	public static String problem1_militaryTimeDifference(int time1, int time2) {

		//(1730, 900)
		//(900, 1730)
		int timeDiff;
		int hours;
		int minutes;
		String output = "";
		
		time2 = (time2 < time1) ? time2 + 2360: time2;
		
		timeDiff = time2 - time1;
		
		hours = ((timeDiff / 100) + (timeDiff % 100) / 60);
		minutes = ((timeDiff % 100) % 60);
				
		output = hours + " hours " + minutes + " minutes";
		return output;
	}

	public static void problem2_calculateTotal() {
		double totalMaskPrice;
		final double TAX = .075;
		final double SHIPPING_CHARGE = .25;
		double addShippingCharge;
		double taxMask;
		double orderTotal;
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter price per mask: ");
		double maskPrice = in.nextDouble();
		
		System.out.print("Enter the number of masks: ");
		int maskQuantity = in.nextInt();
		
		totalMaskPrice = maskQuantity * maskPrice;
		
		addShippingCharge = maskQuantity * SHIPPING_CHARGE;
		taxMask = totalMaskPrice * TAX;
		
		orderTotal = totalMaskPrice + taxMask + addShippingCharge;
		
		System.out.printf("Your total is: $%.2f", orderTotal);
	
		
	}

	public static String problem3_getDollarsAndCents(double amount) {
		String doubleToString = Double.toString(amount);
		int doubleDecimalIndex = doubleToString.indexOf('.');
		String dollars = doubleToString.substring(0,doubleDecimalIndex);
		String cents = doubleToString.substring(doubleDecimalIndex + 1);
		String output = "dollars: " + dollars + "\n" + "cents: " + cents;
		return output; 
	}

	public static int problem4_getDiscount(int numMasksBought, int numClientsReferred) {
		int discountSum = numMasksBought + numClientsReferred;
		
		if (discountSum >= 75) {
			return 75;
		}
		return discountSum;
	}

	public static void problem5_giveChange() {
		String output = "";
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter amount due in cents: ");
		int centsDue = in.nextInt();
		
		System.out.print("Enter amount received in cents: ");
		int centsReceived = in.nextInt();
		
		int changeDiff = centsReceived - centsDue;
		
		int dollars = changeDiff / 100;
		
		changeDiff %= 100;
		
		int quarters = changeDiff / 25;
		
		changeDiff %= 25;
		
		int dimes = changeDiff / 10;
		
		changeDiff %= 10;
		
		int nickels = changeDiff / 5;
		
		changeDiff %= 5;
		
		int pennies = changeDiff;
		
		
		/*
		output = "Give the following change: \n" + "Dollars:              " + dollars + "\n" + "Quarters:             "+ quarters + "\n"
		+ "Dimes:                " + dimes + "\n" + "Nickels:              " + nickels + "\n" + "Pennies:              " + pennies + "\n";
		
		System.out.println(output);
		
		
		System.out.printf("Give the following change: \n");
        System.out.printf("Dollars:%13s\n", dollars);
        System.out.printf("Quarters:%12s\n", quarters);
        System.out.printf("Dimes:%15s\n", dimes);
        System.out.printf("Nickels:%13s\n", nickels);
        System.out.printf("Pennies:%13s\n", pennies);
        
        */
        System.out.printf("Give the following change: \nDollars:%15s\nQuarters:%14s\nDimes:%17s\nNickels:%15s\nPennies:%15s\n", dollars, quarters, dimes, nickels, pennies);

		
	}

	public static boolean problem6_evenlySpaced(int a, int b, int c) {
		return (b - a == c - b) || (a - c == b - a)||(c - b == a - c);
	}

	public static int problem8_specialSum(int a, int b, int c) {
		
		if (a == 13)
		{
			return 0;
		}
		else if (b == 13)
		{
			return a;
		}
		else if (c == 13)
		{
			return a + b;
		}
		else
		{
			return a + b + c;
		}

	}

	public static void main(String[] args) {
		/*
		 System.out.println();
		  
		System.out.println("This is problem 1: " + problem1_militaryTimeDifference(900, 1730)); // returns "8 hours 30 minutes"
		System.out.println("This is problem 2: " + problem1_militaryTimeDifference(1730, 900)); // returns "15 hours 30 minutes"
		System.out.println("This is problem 3: " + problem1_militaryTimeDifference(1630, 1630)); // returns "0 hours 0 minutes"
		System.out.println("This is problem 4: " + problem1_militaryTimeDifference(630, 731)); // returns "1 hours 1 minutes"  
		
		problem2_calculateTotal();
		
		
		System.out.println(problem3_getDollarsAndCents(2.95));
		System.out.println(problem3_getDollarsAndCents(4.34));

		 System.out.println(problem4_getDiscount(56, 3));
		 System.out.println(problem4_getDiscount(156, 13));
		 System.out.println(problem4_getDiscount(0, 0));
		
		problem5_giveChange();
				
		System.out.println(problem6_evenlySpaced(2,4,6));//true
		System.out.println(problem6_evenlySpaced(4,6,2));//true
		System.out.println(problem6_evenlySpaced(4,6,3));//false
		System.out.println(problem6_evenlySpaced(4,4,4));// returns true
		
		System.out.println(problem8_specialSum(1, 2, 3)); // returns 6
		System.out.println(problem8_specialSum(1, 2, 13)); // 3
		System.out.println(problem8_specialSum(-1, 13, 3)); // -1
		System.out.println(problem8_specialSum(13, 2, 3)); // 0
		
	
		TaxBill bill1 = new TaxBill(false, 65536);
		System.out.println("Bill 1 " + bill1.getAmountDue()); // returns 12784.0
		
		TaxBill bill2 = new TaxBill(true, 13553);
		System.out.println("Bill 2 " + bill2.getAmountDue()); // returns 1355.3000000000002

		TaxBill bill3 = new TaxBill(false, 28001.22);
		System.out.println("Bill 3 " + bill3.getAmountDue()); // returns 3800.183


		Distance d = new Distance(23.552);
		System.out.println(d.getMeters()); // 23.552
		System.out.println(d.getCentimeters()); // 2355.2
		System.out.println(d.getFeet()); // 77.274112
		System.out.println(d.getInches()); // 927.2422399999999
		System.out.println(d.getKilometers()); // 0.023552
		System.out.println(d.getMiles()); //  0.014637663144810442
		
		
		
		Rectangle r1 = new Rectangle(10.5, 22.5, 20.5, 12.5);
		System.out.println(r1.getOrientation()); // returns "square"
		Rectangle r2 = new Rectangle(10.5, 32.5, 21.5, 12.5);
		System.out.println(r2.getOrientation());; // returns "portrait"
		Rectangle r3 = new Rectangle(-10.5, 22.5, 21.5, 12.5);
		System.out.println(r3.getOrientation());; // returns "landscape"

		problem5_giveChange();
		
		*/

		
	}
}
