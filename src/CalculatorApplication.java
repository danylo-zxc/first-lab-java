import java.util.Scanner;
public class CalculatorApplication {
    private static final Calculator calculator = new Calculator();
    private static final Scanner scanner = new Scanner(System.in);

    private static void executeOperation(String operation) {
        try {
            double a;

            if (operation.equalsIgnoreCase("cube volume")) {
                a = getOneNumber("Enter one number: ");
                if (a >= 0) {
                    System.out.println("Result: " + calculator.cubeVolume(a));
                } else {
                    System.out.println("Invalid input. Side of the cube cannot be negative.");
                }
            } else if (operation.equalsIgnoreCase("square root")) {
                a = getOneNumber("Enter one number: ");
                if (a >= 0) {
                    System.out.println("Result: " + calculator.squareRoot(a));
                } else {
                    System.out.println("Invalid input. Square root argument cannot be negative.");
                }
            } else {
                executeDoubleOperations(operation);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeDoubleOperations(String operation) {
        double[] nums = getTwoNumbers("Enter two numbers: ");
        double a = nums[0];
        double b = nums[1];

        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("Result: " + calculator.add(a, b));
                break;
            case "subtract":
                System.out.println("Result: " + calculator.subtract(a, b));
                break;
            case "multiply":
                System.out.println("Result: " + calculator.multiply(a, b));
                break;
            case "divide":
                System.out.println("Result: " + calculator.divide(a, b));
                break;
            default:
                System.out.println("Unknown operation. Please enter correct operation name.");
        }
    }

    private static double getOneNumber(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }

    private static double[] getTwoNumbers(String message) {
        System.out.println(message);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        return new double[]{a, b};
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter operation (add, subtract, multiply, divide, cube volume, square root, exit): ");
            String operation = scanner.nextLine();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            executeOperation(operation);
        }
        scanner.close();
        System.out.println("Exiting Calculator");
    }
}