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
	
	@Test
    public void testUnknownNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(10, Calculator.add("1,2,3,4"));
    	System.out.println("String with unknown number of arugument : Success");
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    	System.out.println("String with new line arugument : Success");
    }
    
    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.add("//:\n1:2"));
    	System.out.println("String with ':' delimiter : Success");
    	assertEquals(3, Calculator.add("//;\n1;2"));
    	System.out.println("String with ';' delimiter : Success");
    	assertEquals(3, Calculator.add("//`\n1`2"));
    	System.out.println("String with '`' delimiter : Success");
    }
}





