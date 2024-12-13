import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select Color");
        button.addActionListener(this);

        label = new JLabel();
        label.setBackground(new Color(0xFFFFFF));
        label.setText("This is some text :D");
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));
        label.setOpaque(true);

        this.add(label);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null, "Pick a color...I guess", new Color(0x00000));
            //label.setForeground(color);
            label.setBackground(color);
        }
    }
}
