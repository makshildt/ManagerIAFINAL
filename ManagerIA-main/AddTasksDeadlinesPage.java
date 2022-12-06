import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;


class AddTasksDeadlinesPage extends JPanel {
    JComboBox teamComboBox;

    AddTasksDeadlinesPage() {
        JTextField taskTextField = addTextField("Task: ");
        JTextField deadlineTextField = addTextField("Deadline: ");
        teamComboBox = new JComboBox();
        addField("Team", teamComboBox);
        updateTeamsComboBox();

        JButton AddTasksDeadlinesPageSubmit = new JButton("Add Task & Deadline");
        add(AddTasksDeadlinesPageSubmit);
        AddTasksDeadlinesPageSubmit.addActionListener(e -> {
            TestDb db = new TestDb().connect();
            db.update("INSERT INTO teams (team_task, team_deadline, team_name) VALUES ('" + taskTextField.getText() + "', '" + deadlineTextField.getText() + "', '" + teamComboBox.getSelectedItem() + "')");
            db.disconnect();
            taskTextField.setText("");
            deadlineTextField.setText("");
            Pages.addEmployeesPage.updateTeamsComboBox();
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