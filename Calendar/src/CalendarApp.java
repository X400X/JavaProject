import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarApp {

    private JFrame frame;
    private JPanel panel;
    private JLabel yearLabel;
    private int currentYear;
    private JPanel gridPanel;

    public CalendarApp() {
        frame = new JFrame("Calendar Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        // Set up the menu bar
        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);

        // Initialize the panel with a BorderLayout and add padding
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add 10px padding around the panel

        currentYear = getCurrentYear();

        gridPanel = initializeGrid();
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField dateTimeField = new JTextField(getCurrentDateTime());
        dateTimeField.setEditable(false);
        dateTimeField.setHorizontalAlignment(JTextField.CENTER);
        dateTimeField.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel topPanel = new JPanel(new BorderLayout());
        yearLabel = new JLabel(String.valueOf(currentYear), SwingConstants.RIGHT);
        yearLabel.setFont(new Font("Arial", Font.BOLD, 24));

        topPanel.add(dateTimeField, BorderLayout.CENTER);
        topPanel.add(yearLabel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton leftYearButton = new JButton("Previous Year");
        JButton rightYearButton = new JButton("Next Year");

        buttonPanel.add(leftYearButton);
        buttonPanel.add(rightYearButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(gridPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        leftYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateYear(-1);
            }
        });

        rightYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateYear(1);
            }
        });
    }

    private JPanel initializeGrid() {
        JPanel gridPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        for (int i = 1; i <= 12; i++) {
            JPanel clickableArea = createClickableArea(i);
            gridPanel.add(clickableArea);
        }
        return gridPanel;
    }

    private JPanel createClickableArea(int month) {
        JPanel clickableArea = new JPanel();
        clickableArea.setPreferredSize(new Dimension(100, 100));
        clickableArea.setBackground(Color.LIGHT_GRAY);

        // Display the calendar for the specific month in the current year
        String calendarText = generateMonthCalendar(month, currentYear);
        JLabel label = new JLabel("<html>" + calendarText.replace("\n", "<br>") + "</html>");
        label.setFont(new Font("Monospaced", Font.PLAIN, 14));
        clickableArea.add(label);

        // Store the month as a client property
        clickableArea.putClientProperty("month", month);

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
                new DetailScreen(frame, "Area " + month + " - " + currentYear, CalendarApp.this);
            }
        });

        return clickableArea;
    }

    public void returnToMainScreen() {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy - HH:mm:ss");
        return sdf.format(new Date());
    }

    private int getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return Integer.parseInt(sdf.format(new Date()));
    }

    private void updateYear(int change) {
        currentYear += change;
        yearLabel.setText(String.valueOf(currentYear));

        // Update all areas with the new year
        for (Component component : gridPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel clickableArea = (JPanel) component;
                int month = (int) clickableArea.getClientProperty("month");
                String calendarText = generateMonthCalendar(month, currentYear);
                for (Component subComponent : clickableArea.getComponents()) {
                    if (subComponent instanceof JLabel) {
                        JLabel label = (JLabel) subComponent;
                        label.setText("<html>" + calendarText.replace("\n", "<br>") + "</html>");
                    }
                }
            }
        }
    }

    public static String generateMonthCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        String monthName = new DateFormatSymbols().getMonths()[month - 1];
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        if (startDay == Calendar.SUNDAY) {
            startDay = 7;
        } else {
            startDay -= 1;
        }

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><div style='padding: 10px;'>");
        sb.append("<b>").append(monthName).append(" ").append(year).append("</b><br>");
        sb.append("Mo Tu We Th Fr Sa Su<br>");

        for (int i = 1; i < startDay; i++) {
            sb.append("&nbsp;&nbsp;");
            sb.append("&nbsp;");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            if (day < 10) {
            	sb.append("&nbsp;");
            }
            	sb.append(String.valueOf(day));
            	sb.append("&nbsp;");
            if ((day + startDay - 1) % 7 == 0) {
                sb.append("<br>");
            }
        }

        sb.append("</div></html>");

        return sb.toString();
    }
        
        private JMenuBar createMenuBar() {
            JMenuBar menuBar = new JMenuBar();

            // Group Menu
            JMenu groupMenu = new JMenu("Groups");

            JMenuItem viewGroups = new JMenuItem("View All Groups");
            JMenuItem addGroup = new JMenuItem("Add New Group");
            JMenuItem deleteGroup = new JMenuItem("Delete Group");

            groupMenu.add(viewGroups);
            groupMenu.add(addGroup);
            groupMenu.add(deleteGroup);

            // Users Menu
            JMenu userMenu = new JMenu("Users");

            JMenuItem viewUsers = new JMenuItem("View All Users");
            JMenuItem addUser = new JMenuItem("Add New User");
            JMenuItem deleteUser = new JMenuItem("Delete User");

            userMenu.add(viewUsers);
            userMenu.add(addUser);
            userMenu.add(deleteUser);

            // Records Menu
            JMenu recordMenu = new JMenu("Records");

            JMenuItem viewRecords = new JMenuItem("View All Records");
            JMenuItem addRecord = new JMenuItem("Add New Record");
            JMenuItem deleteRecord = new JMenuItem("Delete Record");

            recordMenu.add(viewRecords);
            recordMenu.add(addRecord);
            recordMenu.add(deleteRecord);

            // Add menus to the menu bar
            menuBar.add(groupMenu);
            menuBar.add(userMenu);
            menuBar.add(recordMenu);

            // Attach action listeners (Example: Showing dialogs)
            viewGroups.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View All Groups"));
            addGroup.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Add New Group"));
            deleteGroup.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Delete Group"));

            viewUsers.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View All Users"));
            addUser.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Add New User"));
            deleteUser.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Delete User"));

            viewRecords.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View All Records"));
            addRecord.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Add New Record"));
            deleteRecord.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Delete Record"));

            return menuBar;
        }
        
        public static void main(String[] args) {
            System.out.println(generateMonthCalendar(3, 2024));
            SwingUtilities.invokeLater(() -> new CalendarApp());
        }
}


