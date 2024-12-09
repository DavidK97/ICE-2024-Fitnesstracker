import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private JButton addARunButton;
    private JButton viewPreviousRunsButton;
    private JButton addAGoalButton;
    private JButton trainingPlanButton;
    private JButton challengesButton;
    private JButton goalsButton;
    private JButton exitButton;
    private CPHFitness app;


    public MainMenuPanel(CPHFitness app) {
        this.app = app;


        addARunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
