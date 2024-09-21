package vms; 
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Form1 extends JFrame {
    public Form1() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VMS System");

        JMenuBar menuBar = new JMenuBar();
        JMenu visitorMenu = new JMenu("Visitor");
        JMenuItem showVisitorDataMenuItem = new JMenuItem("Show Visitor Data");
        visitorMenu.add(showVisitorDataMenuItem);
        menuBar.add(visitorMenu);
        setJMenuBar(menuBar);

        JButton photoButton = new JButton("Open Photo Form");
        JButton exitButton = new JButton("Exit");

        setLayout(new FlowLayout());
        add(photoButton);
        add(exitButton);

        photoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Photofrm frm = new Photofrm();
                frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frm.setLocationRelativeTo(Form1.this);
                frm.setVisible(true);
                frm.setOpacity(0.0f);
                Form1.this.repaint();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExitForm frm = new ExitForm();
                frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frm.setLocationRelativeTo(Form1.this);
                frm.setVisible(true);
                frm.setOpacity(0.0f);
                Form1.this.repaint();
            }
        });

        showVisitorDataMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrmUserRegister fr = new UserFrmUserRegister();
                fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fr.setLocationRelativeTo(Form1.this);
                fr.setVisible(true);
            }
        });

        addWindowListener(new WindowAdapter() {
            boolean close = true;

            @Override
            public void windowClosing(WindowEvent e) {
                if (close) {
                    int result = JOptionPane.showConfirmDialog(Form1.this,
                            "Are You Sure You Want To Exit", "Exit",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        close = false;
                        System.exit(0);
                    }
                }
            }
        });

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }
}
