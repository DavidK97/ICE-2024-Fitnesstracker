import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame {
    private JLabel welcomeToCPHFitnessTextField;
    private JButton loginButton;
    private JButton registerNewUserButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private CPHFitness cphFitness;


    public LoginPanel() {
      /*
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Program exits when closed
        setVisible(true);
        setSize(400, 300);
        setTitle("CPHFitness");
       */

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // cphFitness.userLogin();
            }
        });


        registerNewUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cphFitness.registerUser();
            }
        });


    }
}
