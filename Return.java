
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class Return extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l11, l12, l13, l14, l15, l16, l17, l18;
    JTextField t1, t2, t3, t4, t5, t6, t7, t11, t12, t13, t14, t15, t16, t17;
    JPanel p1, p2;
    JButton search1, search2, returned, back;
    String date;

    Return() {
        setTitle("Return Book");
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        p1 = new JPanel();

        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder("Return Panel");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(0, 0, 1200, 350);
        p1.setLayout(null);
        //p1.setSize(900, 350);

        l1 = new JLabel("Member id");
        l1.setBounds(100, 60, 100, 30);
        p1.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(100, 100, 100, 30);
        p1.add(l2);
        l3 = new JLabel("Father Name");
        l3.setBounds(100, 140, 100, 30);
        p1.add(l3);
        l4 = new JLabel("Department");
        l4.setBounds(100, 180, 200, 30);
        p1.add(l4);
        l5 = new JLabel("Year");
        l5.setBounds(100, 220, 100, 30);
        p1.add(l5);
        l6 = new JLabel("Sem");
        l6.setBounds(100, 260, 100, 30);
        p1.add(l6);
        l7 = new JLabel("Member type");
        l7.setBounds(100, 300, 100, 30);
        p1.add(l7);
        t1 = new JTextField();
        t1.setBounds(280, 60, 200, 30);
        p1.add(t1);
        t2 = new JTextField();
        t2.setBounds(280, 100, 200, 30);
        t2.setEditable(false);
        p1.add(t2);
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
        t7 = new JTextField();
        t7.setBounds(280, 300, 200, 30);
        t7.setEditable(false);
        p1.add(t7);

        search1 = new JButton("Search");
        search1.setBounds(500, 60, 100, 30);
           Class cls = this.getClass();
        URL url = cls.getResource("anyfiles\\icon\\icon\\18.png");
        search1.setIcon(new ImageIcon(url));

        search1.setHorizontalAlignment(SwingConstants.LEFT);

        search1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchIssueMember();

            }
        });
        p1.add(search1);
        p1.setBackground(Color.white);
        l11 = new JLabel("Book ID");
        l11.setBounds(650, 60, 100, 30);
        p1.add(l11);
        l12 = new JLabel("Name");
        l12.setBounds(650, 100, 100, 30);
        p1.add(l12);
        l13 = new JLabel("Edition");
        l13.setBounds(650, 140, 100, 30);
        p1.add(l13);
        l14 = new JLabel("Publisher");
        l14.setBounds(650, 180, 200, 30);
        p1.add(l14);
        l15 = new JLabel("Price");
        l15.setBounds(650, 220, 100, 30);
        p1.add(l15);
        l16 = new JLabel("Pages");
        l16.setBounds(650, 260, 100, 30);
        p1.add(l16);
        l17 = new JLabel();
        l17.setBounds(650, 300, 200, 30);
        l17.setText("Date of Issue is : ");
        p1.add(l17);
        t11 = new JTextField();
        t11.setBounds(820, 60, 200, 30);
        t11.setEditable(true);
        p1.add(t11);
        search2 = new JButton("Search");
        search2.setBounds(1040, 60, 100, 30);
        url = cls.getResource("anyfiles\\icon\\icon\\17.png");
        search2.setIcon(new ImageIcon(url));

        search2.setHorizontalAlignment(SwingConstants.LEFT);

        search2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchIssueBook();

            }
        });
        p1.add(search2);

        
        t12 = new JTextField();
        t12.setBounds(820, 100, 200, 30);
        p1.add(t12);
        t12.setEditable(false);
        t13 = new JTextField();
        t13.setBounds(820, 140, 200, 30);
        t13.setEditable(false);
        p1.add(t13);
        t14 = new JTextField();
        t14.setBounds(820, 180, 200, 30);
        t14.setEditable(false);
        p1.add(t14);
        t15 = new JTextField();
        t15.setBounds(820, 220, 200, 30);
        t15.setEditable(false);
        p1.add(t15);
        t16 = new JTextField();
        t16.setBounds(820, 260, 200, 30);
        t16.setEditable(false);
        p1.add(t16);

        t17 = new JTextField();
        t17.setBounds(820, 300, 200, 30);
        t17.setEditable(false);
        p1.add(t17);
        add(p1);
        l18 = new JLabel("Returned Date : " + date);
        l18.setBounds(600, 420, 200, 30);
        add(l18);
        returned = new JButton("Return");
        returned.setBounds(900, 420, 100, 40);
        url = cls.getResource("anyfiles\\icon\\icon\\14.png");
        returned.setIcon(new ImageIcon(url));

        returned.setHorizontalAlignment(SwingConstants.LEFT);
        add(returned);
        returned.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                returnBook();

            }
        });
        back = new JButton("Back");
        back.setBounds(100, 420, 100, 40);
        url = cls.getResource("anyfiles\\icon\\icon\\11.png");
        back.setIcon(new ImageIcon(url));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });
        add(back);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 240, 600, 400);
    }

    void searchIssueMember() {
        String s1, s2;

        s1 = s2 = "";
        s2 = t1.getText();

        if (s2.equals(s1)) {
            JOptionPane.showMessageDialog(null, "Blank Character is not allowed");
        } else {

            try {
                int i = Integer.parseInt(t1.getText());
                String search = "select memberid from Issue where memberid='" + i + "'";
                String member = "select * from Member where memberid='" + i + "'";
                //    String book="select * from Book where  "
                JavaConnection dm = new JavaConnection();
                dm.connection();
                ResultSet rs1 = dm.executeQuery(search);

                //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
                if (rs1.next()) {
                    ResultSet rs2 = dm.executeQuery(member);
                    if (rs2.next()) {

                        t2.setText(rs2.getString(2));
                        t3.setText(rs2.getString(3));
                        t4.setText(rs2.getString(4));
                        t5.setText(rs2.getString(5));
                        t6.setText(rs2.getString(6));
                        t7.setText(rs2.getString(7));
                    } else {

                        JOptionPane.showMessageDialog(null, "something internall error");
                    }

                } else {
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    JOptionPane.showMessageDialog(null, " HE Did not Took Any Book");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

    }

    void searchIssueBook() {
        String s1, s2,s3,s4;

        s3 = s4 = "";
        s1=t1.getText();
        s2 = t11.getText();

        if (s1.equals(s3) || s2.equals(s4)) {
            JOptionPane.showMessageDialog(null, "Fill Member id too , Blank Character not allowed");
        } else {

            try {
                int i = Integer.parseInt(t11.getText());
                int j = Integer.parseInt(t1.getText());
                String search = "select memberid,date from Issue where bookid='" + i + "' AND memberid='" + j + "'";
                String member = "select * from Book where bookid='" + i + "'";
                //    String book="select * from Book where  "
                JavaConnection dm = new JavaConnection();
                dm.connection();
                ResultSet rs1 = dm.executeQuery(search);

                //  System.out.println("username:" + rs.getString(1) + "  password " + rs.getString(2));
                if (rs1.next()) {
                    ResultSet rs2 = dm.executeQuery(member);
                    if (rs2.next()) {

                        t12.setText(rs2.getString(2));
                        t13.setText(rs2.getString(3));
                        t14.setText(rs2.getString(4));
                        t15.setText(rs2.getString(5));
                        t16.setText(rs2.getString(6));
                        t17.setText(rs1.getString(2));
                    } else {

                        JOptionPane.showMessageDialog(null, "something internall error");
                    }

                } else {
                    t12.setText("");
                    t13.setText("");
                    t14.setText("");
                    t15.setText("");
                    t16.setText("");
                    t17.setText("");
                    JOptionPane.showMessageDialog(null, " HE Did not Took this BOOK of Book id :" + i);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    void returnBook() {
        String s1, s2, s3, s4, s5, s6;

        s1 = s2 = s3 = s4 = "";
        s2 = t1.getText();
        s4 = t11.getText();
        s5 = s6 = "0";

        if (s2.equals(s1) || s4.equals(s3) || s4.equals(s5) || s2.equals(s6)) {
            JOptionPane.showMessageDialog(null, "What You Want To Return?");
        } else {

            try {
                int member_id, book_id;
                String member_name, department, member_type, issue_date, return_date;
                //= Integer.parseInt(t11.getText());
                member_id = Integer.parseInt(t1.getText());
                book_id = Integer.parseInt(t11.getText());
                member_name = t2.getText();
                department = t4.getText();
                member_type = t7.getText();
                issue_date = t17.getText();
                return_date = date;
                //String check1,check2;

                String insert = "insert into ReturnTable (member_id,book_id,member_name,department,member_type,issue_date,return_date) Values('" + member_id + "','" + book_id + "','" + member_name + "','" + department + "','" + member_type + "', STR_TO_DATE('" + issue_date + "','%Y-%m-%d'), STR_TO_DATE('" + return_date + "','%Y-%m-%d'))";
                String delete = "delete from Issue where memberid='" + member_id + "' AND bookid='" + book_id + "'";
                //    String book="select * from Book where  "
                String check1 = "select member_id,book_id,issue_date,return_date from ReturnTable Where member_id='" + member_id + "' AND book_id='" + book_id + "' AND issue_date='" + issue_date + "' AND return_date='" + return_date + "'";
                System.out.println(check1);
                String check2 = "select * from Issue where memberid='" + member_id + "' AND bookid='" + book_id + "'";
                JavaConnection dm = new JavaConnection();
                dm.connection();
                ResultSet rs2 = dm.executeQuery(check2);
                if (rs2.next()) {
                    ResultSet rs = dm.executeQuery(check1);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "You already returned ");
                    } else {
                        dm.executeUpdate(insert);
                        dm.executeUpdate(delete);
                        JOptionPane.showMessageDialog(null, "Returned ! ");
                        dm.connClose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid id ! ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

}

class Sigupe {

    public static void main(String[] args) {
        Return s = new Return();
        s.setSize(1220, 520);

    }
}
