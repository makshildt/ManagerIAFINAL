import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.BoxLayout;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

class AddEmployeesPage extends JPanel {
    AddEmployeesPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addTextField("ID: ");
        addTextField("First Name: ");
        addTextField("Last Name: ");
        addTextField("Email: ");
        addTextField("Role: ");
        addField("Team", createTeamsComboBox());
        JButton AddEmployeesPageSubmit = new JButton("Add Employee");
        add(AddEmployeesPageSubmit);
        
    }

    private void addTextField(String name) {
        addField(name, new JTextField(10));
    }

    private void addField(String name, JComponent component) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(name));
        panel.add(component);
        add(panel);
    }

    private JComboBox createTeamsComboBox() {
        JComboBox teamComboBox = new JComboBox();
        TestDb db = new TestDb().connect();
        try {
            ResultSet resultSet = db.query("SELECT team_name FROM teams");
            while (resultSet.next()) {
                teamComboBox.addItem(resultSet.getString("team_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teamComboBox;
    }
}