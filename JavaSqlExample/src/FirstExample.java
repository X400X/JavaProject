import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FirstExample {
    private static final String URL = "jdbc:mysql://localhost:3306/employees_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0410";

    private JFrame frame;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FirstExample().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Employee App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLayout(null);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the "File" menu
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // Add an action listener for the "Exit" menu item
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });

        // Create the "Settings" menu
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem preferencesItem = new JMenuItem("Preferences");

        // Add menu items to the "Settings" menu
        settingsMenu.add(preferencesItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);

        // Add the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Create a label for "First Name"
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 10, 80, 25);
        frame.add(firstNameLabel);

        // Create the text field for "First Name"
        firstNameField = new JTextField();
        firstNameField.setBounds(100, 10, 160, 25);
        frame.add(firstNameField);

        // Create a label for "Last Name"
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 40, 80, 25);
        frame.add(lastNameLabel);

        // Create the text field for "Last Name"
        lastNameField = new JTextField();
        lastNameField.setBounds(100, 40, 160, 25);
        frame.add(lastNameField);

        // Create the "Add Employee" button
        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(10, 80, 250, 25);
        frame.add(addButton);

        // Add an action listener to the "Add Employee" button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                addEmployee(firstName, lastName);
            }
        });

        // Create the "Show Employees" button
        JButton showButton = new JButton("Show All Employees");
        showButton.setBounds(10, 120, 250, 25);
        frame.add(showButton);

        // Add an action listener to the "Show Employees" button
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllEmployees();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    private void addEmployee(String firstName, String lastName) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO employees (first_name, last_name1) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error adding employee.");
        }
    }

    private void showAllEmployees() {
        JFrame tableFrame = new JFrame("All Employees");
        tableFrame.setSize(800, 400);

        // Fetch employee data from the database
        String[] columnNames = {"Employee ID", "First Name", "Last Name"};
        Object[][] data = fetchEmployeeData();

        // Create JTable with fetched data
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        tableFrame.add(scrollPane);

        // Set the frame visible
        tableFrame.setVisible(true);
    }

    private Object[][] fetchEmployeeData() {
        String sql = "SELECT id, first_name, last_name1 FROM employees";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             // Create a PreparedStatement with a scrollable ResultSet
             PreparedStatement preparedStatement = connection.prepareStatement(
                 sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Move to the last row to get the row count
            resultSet.last();
            int rowCount = resultSet.getRow();
            // Move back to before the first row
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][3];
            int row = 0;

            // Iterate through the ResultSet
            while (resultSet.next()) {
                data[row][0] = resultSet.getInt("id");
                data[row][1] = resultSet.getString("first_name");
                data[row][2] = resultSet.getString("last_name1");
                row++;
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error retrieving employee data.");
            return new Object[0][0];
        }
    }

}
