import java.util.ArrayList;
import java.util.Scanner;

public class studarr {
    public static void main(String[] args) {
        ArrayList<String> studentsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer input

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String studentName = scanner.nextLine();
                    addStudent(studentsList, studentName);
                    break;
                case 2:
                    displayStudents(studentsList);
                    break;
                case 3:
                    System.out.print("Enter student's name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    removeStudent(studentsList, nameToRemove);
                    break;
                case 4:
                    System.out.print("Enter student's name to search: ");
                    String nameToSearch = scanner.nextLine();
                    searchStudent(studentsList, nameToSearch);
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Function to add a student to the list
    public static void addStudent(ArrayList<String> studentsList, String studentName) {
        studentsList.add(studentName);
        System.out.println(studentName + " has been added to the list.");
    }

    // Function to display the list of students
    public static void displayStudents(ArrayList<String> studentsList) {
        if (studentsList.isEmpty()) {
            System.out.println("The list is empty. No students to display.");
        } else {
            System.out.println("--- List of Students ---");
            for (String student : studentsList) {
                System.out.println(student);
            }
        }
    }

    // Function to remove a student from the list
    public static void removeStudent(ArrayList<String> studentsList, String studentName) {
        if (studentsList.remove(studentName)) {
            System.out.println(studentName + " has been removed from the list.");
        } else {
            System.out.println(studentName + " is not found in the list.");
        }
    }

    // Function to search for a specific student by name
    public static void searchStudent(ArrayList<String> studentsList, String studentName) {
        if (studentsList.contains(studentName)) {
            System.out.println(studentName + " is found in the list.");
        } else {
            System.out.println(studentName + " is not found in the list.");
        }
    }
}
