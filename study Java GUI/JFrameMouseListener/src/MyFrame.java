import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {

    JLabel label;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(new Color(0xFC0202));
        label.setOpaque(true);
        label.addMouseListener(this);

        this.add(label);
        this.setVisible(true);
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("You clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed the mouse");
        label.setBackground(new Color(0x00FD2A));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("You released the mouse"); //отжатие кнопки
        label.setBackground(new Color(0xFFFB02));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("You entered the mouse"); // реагирует на наведение мышки
        label.setBackground(new Color(0x0338FF));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("You exited the mouse");  // реагирует на наведение мышки
        label.setBackground(new Color(0xFF0101));
    }
}
