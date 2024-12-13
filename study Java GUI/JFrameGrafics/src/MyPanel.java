import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Image image;

    MyPanel () {
        image = new ImageIcon("logo1.png").getImage();
        this.setPreferredSize(new Dimension(500, 500));
    }

    public void paint (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(0xE70F0F));
        g2D.setStroke(new BasicStroke(5));
        //g2D.drawLine(0, 0, 500, 500);

        //g2D.setPaint(new Color(0xFDF808));
        //g2D.drawRect(0, 0, 100, 200);
        //g2D.fillRect(0, 0, 100, 200);

//        g2D.setPaint(new Color(0xFDF808));
//        g2D.drawOval(0 ,0, 100, 100);
//        g2D.fillOval(0 ,0, 100, 100);

//        g2D.setPaint(new Color(0xFF0303));
//        g2D.drawArc(0, 0, 100, 100, 0, 270);
//        g2D.fillArc(0, 0, 100, 100, 0, 180);
//        g2D.setPaint(new Color(0xFFFFFF));
//        g2D.fillArc(0, 0, 100, 100, 180, 180);

//        int[] xPoints = {150, 250, 350};
//        int[] yPoints = {300, 150, 300};
//        g2D.setPaint(new Color(0x29FF03));
//        g2D.drawPolygon(xPoints, yPoints, 3);
//        g2D.fillPolygon(xPoints, yPoints, 3);

//        g2D.setPaint(new Color(0x0037FD));
//        g2D.setFont(new Font("Ink Free",Font.PLAIN, 50));
//        g2D.drawString("U R A WINNER! :D", 50, 50);

        g2D.drawImage(image, 0, 0, null);

    }
}
