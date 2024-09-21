package Employeetime;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EmployeeTimeTrackingPage extends JFrame {
    private JTextField employeeIdField;
    private JTextField taskIdField;
    private JButton startButton;
    private JButton endButton;
    private JButton submitButton;

    private Date startTime;
    private Date endTime;
    private String taskName;
    private String employeeName;

    private Map<String, Double> timeTrackMap = new HashMap<>();

    private final String connectionString = "jdbc:sqlserver://FGLAPNL207HFZT\\SQLEXPRESS;databaseName=WEBAPI_DB;IntegratedSecurity=true;";

    public EmployeeTimeTrackingPage(String employeeId) {
        setTitle("Employee Time Tracking");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdField = new JTextField(10);
        employeeIdField.setText(employeeId);

        JLabel taskIdLabel = new JLabel("Task Name:");
        taskIdField = new JTextField(10);

        startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            taskName = taskIdField.getText();
            startTime = new Date();
        });

        endButton = new JButton("End");
        endButton.addActionListener(e -> {
            if (startTime != null) {
                endTime = new Date();
            }
        });

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            if (startTime != null && endTime != null) {
                double workingHours = (endTime.getTime() - startTime.getTime()) / (60 * 60 * 1000.0);
                timeTrackMap.put(taskName, timeTrackMap.getOrDefault(taskName, 0.0) + workingHours);

                String taskDetails = "Task: " + taskName + "\n" +
                                    "Start Time: " + startTime + "\n" +
                                    "End Time: " + endTime + "\n" +
                                    "Working Hours: " + String.format("%.2f", workingHours) + " hours";

                saveTaskToDatabase(employeeId, employeeName, taskName, startTime, endTime, workingHours);

                JOptionPane.showMessageDialog(EmployeeTimeTrackingPage.this, taskDetails);

                startTime = null;
                endTime = null;
                taskName = null;
                taskIdField.setText("");
            } else {
                JOptionPane.showMessageDialog(EmployeeTimeTrackingPage.this,
                        "Please start and end the task before submitting.");
            }
        });

        panel.add(employeeIdLabel);
        panel.add(employeeIdField);
        panel.add(taskIdLabel);
        panel.add(taskIdField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(startButton);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(endButton);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(submitButton);

        add(panel);
    }

    private void saveTaskToDatabase(String employeeId, String employeeName, String taskName,
                                    Date startTime, Date endTime, double workingHours) {
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO EmployeeTimeTracking (EmployeeID, EmployeeName, TaskName, StartTime, EndTime, WorkingHours) " +
                             "VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, employeeId);
            statement.setString(2, employeeName);
            statement.setString(3, taskName);
            statement.setTimestamp(4, new java.sql.Timestamp(startTime.getTime()));
            statement.setTimestamp(5, new java.sql.Timestamp(endTime.getTime()));
            statement.setDouble(6, workingHours);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String employeeId = "123"; // Replace with the actual employee ID from login
            EmployeeTimeTrackingPage trackingPage = new EmployeeTimeTrackingPage(employeeId);
            trackingPage.setVisible(true);
        });
    }
}
