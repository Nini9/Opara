package View;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class LoginView {
    /***************************************
     * Variable Declaration Starts
     ****************************************/
    // Login Frame Declaration
    public JFrame loginPageFrame = new JFrame();

    // Page Heading and Field Label Declaration
    public JLabel headingLabel = new JLabel("LOGIN PAGE");
    public JLabel messageLabel = new JLabel("", JLabel.CENTER);
    public JLabel usernameLabel = new JLabel("Username");
    public JLabel passwordLabel = new JLabel("Password");

    // Login Button Declaration
    public JButton loginButton = new JButton("Login");

    // Username and password fields Declaration
    public JTextField usernameField = new JTextField();
    public JPasswordField passwordField = new JPasswordField();

    // App Logo Declaration
    ImageIcon logo = new ImageIcon("logo.png");
    JLabel iconLabel = new JLabel();

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    public LoginView() {
        /***************************************
         * Login Button Configuration
         ****************************************/
        loginButton.setBounds(40, 230, 250, 30);
        loginButton.setFocusable(false);

        /***************************************
         * App Logo Configuration
         ****************************************/
        iconLabel.setIcon(logo);
        iconLabel.setBounds(150, 10, 50, 50);

        /***************************************
         * Page Heading and Field Label Configuration
         ****************************************/
        // Label Bound Setting
        headingLabel.setBounds(100, 46, 200, 50);
        messageLabel.setBounds(80, 85, 200, 30);
        usernameLabel.setBounds(40, 120, 120, 40);
        passwordLabel.setBounds(40, 170, 120, 40);

        // Label Font Setting
        headingLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        usernameLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        passwordLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));

        // Setting more properties for the message label
        messageLabel.setForeground(Color.red);
        messageLabel.setVisible(false);

        /***********************************************
         * Username and password fields Configuration
         ***********************************************/
        usernameField.setBounds(150, 120, 120, 40);
        passwordField.setBounds(150, 170, 120, 40);

        /***************************************
         * Login Frame Configuration
         ****************************************/
        // Login Frame Contents Added
        loginPageFrame.add(headingLabel);
        loginPageFrame.add(usernameLabel);
        loginPageFrame.add(passwordLabel);
        loginPageFrame.add(usernameField);
        loginPageFrame.add(passwordField);
        loginPageFrame.add(loginButton);
        loginPageFrame.add(messageLabel);
        loginPageFrame.add(iconLabel);

        // Setting the properties of the login frame
        loginPageFrame.setTitle("Opara Login Page");
        loginPageFrame.setLayout(null);
        loginPageFrame.setResizable(false);
        loginPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPageFrame.setSize(400, 350);
        loginPageFrame.setLocationRelativeTo(null);
        loginPageFrame.setIconImage(logo.getImage());
        loginPageFrame.setVisible(true);
    }

}
