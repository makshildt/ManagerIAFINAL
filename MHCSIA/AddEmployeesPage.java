import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.BoxLayout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class AddEmployeesPage extends JPanel {
    JComboBox teamComboBox;

    AddEmployeesPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //JTextField id = new JTextField(10);
        JTextField firstName = addTextField("First Name: ");
        JTextField lastName = addTextField("Last Name: ");
        JTextField dob = addTextField("Year of Birth: ");
        JTextField email = addTextField("Email: ");
        JTextField role = addTextField("Role: ");
        teamComboBox = new JComboBox();
        addField("Team", teamComboBox);

        // JTextField id = addTextField("ID: ");
        // addTextField("First Name: ");
        // addTextField("Last Name: ");
        // addTextField("Email: ");
        // addTextField("Role: ");
        // addField("Team", createTeamsComboBox());

        JButton AddEmployeesPageSubmit = new JButton("Add Employee");
        add(AddEmployeesPageSubmit);

        AddEmployeesPageSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TestDb db = new TestDb().connect();
                db.update("INSERT INTO users (first_name, last_name, dob, email, role, team) VALUES ('" + firstName.getText() + "', '" + lastName.getText() + "', '" + dob.getText() + "', '" + email.getText() + "', '" + role.getText() +  "', '" + teamComboBox.getSelectedItem() +"')");
                db.disconnect();
                firstName.setText("");
                lastName.setText("");
                dob.setText("");
                email.setText("");
                role.setText("");
            }
        });
    }

    private JTextField addTextField(String name) {
        JTextField textField = new JTextField(10);
        addField(name, textField);
        return textField;
    }

    private void addField(String name, JComponent component) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(name));
        panel.add(component);
        add(panel);
    }

    void updateTeamsComboBox() {
        teamComboBox.removeAllItems();
        TestDb db = new TestDb().connect();
        try {
            ResultSet resultSet = db.query("SELECT team_name FROM teams");
            while (resultSet.next()) {
                teamComboBox.addItem(resultSet.getString("team_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}