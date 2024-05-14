import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter operation (add, subtract, multiply, divide, exit): ");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter two numbers: ");
            double a;
            double b;
            try {
                a = scanner.nextDouble();
                b = scanner.nextDouble();
            } catch (Exception ignored) {
                System.out.println("Invalid input");
                continue;
            }
            try{
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
                        System.out.println("Unknown operation.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Exiting Calculator");
    }
}