package linkedlist;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book other) {
        if (this.price < other.price) {
            return 1; 
        } else if (this.price > other.price) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: $" + price;
    }
}

public class BookSortingSoftware {
    public static void main(String[] args) {
        TreeMap<Book, Integer> books = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books by Price (Descending Order)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addBook(scanner, books);
                    break;
                case 2:
                    displayBooksByPriceDescending(books);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addBook(Scanner scanner, TreeMap<Book, Integer> books) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Book book = new Book(title, author, price);
        
        int count = books.getOrDefault(book, 0);
        books.put(book, count + 1);

        System.out.println("Book added successfully.");
    }

    public static void displayBooksByPriceDescending(TreeMap<Book, Integer> books) {
        System.out.println("Books sorted by price (descending order):");
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                System.out.println(book);
            }
        }
    }
}
