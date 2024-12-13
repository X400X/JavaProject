import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\LabelJFrame\\src\\logo.png");
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel();
        label.setText("Bro, do you even code?");
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color((0x00FF00)));
        label.setFont(new Font("My Font", Font.PLAIN, 50));
        label.setIconTextGap(-25);
        label.setBorder(border);

        label.setVerticalAlignment(JLabel.CENTER);   //все в центре
        label.setHorizontalAlignment(JLabel.CENTER);

        //label.setBounds(0, 0, 350, 350); // остаеться на том месте что указано. frame.setLayout(null);

        label.setBackground(Color.black);
        label.setOpaque(true);



        JFrame frame = new JFrame();

        //frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
    }
}
