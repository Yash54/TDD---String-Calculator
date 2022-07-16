package main.java.calc;

public class Calculator {
	
	// Function to add string arguments
    public static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (text.matches("//(.*)\n(.*)")) {
            delimiter = Character.toString(text.charAt(2));
            text = text.substring(4);
        }
        String[] numberList = text.split(delimiter + "|\n");
        return sum(numberList);
    }

    //Function to calculate sum of given numbers
    private static int sum(String[] numbers) {
        int total = 0;
        try {
            String negString = "";
            for (String number : numbers) {
                if (Integer.parseInt(number) < 0) {
                    if (negString.isEmpty()) {
                        negString = number;
                    } else {
                        negString += ("," + number);
                    }
                } else {
                    total += Integer.parseInt(number);
                }
            }

            if (!negString.isEmpty()) {
                throw new IllegalArgumentException("Negative values are not allowed: " + negString);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Argument is not an Integer format");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Unknown error occurred " + e.getMessage());
        }
        return total;
    }
}
