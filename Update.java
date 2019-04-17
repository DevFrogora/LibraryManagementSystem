/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.TitledBorder;
import java.sql.*;

/**
 *
 * @author root
 */
public class Update extends JFrame {

    TitledBorder title1, title2;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JButton b1, b2, b3, b4;
    String yyear[], ssem[], ccourse[], mmember[];

    JComboBox j1, j2, j3, j4;
    Class cls = this.getClass();
    URL url;

    Update() {

        setTitle("Updatation/Deletion");
        setSize(950, 800);
        setVisible(true);
        setLayout(null);
        setBounds(400, 100, 950, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title1 = BorderFactory.createTitledBorder("Update Member/Books");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(0, 0, 470, 250);
        p1.setLayout(null);
        p1.setBackground(Color.white);
        JButton b1;
        b1 = new JButton();
        b1.setBounds(80, 60, 100, 100);
        
        url = cls.getResource("anyfiles\\icon\\icon\\24.png");
        b1.setIcon(new ImageIcon(url));
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                member();

            }
        });

        JLabel l1 = new JLabel("Update Member");
        l1.setBounds(80, 180, 200, 30);
        p1.add(l1);
        p1.add(b1);
        b2 = new JButton("Book");
        b2.setBounds(300, 60, 100, 100);
        url = cls.getResource("anyfiles\\icon\\icon\\25.png");
        b2.setIcon(new ImageIcon(url));
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                book();

            }
        });
        p1.add(b2);

        JLabel l2 = new JLabel("Update Book");
        l2.setBounds(300, 180, 200, 30);
        p1.add(l2);
        add(p1);
        title2 = BorderFactory.createTitledBorder("Delete Member/Books");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p3.setBorder(title2);
        // p.setBackground();
        p3.setBounds(470, 0, 470, 250);
        p3.setLayout(null);
        p3.setBackground(Color.white);
        b3 = new JButton();
        b3.setBounds(80, 60, 100, 100);
        b3.setBounds(80, 60, 100, 100);
        url = cls.getResource("anyfiles\\icon\\icon\\23.png");

        b3.setIcon(new ImageIcon(url));
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                delMember();

            }
        });
        p3.add(b3);
        JLabel l3 = new JLabel("Delete Member");
        l3.setBounds(80, 180, 200, 30);
        p3.add(l3);
        b4 = new JButton("Book");
        b4.setBounds(300, 60, 100, 100);
        url = cls.getResource("anyfiles\\icon\\icon\\26.png");
        b4.setIcon(new ImageIcon(url));

        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                delBook();

            }
        });
        JLabel l4 = new JLabel("Delete Book");
        l4.setBounds(300, 180, 200, 30);
        p3.add(l4);

        p3.add(b3);
        p3.add(b4);
        JButton back = new JButton("Back");
        back.setBounds(400, 700, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\11.png");
        back.setIcon(new ImageIcon(url));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().setBackground(Color.red);
        add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                WelcomePage w = new WelcomePage();
            }

        });
        add(p1);
        add(p3);

    }

    void member() {
        JLabel l1, l2, l3, l4, l5, l6, l7;
        JTextField t1, t2, t3, t4, t5, t6, t7;
        remove(p2);

        p2 = new JPanel();
        title1 = BorderFactory.createTitledBorder("Update Member");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title1);
        // p.setBackground();
        p2.setBounds(0, 250, 940, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);

        l1 = new JLabel("Search Member ID:");
        l1.setBounds(200, 60, 200, 20);
        p2.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 100, 100, 20);
        p2.add(l2);
        l3 = new JLabel("Father Name");
        l3.setBounds(200, 140, 100, 20);
        p2.add(l3);
        l4 = new JLabel("Department");
        l4.setBounds(200, 180, 100, 20);
        p2.add(l4);
        l5 = new JLabel("Year");
        l5.setBounds(200, 220, 100, 20);
        p2.add(l5);
        l6 = new JLabel("Sem");
        l6.setBounds(200, 260, 100, 20);
        p2.add(l6);
        l7 = new JLabel("Member Type");
        l7.setBounds(200, 300, 100, 20);
        p2.add(l7);

        t1 = new JTextField();
        t1.setBounds(400, 60, 200, 30);
        p2.add(t1);
        t2 = new JTextField();
        t2.setBounds(400, 100, 200, 30);
        p2.add(t2);
        t3 = new JTextField();
        t3.setBounds(400, 140, 200, 30);
        p2.add(t3);

        ccourse = new String[]{"Mtech", "BTech", "MCA", "BCA", "BBA", "MBA", "BA", "BCom", "BSC"};
        j1 = new JComboBox(ccourse);
        j1.setBounds(400, 180, 200, 30);
        p2.add(j1);
        yyear = new String[]{"1", "2", "3", "4"};
        j2 = new JComboBox(yyear);
        j2.setBounds(400, 220, 200, 30);
        p2.add(j2);
        ssem = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        j3 = new JComboBox(ssem);
        j3.setBounds(400, 260, 200, 30);
        p2.add(j3);
        mmember = new String[]{"Student", "Teacher"};
        j4 = new JComboBox(mmember);
        j4.setBounds(400, 300, 200, 30);
        p2.add(j4);

        JButton b1, b2;
        b1 = new JButton("search");
        b1.setBounds(620, 60, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\18.png");
        b1.setIcon(new ImageIcon(url));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String blank = "";
                if (mem.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " Invalid input");
                } else {
                    try {
                        int member = Integer.parseInt(t1.getText());
                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String sql = "select * from Member Where memberid='" + member + "'";
                        ResultSet rs = db.executeQuery(sql);
                        if (rs.next()) {
                            t1.setEditable(false);
                            t2.setText(rs.getString(2));
                            t3.setText(rs.getString(3));
                            j1.setSelectedItem(rs.getString(4));
                            j2.setSelectedItem(rs.getString(5));
                            j3.setSelectedItem(rs.getString(6));
                            j4.setSelectedItem(rs.getString(7));

                        } else {
                            JOptionPane.showMessageDialog(null, "user not exist");
                        }

                    } catch (Exception ex) {
                    }

                }

            }
        }
        );

        p2.add(b1);
        b2 = new JButton("Update");
        b2.setBounds(620, 350, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\20.png");
        b2.setIcon(new ImageIcon(url));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        p2.add(b2);

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String nam = t2.getText();

                String blank = "";
                if (mem.equals(blank) || nam.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " NO id input");
                } else {

                    int memberid = Integer.parseInt(t1.getText());
                    String name, father_name, department, member_type;
                    int year, sem;
                    name = t2.getText();
                    name = t2.getText();
                    father_name = t3.getText();
                    department = (String) j1.getSelectedItem();
                    year = Integer.parseInt((String) j2.getSelectedItem());
                    sem = Integer.parseInt((String) j3.getSelectedItem());
                    member_type = (String) j4.getSelectedItem();
                    JavaConnection db = new JavaConnection();
                    db.connection();
                    String check = "select * from Member where memberid='" + memberid + "'";

                    try {
                        ResultSet rs = db.executeQuery(check);
                        if (rs.next()) {
                            String sql = "update Member set name='" + name + "' ,father_name='" + father_name + "' ,department='" + department + "',year='" + year + "', sem='" + sem + "', member_type='" + member_type + "'  Where memberid='" + memberid + "'";
                            db.executeUpdate(sql);

                            JOptionPane.showMessageDialog(null, "Updated");
                        } else {
                            JOptionPane.showMessageDialog(null, "No member found");
                        }
                    } catch (Exception ex) {
                    }
                }

            }

        }
        );

        add(p2);

        revalidate();// we have to validate frame only

        repaint();

    }

    void book() {
        JLabel l1, l2, l3, l4, l5, l6, l7;
        JTextField t1, t2, t3, t4, t5, t6, t7;
        remove(p2);

        p2 = new JPanel();
        title1 = BorderFactory.createTitledBorder("Update Book");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title1);
        // p.setBackground();
        p2.setBounds(0, 250, 940, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);

        l1 = new JLabel("Search BOOK ID:");
        l1.setBounds(200, 60, 200, 20);
        p2.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 100, 100, 20);
        p2.add(l2);
        l3 = new JLabel("Edition");
        l3.setBounds(200, 140, 100, 20);
        p2.add(l3);
        l4 = new JLabel("Publisher");
        l4.setBounds(200, 180, 100, 20);
        p2.add(l4);
        l5 = new JLabel("Price");
        l5.setBounds(200, 220, 100, 20);
        p2.add(l5);
        l6 = new JLabel("Pages");
        l6.setBounds(200, 260, 100, 20);
        p2.add(l6);

        t1 = new JTextField();
        t1.setBounds(400, 60, 200, 30);
        p2.add(t1);
        t2 = new JTextField();
        t2.setBounds(400, 100, 200, 30);
        p2.add(t2);
        t3 = new JTextField();
        t3.setBounds(400, 140, 200, 30);
        p2.add(t3);
        t4 = new JTextField();
        t4.setBounds(400, 180, 200, 30);
        p2.add(t4);
        t5 = new JTextField();
        t5.setBounds(400, 220, 200, 30);
        p2.add(t5);
        t6 = new JTextField();
        t6.setBounds(400, 260, 200, 30);
        p2.add(t6);

        JButton b1, b2;
        b1 = new JButton("search");
        b1.setBounds(620, 60, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\17.png");
        b1.setIcon(new ImageIcon(url));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String blank = "";
                if (mem.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " Invalid input");
                } else {
                    try {
                        int bookid = Integer.parseInt(t1.getText());
                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String sql = "select * from Book Where bookid='" + bookid + "'";
                        ResultSet rs = db.executeQuery(sql);
                        if (rs.next()) {
                            t1.setEditable(false);
                            t2.setText(rs.getString(2));
                            t3.setText(rs.getString(3));
                            t4.setText(rs.getString(4));
                            t5.setText(rs.getString(5));
                            t6.setText(rs.getString(6));

                        } else {
                            JOptionPane.showMessageDialog(null, "Book not exist");
                        }

                    } catch (Exception ex) {
                    }

                }

            }
        }
        );

        p2.add(b1);
        b2 = new JButton("Update");
        b2.setBounds(620, 350, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\20.png");
        b2.setIcon(new ImageIcon(url));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        p2.add(b2);

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String nam = t2.getText();
                String pub = t4.getText();

                String blank = "";
                if (mem.equals(blank) || nam.equals(blank) || pub.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " NO id input");
                } else {
                    try {
                        int bookid = Integer.parseInt(t1.getText());
                        String name, publisher;
                        int edition, pages;
                        float price;
                        name = t2.getText();
                        edition = Integer.parseInt(t3.getText());
                        publisher = t4.getText();
                        price = Float.parseFloat(t5.getText());
                        pages = Integer.parseInt(t6.getText());
                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String check = "select * from Book where bookid='" + bookid + "'";

                        ResultSet rs = db.executeQuery(check);
                        if (rs.next()) {
                            String sql = "update Book set name='" + name + "' , edition='" + edition + "' , publisher='" + publisher + "',price='" + price + "', pages='" + pages + "'  Where bookid='" + bookid + "'";
                            db.executeUpdate(sql);

                            JOptionPane.showMessageDialog(null, "Updated");
                        } else {
                            JOptionPane.showMessageDialog(null, "No Book found");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Illegal input Found .!You can put character in price , pages ,edition  ! No updatation Done");
                    }
                }

            }

        }
        );

        add(p2);

        revalidate();// we have to validate frame only

        repaint();

    }

    void delBook() {
        JLabel l1, l2, l3, l4, l5, l6, l7;
        JTextField t1, t2, t3, t4, t5, t6, t7;
        remove(p2);

        p2 = new JPanel();
        title1 = BorderFactory.createTitledBorder("Delete Book");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title1);
        // p.setBackground();
        p2.setBounds(0, 250, 940, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);

        l1 = new JLabel("Search BOOK ID:");
        l1.setBounds(200, 60, 200, 20);
        p2.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 100, 100, 20);
        p2.add(l2);
        l3 = new JLabel("Edition");
        l3.setBounds(200, 140, 100, 20);
        p2.add(l3);
        l4 = new JLabel("Publisher");
        l4.setBounds(200, 180, 100, 20);
        p2.add(l4);
        l5 = new JLabel("Price");
        l5.setBounds(200, 220, 100, 20);
        p2.add(l5);
        l6 = new JLabel("Pages");
        l6.setBounds(200, 260, 100, 20);
        p2.add(l6);

        t1 = new JTextField();
        t1.setBounds(400, 60, 200, 30);
        p2.add(t1);
        t2 = new JTextField();
        t2.setBounds(400, 100, 200, 30);
        p2.add(t2);
        t3 = new JTextField();
        t3.setBounds(400, 140, 200, 30);
        p2.add(t3);
        t4 = new JTextField();
        t4.setBounds(400, 180, 200, 30);
        p2.add(t4);
        t5 = new JTextField();
        t5.setBounds(400, 220, 200, 30);
        p2.add(t5);
        t6 = new JTextField();
        t6.setBounds(400, 260, 200, 30);
        p2.add(t6);

        JButton b1, b2;
        b1 = new JButton("search");
        b1.setBounds(620, 60, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\17.png");
        b1.setIcon(new ImageIcon(url));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String blank = "";
                if (mem.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " Invalid input");
                } else {
                    try {
                        int bookid = Integer.parseInt(t1.getText());
                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String sql = "select * from Book Where bookid='" + bookid + "'";
                        ResultSet rs = db.executeQuery(sql);
                        if (rs.next()) {
                            t1.setEditable(false);
                            t2.setText(rs.getString(2));
                            t3.setText(rs.getString(3));
                            t4.setText(rs.getString(4));
                            t5.setText(rs.getString(5));
                            t6.setText(rs.getString(6));

                        } else {
                            JOptionPane.showMessageDialog(null, "Book not exist");
                        }

                    } catch (Exception ex) {
                    }

                }

            }
        }
        );

        p2.add(b1);
        b2 = new JButton("Delete");
        b2.setBounds(620, 350, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\21.png");
        b2.setIcon(new ImageIcon(url));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        p2.add(b2);

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String nam = t2.getText();
                String pub = t4.getText();

                String blank = "";
                if (mem.equals(blank) || nam.equals(blank) || pub.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " NO id input");
                } else {
                    try {
                        int bookid = Integer.parseInt(t1.getText());

                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String check1 = "select * from Book where bookid='" + bookid + "'";
                        String check2 = "select memberid,membername from Issue where bookid='" + bookid + "'";
                        ResultSet rs1 = db.executeQuery(check2);
                        if (!rs1.next()) {
                            ResultSet rs2 = db.executeQuery(check1);
                            if (rs2.next()) {
                                String sql = "Delete from book  Where bookid='" + bookid + "'";
                                db.executeUpdate(sql);

                                JOptionPane.showMessageDialog(null, "deleted");
                            } else {
                                JOptionPane.showMessageDialog(null, "No Book found");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "This book is issue to\n Member Id: " + rs1.getString(1) + " \n member name : " + rs1.getString(2) + "\n you cant delete");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Illegal input Found .!You can put character in price , pages ,edition  ! No updatation Done");
                    }
                }

            }

        }
        );

        add(p2);

        revalidate();// we have to validate frame only

        repaint();

    }

    void delMember() {
        JLabel l1, l2, l3, l4, l5, l6, l7;
        JTextField t1, t2, t3, t4, t5, t6, t7;
        remove(p2);

        p2 = new JPanel();
        title1 = BorderFactory.createTitledBorder("Delete Member");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title1);
        // p.setBackground();
        p2.setBounds(0, 250, 940, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);

        l1 = new JLabel("Search Member ID:");
        l1.setBounds(200, 60, 200, 20);
        p2.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(200, 100, 100, 20);
        p2.add(l2);
        l3 = new JLabel("Father Name");
        l3.setBounds(200, 140, 100, 20);
        p2.add(l3);
        l4 = new JLabel("Department");
        l4.setBounds(200, 180, 100, 20);
        p2.add(l4);
        l5 = new JLabel("Year");
        l5.setBounds(200, 220, 100, 20);
        p2.add(l5);
        l6 = new JLabel("Sem");
        l6.setBounds(200, 260, 100, 20);
        p2.add(l6);
        l7 = new JLabel("Member Type");
        l7.setBounds(200, 300, 100, 20);
        p2.add(l7);

        t1 = new JTextField();
        t1.setBounds(400, 60, 200, 30);
        p2.add(t1);
        t2 = new JTextField();
        t2.setBounds(400, 100, 200, 30);
        p2.add(t2);
        t3 = new JTextField();
        t3.setBounds(400, 140, 200, 30);
        p2.add(t3);

        ccourse = new String[]{"Mtech", "BTech", "MCA", "BCA", "BBA", "MBA", "BA", "BCom", "BSC"};
        j1 = new JComboBox(ccourse);
        j1.setBounds(400, 180, 200, 30);
        p2.add(j1);
        yyear = new String[]{"1", "2", "3", "4"};
        j2 = new JComboBox(yyear);
        j2.setBounds(400, 220, 200, 30);
        p2.add(j2);
        ssem = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        j3 = new JComboBox(ssem);
        j3.setBounds(400, 260, 200, 30);
        p2.add(j3);
        mmember = new String[]{"Student", "Teacher"};
        j4 = new JComboBox(mmember);
        j4.setBounds(400, 300, 200, 30);
        p2.add(j4);

        JButton b1, b2;
        b1 = new JButton("search");
        b1.setBounds(620, 60, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\18.png");
        b1.setIcon(new ImageIcon(url));
        b1.setHorizontalAlignment(SwingConstants.LEFT);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String blank = "";
                if (mem.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " Invalid input");
                } else {
                    try {
                        int member = Integer.parseInt(t1.getText());
                        JavaConnection db = new JavaConnection();
                        db.connection();
                        String sql = "select * from Member Where memberid='" + member + "'";
                        ResultSet rs = db.executeQuery(sql);
                        if (rs.next()) {
                            t1.setEditable(false);
                            t2.setText(rs.getString(2));
                            t3.setText(rs.getString(3));
                            j1.setSelectedItem(rs.getString(4));
                            j2.setSelectedItem(rs.getString(5));
                            j3.setSelectedItem(rs.getString(6));
                            j4.setSelectedItem(rs.getString(7));

                        } else {
                            JOptionPane.showMessageDialog(null, "user not exist");
                        }

                    } catch (Exception ex) {
                    }

                }

            }
        }
        );

        p2.add(b1);
        b2 = new JButton("Delete");
        b2.setBounds(620, 350, 100, 30);
         url = cls.getResource("anyfiles\\icon\\icon\\21.png");
        b2.setIcon(new ImageIcon(url));
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        p2.add(b2);

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mem = t1.getText();
                String nam = t2.getText();

                String blank = "";
                if (mem.equals(blank) || nam.equals(blank)) {
                    JOptionPane.showMessageDialog(null, " NO id input");
                } else {

                    int memberid = Integer.parseInt(t1.getText());

                    JavaConnection db = new JavaConnection();
                    db.connection();
                    String check = "select * from Member where memberid='" + memberid + "'";
                    String check2 = "select memberid,membername from Issue where memberid='" + memberid + "'";
                    ResultSet rs1 = db.executeQuery(check2);
                    try {
                        if (!rs1.next()) {

                            ResultSet rs = db.executeQuery(check);
                            if (rs.next()) {
                                String sql = "Delete from member  Where memberid='" + memberid + "'";
                                db.executeUpdate(sql);

                                JOptionPane.showMessageDialog(null, "Deleted");
                                t2.setText("");
                                t3.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "No member found");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Book is issued to \n Member Id: " + rs1.getString(1) + " \n member name : " + rs1.getString(2) + "\n you cant delete");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "something wrong that creator dont know ");
                    }

                }
            }

        }
        );

        add(p2);

        revalidate();// we have to validate frame only

        repaint();

    }

}

class a {

    public static void main(String[] args) {
        Update u = new Update();
        u.revalidate();
        u.repaint();
    }
}
