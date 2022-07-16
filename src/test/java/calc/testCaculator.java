package test.java.calc;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.calc.Calculator;

public class testCaculator {
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
		System.out.println("Empty String : Success");
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		System.out.println("String with 1 arugument : Success");
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
		System.out.println("String with 2 arugument : Success");
	}
}





