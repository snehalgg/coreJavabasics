package Oops;

public class printint {
    // Method to print integer and character in the sequence (int, char)
    void print(int n, char c) {
        System.out.println("Integer: " + n + ", Character: " + c);
    }

    // Method to print integer and character in the sequence (char, int)
    void print(char c, int n) {
        System.out.println("Character: " + c + ", Integer: " + n);
    }

    public static void main(String[] args) {
        printint obj = new printint();

        // Call the method with (int, char) sequence
        obj.print(10, 'A');

        // Call the method with (char, int) sequence
        obj.print('B', 20);
    }
}

