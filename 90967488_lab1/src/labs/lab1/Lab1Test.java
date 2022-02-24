package labs.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lab1Test {
	
	@BeforeEach
	void before() {
		//
	}
	
	@Test
	void problem1() {
		assertEquals("Helo", Main.problem1_firstLastN("Hello", 2));
		assertEquals("Choate", Main.problem1_firstLastN("Chocolate", 3));
		assertEquals("Ce", Main.problem1_firstLastN("Chocolate", 1));
		assertEquals("CC", Main.problem1_firstLastN("C", 1));
	}
	@Test
	void problem2() {
		assertEquals("ri", Main.problem2_middle("string"));
		assertEquals("od", Main.problem2_middle("code"));
		assertEquals("Oh", Main.problem2_middle("Oh"));
	}
	
	@Test
	void problem3() {
		
		String result = Main.problem3_rollDie(); 
		boolean correct = true;
		
		//The length of result must be 9 (it includes 4 spaces between the 5 numbers).
		if (result.length()!=9) {
			correct = false;
		}
		
		// All numbers must be integers less or equal to 6
		result = result.replaceAll("\\s","");
		for(int i=0; i<result.length();i++) {
			try {
				int number = Integer.parseInt(String.valueOf(result.charAt(i)));
				if(number > 6) {
					correct = false;
				}
			}catch(Exception e) {
				correct = false; //if conversion from string to integer fails
			}
		}		
		assertEquals(true, correct);
	}
	
	@Test
	void problem4() {
		assertEquals("t3reboR", Main.problem4_reverseAndInsert("Robert", 3));
		assertEquals("H899", Main.problem4_reverseAndInsert("H", 899));
		assertEquals("i-45h",Main.problem4_reverseAndInsert("hi", -45));
	}
	@Test
	void problem5() {	
		assertEquals("SATURDAY",Main.problem5_getDayOfWeek(12, 25, 2021));
		assertEquals("FRIDAY", Main.problem5_getDayOfWeek(12, 18, 2020));
		assertEquals("MONDAY", Main.problem5_getDayOfWeek(4, 2, 1934));
	}
	
	@Test
	void problem6() {	
		AntPopulation ants = new AntPopulation(10);
		ants.breed();
		ants.spray(10.0);
		assertEquals(18,ants.getAnts());
		ants.breed();
		ants.spray(5.0);
		assertEquals(35,ants.getAnts());
	}
	
	@Test
	void problem7_Functions() {
		CashRegister register = new CashRegister();
		// transaction #1:
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		assertEquals(2,register.getItemCountInPurchase()); // returns 2
		
		register.receivePayment(50.00);
	
		//register.getReceipt();
		
		register.giveChange();
		
		// transaction #2:
		register.recordPurchase(30);
		register.recordPurchase(10);
		register.receivePayment(50);
		register.giveChange();

		// transaction #3:
		register.recordPurchase(20);
		register.receivePayment(20);
		register.giveChange();
		assertEquals(98.75, register.getSalesTotal()); // returns 98.75
		assertEquals(3, register.getSalesCount()); // returns 3		
	}
	
	@Test
	void problem7_Receipt() {
		CashRegister register = new CashRegister();
		
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		register.receivePayment(50.00);

		String receipt = register.getReceipt();
		boolean correctReceipt = true; 
		
		Scanner scanner = new Scanner(receipt);
		List<Double> history = new ArrayList<>();
		
		try {
			while (scanner.hasNextLine()) {
				  String line = scanner.nextLine();	  
				  history.add(Double.valueOf(line));
			}			
		}catch(Exception e) {
			correctReceipt = false;
			System.out.println(e.getMessage()); //Something went wrong with the conversion from String to Double.
		}

		assertEquals(true, correctReceipt); //All numbers are doubles in different lines.
		assertEquals(3, history.size()); //Only 3 values in history
		
		if(history.size() == 3) {
			// All lines must be correct in content and order
			assertEquals(29.5, history.get(0));
			assertEquals(9.25, history.get(1));
			assertEquals(38.75, history.get(2));
		}
		scanner.close();
	}
	
	@Test
	void problem8() {
		Letter dearJohnLetter = new Letter("Mary", "John");
		dearJohnLetter.addLine("I am sorry we must part.");
		dearJohnLetter.addLine("I wish you all the best.");
		
		String message = dearJohnLetter.getText();
		Scanner scanner = new Scanner(message);
		List<String> letter = new ArrayList<>();
		
	    while (scanner.hasNextLine()) {
			String line = scanner.nextLine();	  
			letter.add(line);
		}			
	    scanner.close();
	    
	    assertEquals(8, letter.size());
	    
	    if(letter.size()==8){ //The size depends on the number of body lines we add to the letter. 
	    	assertEquals("DearJohn:", letter.get(0).replaceAll("\\s",""));
	    	assertEquals("Iamsorrywemustpart.", letter.get(2).replaceAll("\\s",""));
	    	assertEquals("Iwishyouallthebest.", letter.get(3).replaceAll("\\s",""));
	    	assertEquals("Mary", letter.get(7).replaceAll("\\s",""));	    	
	    }
	    /*
	     * 
	     	Dear John:

			I am sorry we must part. //body line 1
			I wish you all the best. //body line 2
			
			Sincerely,
			
			Mary
	     * 
	     * */
	
	}
	
	@Test
	void problem9() {
		Bug bugsy = new Bug(10);
		bugsy.move();
		assertEquals(11,bugsy.getPosition()); // returns 11
		bugsy.turn(); 
		bugsy.move(); 
		assertEquals(10,bugsy.getPosition()); // returns 10		
	}
	
	@Test
	void problem10() {
		Microwave appliance = new Microwave();
		appliance.increaseTime();
		appliance.increaseTime();
		appliance.increaseTime();
		appliance.switchPower();
		assertEquals("Cookingfor90secondsatlevel2",appliance.start().replaceAll("\\s",""));
		appliance.reset();
		appliance.increaseTime();
		appliance.switchPower();
		appliance.switchPower();
		assertEquals("Cookingfor30secondsatlevel1", appliance.start().replaceAll("\\s","")); // returns "Cooking for 30 seconds at level 1"		
	}
	
}
