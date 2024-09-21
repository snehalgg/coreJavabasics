package Oops;

class Vehicle {
    String type;

    Vehicle(String type) {
        this.type = type;
    }

    void start() {
        System.out.println(type + " is starting.");
    }

    void stop() {
        System.out.println(type + " is stopping.");
    }
}

class Car extends Vehicle {
    Car() {
        super("Car");
    }
    @Override
    void start() {
        System.out.println("Ignition ON. " + type + " is starting.");
    }
}

class Motorcycle extends Vehicle {
    Motorcycle() {
        super("Motorcycle");
    }
    @Override
    void stop() {
        System.out.println("Pressing the brakes. " + type + " is stopping.");
    }
}

class Bicycle extends Vehicle {
    Bicycle() {
        super("Bicycle");
    }
}

public class Vehicles {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Motorcycle();
        vehicles[2] = new Bicycle();

        for (Vehicle vehicle : vehicles) {
            // Start and stop each vehicle
            vehicle.start();
            vehicle.stop();
            System.out.println();
        }
    }
}

//The @Override annotation is used in Java to indicate that a method in a subclass is intended to override a method with the same signature (method name, return type, and parameters) in its superclass. This annotation helps to ensure that the method is indeed overriding a superclass method, preventing potential bugs or unintended behavior in your code.