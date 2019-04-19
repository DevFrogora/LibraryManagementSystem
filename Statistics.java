/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

/**
 *
 * @author root
 */
public class Statistics extends JFrame {

    JButton back;

    TitledBorder title1, title2;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    Statistics() {
        setTitle("Statistics");
        setSize(950, 800);
        setVisible(true);
        setLayout(null);
        setBounds(400, 100, 950, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title1 = BorderFactory.createTitledBorder("Issue Details");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(40, 10, 840, 250);
        p1.setLayout(null);
        p1.setBackground(Color.white);

        // issue();
        title2 = BorderFactory.createTitledBorder("Return Details");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title2.setTitleColor(Color.RED);
        title2.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p2.setBorder(title2);
        // p.setBackground();
        p2.setBounds(40, 350, 840, 250);
        p2.setLayout(null);
        p2.setBackground(Color.white);
        // returnTable();

        p1.revalidate();
        p1.repaint();
        p2.revalidate();
        p2.repaint();

        revalidate();
        repaint();
        add(p1);
        add(p2);
        back = new JButton("Back");
        back.setBounds(400, 660, 100, 30);
     
        back.setIcon(new ImageIcon(getClass().getResource("/11.png")));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });
        add(back);
        getContentPane().setBackground(new Color(153, 170, 181));

    }

    void issue() {
        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from Issue");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(10, 30, 800, 200);
            sp.setSize(800, 200);

            p1.add(sp);

        } catch (Exception e) {
        }
    }

    void returnTable() {
        try {
            JavaConnection dm = new JavaConnection();
            dm.connection();
            TableModelJTable d = new TableModelJTable();
            ResultSet rs = dm.executeQuery("select * from ReturnTable");

            JTable table = new JTable(d.buildTableModel(rs));
            JScrollPane sp = new JScrollPane(table);

            sp.setBounds(10, 30, 800, 200);
            sp.setSize(800, 200);
            p2.add(sp);

        } catch (Exception e) {
        }
    }

}

class TablView {

    public static void main(String[] args) {
        Statistics s = new Statistics();

        s.returnTable();
        s.issue();

    }

}
