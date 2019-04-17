/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import java.net.URL;
import java.lang.*;


/**
 *
 * @author user
 */
public class ForgetPassword extends JFrame {
  
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    JButton search, retrive, back;

    ForgetPassword() {
        // setLocationRelativeTo(null);
        setTitle("Forget Password");
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setBounds(700, 300, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        

        TitledBorder title;
        title = BorderFactory.createTitledBorder("Forget Password");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(10, 20, 450, 300);
        p.setLayout(null);

        l1 = new JLabel("UserName");
        l1.setBounds(10, 40, 100, 30);
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(10, 80, 100, 30);
        p.add(l2);
        l3 = new JLabel("Your Security Question");
        l3.setBounds(10, 120, 200, 30);
        p.add(l3);
        l4 = new JLabel("Answer");
        l4.setBounds(10, 160, 200, 30);
        p.add(l4);
        l5 = new JLabel("Your Password");
        l5.setBounds(10, 200, 100, 30);
        p.add(l5);
        t1 = new JTextField();
        t1.setBounds(180, 40, 150, 30);
        p.add(t1);
        t2 = new JTextField();
        t2.setBounds(180, 80, 150, 30);
        t2.setEditable(false);
        p.add(t2);
        t3 = new JTextField();
        t3.setBounds(180, 120, 200, 30);
        t3.setEditable(false);
        p.add(t3);

        t4 = new JTextField();
        t4.setBounds(180, 160, 150, 30);
        p.add(t4);
        t5 = new JTextField();
        t5.setBounds(180, 200, 150, 30);
        p.add(t5);

        search = new JButton("Search");
        search.setBounds(340, 40, 100, 30);
        Class cls= this.getClass();
        URL url=cls.getResource("anyfiles\\icon\\icon\\8.png");
        
        search.setIcon(new ImageIcon(url));

        search.setHorizontalAlignment(SwingConstants.LEFT);
        search.setBackground(new Color(240, 126, 86));
        p.add(search);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }

        });
        retrive = new JButton("Retrive");
        retrive.setBounds(340, 160, 100, 30);
        url=cls.getResource("anyfiles\\icon\\icon\\bg5.jpg");
        retrive.setIcon(new ImageIcon(url));

        retrive.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(retrive);
        retrive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrive();
            }

        });
        add(p);

        back = new JButton("Back");
        back.setSize(100, 100);
        url=cls.getResource("anyfiles\\icon\\icon\\11.png");
        back.setIcon(new ImageIcon(url));

        back.setHorizontalAlignment(SwingConstants.LEFT);

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                Login w = new Login();
                try {
                    w.LoginFrame();
                } catch (Exception ev) {
                }
            }

        });

        back.setBounds(200, 400, 100, 30);
        add(back);
        repaint();

    }

    void search() {
        String a1 = t1.getText();
        String sql = "select name,question from sign where username='" + a1 + "'";
        JavaConnection dm = new JavaConnection();
        dm.connection();
        ResultSet rs = dm.executeQuery(sql);
        try {

            //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
            if (rs.next()) {
                t2.setText(rs.getString(1));
                t3.setText(rs.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "User Not Exists ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    void retrive() {
        String user = t1.getText();
        String a1 = t4.getText();
        String sql = "select password from sign where answer='" + a1 + "' And username='" + user + "'";
        JavaConnection dm = new JavaConnection();
        dm.connection();
        ResultSet rs = dm.executeQuery(sql);
        try {

            //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
            if (rs.next()) {
                t5.setText(rs.getString(1));
                t5.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "your Answer is Wrong ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

}

class forget {

    public static void main(String[] args) {
        ForgetPassword s = new ForgetPassword();

    }
}
