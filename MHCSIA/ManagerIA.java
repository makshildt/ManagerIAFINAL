import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManagerIA {
    public static void main(String[] args) {
        new ManagerIA();
    }

    JFrame mainFrame;
    JTabbedPane tabbedPane;
    JPanel page1;

    ManagerIA() {
        mainFrame = new JFrame();
        mainFrame.setSize(1000, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        tabbedPane = new JTabbedPane();
        mainFrame.add(tabbedPane);

        page1 = new JPanel();

        Pages.displayTeamPage = new DisplayTeamPage();
        tabbedPane.addTab("Teams", Pages.displayTeamPage);

        tabbedPane.addTab("Add Teams", new AddTeamsPage());

        Pages.addEmployeesPage = new AddEmployeesPage();
        tabbedPane.addTab("Add Employees", Pages.addEmployeesPage);

        Pages.addTasksDeadlinesPage = new AddTasksDeadlinesPage();
        tabbedPane.addTab("Add Tasks & Deadlines", Pages.addTasksDeadlinesPage);

        tabbedPane.addTab("Visual Representation", new VisualRepresentation());
    }

    
}