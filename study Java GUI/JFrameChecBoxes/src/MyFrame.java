import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon imageIconX;
    ImageIcon imageIconY;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        imageIconX = new ImageIcon("logo.png");
        imageIconY = new ImageIcon("logo1.png");


        button = new JButton();
        button.setText("Submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I am not a robot!");
        checkBox.setFocusPainted(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
        checkBox.setIcon(imageIconX);
        checkBox.setSelectedIcon(imageIconY);


        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println(checkBox.isSelected());
        }
    }
}
