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
    }

    public void inputs(JTextField textField) {
        String teamName = textField.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddTeamsPageSubmit) {
            inputs(teamName);
        }
    }

    ActionListener AddTeamsPageSubmit = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //input from textField to test.db as a new team
            JTextField input = AddTeamsPage.textField.getText();
        }
    };

    

}

