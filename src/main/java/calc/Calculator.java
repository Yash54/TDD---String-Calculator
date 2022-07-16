package main.java.calc;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		
		String delimiter = ",";
		if(text.matches("//(.*)\n(.*)")){
			delimiter = Character.toString(text.charAt(2));
			text = text.substring(4);
		}
		String numberList[] = splitNum(text, delimiter + "|\n");
		return sum(numberList);
	}
	
	private static String[] splitNum(String numbers, String divider){
	    return numbers.split(divider);
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static int sum(String[] numbers){
		int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
		    total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negative values are not allowed: " + negString);
		}

		return total;
    }

}
