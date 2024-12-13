import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {

    JLabel label;
    ImageIcon imageIcon1;
    ImageIcon imageIcon2;
    ImageIcon imageIcon3;
    ImageIcon imageIcon4;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.addMouseListener(this);

        imageIcon1 = new ImageIcon("logo1.png");
        imageIcon2 = new ImageIcon("logo2.png");
        imageIcon3 = new ImageIcon("logo3.png");
        imageIcon4 = new ImageIcon("logo4.png");

        label.setIcon(imageIcon1);

        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }




    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setIcon(imageIcon4);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setIcon(imageIcon3);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setIcon(imageIcon2);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setIcon(imageIcon1);
    }
}
