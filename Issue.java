/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;
import java.sql.*;

/**
 *
 * @author root
 */
public class Issue extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l11, l12, l13, l14, l15, l16, l17, l18;
    JTextField t1, t2, t3, t4, t5, t6, t11, t12, t13, t14, t15, t16, t17;
    JPanel p1, p2;
    JButton search1, search2, issue, back;
    String date;

    Issue() {
        getContentPane().setBackground(new Color(153, 170, 181));
        setTitle("Issue Book");
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        p1 = new JPanel();

        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder("Book Details");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(0, 0, 600, 400);
        p1.setLayout(null);
        // p1.setSize(420, 350);
        l1 = new JLabel("Book ID");
        l1.setBounds(100, 60, 100, 30);
        p1.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(100, 100, 100, 30);
        p1.add(l2);
        l3 = new JLabel("Edition");
        l3.setBounds(100, 140, 100, 30);
        p1.add(l3);
        l4 = new JLabel("Publisher");
        l4.setBounds(100, 180, 200, 30);
        p1.add(l4);
        l5 = new JLabel("Price");
        l5.setBounds(100, 220, 100, 30);
        p1.add(l5);
        l6 = new JLabel("Pages");
        l6.setBounds(100, 260, 100, 30);
        p1.add(l6);
        t1 = new JTextField();
        t1.setBounds(280, 60, 200, 30);
        t1.setText("0");
        p1.add(t1);

        t1.setEditable(true);
        t2 = new JTextField();
        t2.setBounds(280, 100, 200, 30);
        p1.add(t2);
        t2.setEditable(false);
        t3 = new JTextField();
        t3.setBounds(280, 140, 200, 30);
        t3.setEditable(false);
        p1.add(t3);
        t4 = new JTextField();
        t4.setBounds(280, 180, 200, 30);
        t4.setEditable(false);
        p1.add(t4);
        t5 = new JTextField();
        t5.setBounds(280, 220, 200, 30);
        t5.setEditable(false);
        p1.add(t5);
        t6 = new JTextField();
        t6.setBounds(280, 260, 200, 30);
        t6.setEditable(false);
        p1.add(t6);
        search1 = new JButton("Search");
        search1.setBounds(490, 60, 100, 30);
            
        search1.setIcon(new ImageIcon(getClass().getResource("/17.png")));

        search1.setHorizontalAlignment(SwingConstants.LEFT);

        search1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                search1();
            }
        });
        p1.add(search1);
        p1.setBackground(Color.white);
        add(p1);

        TitledBorder title;
        title = BorderFactory.createTitledBorder("Member Details");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));
        p2 = new JPanel();
        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title);
        // p.setBackground();
        p2.setBounds(600, 0, 620, 400);
        p2.setLayout(null);
        // p2.setSize(420, 450);
        l11 = new JLabel("Member id");
        l11.setBounds(100, 60, 100, 30);
        p2.add(l11);
        l12 = new JLabel("Name");
        l12.setBounds(100, 100, 100, 30);
        p2.add(l12);
        l13 = new JLabel("Father Name");
        l13.setBounds(100, 140, 100, 30);
        p2.add(l13);
        l14 = new JLabel("Department");
        l14.setBounds(100, 180, 200, 30);
        p2.add(l14);
        l15 = new JLabel("Year");
        l15.setBounds(100, 220, 100, 30);
        p2.add(l15);
        l16 = new JLabel("Sem");
        l16.setBounds(100, 260, 100, 30);
        p2.add(l16);
        l17 = new JLabel("Member type");
        l17.setBounds(100, 300, 100, 30);
        p2.add(l17);
        t11 = new JTextField();
        t11.setBounds(280, 60, 200, 30);
        t11.setText("0");
        p2.add(t11);
        t12 = new JTextField();
        t12.setBounds(280, 100, 200, 30);
        t12.setEditable(false);
        p2.add(t12);
        t13 = new JTextField();
        t13.setBounds(280, 140, 200, 30);
        t13.setEditable(false);
        p2.add(t13);
        t14 = new JTextField();
        t14.setBounds(280, 180, 200, 30);
        t14.setEditable(false);
        p2.add(t14);
        t15 = new JTextField();
        t15.setBounds(280, 220, 200, 30);
        t15.setEditable(false);
        p2.add(t15);
        t16 = new JTextField();
        t16.setBounds(280, 260, 200, 30);
        t16.setEditable(false);
        p2.add(t16);
        t17 = new JTextField();
        t17.setBounds(280, 300, 200, 30);
        t17.setEditable(false);
        p2.add(t17);
        search2 = new JButton("Search");
      
        search2.setIcon(new ImageIcon(getClass().getResource("/18.png")));

        search2.setHorizontalAlignment(SwingConstants.LEFT);
        search2.setBounds(500, 60, 100, 30);
        p2.add(search2);
        l18 = new JLabel();

        l18.setText("current date is : " + date);

        l18.setBounds(600, 460, 200, 30);
        add(l18);
        p2.setBackground(Color.white);
        search2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                search2();
            }
        });

        issue = new JButton("               Issue");
       
        issue.setIcon(new ImageIcon(getClass().getResource("/14.png")));

        issue.setHorizontalAlignment(SwingConstants.LEFT);

        issue.setBounds(800, 460, 200, 30);
        issue.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                issueStore();
            }
        });
        add(issue);
        add(p2);
        back = new JButton("Back");
        back.setBounds(200, 460, 100, 30);
        
        back.setIcon(new ImageIcon(getClass().getResource("/11.png")));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });
        add(back);

