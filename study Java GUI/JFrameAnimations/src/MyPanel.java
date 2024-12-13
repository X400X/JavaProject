import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image image;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 3;
    int yVelocity = 2;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(new Color(0xFFFFFF));
        image = new ImageIcon("logo1.png").getImage();
        backgroundImage = new ImageIcon("logo2.png").getImage();
        timer = new Timer(10, this);
        timer.start();

    }

    public void paint(Graphics g) {

        super.paint(g); //paint background

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(backgroundImage, 0, 0, null);
        g2d.drawImage(image, x, y, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH-image.getWidth(null) || x < 0) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if (y >= PANEL_HEIGHT-image.getHeight(null) || y < 0) {
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;

        repaint();

    }
}
