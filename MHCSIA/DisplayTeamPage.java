import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.css.SimpleStyleableDoubleProperty;

import java.awt.event.*;

public class DisplayTeamPage extends JPanel {
    JComboBox teamComboBox; 
    DisplayTeamPage() {
        JLabel Title1 = new JLabel("Display Team Page");
        add(Title1);

        teamComboBox = new JComboBox();
        addField("Team", teamComboBox);
        JButton DeleteTeams = new JButton("Delete Team");
        add(DeleteTeams);
        DeleteTeams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TestDb db = new TestDb().connect();
                db.update("DELETE FROM teams WHERE team_name = '" + teamComboBox.getSelectedItem() + "'");
                db.update("DELETE FROM TEAMB WHERE team_name2 = '" + teamComboBox.getSelectedItem() + "'");
                db.disconnect();
                
                Pages.addTasksDeadlinesPage.updateTeamsComboBox();
                Pages.addEmployeesPage.updateTeamsComboBox();
                Pages.displayTeamPage.updateTeamsComboBox();
            }
        });

        JButton DisplayAllTeams = new JButton("Display All Teams");
        add(DisplayAllTeams);
        DisplayAllTeams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectAll();
            }
        });

        JButton DisplayEmployees = new JButton("Display Employees");
        add(DisplayEmployees);
        DisplayEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectEmployees();
            }
        });
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

    public void selectAll(){
        TestDb db = new TestDb().connect();
        try {
            ResultSet resultSet = db.query("SELECT * FROM teams");
            ResultSet resultSetb = db.query("SELECT * FROM teamb");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("team_id") + " " + resultSet.getString("team_name"));
            }
            while (resultSetb.next()) {
                String teamInfo = resultSetb.getString("team_id2") + " " + resultSetb.getString("team_name2") + " " + resultSetb.getString("team_task2") + " " + resultSetb.getString("team_deadline2");
                System.out.println(teamInfo);
                JLabel teamInfoLabel = new JLabel(teamInfo);
                add(teamInfoLabel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public void selectEmployees(){
        TestDb db = new TestDb().connect();
        try {
            ResultSet resultSet = db.query("SELECT * FROM users");
            while (resultSet.next()) {
                String empInfo = resultSet.getString("first_name") + "  " + resultSet.getString("last_name") + " / " + resultSet.getString("team");
                System.out.println(empInfo);
                JLabel empInfoLabel = new JLabel(empInfo);
                add(empInfoLabel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
        
}    



