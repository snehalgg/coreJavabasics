package array;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Task {
    private String name;
    private int hours;

    public Task(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }
}

class Employee {
    private String username;
    private String password;
    private List<Task> tasks;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
        tasks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}

public class EmployeeTimeTracker {
    private JFrame frame;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JTextField taskNameField;
    private JTextField hoursField;
    private JComboBox<String> employeeComboBox;
    private List<Employee> employees;

    public EmployeeTimeTracker() {
        employees = new ArrayList<>();
        employees.add(new Employee("admin", "admin"));

        frame = new JFrame("Task Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Employee:"));
        employeeComboBox = new JComboBox<>();
        for (Employee employee : employees) {
            employeeComboBox.addItem(employee.getUsername());
        }
        panel.add(employeeComboBox);

        panel.add(new JLabel("Task Name:"));
        taskNameField = new JTextField();
        panel.add(taskNameField);

        panel.add(new JLabel("Hours:"));
        hoursField = new JTextField();
        panel.add(hoursField);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        panel.add(addButton);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addTask() {
        String employeeUsername = (String) employeeComboBox.getSelectedItem();
        String taskName = taskNameField.getText();
        int hours = Integer.parseInt(hoursField.getText());

        for (Employee employee : employees) {
            if (employee.getUsername().equals(employeeUsername)) {
                Task task = new Task(taskName, hours);
                employee.addTask(task);
                listModel.addElement(employee.getUsername() + ": " + task.getName() + " - " + task.getHours() + " hours");
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeeTimeTracker();
            }
        });
    }
}

