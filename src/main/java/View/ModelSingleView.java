package View;

import javax.swing.*;

import java.awt.Font;

public class ModelSingleView {
    // Page button properities variable declaration
    private final int btnWidth = 100;
    private final int btnHeight = 30;
    private final int btnYAxis = 150;

    // Setting the detail of the app logo
    private ImageIcon logo = new ImageIcon("logo.png");

    // Method to set the display of button on the page
    public void buttonConfiguration(JButton previousButton, JButton nextButton, JButton deleteButton,
            JButton addNewRecordButton, JButton updateRecordButton, JButton backToDetailsButton,
            JButton createNewRecordButton, JButton createNewRecordBackButton) {
        previousButton.setBounds(10, btnYAxis, btnWidth, btnHeight);
        previousButton.setFocusable(false);
        previousButton.setEnabled(false);

        nextButton.setBounds(420, btnYAxis, btnWidth, btnHeight);
        nextButton.setFocusable(false);

        deleteButton.setBounds(10, 330, btnWidth, btnHeight);
        deleteButton.setFocusable(false);

        addNewRecordButton.setBounds(120, 330, btnWidth, btnHeight);
        addNewRecordButton.setFocusable(false);
        addNewRecordButton.setEnabled(true);

        updateRecordButton.setBounds(230, 330, btnWidth, btnHeight);
        updateRecordButton.setFocusable(false);

        backToDetailsButton.setBounds(10, 10, 150, btnHeight);
        backToDetailsButton.setFocusable(false);

        createNewRecordButton.setBounds(100, 330, 200, btnHeight);
        createNewRecordButton.setFocusable(false);

        createNewRecordBackButton.setBounds(10, 10, 150, btnHeight);
        createNewRecordBackButton.setFocusable(false);
    }

    // Method to configure all labels on the page
    public void labelConf(JLabel headingLabel, JLabel messageLabel, JLabel firstNameLabel, JLabel lastNameLabel,
            JLabel emailLabel, JLabel userIdLabel) {
        // Label Bound Setting
        headingLabel.setBounds(200, 0, 200, 50);
        messageLabel.setBounds(180, 37, 200, 30);
        firstNameLabel.setBounds(140, 70, 120, 40);
        lastNameLabel.setBounds(140, 120, 120, 40);
        emailLabel.setBounds(140, 170, 120, 40);
        userIdLabel.setBounds(140, 220, 120, 40);

        // Label Font Setting
        headingLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        firstNameLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        lastNameLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        emailLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        userIdLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));

        // Setting more properties for the message label
        messageLabel.setVisible(false);
    }

    // Method for configuring all input fields on the page
    public void textFieldConf(JTextField firstNameField, JTextField lastNameField, JTextField emailField,
            JTextField userIdField) {
        firstNameField.setBounds(250, 70, 120, 40);
        lastNameField.setBounds(250, 120, 120, 40);
        emailField.setBounds(250, 170, 120, 40);
        userIdField.setBounds(250, 220, 120, 40);
        userIdField.setEnabled(false);
    }

    // Method to append the contents of the page
    public void frameConf(JFrame frame, JButton previousButton, JButton nextButton, JButton deleteButton,
            JButton addNewRecordButton, JButton updateRecordButton, JButton backToDetailsButton, JLabel headingLabel,
            JLabel messageLabel, JLabel firstNameLabel, JLabel lastNameLabel, JLabel emailLabel, JLabel userIdLabel,
            JTextField firstNameField, JTextField lastNameField, JTextField emailField, JTextField userIdField) {
        frame.add(headingLabel);
        frame.add(previousButton);
        frame.add(nextButton);
        frame.add(deleteButton);
        frame.add(addNewRecordButton);
        frame.add(updateRecordButton);
        frame.add(backToDetailsButton);
        frame.add(messageLabel);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(emailLabel);
        frame.add(userIdLabel);
        frame.add(firstNameField);
        frame.add(lastNameField);
        frame.add(emailField);
        frame.add(userIdField);
    }

    // Method to set the page frame display properties
    public void frameDisplay(JFrame frame) {
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(logo.getImage());
        frame.setVisible(false);
    }

    // Method to confirm delete officially from the faculty
    public int deleteDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        return result;
    }

}
