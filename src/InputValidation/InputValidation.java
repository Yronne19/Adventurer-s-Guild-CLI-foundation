package InputValidation;

import java.util.Scanner;

public class InputValidation {
    private final Scanner scanner;

    public InputValidation(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputText(String message) {
        while (true) {
            System.out.print(message + ": ");
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Please enter a value.");
        }
    }

    public int inputNumberInRange(String message, int minimum, int maximum) {
        while (true) {
            System.out.printf("%s (%d-%d): ", message, minimum, maximum);
            String value = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(value);
                if (number >= minimum && number <= maximum) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
                // Show the same clear validation message for non-numeric input.
            }
            System.out.printf("Enter a whole number from %d to %d.%n", minimum, maximum);
        }
    }

    public boolean inputYesNo(String message) {
        while (true) {
            System.out.print(message + " (y/n): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Please enter y or n.");
        }
    }
}
