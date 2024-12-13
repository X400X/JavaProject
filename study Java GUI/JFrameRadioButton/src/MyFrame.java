import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotDogButton;

    ImageIcon pizza;
    ImageIcon hamburger;
    ImageIcon hotdog;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(200, 500);

        pizza = new ImageIcon("logo.png");
        hamburger = new ImageIcon("logo1.png");
        hotdog = new ImageIcon("logo2.png");

        pizzaButton = new JRadioButton("pizza");
        hamburgerButton = new JRadioButton("hamburger");
        hotDogButton = new JRadioButton("hotDog");

        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotDogButton);

        pizzaButton.addActionListener(this);
        hamburgerButton.addActionListener(this);
        hotDogButton.addActionListener(this);

        pizzaButton.setIcon(pizza);
        hamburgerButton.setIcon(hamburger);
        hotDogButton.setIcon(hotdog);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotDogButton);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizzaButton) {
            System.out.println("You order Pizza");
        } else if (e.getSource() == hamburgerButton) {
            System.out.println("You order Hamburger");
        } else if (e.getSource() == hotDogButton) {
            System.out.println("You order HotDog");
        }
    }
}
