import java.util.ArrayList;
import java.util.Scanner;

public class Arylisteg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbersList = new ArrayList<>();

        System.out.println("Enter integers (enter '-1' to stop):");
        int number;
        while ((number = scanner.nextInt()) != -1) {
            numbersList.add(number);
        }

        System.out.println("Prime Numbers in the List:");
        for (int num : numbersList) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
