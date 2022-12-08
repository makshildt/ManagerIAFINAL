import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
                System.out.println("Delete Teams Button Clicked");
                TestDb db = new TestDb().connect();
                db.update("DELETE FROM teams WHERE team_name = '" + teamComboBox.getSelectedItem() + "'");
                db.disconnect();
                Pages.addEmployeesPage.updateTeamsComboBox();
                Pages.displayTeamPage.updateTeamsComboBox();
            }
        });
        
        JLabel currentTeams = new JLabel();
        TestDb db = new TestDb().connect();
        try {
            ResultSet resultSet = db.query("SELECT team_name FROM teams");
            while (resultSet.next()) {
                currentTeams.setText(resultSet.getString("team_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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