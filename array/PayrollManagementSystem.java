package array;

import javax.swing.JOptionPane;

public class PayrollManagementSystem {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the salary: ");
        double a = Double.parseDouble(input);

        double pt;
        double it;
        double IT;

        // Calculate Basic Salary
        double basicSalary = 0.6 * a;

        // Calculate HRA
        double hra = 0.5 * basicSalary;

        // Calculate Conveyance Allowance, Medical Allowance, and Special Allowance
        double conveyanceAllowance = 1200;
        double medicalAllowance = 1250;
        double specialAllowance = 4000;

        // Calculate Gross Salary
        double grossSalary = basicSalary + hra + conveyanceAllowance + medicalAllowance + specialAllowance;

        // Calculate Income Tax
        if (grossSalary <= 15000) {
            pt = 0;
            it = 0;
        } else if (grossSalary <= 20000) {
            pt = 150;
            it = 0;
        } else if (grossSalary > 20000 && grossSalary <= 500000) {
            pt = 200;
            it = 0;
        } else if (grossSalary <= 1000000) {
            it = 0.1 * grossSalary;
            pt = 200;
        } else {
            it = 0.2 * grossSalary;
            pt = 200;
        }

        // Calculate Net Salary
        IT = it / 12;
        double netSalary = grossSalary - (pt + IT);
        double monthlysal = basicSalary/12;

        // Display the Results
        JOptionPane.showMessageDialog(null, "Basic Salary: " + basicSalary +
                "\nHRA: " + hra +
                "\nGross Salary: " + grossSalary +
                "\nIncome Tax: " + it +
                "\nPT: " + pt +
                "\nIT per month: " + IT +
                "\nNet Salary: " + netSalary+
                "\nNet Salary per month: " + monthlysal);
    }
}

