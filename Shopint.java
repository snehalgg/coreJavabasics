import java.util.ArrayList;
import java.util.List;

interface Product {
    String getName();
    double getPrice();
}
class Book implements Product {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

     public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}

class Electronics implements Product {
    private String name;
    private double price;
    private String manufacturer;

    public Electronics(String name, double price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }
     public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

public class Shopint {
    public static void main(String[] args) {
        // Creating some sample products
        Product book1 = new Book("Java Programming", 29.99, "John Doe");
        Product book2 = new Book("Clean Code", 24.99, "Robert C. Martin");
        Product electronics1 = new Electronics("Smartphone", 699.99, "Samsung");
        Product electronics2 = new Electronics("Laptop", 1099.99, "Dell");

        // Creating a ShoppingCart
        ShoppingCart cart = new ShoppingCart();

        // Adding products to the cart
        cart.addProduct(book1);
        cart.addProduct(book2);
        cart.addProduct(electronics1);
        cart.addProduct(electronics2);

        // Calculating the total price
        double totalPrice = cart.getTotalPrice();

        // Displaying the total price
        System.out.println("Total Price of items in the cart: $" + totalPrice);
    }
}
