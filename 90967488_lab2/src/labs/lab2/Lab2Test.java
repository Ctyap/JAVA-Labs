package labs.lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class Lab2Test {

	@Test
	void problem1() {
		// Test case 1
		assertEquals("8 hours 30 minutes", Main.problem1_militaryTimeDifference(900, 1730));
		// Test case 2
		assertEquals("15 hours 30 minutes", Main.problem1_militaryTimeDifference(1730, 900));
		// Test case 3
		assertEquals("0 hours 0 minutes", Main.problem1_militaryTimeDifference(1630, 1630));
		// Test case 4
		assertEquals("1 hours 1 minutes", Main.problem1_militaryTimeDifference(630, 731));
	}

	@Test
	void problem2() {
		// Test case 1
		String input = "1.00\n10";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_calculateTotal();
		String total = output.toString();
		assertEquals("Enter price per mask: " + "Enter the number of masks: " + "Your total is: $13.25", total); // Check
																													// formatting
																													// carefully

	}

	@Test
	void problem3() {
		// Test case 1
		assertEquals("dollars: 2\n" + "cents: 95", Main.problem3_getDollarsAndCents(2.95)); // Check formatting
																							// carefully
		// Test case 2
		assertEquals("dollars: 4\n" + "cents: 34", Main.problem3_getDollarsAndCents(4.34));
	}

	@Test
	void problem4() {
		// Test case 1
		assertEquals(59, Main.problem4_getDiscount(56, 3));
		// Test case 2
		assertEquals(75, Main.problem4_getDiscount(156, 13));
		// Test case 3
		assertEquals(0, Main.problem4_getDiscount(0, 0));
	}

	@Test
	void problem5() {
		// Test case 1
		String input = "174\n300";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_giveChange();
		String change = output.toString();
		assertEquals("Enter amount due in cents: " + "Enter amount received in cents: "
				+ "Give the following change: \n" + "Dollars:              1\n" + "Quarters:             1\n"
				+ "Dimes:                0\n" + "Nickels:              0\n" + "Pennies:              1\n", change); // Check
																													// formatting
																													// carefully

		// Test case 2
		input = "382998\n998778";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_giveChange();
		change = output.toString();
		assertEquals("Enter amount due in cents: " + "Enter amount received in cents: "
				+ "Give the following change: \n" + "Dollars:           6157\n" + "Quarters:             3\n"
				+ "Dimes:                0\n" + "Nickels:              1\n" + "Pennies:              0\n", change); // Check
																													// formatting
																													// carefully

	}

	@Test
	void problem6() {
		// Test case 1
		assertEquals(true, Main.problem6_evenlySpaced(2, 4, 6));
		// Test case 2
		assertEquals(true, Main.problem6_evenlySpaced(4, 6, 2));
		// Test case 3
		assertEquals(false, Main.problem6_evenlySpaced(4, 6, 3));
		// Test case 4
		assertEquals(true, Main.problem6_evenlySpaced(4, 4, 4));
	}

	@Test
	void problem7() {
		Rectangle r1 = new Rectangle(10.5, 22.5, 20.5, 12.5);
		Rectangle r2 = new Rectangle(10.5, 32.5, 21.5, 12.5);
		Rectangle r3 = new Rectangle(-10.5, 22.5, 21.5, 12.5);
		// Test case 1
		assertEquals("square", r1.getOrientation());
		// Test case 2
		assertEquals("portrait", r2.getOrientation());
		// Test case 3
		assertEquals("landscape", r3.getOrientation());
	}

	@Test
	void problem8() {
		// Test case 1
		assertEquals(6, Main.problem8_specialSum(1, 2, 3));
		// Test case 2
		assertEquals(3, Main.problem8_specialSum(1, 2, 13));
		// Test case 3
		assertEquals(-1, Main.problem8_specialSum(-1, 13, 3));
		// Test case 4
		assertEquals(0, Main.problem8_specialSum(13, 2, 3));
	}

	@Test
	void problem9() {
		TaxBill bill1 = new TaxBill(false, 65536);
		TaxBill bill2 = new TaxBill(true, 13553);
		TaxBill bill3 = new TaxBill(false, 28001.22);
		// Test case 1
		assertEquals(12784.00, Math.round(bill1.getAmountDue() * 100.0) / 100.0); // Round off to 2 decimals
		// Test case 2
		assertEquals(1355.30, Math.round(bill2.getAmountDue() * 100.0) / 100.0);
		// Test case 3
		assertEquals(3800.18, Math.round(bill3.getAmountDue() * 100.0) / 100.0);
	}

	@Test
	void problem10() {
		// Test case 1
		Distance d = new Distance(23.552);
		assertEquals(23.55, Math.round(d.getMeters() * 100.0) / 100.0);
		assertEquals(2355.20, Math.round(d.getCentimeters() * 100.0) / 100.0);
		assertEquals(77.27, Math.round(d.getFeet() * 100.0) / 100.0);
		assertEquals(927.24, Math.round(d.getInches() * 100.0) / 100.0);
		assertEquals(0.024, Math.round(d.getKilometers() * 1000.0) / 1000.0);
		assertEquals(0.015, Math.round(d.getMiles() * 1000.0) / 1000.0);
	}

}
