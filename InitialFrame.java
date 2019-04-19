/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Image;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 *
 * @author root
 */
public class InitialFrame extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3;
    JTextField t1;
    JComboBox j1;

    void initialframe() throws IOException {
        setTitle("Initial configuration setup");
        // setSize(610, 600);
        getContentPane().setBackground(new Color(44, 43, 48));
        setVisible(true);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 610, 400);
        l1 = new JLabel("Create New Dbname : ");
        l1.setBounds(60, 10, 200, 30);
        l1.setForeground(Color.white);
        t1 = new JTextField();
        t1.setSize(100, 30);
        t1.setBounds(200, 10, 200, 30);
        b1 = new JButton("Create DB & Use");

        b1.setBounds(420, 10, 170, 30);

        //Class cls = this.getClass();
        // URL url;
        // url = cls.getResource("\\icon\\32.png");
        //   url = new URL("\\icon\\32.png");
        //Image image=null;
        // try {
        //e ImageIO.read(getClass().getResource("yourFolder/yourIcon.png"))
        //   Image image = ImageIO.read(this.getClass().getResource("anyFiles\\icon\\icon\\32.png"));
        //   Image image1 = ImageIO.read(new File("icon/db.jpg"));
        //     image=  ImageIO.read(url);
        //    b1.setIcon(new ImageIcon(image));
        // } catch (Exception e) {
        //    e.printStackTrace();
        //}
        //  jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/11.png")));
        b1.setIcon(new ImageIcon(getClass().getResource("/32.png")));

        b1.setHorizontalAlignment(SwingConstants.LEFT);

        JavaConnection db = new JavaConnection();
        db.connectionInitial();
        j1 = new JComboBox();
        j1.setBounds(150, 170, 100, 30);
        j1.setVisible(false);
        add(j1);
        l2 = new JLabel("We find an Existing Database in Your Computer Of Our Software Wana Use?:");
        l2.setBounds(10, 100, 500, 30);
        l2.setVisible(false);
        l2.setForeground(Color.green);
        add(l2);
        l3 = new JLabel("Select the existing database and Click on Use Button.");
        l3.setBounds(10, 140, 500, 30);
        l3.setVisible(false);
        l3.setForeground(Color.white);
        add(l3);
        l4 = new JLabel("Existing Database ");
        l4.setBounds(10, 170, 500, 30);
        l4.setVisible(false);
        l4.setForeground(Color.white);
        add(l4);
        l5 = new JLabel("OR");
        l5.setBounds(10, 70, 500, 20);
        l5.setForeground(Color.red);
        //l5.setOpaque(true);
        // l5.setBackground(Color.yellow);
        l5.setVisible(false);
        add(l5);

        l6 = new JLabel(new ImageIcon(getClass().getResource("/db.jpg")));
        //url = cls.getResource("anyfiles\\icon\\icon\\db.jpg");

        l6.setBounds(0, 260, 100, 100);
        l6.setForeground(Color.red);
        l6.setVisible(true);
        add(l6);
        b2 = new JButton("USE");
        b2.setBounds(300, 170, 100, 30);

        b2.setIcon(new ImageIcon(getClass().getResource("/33.png")));
        //  url = cls.getResource("anyfiles\\icon\\icon\\33.png");

        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.setVisible(false);

        File file = new File(".\\initialdbsetup.txt");
        if (file.exists()) {
            setVisible(false);
            Login L1 = new Login();
            L1.LoginFrame();

        }

        try {
            ResultSet check = db.executeQuery(" SHOW TABLES LIKE 'dbname'");
            //ResultSet rs2 = db.executeQuery("select username from dbname");;

            if (check.next()) {
                l2.setVisible(true);
                l3.setVisible(true);
                l4.setVisible(true);
                b2.setVisible(true);
                j1.setVisible(true);
                l5.setVisible(true);
                ResultSet rs = db.executeQuery("select username from dbname");
                while (rs.next()) {
                    j1.addItem(rs.getString("username"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "welcome we Figuered out You haven't used this Software on this computer");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "please Connect Xamp Start Mysql","Error the Developer Wants You to Start Xamp/Wamp",JOptionPane.ERROR_MESSAGE);
        }
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    String blank = "";
                    String isblank = t1.getText();
                    if (isblank.equals(blank)) {
                        JOptionPane.showMessageDialog(null, "Fill Db Name to Create");
                    } else {
                        call();
                    }

                } catch (Exception ev) {
                    System.out.println(ev);
                }

            }

        });

        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //refresh();
                String dbselected = (String) j1.getSelectedItem();
                String addd = "update currentdb  set id='" + 1 + "',name='" + dbselected + "'";
                db.executeUpdate(addd);
                try {
                    file.createNewFile();
                    setVisible(false);
                    Login L1 = new Login();
                    L1.LoginFrame();
                } catch (Exception ev) {
                    System.out.println(ev);
                }

            }

        });
        add(b2);
        b3 = new JButton("refresh");
        b3.setBounds(300, 270, 100, 30);

        /*    try {
              //e ImageIO.read(getClass().getResource("yourFolder/yourIcon.png"))
                Image image3 = ImageIO.read(this.getClass().getResource("anyFiles\\icon\\icon\\31.png"));
       //   Image image1 = ImageIO.read(new File("icon/db.jpg"));
            //     image=  ImageIO.read(url);
          b3.setIcon(new ImageIcon(image3));
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
        b3.setIcon(new ImageIcon(getClass().getResource("/31.png")));
        //url = cls.getResource("anyfiles\\icon\\icon\\31.png");

        b3.setHorizontalAlignment(SwingConstants.LEFT);
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    refresh();
                } catch (Exception ex) {
                }

            }

        });
        add(b3);
        add(b1);
        add(l1);
        add(t1);

        revalidate();
        repaint();

    }

    void refresh() throws IOException {

        revalidate();
        repaint();
        setVisible(false);
        remove(this);
        InitialFrame s = new InitialFrame();
        s.initialframe();

    }

    void call() {
        JavaConnection db = new JavaConnection();
        db.connectionInitial();
        String dbname = t1.getText();
        File file = new File(".\\initialdbsetup.txt");
        //String dbname = "db4";

        String sql = "SELECT SCHEMA_NAME  FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME='" + dbname + "'";
        ResultSet rs1 = db.executeQuery(sql);
        try {
            if (rs1.next()) {
                JOptionPane.showMessageDialog(null, rs1.getString(1) + " already exits");
                System.out.println(rs1.getString(1) + " already exits");

                //   b1.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, dbname + " Not exits");
                System.out.println(dbname + " Not exits");
                //  b1.setVisible(true);
                // ResultSet rs2 = db.executeQuery("SHOW TABLES LIKE 'dbname'");
                int r = db.executeUpdate("CREATE DATABASE " + dbname);
                if (r == 0) {
                    JOptionPane.showMessageDialog(null, dbname + ", database already exists");
                    // System.out.println("Database exists");
                } else {
                    JOptionPane.showMessageDialog(null, dbname + ", database created");
                }
                System.out.println("1");

                ResultSet rs2 = db.executeQuery(" SELECT * FROM information_schema.tables WHERE table_schema = 'test' AND table_name = 'dbname'");
                if (rs2.next()) {
                    System.out.println("2");
                    System.out.println(rs2.getString(1) + " dbname table exits");
                    String add = "Insert into dbname values ('" + dbname + "')";
                    db.executeUpdate(add);
                    ResultSet rs22 = db.executeQuery(" SELECT * FROM information_schema.tables WHERE table_schema = 'test' AND table_name = 'currentdb'");
                    if (rs22.next()) {
                        System.out.println("3");
                        String addd = "update currentdb  set id='" + 1 + "',name='" + dbname + "'";
                        db.executeUpdate(addd);
                        PrimarySetup s = new PrimarySetup();

                        // s.grantUser();
                        s.call();
                        file.createNewFile();
                        setVisible(false);
                        Login L1 = new Login();
                        L1.LoginFrame();

                    } else {
                        System.out.println("4");
                        String currentdb = "CREATE TABLE currentdb ( id INT not NUll,name VARCHAR(255) not NULL,PRIMARY KEY (id))";
                        db.executeUpdate(currentdb);
                        String addd = "Insert into currentdb values ('" + 1 + "','" + dbname + "')";
                        db.executeUpdate(addd);
                        PrimarySetup s = new PrimarySetup();

                        // s.grantUser();
                        s.call();
                        file.createNewFile();
                        setVisible(false);
                        Login L1 = new Login();
                        L1.LoginFrame();

                    }
                } else {
                    System.out.println("5");
                    String dbTablename = "CREATE TABLE dbname ( username VARCHAR(255) not NULL) ";
                    db.executeUpdate(dbTablename);

                    String add = "Insert into dbname values ('" + dbname + "')";
                    db.executeUpdate(add);
                    JOptionPane.showMessageDialog(null, " dbname table is created");

                    ResultSet rs22 = db.executeQuery(" SELECT * FROM information_schema.tables WHERE table_schema = 'test' AND table_name = 'currentdb'");
                    if (rs22.next()) {
                        System.out.println("6");
                        String addd = "update currentdb set id='" + 1 + "',name='" + dbname + "'";
                        db.executeUpdate(addd);
                        PrimarySetup s = new PrimarySetup();

                        // s.grantUser();
                        s.call();
                        file.createNewFile();
                        setVisible(false);
                        Login L1 = new Login();
                        L1.LoginFrame();

                    } else {
                        System.out.println("7");
                        String currentdb = "CREATE TABLE currentdb ( id INT not NUll,name VARCHAR(255) not NULL,PRIMARY KEY (id))";
                        db.executeUpdate(currentdb);
                        String addd = "Insert into currentdb values ('" + 1 + "','" + dbname + "')";
                        db.executeUpdate(addd);
                        PrimarySetup s = new PrimarySetup();

                        // s.grantUser();
                        s.call();
                        file.createNewFile();
                        setVisible(false);
                        Login L1 = new Login();
                        L1.LoginFrame();

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" something code wrong" + e);
        }
    }

}

class frrt {

    public static void main(String[] args) throws IOException {
        InitialFrame s = new InitialFrame();
        s.initialframe();
        // s.call();

    }
}
