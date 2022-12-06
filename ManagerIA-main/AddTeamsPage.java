import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

public class AddTeamsPage extends JPanel {
    AddTeamsPage() {
        JLabel label = new JLabel("Add Teams Page");
        add(label);
        JTextField textField = new JTextField((10));
        add(textField);
        JButton AddTeamsPageSubmit = new JButton("Add Team");
        add(AddTeamsPageSubmit); 
        //NEW BY MAKS/COPILOT
        AddTeamsPageSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Add Teams Page Submit Button Clicked");
                TestDb db = new TestDb().connect();
                db.update("INSERT INTO teams (team_name) VALUES ('" + textField.getText() + "')");
                db.disconnect();
                textField.setText("");
                Pages.addEmployeesPage.updateTeamsComboBox();
            }
        });

        JButton DelTeamsPageSubmit = new JButton("Delete Team");
        add(DelTeamsPageSubmit);
        DelTeamsPageSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Add Teams Page Submit Button Clicked");
                TestDb db = new TestDb().connect();
                db.update("DELETE FROM teams WHERE team_name = '" + textField.getText() + "'");
                db.disconnect();
                textField.setText("");
                Pages.addEmployeesPage.updateTeamsComboBox();
            }
        });
        
    }

    
}

