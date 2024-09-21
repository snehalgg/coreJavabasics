package array;

class Employee {
    protected String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: $" + basicSalary);
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double basicSalary, double bonus) {
        super(name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

class Engineer extends Employee {
    private double overtimePay;

    public Engineer(String name, double basicSalary, double overtimePay) {
        super(name, basicSalary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + overtimePay;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overtime Pay: $" + overtimePay);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

class Salesperson extends Employee {
    private double commission;

    public Salesperson(String name, double basicSalary, double commission) {
        super(name, basicSalary);
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + commission;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Commission: $" + commission);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("Muazzam", 50000, 1000);
        employees[1] = new Engineer("Dhruv", 40000, 500);
        employees[2] = new Salesperson("Ayuchan", 30000, 300);

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println();
        }
    }
}
