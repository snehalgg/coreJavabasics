import java.util.Scanner;

public class task {
    //1. Write a program to print the sum of the numbers 2, 4 and 5.

    // public static void main(String[] args) {
    //     int number1 = 2;
    //     int number2 = 4;
    //     int number3 = 5;

    //     int sum = number1 + number2 + number3;
    //     System.out.println("The sum of the numbers is: " + sum);
    // }

    //2. Length and breadth of a rectangle are 5 and 7 respectively Write a program to calculate the area and perimeter of the rectangle.

    // public static void main(String[] args) {
    //     int length = 5;
    //     int breadth = 7;

    //     int area = length * breadth;
    //     int perimeter = 2 * (length + breadth);

    //     System.out.println("Area of the rectangle: " + area);
    //     System.out.println("Perimeter of the rectangle: " + perimeter);
    // }

        //3. Write a program to check if the two numbers 23 and 45 are equal.

    // public static void main(String[] args) {
    //     int number1 = 23;
    //     int number2 = 45;

    //     if (number1 == number2) {
    //         System.out.println("The two numbers are equal.");
    //     } else {
    //         System.out.println("The two numbers are not equal.");
    //     }
    // }

    //4. If the marks of Robert in three subjects are 78,45 and 62 respectively (each out of 100), write a program to calculate his total marks and percentage marks.

    // public static void main(String[] args) {
    //     int subject1Marks = 78;
    //     int subject2Marks = 45;
    //     int subject3Marks = 62;

    //     int totalMarks = subject1Marks + subject2Marks + subject3Marks;
    //     double percentageMarks = (totalMarks / 300.0) * 100;

    //     System.out.println("Total marks: " + totalMarks);
    //     System.out.println("Percentage marks: " + percentageMarks + "%");
    // }

        //5. Suppose the values of variables 'a' and 'b' are 6 and 8 respectively, write two programs to swap the values of the two variables.
        //5.1 Using third variable

        // public static void main(String[] args) {
        //     int a = 6;
        //     int b = 8;
    
        //     // Swapping using a third variable 'c'
        //     int c = a;
        //     a = b;
        //     b = c;
    
        //     System.out.println("After swapping:");
        //     System.out.println("a = " + a);
        //     System.out.println("b = " + b);
        // }

        //5.2 Without using third variable

        // public static void main(String[] args) {
        //     int a = 6;
        //     int b = 8;
    
        //     // Swapping without using a third variable
        //     a = a + b;
        //     b = a - b;
        //     a = a - b;
    
        //     System.out.println("After swapping:");
        //     System.out.println("a = " + a);
        //     System.out.println("b = " + b);
        // }

      
      //  6. A shop will give a discount of 10% if the cost of purchased quantity is more than 1000. Ask user for quantity Suppose, one unit will cost 100. Judge and print total cost for user

    // public static void main(String[] args) {
    //     int unitCost = 100;
    //     double discountPercentage = 10;
    //     int minimumQuantityForDiscount = 1000;

    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter the quantity: ");
    //     int quantity = scanner.nextInt();
    //     scanner.close();

    //     int totalCost = unitCost * quantity;

    //     // Apply discount if the total cost is more than 1000
    //     if (totalCost > minimumQuantityForDiscount) {
    //         double discountAmount = (discountPercentage / 100) * totalCost;
    //         totalCost -= discountAmount;
    //     }

    //     System.out.println("Total cost: " + totalCost);
    // }

        //7. A school has following rules for grading system: a. Below25-F,  b. 25to45 -E, c. 45to50-D, d. 50to60-C e. 60to80-B f. Above 80-A Ask user to enter marks and print the grade

    //      public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter your marks: ");
    //     int marks = scanner.nextInt();
    //     scanner.close();

    //     char grade;

    //     if (marks < 25) {
    //         grade = 'F';
    //     } else if (marks >= 25 && marks <= 45) {
    //         grade = 'E';
    //     } else if (marks > 45 && marks <= 50) {
    //         grade = 'D';
    //     } else if (marks > 50 && marks <= 60) {
    //         grade = 'C';
    //     } else if (marks > 60 && marks <= 80) {
    //         grade = 'B';
    //     } else {
    //         grade = 'A';
    //     }

    //     System.out.println("Your grade is: " + grade);
    // }

    //8. A student will not be allowed to sit in exam if his/her attendence is less than 75% Take following input from user- Number of classes held, Number of classes attended. and print percentage of class attended . Is student allowed to sit in exam or not

    //  public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
        
    //     System.out.print("Enter the number of classes held: ");
    //     int totalClasses = scanner.nextInt();
        
    //     System.out.print("Enter the number of classes attended: ");
    //     int attendedClasses = scanner.nextInt();
        
    //     scanner.close();

    //     double attendancePercentage = (double) attendedClasses / totalClasses * 100;

    //     System.out.println("Attendance percentage: " + attendancePercentage + "%");

    //     if (attendancePercentage >= 75) {
    //         System.out.println("You are allowed to sit in the exam.");
    //     } else {
    //         System.out.println("You are not allowed to sit in the exam due to low attendance.");
    //     }
    // }

      //  9. write a program to check if a year is leap year or not. If a year is divisible by 4 then it is a leap year but if the year is a century like 2000, 1900, 2100 then it must be divisible by 400
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter a year: ");
    //     int year = scanner.nextInt();
    //     scanner.close();

    //     boolean isLeapYear = false;

    //     if (year % 4 == 0) {
    //         if (year % 100 == 0) {
    //             // If a century, check if it is divisible by 400
    //             if (year % 400 == 0) {
    //                 isLeapYear = true;
    //             }
    //         } else {
    //             // If not a century, it is a leap year
    //             isLeapYear = true;
    //         }
    //     }

    //     if (isLeapYear) {
    //         System.out.println(year + " is a leap year.");
    //     } else {
    //         System.out.println(year + " is not a leap year.");
    //     }
    // }

    
    // 10. Write a java program to calculate factorial of a number

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter a number: ");
    //     int number = scanner.nextInt();
    //     scanner.close();

    //     int factorial = 1;
    //     String factorialSteps = number + "! = ";

    //     for (int i = number; i >= 1; i--) {
    //         factorial *= i;
    //         factorialSteps += i;

    //         if (i != 1) {
    //             factorialSteps += " * ";
    //         }
    //     }

    //     System.out.println(factorialSteps + " = " + factorial);
    // }

      //  11. Take integer inputs from user until he/she presses q (Ask to press q to quit after every integer input). Print average and product of all numbers. 

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        int product = 1;

        char choice = ' ';

        while (choice != 'q') {
            System.out.print("Enter an integer (press 'q' to quit): ");
            String input = scanner.next();

            if (input.equals("q")) {
                choice = 'q';
            } else {
                int number = Integer.parseInt(input);
                sum += number;
                product *= number;
                count++;
            }
        }

        System.out.print("Enter 'a' to calculate average or 'p' to calculate product: ");
        char operationChoice = scanner.next().charAt(0);

        if (operationChoice == 'a') {
            double average = (double) sum / count;
            System.out.println("Average: " + average);
        } else if (operationChoice == 'p') {
            System.out.println("Product: " + product);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
      

}
