/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author root
 */
public class Member extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3;
    JButton add, back;
    String name, father, course, member;
    int year, sem, roll = 1;
    String yyear[], ssem[], ccourse[], mmember[];

    JComboBox j1, j2, j3, j4;
    JPanel p=new JPanel();

    Member() {
        setTitle("New Member");
        setLayout(null);
        TitledBorder title;
        
        title = BorderFactory.createTitledBorder("  New Member");
        //BorderFactory.createTitledBorder(null, "text", TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("times new roman",Font.PLAIN,12), Color.yellow)
        title.setTitleColor(Color.RED);
        title.setTitleFont(new Font("times new roman", Font.PLAIN, 20));

        // title.setTitleJustification(TitledBorder.LEFT);
        p.setBorder(title);
        // p.setBackground();
        p.setBounds(0, 0, 600, 500);
        p.setLayout(null);
        p.setBackground(Color.white);
        l1 = new JLabel("Member id");
        l1.setBounds(100, 60, 100, 30);
        p.add(l1);
        l2 = new JLabel("Name");
        l2.setBounds(100, 100, 100, 30);
        p.add(l2);
        l3 = new JLabel("Father Name");
        l3.setBounds(100, 140, 100, 30);
        p.add(l3);
        l4 = new JLabel("Department");
        l4.setBounds(100, 180, 200, 30);
        p.add(l4);
        l5 = new JLabel("Year");
        l5.setBounds(100, 220, 100, 30);
        p.add(l5);
        l6 = new JLabel("Sem");
        l6.setBounds(100, 260, 100, 30);
        p.add(l6);
        l7 = new JLabel("Member type");
        l7.setBounds(100, 300, 100, 30);
        p.add(l7);
        t1 = new JTextField();
        t1.setBounds(300, 60, 200, 30);
        t1.setEditable(false);
        t1.setText(" Automatic Generated");
        p.add(t1);

        t2 = new JTextField();
        t2.setBounds(300, 100, 200, 30);
        p.add(t2);
        t3 = new JTextField();
        t3.setBounds(300, 140, 200, 30);
        p.add(t3);

        ccourse = new String[]{"Mtech", "BTech", "MCA", "BCA", "BBA", "MBA", "BA", "BCom", "BSC"};
        j1 = new JComboBox(ccourse);
        j1.setBounds(300, 180, 200, 30);
        p.add(j1);

        yyear = new String[]{"1", "2", "3", "4"};
        j2 = new JComboBox(yyear);
        j2.setBounds(300, 220, 200, 30);
        p.add(j2);
        ssem = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        j3 = new JComboBox(ssem);
        j3.setBounds(300, 260, 200, 30);
        p.add(j3);
        mmember = new String[]{"Student", "Teacher"};
        j4 = new JComboBox(mmember);
        j4.setBounds(300, 300, 200, 30);
        p.add(j4);

        add = new JButton("Add");
        add.setBounds(70, 400, 100, 30);
        
        add.setIcon(new ImageIcon(getClass().getResource("/12.png")));

        add.setHorizontalAlignment(SwingConstants.LEFT);
        p.add(add);
        back = new JButton("Back");
        back.setBounds(400, 400, 100, 30);
     
        back.setIcon(new ImageIcon(getClass().getResource("/11.png")));

        back.setHorizontalAlignment(SwingConstants.LEFT);

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });

        p.add(back);
        add(p);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 270, 610, 540);
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                add();
            }

        });

    }

    void add() {

        JavaConnection db = new JavaConnection();
        db.connection();

        name = t2.getText();
        father = t3.getText();
        course = (String) j1.getSelectedItem();
        year = Integer.parseInt((String) j2.getSelectedItem());
        sem = Integer.parseInt((String) j3.getSelectedItem());
        member = (String) j4.getSelectedItem();
        String nam, fath, mem;
        nam = fath = mem ="";
        String insert;
        if (name.equals(nam) || father.equals(fath)) {
            
             JOptionPane.showMessageDialog(null, "This is an illegal input !");
            
        } else {

            insert = "INSERT INTO Member (name,father_name,department,year,sem,member_type) VALUES('" + name + "','" + father + "','" + course + "','" + year + "','" + sem + "','" + member + "')";
            db.executeUpdate(insert);
             JOptionPane.showMessageDialog(null,member +", is added as Member !");
             t2.setText("");
             t3.setText("");
        }
        db.connClose();

    }

}

class Sig {

    public static void main(String[] args) {
        Member s = new Member();

    }
}
