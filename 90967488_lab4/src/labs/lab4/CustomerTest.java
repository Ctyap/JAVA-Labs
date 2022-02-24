package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testPurchaseLessThan100() // Tests that a purchase less than $100 behaves as expected
	{
		Customer c = new Customer();
		c.makePurchase(75);
		assertEquals(0, c.getNumDiscountsToUse()); // returns 0
		assertEquals(75.0, c.getTotalAmountSpent()); // returns 75.0

	}
	
	@Test
	void testPurchaseMoreThan100() // Tests that a purchase more than $100 behaves as expected
	{
		Customer c = new Customer();
		c.makePurchase(130);
		assertEquals(1, c.getNumDiscountsToUse()); // returns 1
		assertEquals(130.0, c.getTotalAmountSpent()); // returns 75.0
		
	}
	
	@Test
	void testDiscountApplied() // Tests that a customer with exactly one discount to use gets that discount automatically applied correctly on their next purchase
	{
		Customer c = new Customer();
		c.makePurchase(75);
		c.makePurchase(50.25);
		assertEquals(1,c.getNumDiscountsToUse());
		c.makePurchase(9.99);
		assertEquals(0,c.getNumDiscountsToUse());
		assertEquals(134.24099999999999, c.getTotalAmountSpent());

	}
	
	@Test
	void testPurchaseEarningMultipleDiscounts() // Tests that a purchase that earns multiple discounts behaves as expected
	{
		Customer c = new Customer();
		c.makePurchase(300);
		assertEquals(3,c.getNumDiscountsToUse());
		c.makePurchase(10);
		assertEquals(2,c.getNumDiscountsToUse());
		c.makePurchase(10);
		assertEquals(1,c.getNumDiscountsToUse());
		c.makePurchase(10);
		assertEquals(0,c.getNumDiscountsToUse());
		assertEquals(327.0,c.getTotalAmountSpent());
		
	}
	
	@Test
	void testOnlyOneDiscountApplied() // Tests that only one discount is applied when the customer has multiple discounts to use
	{
		Customer c = new Customer();
		c.makePurchase(300);
		assertEquals(3,c.getNumDiscountsToUse());
		c.makePurchase(100);
		assertEquals(2,c.getNumDiscountsToUse());
		assertEquals(390.0,c.getTotalAmountSpent());
	}

}