//System.out.println(LocalDate.now().toString());
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 120, 1225, 600); // set where frame will be
    }

    void search1() {

        String s1, s2;
        s2 = "";
        s1 = t1.getText();

        JavaConnection dm = new JavaConnection();
        dm.connection();
        if (!s1.equals(s2)) {
            try {
                int i = Integer.parseInt(t1.getText());
                String search = "select * from Book where bookid='" + i + "'";
                ResultSet rs = dm.executeQuery(search);

                //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
                if (rs.next()) {
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Book ID");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        } else {
            JOptionPane.showMessageDialog(null, "put something");

        }

    }

    void search2() {

        JavaConnection dm = new JavaConnection();
        dm.connection();
        String s1, s2;
        s2 = "";
        s1 = t11.getText();
        if (s1.equals(s2)) {
            JOptionPane.showMessageDialog(null, "put something");

        } else {

            try {
                int i = Integer.parseInt(t11.getText());
                String search = "select * from Member where memberid='" + i + "'";
                ResultSet rs = dm.executeQuery(search);

                //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
                if (rs.next()) {
                    t12.setText(rs.getString(2));
                    t13.setText(rs.getString(3));
                    t14.setText(rs.getString(4));
                    t15.setText(rs.getString(5));
                    t16.setText(rs.getString(6));
                    t17.setText(rs.getString(7));
                } else {
                    JOptionPane.showMessageDialog(null, "User Not Exists ");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }

        }

    }

    void issueStore() {
        String membername, department, member_type;
        int bookid, memberid;

        membername = t12.getText();
        department = t14.getText();
        member_type = t17.getText();
        String s1, s2, s3, s4;
        

        s1 = s2 = s3 = s4 = "";
        int i, j;
        i = j = 0;
        s3 = t1.getText();
        s4 = t11.getText();
        //JOptionPane.showMessageDialog(null, "s3 :" + s3 + "\ns4   :" + s4);
        JavaConnection db = new JavaConnection();
        db.connection();

        if (s3.equals(s1) || s4.equals(s2)) {
            JOptionPane.showMessageDialog(null, "Blank Character is not allowed");
        } else {
            memberid = Integer.parseInt(t11.getText());
            bookid = Integer.parseInt(t1.getText());
            if (bookid == i && memberid ==j) {
                JOptionPane.showMessageDialog(null, "First input something");

            } else {
                String insert, check, check1, check2, check3, check4, check5;
                check1 = "select memberid,bookid from Issue Where memberid=bookid AND memberid='" + memberid + "'";
                check2 = "select memberid,bookid from Issue Where memberid='" + memberid + "' AND bookid='" + bookid + "'";
                check3 = "select * from Issue Where bookid='" + bookid + "'";
                check4 = "select * from Book where bookid='" + bookid + "'";
                check5 = "select * from Member where memberid='" + memberid + "'";
                try {
                    ResultSet rs1 = db.executeQuery(check1);
                    if (rs1.next()) {
                        JOptionPane.showMessageDialog(null, "The user that request for the book,he already have");
                    } else {
                        ResultSet rs2 = db.executeQuery(check2);
                        if (rs2.next()) {
                            JOptionPane.showMessageDialog(null, "The user that request for the book,he already have");
                        } else {
                            ResultSet rs3 = db.executeQuery(check3);
                            if (rs3.next()) {
                                JOptionPane.showMessageDialog(null, "book cant be distrubuted of same id");
                            } else {
                                ResultSet rs4, rs5;
                                rs4 = db.executeQuery(check4);
                                rs5 = db.executeQuery(check5);
                                if (rs4.next() && rs5.next()) {
                                    insert = "INSERT INTO Issue (memberid,bookid,membername,department,member_type,date) VALUES('" + memberid + "','" + bookid + "','" + membername + "','" + department + "','" + member_type + "', STR_TO_DATE('" + date + "','%d-%m-%Y') )";
                                    db.executeUpdate(insert);
                                    JOptionPane.showMessageDialog(null, "Issued \n Bookid: "+bookid+" \n To Memberid : "+memberid);
                                    db.connClose();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid BookID or Member ID");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }

    }

}

class Sigsupe {

    public static void main(String[] args) {
        Issue s = new Issue();
        s.setSize(1230, 600);

    }
}
