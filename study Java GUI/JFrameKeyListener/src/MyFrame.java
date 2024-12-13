import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon imageIcon;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.addKeyListener(this);
        this.setLayout(null);

        imageIcon = new ImageIcon("logo.png");

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);

        label.setIcon(imageIcon);
//        label.setBackground(new Color(0xF32D2D));
//        label.setOpaque(true);

        this.getContentPane().setBackground(new Color(0x000000));
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'a' : label.setLocation(label.getX()-10, label.getY());
                break;
            case 'w' : label.setLocation(label.getX(), label.getY()-10);
                break;
            case 's' : label.setLocation(label.getX(), label.getY()+10);
                break;
            case 'd' : label.setLocation(label.getX()+10, label.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key char: " + e.getKeyCode());
    }
}
