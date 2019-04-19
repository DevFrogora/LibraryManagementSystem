/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author user
 */
public class Signup extends JFrame {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    String Question[];
    String username, name, password, answer, question;
    JComboBox SecurityQuestion;
    JButton create, Back;

    Signup() {
        JPanel p = new JPanel();

        TitledBorder title;
        title = BorderFactory.createTitledBorder("  Signup");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(0, 0, 490, 490);
        p.setLayout(null);
        p.setBackground(Color.white);
        setBounds(800, 200, 400, 400);
        setTitle("Signup");
        setLayout(null);
        l1 = new JLabel("UserName");
        l1.setBounds(40, 60, 100, 30);
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(40, 100, 100, 30);
        p.add(l2);
        l3 = new JLabel("Password");
        l3.setBounds(40, 140, 100, 30);
        p.add(l3);
        l4 = new JLabel("Security Question");
        l4.setBounds(40, 180, 200, 30);
        p.add(l4);
        l5 = new JLabel("Answer");
        l5.setBounds(40, 220, 100, 30);
        p.add(l5);
        t1 = new JTextField();
        t1.setBounds(240, 60, 200, 30);
        p.add(t1);
        t2 = new JTextField();
        t2.setBounds(240, 100, 200, 30);
        p.add(t2);
        t3 = new JTextField();
        t3.setBounds(240, 140, 200, 30);
        p.add(t3);
        Question = new String[]{"What is your nick name?", "Who is your Best Friend", "What is your Mother name?"};
        SecurityQuestion = new JComboBox(Question);
        SecurityQuestion.setBounds(240, 180, 200, 30);
        p.add(SecurityQuestion);

        t4 = new JTextField();
        t4.setBounds(240, 220, 200, 30);
        p.add(t4);

        create = new JButton("Create");
        create.setBounds(70, 340, 100, 30);
        
     
        create.setIcon(new ImageIcon(getClass().getResource("/12.png")));

        create.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(create);
        Back = new JButton("Back");
        Back.setBounds(290, 340, 100, 30);
        
        Back.setIcon(new ImageIcon(getClass().getResource("/11.png")));

        Back.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(Back);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login w = new Login();
                try {
                    w.LoginFrame();
                } catch (Exception ev) {
                }
            }

        });
        add(p);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //  try {
                storeData();
                // } catch (Exception x) {

                //  System.out.println("Try again because we just fixed a issue");
                //}
            }

        });
    }

    void storeData() {
        username = t1.getText();
        name = t2.getText();
        password = t3.getText();
        answer = t4.getText();
        question = (String) SecurityQuestion.getSelectedItem();
        JavaConnection db = new JavaConnection();
        db.connection();
        String usr, pwd, ans, nam;
        usr = pwd = ans = nam = "";
        String insert, check;
        check = "select * from Sign where username='" + username + "'";
        ResultSet rs = db.executeQuery(check);
        try {
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "user already exist");
            } else {
                if (username.equals(usr) && password.equals(pwd) && name.equals(nam) && answer.equals(ans)) {
                    JOptionPane.showMessageDialog(null, "This is an illegal input !");

                } else {

                    insert = "INSERT INTO Sign  VALUES('" + username + "','" + name + "','" + password + "','" + question + "','" + answer + "')";
                    db.executeUpdate(insert);
                    File file = new File(".\\true.txt");
                    file.createNewFile();
                    JOptionPane.showMessageDialog(null, username + " , Account is Ready");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception occur:" + e);
        }
        db.connClose();

    }

}

class Signupe {

    public static void main(String[] args) {
        Signup s = new Signup();

    }
}
