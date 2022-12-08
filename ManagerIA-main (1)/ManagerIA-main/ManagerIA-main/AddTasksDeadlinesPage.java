import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

class AddTasksDeadlinesPage extends JPanel {
    AddTasksDeadlinesPage() {
        addField("Task: ");
        addField("Deadline: ");
        addField("For Team: ");
        JButton AddTasksDeadlinesPageSubmit = new JButton("Add Task & Deadline");
        add(AddTasksDeadlinesPageSubmit);
    }

    private void addField(String name) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(name));
        panel.add(new JTextField(10));
        add(panel);
    }
}