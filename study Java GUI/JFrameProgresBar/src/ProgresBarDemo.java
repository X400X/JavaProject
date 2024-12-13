import javax.swing.*;
import java.awt.*;

public class ProgresBarDemo extends JFrame {

    JFrame frame = new JFrame();
    JProgressBar progressBar = new JProgressBar(0, 100);
    //JProgressBar progressBar = new JProgressBar(0, 500);



    ProgresBarDemo() {

        progressBar.setValue(0);
        progressBar.setBounds(0, 0, 420, 50);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("MV Boli", Font.PLAIN, 25));
        progressBar.setForeground(new Color(0xF30808));
        progressBar.setBackground(new Color(0x000000));

        frame.add(progressBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill () {
        int count = 0;

        while (count <= 100) {
            progressBar.setValue(count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count += 1;
        }
        progressBar.setString("Done! :)");
    }

//    public void fill () {
//        int count = 500;
//
//        while (count > 0) {
//            progressBar.setValue(count);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            count--;
//        }
//        progressBar.setString("Done! :)");
//    }

}
