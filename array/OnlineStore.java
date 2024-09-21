package array;

class Product {
    protected String name;
    protected double price;

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


class Electronics extends Product {
    private int warranty;

    public Electronics(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    public boolean isEligibleForReturn() {
        if (price < 200){
            return false;
        }
        else {
            return true;
        }
       
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

   
}
class Books extends Product {
    private String author;

    public Books(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

}

public class OnlineStore {
    public static void main(String[] args) {
        
        Product product1 = new Electronics("Laptop", 999.99, 2);
        Product product2 = new Clothing("T-Shirt", 19.99, "M");
        Product product3 = new Books("Harry Potter", 29.99, "J.K. Rowling");

       
        System.out.println("Product Name: " + product1.getName());
        System.out.println("Product Price: $" + product1.getPrice());

       
        if (product1 instanceof Electronics) {
            Electronics electronics = (Electronics) product1;
            boolean isEligible = electronics.isEligibleForReturn();
            System.out.println("Is Eligible for Return: " + isEligible);
        }

        // Additional operations specific to Clothing or Books
    }
}
