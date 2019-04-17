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

/**
 *
 * @author user
 */
public class NewBook extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton add, back;
    String name, publisher;
    int edition, pages;
    float price;
    JPanel p = new JPanel();

    NewBook() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 270, 600, 500);
        setTitle("New Book");
        setLayout(null);
        setSize(500, 500);

        TitledBorder title;
        title = BorderFactory.createTitledBorder("  New Book");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(0, 0, 490, 490);
        p.setLayout(null);
        p.setBackground(Color.white);

        l1 = new JLabel("Book ID");
        l1.setBounds(50, 60, 100, 30);
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(50, 100, 100, 30);
        p.add(l2);
        l3 = new JLabel("Edition");
        l3.setBounds(50, 140, 100, 30);
        p.add(l3);
        l4 = new JLabel("Publisher");
        l4.setBounds(50, 180, 200, 30);
        p.add(l4);
        l5 = new JLabel("Price");
        l5.setBounds(50, 220, 100, 30);
        p.add(l5);
        l6 = new JLabel("Pages");
        l6.setBounds(50, 260, 100, 30);
        p.add(l6);
        t1 = new JTextField();
        t1.setBounds(200, 60, 200, 30);
        p.add(t1);
        t1.setText("  Automatic Generate");
        t1.setEditable(false);
        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 30);
        p.add(t2);
        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 30);
        t3.setText("0");
        p.add(t3);
        t4 = new JTextField();
        t4.setBounds(200, 180, 200, 30);
        p.add(t4);
        t5 = new JTextField();
        t5.setBounds(200, 220, 200, 30);
        t5.setText("0");
        p.add(t5);
        t6 = new JTextField();
        t6.setBounds(200, 260, 200, 30);
        t6.setText("0");
        p.add(t6);

        add = new JButton("Add");
        add.setBounds(70, 350, 100, 30);
        Class cls = this.getClass();
        URL url = cls.getResource("anyfiles\\icon\\icon\\12.png");
        add.setIcon(new ImageIcon(url));

        add.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(add);
        back = new JButton("Back");
        back.setBounds(300, 350, 100, 30);
        url = cls.getResource("anyfiles\\icon\\icon\\11.png");
        back.setIcon(new ImageIcon(url));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });
        p.add(back);
        revalidate();
        repaint();
        add(p);

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                add();
            }

        });

    }

    void add() {

        JavaConnection db = new JavaConnection();
        db.connection();

        String nam, pub, s1, s2, s3, s4, s5,edi,pric,pag;
        float pri;
        int page;
        nam = pub =edi=pric=pag= "";
        pri = 0;
        s1 = t2.getText();
        s2 = t3.getText();
        s3 = t4.getText();
        s4 = t5.getText();
        s5 = t6.getText();
        //page = editionn = 0;&& pri == price && page == pages && editionn == edition

        String insert;
        if (nam.equals(s1) || edi.equals(s2) || pub.equals(s3) || pric.equals(s4) || pag.equals(s5)) {
            JOptionPane.showMessageDialog(null, "This is an illegal input !");

        } else {
            name = t2.getText();
            edition = Integer.parseInt(t3.getText());
            publisher = t4.getText();
            price = Float.parseFloat(t5.getText());
            pages = Integer.parseInt(t6.getText());
            insert = "INSERT INTO Book (name,edition,publisher,price,pages) VALUES('" + name + "','" + edition + "','" + publisher + "'," + price + "," + pages + ")";
            JOptionPane.showMessageDialog(null, "Your Book is added !");
            
            t2.setText("");
            t3.setText("0");
            t4.setText("");
            t5.setText("0");
            t6.setText("0");
            db.executeUpdate(insert);
        }

        db.connClose();

    }

}

class Sigsnupe {

    public static void main(String[] args) {
        NewBook s = new NewBook();

    }
}
