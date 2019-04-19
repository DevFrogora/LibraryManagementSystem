/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author root
 */
public class ViewTable extends JFrame {

    TitledBorder title1, title2;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JTextField t0, t1, t2, t3, t4, t5;
    JLabel l0, l1, l2, l3, l4, l5;
    JButton b1, b0, b2, b3, b4, b5;

    ViewTable() {
        setTitle("VIewTable");
        setSize(1100, 800);
        setVisible(true);
        setLayout(null);
        setBounds(400, 100, 1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title1 = BorderFactory.createTitledBorder("View Member/Book");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(0, 0, 270, 770);
        p1.setLayout(null);
        p1.setBackground(Color.blue);

        b1 = new JButton();
        b1.setBounds(80, 60, 150, 150);
        b1.setBackground(Color.blue);
       
  

        b1.setIcon(new ImageIcon(getClass().getResource("/28.png")));
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewMemTable();
                revalidate();
                repaint();
            }
        });
        p1.add(b1);
        b2 = new JButton();
        b2.setBounds(80, 260, 150, 150);
        b2.setBackground(Color.blue);

        b2.setIcon(new ImageIcon(getClass().getResource("/29.png")));
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewBookTable();
                revalidate();
                repaint();
            }
        });
        p1.add(b2);
        add(p1);
        revalidate();
        repaint();

        JButton back = new JButton("Back");
        back.setBounds(600, 700, 100, 30);
        
        back.setIcon(new ImageIcon(getClass().getResource("/11.png")));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().setBackground(Color.red);
        add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                WelcomePage w = new WelcomePage();
            }

        });

    }

    void viewMemTable() {
        remove(p2);

        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);
        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
    }

    void searchMemName() {
        String name = t1.getText();
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member where name='" + name + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

    void searchMemId() {
        int id = 0;
        try {
            id = Integer.parseInt(t0.getText());
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Type Integer");
        }
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member where memberid='" + id + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

    void searchMemSem() {
        int sem = 0;
        try {
            sem = Integer.parseInt(t3.getText());
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Type Integer");
        }
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member where sem='" + sem + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

    void searchMemDept() {
        String dept = t2.getText();
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member where department='" + dept + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

    void searchMemType() {
        String type = t4.getText();
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemName();

            }

        });
        p2.add(b1);
        l2 = new JLabel("Department");
        l2.setBounds(100, 100, 200, 30);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p2.add(t2);
        b2 = new JButton("search");
        b2.setBounds(500, 100, 100, 30);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemDept();

            }

        });
        p2.add(b2);
        l3 = new JLabel("Sem");
        l3.setBounds(100, 140, 200, 30);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        p2.add(t3);
        b3 = new JButton("search");
        b3.setBounds(500, 140, 100, 30);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemSem();

            }

        });
        l4 = new JLabel("Member Type");
        l4.setBounds(100, 180, 200, 30);
        p2.add(l4);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p2.add(t4);
        b4 = new JButton("search");
        b4.setBounds(500, 180, 100, 30);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchMemType();

            }

        });
        p2.add(b4);
        p2.add(b3);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Member where member_type='" + type + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

    void viewBookTable() {
        remove(p2);

        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBookId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                  searchBookName();

            }

        });
        p2.add(b1);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Book");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
    }

    void searchBookId() {
        int id = 0;
        try {
            id = Integer.parseInt(t0.getText());
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Type Integer");
        }
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBookId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                 searchBookName();

            }

        });
        p2.add(b1);

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Book where bookid='" + id + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }
  
    void searchBookName() {
        String name = t1.getText();
        remove(p2);
        p2 = new JPanel();
        title2 = BorderFactory.createTitledBorder("");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(270, 0, 820, 670);
        p2.setLayout(null);
        p2.setBackground(Color.yellow);
        l0 = new JLabel("ID");
        l0.setBounds(100, 10, 200, 30);
        p2.add(l0);
        t0 = new JTextField();
        t0.setBounds(200, 10, 200, 30);
        p2.add(t0);
        b0 = new JButton("search");
        b0.setBounds(500, 10, 100, 30);
        b0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBookId();

            }

        });
        p2.add(b0);
        l1 = new JLabel("Name");
        l1.setBounds(100, 60, 200, 30);
        p2.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(500, 60, 100, 30);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBookName();

            }

        });
        p2.add(b1);
        

        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Book where name='" + name + "'");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 300, 770, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
        add(p2);
        revalidate();
        repaint();

    }

}

class af {

    public static void main(String[] args) {
        ViewTable u = new ViewTable();
        //  u.revalidate();
        //   u.repaint();
    }
}
