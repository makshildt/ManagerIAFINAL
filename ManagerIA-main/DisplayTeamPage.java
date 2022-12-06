import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayTeamPage extends JPanel {
    DisplayTeamPage() {
        JLabel Title1 = new JLabel("Display Team Page");
        add(Title1);
        // JLabel CurrentTeams = new JLabel("| Current Teams: ");
        // add(CurrentTeams);
        
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
}