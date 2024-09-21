package student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Student {
    int id;
    String name;
    int age;
    String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

class StudentManagementSystem {
    // Keep track of your students in memory
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student existingStudent : students) {
        if (existingStudent.id == student.id) {
            JOptionPane.showMessageDialog(null, "Error: Student with the same ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without adding the student
        }
    }
        students.add(student);
    }

    public void updateStudent(int id, String newCourse) {
        for (Student student : students) {
            if (student.id == id) {
                student.course = newCourse;
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.id == id);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

public class studentms {
    private static StudentManagementSystem system = new StudentManagementSystem();

    // Define your connection string
    private static final String CONNECTION_STRING = "jdbc:sqlserver://localhost:1433;databaseName=student;user=your_username;password=your_password";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // ... (your existing GUI code)
        panel.setLayout(new FlowLayout()); // Set layout manager to FlowLayout

        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
    
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(updateButton);
        panel.add(deleteButton);
    


       addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Show a dialog to get student details and add to the system
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
        String name = JOptionPane.showInputDialog("Enter Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        String course = JOptionPane.showInputDialog("Enter Course:");

        Student newStudent = new Student(id, name, age, course);
        system.addStudent(newStudent);
    }
});


viewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Show a dialog to display all students
        ArrayList<Student> students = system.getStudents();
        StringBuilder message = new StringBuilder();
        for (Student student : students) {
            message.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
});


updateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Show a dialog to get student ID and new course, then update in the system
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
        String newCourse = JOptionPane.showInputDialog("Enter New Course:");
        system.updateStudent(id, newCourse);
    }
});


deleteButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Show a dialog to get student ID and delete from the system
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?");
        if (confirm == JOptionPane.YES_OPTION) {
            system.deleteStudent(id);
        }
    }
});

    }

    // Method to connect to the database
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING);
    }

    // Example method to retrieve data from the database
    private static ArrayList<Student> getStudentsFromDatabase() {
        ArrayList<Student> students = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String course = resultSet.getString("Course");

                students.add(new Student(id, name, age, course));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
