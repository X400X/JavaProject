import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(0xEE0808));
        textField.setBackground(new Color(0x4C4B4B));
        textField.setCaretColor(Color.WHITE);
        textField.setText("Username");


        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("Welcome " + textField.getText());

//            button.setEnabled(false);
//            textField.setEnabled(false);
        }
    }
}
