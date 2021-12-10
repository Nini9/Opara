package Controller;

import View.*;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.JLabel;

public class MainController extends SerializedDataCollection implements ActionListener {
    // Creating an instance of the login and model view classes
    LoginView loginView = new LoginView();
    ModelView modelView = new ModelView();

    // Error tracker
    private int error_tracker;

    // Class Constructor
    public MainController() {
        // Deserializing the details of faculty members
        deSerializeDetails(facultyArray, "facultyDetails");

        // Appending Action Listeners
        loginView.loginButton.addActionListener(this);
        modelView.studentModelButton.addActionListener(this);
        modelView.staffModelButton.addActionListener(this);
    }

    public void nothing() {
    }

    /**
     *
     * Action Controller for the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        error_tracker = 0;

        for (int i = 0; i < facultyArray.size(); i++) {
            // Confirming username existence using the error tracker variable
            if (!(facultyArray.get(i).getUsername().equals(loginView.usernameField.getText()))) {
                error_tracker++;
            }

            // Confirming validity of username and password using the error tracker variable
            if (facultyArray.get(i).getUsername().equals(loginView.usernameField.getText())) {
                String pwd = String.valueOf(loginView.passwordField.getPassword());
                String dbPwd = facultyArray.get(i).getPassword();
                if (!(dbPwd.equals(pwd))) {
                    error_tracker++;
                }
            }

        }

        // Login Button logic controller
        if (e.getSource() == loginView.loginButton) {
            // Validating to check for empty fields
            if (loginView.usernameField.getText().isEmpty() || loginView.passwordField.getPassword().length == 0) {
                messageLabel(loginView.messageLabel, "All fields are mandatory", Color.red, Color.white);
                itemRemover(loginView.messageLabel);
            }

            // Displaying error if username or password as mismatch
            else if (error_tracker > 0) {
                messageLabel(loginView.messageLabel, "Incorrect Details", Color.red, Color.white);
                itemRemover(loginView.messageLabel);
            }

            // Logging the user into the system
            else {
                modelView.frame.setVisible(true);
                loginView.loginPageFrame.setVisible(false);
            }
        }

        // Student Model View Button Logic controller
        else if (e.getSource() == modelView.studentModelButton) {
            modelView.frame.setVisible(false);
            StudentController studentController = new StudentController();
        }

        // Staff Model Button Logic controller
        else if (e.getSource() == modelView.staffModelButton) {
            modelView.frame.setVisible(false);
            StaffController staffController = new StaffController();
        }
    }

    // Method to remove the message label after specified time
    public void itemRemover(JLabel label) {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
            }
        }, 3000);
    }

    // Method to show either success message or error message
    public void messageLabel(JLabel label, String message, Color bgColor, Color textColor) {
        label.setText(message);
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setForeground(textColor);
        label.setVisible(true);
    }

}
