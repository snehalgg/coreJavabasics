package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        LinkedList<Product> cart = new LinkedList<>();
        Map<Product, Integer> cartItems = new HashMap<>();
        LinkedList<Product> shopData = new LinkedList<>();

        shopData.add(new Product("Phone", 500.0));
        shopData.add(new Product("Laptop", 1000.0));
        shopData.add(new Product("Headphones", 50.0));
        shopData.add(new Product("Shirt", 25.0));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Shopping Cart ---");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Buy Products");
            System.out.println("4. Return Products");
            System.out.println("5. Display Cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts(shopData);
                    System.out.print("Enter product number to add to cart or press 'q' to exit: ");
                    String input = scanner.next().toLowerCase();
                    while (!input.equals("q")) {
                        int productNumToAdd = Integer.parseInt(input);
                        if (productNumToAdd >= 1 && productNumToAdd <= shopData.size()) {
                            Product selectedProduct = shopData.get(productNumToAdd - 1);
                            System.out.print("Enter quantity: ");
                            int quantity = scanner.nextInt();

                            if (quantity > 0) {
                                cart.add(selectedProduct);
                                cartItems.put(selectedProduct, quantity);
                                System.out.println("Product added to cart.");
                            } else {
                                System.out.println("Invalid quantity.");
                            }
                        } else {
                            System.out.println("Invalid product number.");
                        }
                        System.out.print("Enter product number to add to cart or press 'q' to exit: ");
                        input = scanner.next().toLowerCase();
                    }
                    break;
                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty. Add products to cart first.");
                    } else {
                        displayCart(cartItems);
                        System.out.print("Enter product number to remove from cart: ");
                        int productNumToRemove = scanner.nextInt();
                        if (productNumToRemove >= 1 && productNumToRemove <= cart.size()) {
                            Product productToRemove = cart.get(productNumToRemove - 1);
                            cart.remove(productToRemove);
                            cartItems.remove(productToRemove);
                            System.out.println("Product removed from cart.");
                        } else {
                            System.out.println("Invalid product number.");
                        }
                    }
                    break;
                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty. Add products to cart first.");
                    } else {
                        double totalAmount = 0;
                        System.out.println("--- Receipt ---");
                        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
                            Product product = entry.getKey();
                            int quantity = entry.getValue();
                            double productTotal = product.getPrice() * quantity;
                            System.out.println(product.getName() + " (Qty: " + quantity + "): $" + productTotal);
                            totalAmount += productTotal;
                        }
                        System.out.println("Total Amount: $" + totalAmount);
                        cart.clear();
                        cartItems.clear();
                    }
                    break;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty. Add products to cart first.");
                    } else {
                        cart.clear();
                        cartItems.clear();
                        System.out.println("Cart emptied. Products returned.");
                    }
                    break;
                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        displayCart(cartItems);
                    }
                    break;
                case 6:
                    System.out.println("Exiting Shopping Cart.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void displayProducts(LinkedList<Product> shopData) {
        System.out.println("--- Shop's Data ---");
        for (int i = 0; i < shopData.size(); i++) {
            System.out.println((i + 1) + ". " + shopData.get(i).getName() + ": $" + shopData.get(i).getPrice());
        }
    }

    public static void displayCart(Map<Product, Integer> cartItems) {
        System.out.println("--- Shopping Cart ---");
        int i = 1;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(i + ". " + product.getName() + " (Qty: " + quantity + ")");
            i++;
        }
    }
}

