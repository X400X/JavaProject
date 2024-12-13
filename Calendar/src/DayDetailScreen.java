import javax.swing.*;
import java.awt.*;

public class DayDetailScreen {

    private JFrame frame;
    private JPanel panel;

    public DayDetailScreen(JFrame frame, int day, int month, int year, CalendarApp mainApp) {
        this.frame = frame;

        panel = new JPanel(new BorderLayout());

        // Create a label to display selected day, month, and year
        String monthName = new java.text.DateFormatSymbols().getMonths()[month - 1];
        JLabel infoLabel = new JLabel("Selected: " + monthName + " " + day + ", " + year);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(infoLabel, BorderLayout.CENTER);

        // Add a back button to return to the DetailScreen
        JButton backButton = new JButton("Back to Detail Screen");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(e -> mainApp.returnToMainScreen());
        panel.add(backButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }
}