package test.java.calc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Random;
import org.junit.Test;
import main.java.calc.Calculator;

public class testCalculator {
	
	//Test case for empty string
    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
        System.out.println("Empty String : Success");
    }

    //Test case for one argument string
    @Test
    public void testOneNumber() {
    	// Hard code test case
        assertEquals(1, Calculator.add("1"));
        
        // Dynamic test case
        Random rand = new Random();
        int a = Math.abs(rand.nextInt());
        assertEquals(a, Calculator.add(a + ""));
        System.out.println("String with 1 argument : Success");
    }

    //Test case for two argument string
    @Test
    public void testTwoNumbers() {
    	// Hard code test case
        assertEquals(3, Calculator.add("1,2"));
        
        // Dynamic test case
        Random rand = new Random();
        int a = Math.abs(rand.nextInt(100000));
        int b = Math.abs(rand.nextInt(100000));
        int expectedSum = a + b;
        assertEquals(expectedSum, Calculator.add(a + "," + b));
        System.out.println("String with 2 argument : Success");
    }

    //Test case for unknown number of argument string
    @Test
    public void testUnknownNumbers() {
    	// Hard code test case
        assertEquals(6, Calculator.add("1,2,3"));
        assertEquals(10, Calculator.add("1,2,3,4"));
        
        // Dynamic test case
        Random random = new Random();
        StringBuilder argument = new StringBuilder();
        int expectedSum = 0;
        for (int i = 0; i < random.nextInt(100); i++) {
            final int number = Math.abs(random.nextInt(100000));
            argument.append(number).append(",");
            expectedSum += number;
        }
        final String finalArgument = argument.substring(0, argument.length() - 1);
        assertEquals(expectedSum, Calculator.add(finalArgument));
        System.out.println("String with unknown number of argument : Success");
    }

    @Test
    public void testNumberFormatException() {
        boolean flag = false;
        try {
            Calculator.add("1,2fdg,3");
        } catch (NumberFormatException e) {
            flag = true;
        }
        assertTrue(flag);
        System.out.println("Argument is not an Integer format");
    }

    //Test case for new line argument string
    @Test
    public void testNewLine() {
        assertEquals(6, Calculator.add("1\n2,3"));
        System.out.println("String with new line argument : Success");
    }

    //Test case for different delimiter arguments
    @Test
    public void testOtherDelimiter() {
        assertEquals(3, Calculator.add("//:\n1:2"));
        System.out.println("String with ':' delimiter : Success");
        assertEquals(3, Calculator.add("//;\n1;2"));
        System.out.println("String with ';' delimiter : Success");
        assertEquals(3, Calculator.add("//#\n1#2"));
        System.out.println("String with '#' delimiter : Success");
    }

    //Test case for negative number argument string
    @Test
    public void testNegativeNumver() {
        boolean flag = false;
        try {
            Calculator.add("-3,-4");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            flag = true;
        }
        assertTrue(flag);
    }
}





