package array;

import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private double basicSalary;
    private double allowances;
    private double deductions;

    public Employee(String employeeId, String name, double basicSalary, double allowances, double deductions) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        double grossSalary = basicSalary + allowances;
        double netSalary = grossSalary - deductions;
        return netSalary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Allowances: " + allowances);
        System.out.println("Deductions: " + deductions);
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println();
    }
}

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Payroll Management System");

        System.out.print("Enter Employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = scanner.nextDouble();

        System.out.print("Enter Deductions: ");
        double deductions = scanner.nextDouble();

        Employee employee = new Employee(employeeId, name, basicSalary, allowances, deductions);
        employee.displayEmployeeDetails();

        scanner.close();
    }
}
