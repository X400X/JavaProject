import javax.swing.*;
import java.awt.*;

public class Mail {
    public static void main(String[] args) {

        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.RED);
        label.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100, 100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.YELLOW);
        label3.setBounds(150, 150, 200, 200);

        JLayeredPane layeredPane  = new JDesktopPane();
        layeredPane.setBounds(0, 0, 700, 700);
        layeredPane.add(label, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(1));



        JFrame frame = new JFrame();
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
