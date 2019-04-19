/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.border.*;

/**
 *
 * @author user
 */
public class WelcomePage extends JFrame {

    JButton b1, b2, b3, b4, b5, b6, b44;
    JLabel l1, l2, l3, l44, l4, l5, l6;

    WelcomePage() {
     
    

        JLabel head = new JLabel(new ImageIcon(getClass().getResource("/2.jpg")));
        head.setBounds(0, 0, 440, 100);
        //l1.setSize(100,100);
        head.setLayout(null);
        add(head);
        JLabel welcome = new JLabel("<html><body><center>#Welcome</center> <br> <center>to</center> <br> <center>Library Management System</body></html>");
        welcome.setBounds(900, 0, 300, 100);
        add(welcome);
     
        JButton logout = new JButton(new ImageIcon(getClass().getResource("/17.jpg")));
        logout.setBounds(1100, 40, 70, 70);
        add(logout);
        logout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login a = new Login();
                try {
                    a.LoginFrame();
                } catch (Exception ev) {
                }

            }
        });
        // setBackground(Color.white);
        JPanel p = new JPanel();

        TitledBorder title;
        title = BorderFactory.createTitledBorder("Operation");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(40, 150, 1100, 250);
        p.setLayout(null);
        p.setBackground(Color.white);
        
        b1 = new JButton(new ImageIcon(getClass().getResource("/7.jpg")));
        b1.setBounds(880, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b1.setSize(150, 150);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Member s = new Member();
            }
        });
        p.add(b1);
        l1 = new JLabel("New Member");
        l1.setBounds(920, 150, 200, 100);
        p.add(l1);
       
        b2 = new JButton(new ImageIcon(getClass().getResource("/8.jpg")));
        b2.setBounds(610, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b2.setSize(150, 150);
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Statistics s = new Statistics();

                s.returnTable();
                s.issue();

            }
        });
        p.add(b2);
        l2 = new JLabel("Statistics");
        l2.setBounds(640, 150, 200, 100);
        p.add(l2);
        
        b3 = new JButton(new ImageIcon(getClass().getResource("/10.jpg")));
        b3.setBounds(330, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b3.setSize(150, 150);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                NewBook a = new NewBook();

            }
        });
        p.add(b3);
        l3 = new JLabel("New Books");
        l3.setBounds(360, 150, 200, 100);
        p.add(l3);
        JLabel l33 = new JLabel("Update/Delete");
        l33.setBounds(80, 150, 200, 100);
        p.add(l33);
        
        JButton b33 = new JButton(new ImageIcon(getClass().getResource("/27.png")));
        b33.setBounds(60, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b33.setSize(150, 150);
        b33.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Update u = new Update();
                u.revalidate();
                u.repaint();

            }
        });
        p.add(b33);
//first panel finished 
        JPanel p1 = new JPanel();

        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder("Action");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title1.setTitleColor(Color.RED);
        title1.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p1.setBorder(title1);
        // p.setBackground();
        p1.setBounds(40, 500, 1100, 250);
        p1.setLayout(null);
        p1.setBackground(Color.white);
       
        b44 = new JButton(new ImageIcon(getClass().getResource("/30.png")));
        b44.setBackground(Color.white);
        b44.setBounds(70, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b44.setSize(150, 150);
        b44.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewTable u = new ViewTable();
                u.revalidate();
                u.repaint();

            }
        });
        p1.add(b44);
        l44 = new JLabel("View Table");
        l44.setBounds(100, 150, 200, 100);
        p1.add(l44);
    
        b4 = new JButton(new ImageIcon(getClass().getResource("/11.jpg")));
        b4.setBounds(330, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b4.setSize(150, 150);
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Issue a = new Issue();
                a.setSize(1230, 600);

            }
        });
        p1.add(b4);
        l4 = new JLabel("Issue Book");
        l4.setBounds(360, 150, 200, 100);
        p1.add(l4);
      
        b5 = new JButton(new ImageIcon(getClass().getResource("/12.jpg")));
        b5.setBounds(620, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b5.setSize(150, 150);
        b5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Return a = new Return();
                a.setSize(1220, 520);

            }
        });
        p1.add(b5);
        l5 = new JLabel("Return Book");
        l5.setBounds(660, 150, 200, 100);
        p1.add(l5);
       

        b6 = new JButton(new ImageIcon(getClass().getResource("/14.jpg")));
        b6.setBounds(880, 30, 200, 100);
        //l1.setSize(100,100);
        // b1.setLayout(null);
        b6.setSize(150, 150);
        b6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                About a = new About();

            }
        });
        p1.add(b6);
        l6 = new JLabel("About Developer");
        l6.setBounds(920, 150, 200, 100);
        p1.add(l6);
        JavaConnection db = new JavaConnection();
        db.connectionInitial();
        ResultSet rs4 = db.executeQuery("Select name from currentdb where id=1");
        try {
            if (rs4.next()) {
                JLabel l7 = new JLabel("Current Db: " + rs4.getString(1));
                l7.setBounds(120, 750, 200, 30);
                add(l7);
            }
        } catch (Exception e) {
        }
        setTitle("Home Page");
        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(1200, 900);
        setVisible(true);
        setBounds(400, 100, 1200, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p);
        add(p1);
    }

}

class fort {

    public static void main(String[] args) {
        WelcomePage s = new WelcomePage();

    }
}
