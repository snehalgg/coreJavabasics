package Oops;

class Shape {
    void printShape() {
        System.out.println("This is shape");
    }
}

class Rectangle extends Shape {
    void printShape() {
        System.out.println("This is rectangular shape");
    }
}

class Circle extends Shape {
    void printShape() {
        System.out.println("This is circular shape");
    }
}

class Square extends Rectangle {
    void printSquare() {
        System.out.println("Square is a rectangle");
    }
}

public class Shapes {
    public static void main(String[] args) {
        Square square = new Square();

        square.printShape();

        square.printSquare();
    }
}

