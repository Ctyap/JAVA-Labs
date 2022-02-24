package labs.lab7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class Lab7Test {
	
	@Test
	void problem1() {
		assertEquals(true, Main.problem1_contains6(new int[] {1, 6, 4}, 0)); // returns true
		assertEquals(false, Main.problem1_contains6(new int[] {1, 4}, 0)); // returns false
		assertEquals(true, Main.problem1_contains6(new int[] {6}, 0)); // returns true
		assertEquals(false, Main.problem1_contains6(new int[] {}, 0)); // returns false
	}
	
	@Test
	void problem2() {
		assertEquals("(abc)", Main.problem2_parenPart("xyz(abc)123")); // returns "(abc)"
		assertEquals("(hello)", Main.problem2_parenPart("x(hello)")); // returns "(hello)"
		assertEquals("(xy)", Main.problem2_parenPart("(xy) 1")); // returns "(xy)"
		assertEquals("()", Main.problem2_parenPart("()")); // returns "()"
	}

	@Test
	void problem3() {
		assertEquals("yza", Main.problem3_removeAdjacentDuplicates("yyzzza")); // returns "yza"
		assertEquals("abcd", Main.problem3_removeAdjacentDuplicates("abbbcdd")); // returns "abcd"
		assertEquals("Helo", Main.problem3_removeAdjacentDuplicates("Hello")); // returns "Helo"
		assertEquals("123", Main.problem3_removeAdjacentDuplicates("123")); // returns "123"
		assertEquals("", Main.problem3_removeAdjacentDuplicates("")); // returns ""
		assertEquals(" ", Main.problem3_removeAdjacentDuplicates("  ")); // returns " "
	}
	
	@Test
	void problem4() { //Tests Country Class
		Country myCountry = new Country("USA",331002651);
		Country myOtherCountry = new Country("Antarctica",1100);
		assertEquals("USA", myCountry.getName()); //returns USA
		assertEquals(331002651, myCountry.getPopulation()); //returns 331002651
		assertEquals(1, myCountry.compareTo(myOtherCountry)); //returns 1
	}
	
	@Test
	void problem5() { //Tests TravelRecord Class
		TravelRecord record = new TravelRecord();
		record.addCountry("USA", 331002651);
		record.addCountry("South Korea", 51269185);
		record.addCountry("Greece", 10423054);
		record.addCountry("Kenya", 53771296);
		assertEquals("Greece South Korea Kenya USA", record.getNamesOrderedByPopulation()); // returns "Antarctica Greece Australia South Korea Kenya Brazil USA"
		
		record.addCountry("Brazil", 212559417);
		record.addCountry("Australia", 25499884);
		record.addCountry("Antarctica", 1100);
		
		assertEquals("Antarctica Greece Australia South Korea Kenya Brazil USA", record.getNamesOrderedByPopulation()); // returns "Antarctica Greece Australia South Korea Kenya Brazil USA"
		assertEquals("Kenya", record.findCountryByPopulation(53771296).getName()); // returns "Kenya"
		assertEquals(10423054, record.findCountryByName("Greece").getPopulation()); // returns 10423054
		
		record.removeCountry(25499884);
		record.removeCountry("Antarctica");
		assertEquals("Greece South Korea Kenya Brazil USA", record.getNamesOrderedByPopulation()); // returns "Greece South Korea Kenya Brazil USA"
	}
	
	@Test
	void problem6() { //Tests Block Class
		Block myBlock = new Block(5,10);
		assertEquals(10, myBlock.getPrice()); //returns 10
		assertEquals(5, myBlock.getQuantity()); //returns 5
		
		myBlock.sell(4);
		assertEquals(1, myBlock.getQuantity()); //returns 1
	}
	
	@Test
	void problem7() { //Tests StockSimulator Class
		StockSimulator mySimulator = new StockSimulator();
	
		Block myBlock1 = new Block(100,12);
		Block myBlock2 = new Block(100,10);
		mySimulator.buy(100, 12);
		mySimulator.buy(100, 10);
		assertEquals(myBlock1.getPrice(), mySimulator.getBlocks().get(0).getPrice());
		assertEquals(myBlock1.getQuantity(), mySimulator.getBlocks().get(0).getQuantity());
		assertEquals(myBlock2.getPrice(), mySimulator.getBlocks().get(1).getPrice());
		assertEquals(myBlock2.getQuantity(), mySimulator.getBlocks().get(1).getQuantity());
			
		assertEquals(550, mySimulator.sell(150, 15));
		assertEquals(250, mySimulator.sell(50, 15));
		try { //Should fail
			mySimulator.sell(100, 5);
		}
		catch(IllegalArgumentException myException) {};
		
		try { //Again, should fail
			mySimulator.sell(20, 1);
		}
		catch(IllegalArgumentException myException) {};
	}
	
	@Test
	void problem8() { //Tests WordCounter Class
		WordCounter wc2 = new WordCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab7\\src\\labs\\lab7\\test2.txt"); //Take care of the file path
		ArrayList<String> result = new ArrayList<String>(Arrays.asList("a", "as", "but", "disappointment", 
				"down", "empty", "from", "great", "her", "it", "jar", "labelled", "marmalade", "of", "one", 
	              "orange", "passed", "she", "shelves", "the", "to", "took", "was"));
		assertEquals(23, wc2.getNumUniqueWords()); // returns 23
		assertEquals(26, wc2.getNumWords()); // returns 26
		assertEquals(result, wc2.getUniqueWords());
	}
	
	@Test
	void problem9() {
		String sentence1 = "Mary had a little lamb. Its fleece was white as snow.";
		String sentence2 = "Mary had afjdkslfaj874928374 888 little lamb. , s Its fleece was white as snow -.";
		assertEquals("Lamb little a had mary. Snow as white was fleece its.", Main.problem9_reverse(sentence1));
		assertEquals("Lamb little 888 afjdkslfaj874928374 had mary. - snow as white was fleece its s ,.", Main.problem9_reverse(sentence2));
	}
	
	@Test 
	void problem10() { //Tests PrintJob and Printer
		PrintJob myPrintJob = new PrintJob("CEO","Important document");
		PrintJob anotherPrintJob = new PrintJob("Manager","Not an important document");
		assertEquals(1, myPrintJob.getPriority());
		assertEquals("Important document", myPrintJob.getDescription());
		assertEquals("CEO", myPrintJob.getEmployeeType());
		assertTrue(myPrintJob.compareTo(anotherPrintJob) < 0); //Checks if myPrintJob.priority < anotherPrintJob.priority
		
		Printer myPrinter = new Printer();
		myPrinter.addJob("Manager","Not an important document");
		myPrinter.addJob("CEO","Important document");
		assertEquals(myPrintJob.getEmployeeType(), myPrinter.nextJob().getEmployeeType()); //CEO top priority
		assertEquals(anotherPrintJob.getDescription(), myPrinter.nextJob().getDescription()); //Next job executed
	}
}
