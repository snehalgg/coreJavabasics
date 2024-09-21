//Write a Java program that takes two integer inputs from the user and performs division on them. Handle the case where the user attempts to divide by zero by using exception handling

// import java.util.Scanner;

// public class Exceptask {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the dividend (numerator): ");
//         int dividend = scanner.nextInt();

//         System.out.print("Enter the divisor (denominator): ");
//         int divisor = scanner.nextInt();

//         try {
//             int result = divide(dividend, divisor);
//             System.out.println("Result of division: " + result);
//         } catch (ArithmeticException e) {
//             System.out.println("Error: " + e.getMessage());
//         }

//         scanner.close();
//     }

//     public static int divide(int dividend, int divisor) throws ArithmeticException {
//         if (divisor == 0) {
//             throw new ArithmeticException("Cannot divide by zero.");
//         }

//         return dividend / divisor;
//     }
// }


//2. Create a Java program that initializes an array of integers. Take input from the user for an index and display the element at that index. Handle the case where the user enters an invalid index (out of bounds) using eception handling

// import java.util.Scanner;

// public class Exceptask {
//     public static void main(String[] args) {
//         int[] array = { 10, 20, 30, 40, 50 };
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the index to fetch the element: ");
//         int index = scanner.nextInt();

//         try {
//             int element = getElementAtIndex(array, index);
//             System.out.println("Element at index " + index + ": " + element);
//         } catch (IndexOutOfBoundsException e) {
//             System.out.println("Error: " + e.getMessage());
//         }

//         scanner.close();
//     }

//     public static int getElementAtIndex(int[] array, int index) throws IndexOutOfBoundsException {
//         if (index < 0 || index >= array.length) {
//             throw new IndexOutOfBoundsException("Invalid index. Index should be between 0 and " + (array.length - 1));
//         }

//         return array[index];
//     }
// }

    // 3. Write a Java program that converts one currency amount to another. Use exception handling to handle any issues related to invalid input or currency conversion errors 
// import java.util.Scanner;

// public class Exceptask {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         try {
//             System.out.print("Enter the amount in your currency: ");
//             double amount = scanner.nextDouble();

//             System.out.print("Enter the exchange rate (your currency to target currency): ");
//             double exchangeRate = scanner.nextDouble();

//             double convertedAmount = convertCurrency(amount, exchangeRate);
//             System.out.println("Converted amount in target currency: " + convertedAmount);
//         } catch (Exception e) {
//             System.out.println("Error: " + e.getMessage());
//         }

//         scanner.close();
//     }

//     public static double convertCurrency(double amount, double exchangeRate) throws IllegalArgumentException {
//         if (amount < 0) {
//             throw new IllegalArgumentException("Invalid amount. Amount should be a positive number.");
//         }

//         if (exchangeRate <= 0) {
//             throw new IllegalArgumentException("Invalid exchange rate. Exchange rate should be a positive number.");
//         }

//         double convertedAmount = amount * exchangeRate;
//         return convertedAmount;
//     }
// }

// 4. Create a custom exception class called InvalidPasswordException. Write a program that asks the user to input a password. If the password does not meet certain criteria (eg. minimum length or specific characters), throw the InvalidPasswordException
// import java.util.Scanner;

// class InvalidPasswordException extends Exception {
//     public InvalidPasswordException(String message) {
//         super(message);
//     }
// }

// public class Exceptask {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         try {
//             System.out.print("Enter your password: ");
//             String password = scanner.nextLine();

//             validatePassword(password);
//             System.out.println("Password is valid.");
//         } catch (InvalidPasswordException e) {
//             System.out.println("Invalid Password: " + e.getMessage());
//         }

//         scanner.close();
//     }

//     public static void validatePassword(String password) throws InvalidPasswordException {
//         int minimumLength = 8; 
//         if (password.length() < minimumLength) {
//             throw new InvalidPasswordException("Password should be at least " + minimumLength + " characters long.");
//         }
//     }
// }

// 5. Password Strength Checker: Create a program that prompts the user to enter a password and checks its strength (e.g., minimum length, presence of uppercase letters, lowercase letters, and special characters). If the password does not meet the criteria, throw a custom exception called WeakPasswordException.

// import java.util.Scanner;

// class WeakPasswordException extends Exception {
//     public WeakPasswordException(String message) {
//         super(message);
//     }
// }

// public class Exceptask {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         try {
//             System.out.print("Enter your password: ");
//             String password = scanner.nextLine();

//             checkPasswordStrength(password);
//             System.out.println("Password is strong.");
//         } catch (WeakPasswordException e) {
//             System.out.println("Weak Password: " + e.getMessage());
//         }

//         scanner.close();
//     }

//     public static void checkPasswordStrength(String password) throws WeakPasswordException {
//         int minimumLength = 8;

//         if (password.length() < minimumLength) {
//             throw new WeakPasswordException("Password should be at least " + minimumLength + " characters long.");
//         }

//         if (!password.matches(".*[A-Z].*")) {
//             throw new WeakPasswordException("Password should contain at least one uppercase letter.");
//         }

//         if (!password.matches(".*[a-z].*")) {
//             throw new WeakPasswordException("Password should contain at least one lowercase letter.");
//         }

//         if (!password.matches(".*[!@#$%^&*()-_=+\\|[{]};:'\",<.>/?].*")) {
//             throw new WeakPasswordException("Password should contain at least one special character.");
//         }

//     }
// }

// 6. Write a Java program for a simple shopping cart. If the user tries to add an item with a negative price or quantity, throw a custom exception called InvalidItemException.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidItemException extends Exception {
    public InvalidItemException(String message) {
        super(message);
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) throws InvalidItemException {
        if (price < 0 || quantity < 0) {
            throw new InvalidItemException("Price and quantity cannot be negative.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String toString() {
        return name + " (Price: $" + price + ", Quantity: " + quantity + ")";
    }
}

public class Exceptask {
    public static void main(String[] args) {
        List<Item> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter item name (or 'done' to finish): ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Enter item price: ");
                double price = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter item quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                Item item = new Item(name, price, quantity);
                cart.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price and quantity.");
            } catch (InvalidItemException e) {
                System.out.println("Invalid item: " + e.getMessage());
            }
        }

        if (!cart.isEmpty()) {
            System.out.println("Shopping Cart Contents:");
            double totalAmount = 0.0;
            for (Item item : cart) {
                System.out.println(item);
                totalAmount += item.getTotalPrice();
            }
            System.out.println("Total Amount: $" + totalAmount);
        } else {
            System.out.println("Shopping Cart is empty.");
        }

        scanner.close();
    }
}
