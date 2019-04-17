
import java.awt.*;
import java.net.URL;
import javax.swing.*;
//import javax.swing.border.*;

public class ProgressBarExample {

    JProgressBar jb;
    int i = 0;

    ProgressBarExample() {
        JFrame f = new JFrame();

        //f.setSize(250, 150);
        f.setLayout(null);
        // f.setLocationRelativeTo(null);

        f.getContentPane().setBackground(new Color(255, 255, 255));// white
        // f.getContentPane().setBackground(new Color(153, 170, 181)); // light -light-light blue
        // f.getContentPane().setBackground(new Color(44, 47, 51));// grey-dicord chat color
      //  JLabel l1 = new JLabel("", new ImageIcon("D:\\1.gif"), JLabel.CENTER);
       Class cls = this.getClass();
        URL url = cls.getResource("anyfiles\\icon\\icon\\1.gif");
        JLabel l1 = new JLabel( new ImageIcon(url));
        l1.setBounds(60, 0, 100, 100);
        f.add(l1);
        //   f.getContentPane().setBackground(Color.blue);
        l1.setSize(400, 400);
        url = cls.getResource("anyfiles\\icon\\icon\\5.gif");
        JLabel l2 = new JLabel(new ImageIcon(url));
        l2.setBounds(150, 400, 400, 20);

        l2.setSize(200, 200);
        f.add(l2);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(700, 270, 500, 600);
        //  f.getContentPane().add(mainPanel); // or whatever...
        // f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb = new JProgressBar(SwingConstants.VERTICAL, 0, 2000);
        jb.setBounds(0, 0, 30, 160);
        jb.setValue(0);
        jb.setSize(40, 561);
        jb.setStringPainted(true);
        // Border blackline;
        // blackline = BorderFactory.createLineBorder(Color.white);
        //jb.setBorder(blackline);
        f.add(jb);
        //Border blackline;
        //blackline,raisedetched, loweredetched,raisedbevel, loweredbevel,
        // jb.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        //  blackline = BorderFactory.createLineBorder(Color.white);
//raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
//loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        // raisedbevel = BorderFactory.createRaisedBevelBorder();
//loweredbevel = BorderFactory.createLoweredBevelBorder();
        //empty = BorderFactory.createEmptyBorder();
        //jb.setBorder(blackline);
      //  jb.setStringPainted(true);
        jb.setForeground(new Color(114, 137, 218));
        jb.setBackground(Color.white);
        run();
        f.setVisible(false);
        WelcomePage s = new WelcomePage();

    }

    public void run() {
        while (i <= 2000) {
            jb.setValue(i);
            i = i + 20;
            try {
               Thread.sleep(15);
            } catch (Exception e) {
           }
        }

    }

}

class as {

    public static void main(String[] args) {
        new ProgressBarExample();
    }
}
