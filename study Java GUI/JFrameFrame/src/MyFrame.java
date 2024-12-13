import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame () {
        this.setTitle("Main Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);

        ImageIcon imageIcon = new ImageIcon("logo.pnp");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(new Color(250, 200, 50));
    }

}
