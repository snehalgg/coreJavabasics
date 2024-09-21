package devops;

public class Calculator {
    public int add(int a, int b) {
        int c = a + b;
        System.out.println(c);
        return c;
    }

    public int subtract(int a, int b) {
        int c = a - b;
        System.out.println(c);
        return c;
    }

    public int multiply(int a, int b) {
        int c = a * b;
        System.out.println(c);
        return c;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        double c = (double) a / b;
        System.out.println(c);
        return c;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(6, 4);
        calc.subtract(10, 3);
        calc.multiply(6, 8);
        calc.divide(15, 3);
    }
}
