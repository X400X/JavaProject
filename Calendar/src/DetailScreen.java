import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetailScreen {

    private JFrame frame;
    private JPanel panel;
    private JLabel monthYearLabel;
    private int currentMonth;
    private int currentYear;
    private CalendarApp mainApp;

    public DetailScreen(JFrame frame, String areaInfo, CalendarApp mainApp) {
        this.frame = frame;
        this.mainApp = mainApp;

        panel = new JPanel(new BorderLayout());

        // Parse the month and year from the areaInfo string
        String[] parts = areaInfo.split(" - ");
        currentMonth = Integer.parseInt(parts[0].split(" ")[1]);
        currentYear = Integer.parseInt(parts[1]);

        // Top panel for month and year display
        JPanel topPanel = new JPanel(new BorderLayout());
        monthYearLabel = new JLabel(getMonthYearText(), SwingConstants.RIGHT);
        monthYearLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(monthYearLabel, BorderLayout.EAST);

        // Add the grid panel
        JPanel gridPanel = initializeGrid();
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(gridPanel, BorderLayout.CENTER);

        // Add the back button
        JButton backButton = new JButton("Back to Main Screen");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(e -> mainApp.returnToMainScreen());
        panel.add(backButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private String getMonthYearText() {
        String monthName = new DateFormatSymbols().getMonths()[currentMonth - 1];
        return monthName + " " + currentYear;
    }

    private JPanel initializeGrid() {
        JPanel gridPanel = new JPanel(new GridLayout(6, 7, 5, 5)); // 6 rows and 7 columns

        // Calculate the first day of the month and the number of days in the month
        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 1 (Monday) to 7 (Sunday)
        int daysInMonth = firstDayOfMonth.lengthOfMonth();

        int dayCounter = 1;

        for (int i = 1; i <= 42; i++) { // 42 cells in a 6x7 grid
            JPanel clickableArea = new JPanel();
            clickableArea.setPreferredSize(new Dimension(60, 60));

            JLabel label;
            if (i >= startDayOfWeek && dayCounter <= daysInMonth) {
                label = new JLabel(String.valueOf(dayCounter));
                int day = dayCounter;
                clickableArea.setBackground(Color.LIGHT_GRAY); // Set background for valid days
                clickableArea.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        clickableArea.setBackground(Color.GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        clickableArea.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new DayDetailScreen(frame, day, currentMonth, currentYear, mainApp);
                    }
                });
                dayCounter++;
            } else {
                label = new JLabel(""); // Empty label for cells before the first day or after the last day
                clickableArea.setBackground(gridPanel.getBackground()); // Match background color for non-day cells
            }
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            clickableArea.add(label);
            gridPanel.add(clickableArea);
        }

        return gridPanel;
    }

}
