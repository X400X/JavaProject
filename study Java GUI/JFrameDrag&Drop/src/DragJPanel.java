import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragJPanel extends JPanel {

    ImageIcon imageIcon = new ImageIcon("logo1.png");
    final int WIDTH = imageIcon.getIconWidth();
    final int HEIGHT = imageIcon.getIconHeight();
    Point imageCorner;
    Point prevPt;

    DragJPanel() {
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        imageIcon.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged (MouseEvent e) {
            Point currentPT = e.getPoint();

            imageCorner.translate(
                    (int)(currentPT.getX()-prevPt.getX()),
                    (int)(currentPT.getY()-prevPt.getY())
            );
                    prevPt = currentPT;
                    repaint();
        }
    }
}
