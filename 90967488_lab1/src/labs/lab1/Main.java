package labs.lab1;
import java.util.Random;
import java.lang.StringBuilder;
import java.time.LocalDate;
import java.time.DayOfWeek;


class Main {
	public static String problem1_firstLastN(String str, int n) {
		String first = str.substring(0,n); //Declare first half of string object and apply substring method (start, end).
		String second = str.substring(str.length() - n);//Declare second half of string object and apply substring method.
		
		return first + second; //Concatenate string objects.
	}
	
	public static String problem2_middle(String str) {
		int middle = str.length() / 2; //Divide even string by two.
		String first_half = str.substring(middle - 1, middle); //Obtain last char of first half of string.
		String second_half = str.substring(middle, middle + 1);//Obtain first char of second half of string.
		
		return first_half + second_half; //Concatenate string objects.
	}
	
	public static String problem3_rollDie() {
		Random rolldie = new Random(); //Instantiate Random class Object rolldie.
		String final_rolldie; //Create variable for return string.
		
		int random_num = rolldie.nextInt(6) + 1; //Instantiate int variable by applying Random class method to rolldie.
		int random_num1 = rolldie.nextInt(6) + 1; //Repeat 5 times; haven't learned loops yet.
		int random_num2 = rolldie.nextInt(6) + 1; //nextInt method obtains random number from (0-5), that why add 1.
		int random_num3 = rolldie.nextInt(6) + 1;
		int random_num4 = rolldie.nextInt(6) + 1;
		
		//Convert each random_num value to string and concatenate string objects to final_rolldie.
		final_rolldie = String.valueOf(random_num) + String.valueOf(random_num1) + String.valueOf(random_num2) + String.valueOf(random_num3) + String.valueOf(random_num4);
		
		
		return final_rolldie.replace(""," ").trim(); //Use replace method on String object to add space and eliminate leading and trailing spaces.
	}
	
	public static String problem4_reverseAndInsert(String str1, int num) {
		StringBuilder str = new StringBuilder(str1); //Instantiate a StringBuilder object to use StringBuilder methods.
		
		StringBuilder reverse_string = str.reverse(); //Instantiate a StringBuilder object and assign to reverse of str.
		reverse_string.insert(1, num); //Insert num value at index 1.
		
		
		
		return reverse_string.toString(); //Convert StringBuilder object to String object to print output.
	}
	
	public static String problem5_getDayOfWeek(int month, int day, int year) {

	    LocalDate date = LocalDate.of(year, month, day); //year-month-day
	    DayOfWeek dow = date.getDayOfWeek(); //gets day of week from LocalDate object


	    return dow.toString(); //returns a string representation of an object
	}

	public static void main(String[] args) {
		
		System.out.println(problem1_firstLastN("Hello", 2));// returns "Helo"
		System.out.println(problem1_firstLastN("Chocolate", 3));// returns "Choate"
		System.out.println(problem1_firstLastN("Chocolate", 1));// returns "Ce"
		System.out.println();
		
		System.out.println(problem2_middle("string"));// returns "ri"
		System.out.println(problem2_middle("code"));// returns "od"
		System.out.println(problem2_middle("Oh"));// returns "Oh"
		System.out.println();

		System.out.println(problem3_rollDie());// returns "6 3 1 4 6"
		System.out.println();

		System.out.println(problem4_reverseAndInsert("Robert", 3));// returns "t3reboR"
		System.out.println(problem4_reverseAndInsert("H", 899));// returns "H899"
		System.out.println(problem4_reverseAndInsert("hi", -45));// returns "i-45h"
		System.out.println();

		System.out.println(problem5_getDayOfWeek(12, 25, 2021)); // returns "SATURDAY"
		System.out.println(problem5_getDayOfWeek(12, 18, 2020)); // returns "FRIDAY"
		System.out.println(problem5_getDayOfWeek(4, 2, 1934)); // returns "MONDAY"

	}
}
