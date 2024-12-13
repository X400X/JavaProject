import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MyFrame() {

        ImageIcon imageIcon = new ImageIcon("logo.png");
        ImageIcon imageIcon1 = new ImageIcon("logo1.png");


        label = new JLabel();
        label.setIcon(imageIcon1);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(150, 100, 200, 150);
        //button.addActionListener(e -> System.out.println("Boom"));
        button.addActionListener(this);
        button.setText("I am button");
        button.setFocusable(false);

        button.setIcon(imageIcon);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font("Comic San", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("Boo");
            label.setVisible(true);
        }
    }
}
