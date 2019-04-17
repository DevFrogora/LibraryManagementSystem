/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author user
 */
public class check extends JFrame {

    JLabel l1, l2, l3;

    check() {
        JFrame f = new JFrame("Panel Example");
        JPanel panel = new JPanel();

        TitledBorder title;
        title = BorderFactory.createTitledBorder("title");
        
        title.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(title);

        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.gray);
        JButton b1 = new JButton("Button 1");
        b1.setBounds(50, 100, 80, 30);
        b1.setBackground(Color.yellow);
        JButton b2 = new JButton("Button 2");
        b2.setBounds(100, 100, 80, 30);
        b2.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        f.add(panel);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class forgt {

    public static void main(String[] args) {
        check s = new check();

    }
}
