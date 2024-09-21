package array;
import java.util.Scanner;
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Node {
    Product product;
    Node next;

    public Node(Product product) {
        this.product = product;
        this.next = null;
    }
}



class ShoppingCart {
    Node head;

    public ShoppingCart() {
        head = null;
    }

    public void addProduct(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println(product.name + " added to the cart.");
    }

    public void viewCart() {
        System.out.println("Products in the cart:");
        Node current = head;
        while (current != null) {
            System.out.println(current.product.name + " - $" + current.product.price);
            current = current.next;
        }
    }

    public void removeProduct(String productName) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.product.name.equalsIgnoreCase(productName)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println(productName + " removed from the cart.");
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println(productName + " not found in the cart.");
    }

public double getTotalPrice() {
        double total = 0.0;
        Node current = head;
        while (current != null) {
            total += current.product.price;
            current = current.next;
        }
        return total;
    }
}



public class Shoppings {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // User input loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add product to cart");
            System.out.println("2. View cart");
            System.out.println("3. Remove product from cart");
            System.out.println("4. Calculate total price");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after nextDouble()
                    cart.addProduct(new Product(name, price));
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    System.out.print("Enter the name of the product to remove: ");
                    String productName = scanner.nextLine();
                    cart.removeProduct(productName);
                    break;
                case 4:
                    double totalPrice = cart.getTotalPrice();
                    System.out.println("Total price in the cart: $" + totalPrice);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

