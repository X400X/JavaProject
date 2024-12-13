import javax.swing.*;

public class MyFrame extends JFrame {


    DragJPanel dragJPanel = new DragJPanel();

    MyFrame() {


        this.add(dragJPanel);
        this.setTitle("drag & Drop demo");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
