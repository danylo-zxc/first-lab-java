import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter operation (add, subtract, multiply, divide, cube volume, exit): ");
            String operation = scanner.nextLine();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            double a;
            double b;
            try {
                if (operation.equalsIgnoreCase("cube volume")) {
                    System.out.println("Enter one number: ");
                    a = Double.parseDouble(scanner.nextLine());
                    if (a < 0) {
                        System.out.println("Invalid input. Side of the cube cannot be negative.");
                        continue;
                    }
                    System.out.println("Result: " + calculator.cubeVolume(a));
                } else {
                    System.out.println("Enter two numbers: ");
                    a = Double.parseDouble(scanner.nextLine());
                    b = Double.parseDouble(scanner.nextLine());
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
                            System.out.println("Unknown operation. Please enter add, subtract, multiply, divide, or cube volume.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Exiting Calculator");
    }
}