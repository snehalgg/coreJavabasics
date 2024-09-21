import java.util.Scanner;

class Area {
    double l1;
    double b1;
    Area(double l2, double b2) {
        l1 = l2;
        b1 = b2;
    }
    double returnArea() {
        return l1 * b1;
    }
}

public class Arearect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double l1 = scanner.nextDouble();

        System.out.print("Enter the breadth of the rectangle: ");
        double b1 = scanner.nextDouble();

        Area rectangle = new Area(l1, b1);
        System.out.println("Area of the rectangle is: " + rectangle.returnArea());

        scanner.close();
    }
}
