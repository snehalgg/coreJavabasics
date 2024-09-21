class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

public class ThrowsExample {
    public static void main(String arg[]) {
        try {
            processInput(10);
        } catch (MyCustomException e) {
            System.out.println("Custom Exception Raised");
        }
    }

    public static void processInput(int value) throws MyCustomException {
        if (value < 0) {
            throw new MyCustomException("Input Should be a positive number");
        }
    }
}
