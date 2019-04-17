/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.border.TitledBorder;

/**
 *
 * @author user
 */
public class Login {

    void LoginFrame() throws IOException {
        JPanel p = new JPanel();

        TitledBorder title;
        title = BorderFactory.createTitledBorder("   Login");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(0, 0, 490, 490);
        p.setLayout(null);
        p.setBackground(Color.white);
        JFrame f = new JFrame("Login");

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(60, 60, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(60, 115, 80, 30);
        JLabel ic1 = new JLabel();
        Class cls = this.getClass();
        URL url = cls.getResource("anyfiles\\icon\\icon\\16.jpg");
        ic1.setIcon(new ImageIcon(url));
        ic1.setBounds(420, 10, 180, 130);

        url = cls.getResource("anyfiles\\icon\\icon\\6.png");
        JLabel ic2 = new JLabel(new ImageIcon(url));
        ic2.setBounds(390, 115, 80, 30);
        JLabel l3 = new JLabel("<html><body text=red> trouble in loggin ?</body></html>");
        l3.setBounds(100, 260, 200, 30);
        l3.setVisible(false);
        final JTextField text = new JTextField();
        text.setBounds(200, 60, 200, 30);
        text.setToolTipText("Type Admin username");
        final JPasswordField value = new JPasswordField();
        value.setBounds(200, 115, 200, 30);
        value.setToolTipText("Type Admin password");
        JButton b1 = new JButton("Login");
        b1.setBounds(80, 200, 100, 30);
        url = cls.getResource("anyfiles\\icon\\icon\\5.png");
        b1.setIcon(new ImageIcon(url));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        JButton b2 = new JButton("Signup");
        b2.setBounds(250, 200, 100, 30);
        url = cls.getResource("anyfiles\\icon\\icon\\3.png");
        b2.setIcon(new ImageIcon(url));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        JButton b3 = new JButton("Forget Password");
        b3.setBounds(250, 260, 200, 30);
        url = cls.getResource("anyfiles\\icon\\icon\\7.png");
        b3.setIcon(new ImageIcon(url));
        b3.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(ic1);
        p.add(ic2);
        p.add(l3);
        p.add(value);
        p.add(l1);

        p.add(l2);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(text);

        f.add(p);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(700, 200, 500, 500);
        File file = new File(".\\true.txt");
        if (file.exists()) {
            b2.setVisible(false);

        } else {
            // file.createNewFile();
        }

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                /*  Connection con = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Driver Loaded");
                    String username = text.getText();
                    String password = new String(value.getPassword());
                    //getPassword return char[] and to pass as a string in parameter we do new String(myarray); 
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", username, password);

                    System.out.println("Connection Establishment");
                    label.setText("Connection Establishment");
                    System.out.println("Connection Establishment");
                    label.setText("Connection Establishment");

                } catch (ClassNotFoundException e) {
                    System.out.println("Exception " + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("SQLException " + e.getMessage());
                }
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Connection Exception :" + e.getMessage());
                }
                f.setVisible(false);
                ProgressBarExample p1=new ProgressBarExample();
              //  SwingUtilities.invokeLater(new ProgressBarExample());
                 */
                JavaConnection dm = new JavaConnection();
                dm.connection();
                String username = text.getText();
                String password = new String(value.getPassword());
                String login = "Select username,password from Sign where username='" + username + "' AND password='" + password + "'";
                ResultSet rs = dm.executeQuery(login);
                try {
                    if (rs.next()) {
                        //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));

                        if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                            f.setVisible(false);
                            ProgressBarExample p1 = new ProgressBarExample();
                        } else {
                            l3.setVisible(true);
                            JOptionPane.showMessageDialog(f, "Wrong username,  Password!");
                        }
                    } else {
                        l3.setVisible(true);
                        JOptionPane.showMessageDialog(f, "Wrong username , Password!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(f, e);

                }

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                f.setVisible(false);
                Signup signup = new Signup();
                signup.setVisible(true);

            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                ForgetPassword forget = new ForgetPassword();
                forget.setVisible(true);

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class rt {

    public static void main(String[] args) throws IOException {
        Login s = new Login();
        s.LoginFrame();
        // s.call();

    }
}
