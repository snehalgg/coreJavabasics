package vms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends JFrame {
    private JTextField textFieldName;
    private JTextField textFieldLocation;
    private JTextField textFieldPhone;
    private JTextField textFieldPurpose;
    private JCheckBox checkBoxLaptop;
    private JTextField textFieldLaptopDetails;
    private JComboBox<String> comboBoxEmployee;
    private JLabel labelId;
    private JTextField textFieldDate;
    private JTextField textFieldTime;

    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("VMS System");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel labelName = new JLabel("Name:");
        textFieldName = new JTextField();
        JLabel labelLocation = new JLabel("Location:");
        textFieldLocation = new JTextField();
        JLabel labelPhone = new JLabel("Phone No:");
        textFieldPhone = new JTextField();
        JLabel labelPurpose = new JLabel("Purpose:");
        textFieldPurpose = new JTextField();
        JLabel labelEmployee = new JLabel("Employee:");
        comboBoxEmployee = new JComboBox<>();
        checkBoxLaptop = new JCheckBox("Carrying Laptop?");
        JLabel labelLaptopDetails = new JLabel("Laptop Details:");
        textFieldLaptopDetails = new JTextField();
        JLabel labelIdTitle = new JLabel("Visitor ID:");
        labelId = new JLabel();
        JLabel labelDate = new JLabel("Date:");
        textFieldDate = new JTextField();
        JLabel labelTime = new JLabel("Time:");
        textFieldTime = new JTextField();
        JButton buttonSubmit = new JButton("Submit");

        panel.add(labelName);
        panel.add(textFieldName);
        panel.add(labelLocation);
        panel.add(textFieldLocation);
        panel.add(labelPhone);
        panel.add(textFieldPhone);
        panel.add(labelPurpose);
        panel.add(textFieldPurpose);
        panel.add(labelEmployee);
        panel.add(comboBoxEmployee);
        panel.add(checkBoxLaptop);
        panel.add(textFieldLaptopDetails);
        panel.add(labelIdTitle);
        panel.add(labelId);
        panel.add(labelDate);
        panel.add(textFieldDate);
        panel.add(labelTime);
        panel.add(textFieldTime);
        panel.add(new JLabel()); // Empty space
        panel.add(buttonSubmit);

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation()) {
                    // Your database logic here
                    JOptionPane.showMessageDialog(HomePage.this, "Welcome to FGII");
                    clearData();
                } else {
                    JOptionPane.showMessageDialog(HomePage.this, "Enter all details");
                }
            }
        });

        checkBoxLaptop.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                textFieldLaptopDetails.setEnabled(checkBoxLaptop.isSelected());
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        pack();
    }

    private boolean validation() {
        // Implement your validation logic here
        // For simplicity, let's assume all fields are required
        return !textFieldName.getText().isEmpty() &&
               !textFieldLocation.getText().isEmpty() &&
               !textFieldPhone.getText().isEmpty() &&
               !textFieldPurpose.getText().isEmpty() &&
               comboBoxEmployee.getSelectedItem() != null;
    }

    private void clearData() {
        textFieldName.setText("");
        textFieldLocation.setText("");
        textFieldPhone.setText("");
        textFieldPurpose.setText("");
        comboBoxEmployee.setSelectedIndex(-1);
        checkBoxLaptop.setSelected(false);
        textFieldLaptopDetails.setText("");
        textFieldDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        textFieldTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        labelId.setText(""); // You need to generate a new ID
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
}
