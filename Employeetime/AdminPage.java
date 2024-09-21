package Employeetime;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class AdminPage extends JFrame {
    private DefaultListModel<String> employeeListModel;
    private JList<String> employeeList;
    private JTextArea employeeTextArea;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public AdminPage() {
        setTitle("Admin Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        employeeListModel = new DefaultListModel<>();
        employeeList = new JList<>(employeeListModel);
        JScrollPane scrollPane = new JScrollPane(employeeList);

        employeeTextArea = new JTextArea(5, 20);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeDetails = employeeTextArea.getText();
                if (!employeeDetails.isEmpty()) {
                    employeeListModel.addElement(employeeDetails);
                    employeeTextArea.setText("");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String editedEmployeeDetails = employeeTextArea.getText();
                    employeeListModel.setElementAt(editedEmployeeDetails, selectedIndex);
                    employeeTextArea.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    employeeListModel.remove(selectedIndex);
                    employeeTextArea.setText("");
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(employeeTextArea, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.EAST);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminPage adminPage = new AdminPage();
                adminPage.setVisible(true);
            }
        });
    }
}
