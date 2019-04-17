/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author root
 */
public class About extends JFrame {

    JButton back;

    About() {
        setSize(950, 700);
        setVisible(true);
        setLayout(null);
        setBounds(600, 100, 950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel("<html><body text=green><h1 text=red>Contact:</h1>xxx00000010101010@gmail.com</body></html>");
        l1.setBounds(400, 100, 200, 70);
        add(l1);
        JLabel l2 = new JLabel("<html><body text=green><b text=red>Name:</b>    Ruhit Rai</body></html>");
        l2.setBounds(400, 400, 200, 70);
        add(l2);
        back = new JButton("Back");
        back.setSize(100, 100);
        back.setIcon(new ImageIcon("E:\\icon\\11.png"));

        back.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().setBackground(new Color(44, 47, 51));

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                WelcomePage w = new WelcomePage();
            }

        });

        back.setBounds(400, 600, 100, 30);
        add(back);

    }

}

class Taew {

    public static void main(String[] args) {
        About a = new About();
        a.repaint();
    }

}
