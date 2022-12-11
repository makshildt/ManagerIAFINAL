import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.event.ActionEvent;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

class AddTasksDeadlinesPage extends JPanel {
    JComboBox teamComboBox;
    AddTasksDeadlinesPage() {
        
        JTextField task = addTextField("Task: ");
        JTextField deadline = addTextField("Deadline: ");
        teamComboBox = new JComboBox();
        addField("Team", teamComboBox);
        

        JButton AddTasksDeadlinesPageSubmit = new JButton("Add Task & Deadline");
        add(AddTasksDeadlinesPageSubmit);
        AddTasksDeadlinesPageSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                TestDb db = new TestDb().connect();
                db.update("INSERT INTO TEAMB (team_name2, team_task2, team_deadline2) VALUES ('" + teamComboBox.getSelectedItem() + "', '" + task.getText() + "', '" + deadline.getText() + "')");
                db.disconnect();
                task.setText("");
                deadline.setText("");
            
                Pages.addTasksDeadlinesPage.updateTeamsComboBox();
                Pages.addEmployeesPage.updateTeamsComboBox();
                Pages.displayTeamPage.updateTeamsComboBox();
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


// //update the database with the new task and deadline for the selected team 
// db.update("INSERT INTO TEAMS WHERE team_name = '" + teamComboBox.getSelectedItem() + "'");
// //(team_task, team_deadline, team_name) VALUES ('" + task.getText() + "', '" + deadline.getText() + "', '" + teamComboBox.getSelectedItem() +"')");
// db.disconnect();
// task.setText("");
// deadline.setText("");

// Pages.addTasksDeadlinesPage.updateTeamsComboBox();
// Pages.addEmployeesPage.updateTeamsComboBox();
// Pages.displayTeamPage.updateTeamsComboBox();

// System.out.println("test");