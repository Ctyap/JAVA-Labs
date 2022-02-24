package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class StudentTest {
	
	@Test
    public void testConstructor() {
		
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");
		Student britannie = null;
		
		assertTrue(bob instanceof Student);
		assertTrue(selena instanceof Student);
		assertTrue(austin instanceof Student);
		assertFalse(britannie instanceof Student);
		

    }

	@Test
    public void testName() {
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");
	
		assertEquals("Bob Charles", bob.getName());
		bob.setName("Bob Fire Charles");
		assertEquals("Bob Fire Charles", bob.getName());
		
		assertEquals("Selena Fam", selena.getName());
		selena.setName("");
		assertEquals("Selena Fam", selena.getName());

		assertEquals("Austin Banks Ender", austin.getName());
		
    }
	
	@Test
	@Order(1)
    public void testId() {
		
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");

		assertEquals(1, bob.getId());
		assertEquals(2, selena.getId());
		assertEquals(3, austin.getId());
		}
	
	@Test
    public void testGPA() {
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");
		
		bob.setGPA(-1);
		selena.setGPA(3.8);
		austin.setGPA(5.3);
		
		assertEquals(0.0, bob.getGPA());
		assertEquals(3.8, selena.getGPA());
		assertEquals(0.0, austin.getGPA());
		
    }
	
	@Test
    public void testHonors() {
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");
		
		bob.setGPA(-1);
		selena.setGPA(3.8);
		austin.setGPA(5.3);
		
		assertEquals(false, bob.isHonorsStudent());
		assertEquals(true, selena.isHonorsStudent());
		assertEquals(false, austin.isHonorsStudent());
		
		austin.setGPA(4.0);
		assertEquals(true, austin.isHonorsStudent());
		

		
	}
}
