package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentView {
        /***************************************
         * Variable Declaration Starts
         ****************************************/
        // Creating an instance of model list view class
        public ModelSingleView msv = new ModelSingleView();

        // Page Frame Declaration
        public JFrame pageFrame = new JFrame();

        // Page Labels Declaration
        public JLabel headingLabel = new JLabel("Student Detail");
        public JLabel messageLabel = new JLabel("", JLabel.CENTER);
        public JLabel firstNameLabel = new JLabel("First Name");
        public JLabel lastNameLabel = new JLabel("Last Name");
        public JLabel emailLabel = new JLabel("Email");
        public JLabel userIdLabel = new JLabel("User ID");

        // Page Button Declaration
        public JButton previousButton = new JButton("Previous");
        public JButton nextButton = new JButton("Next");
        public JButton deleteButton = new JButton("Delete");
        public JButton addButton = new JButton("Add New");
        public JButton updateRecordButton = new JButton("Update");
        public JButton createStudentButton = new JButton("Create New Sudent");
        public JButton backToDetailsButton = new JButton("Back to Details");
        public JButton createStudentBackButton = new JButton("Back to Details");

        // Input Fields Declaration
        public JTextField firstNameField = new JTextField();
        public JTextField lastNameField = new JTextField();
        public JTextField emailField = new JTextField();
        public JTextField userIdField = new JTextField();

        /***************************************
         * Variable Declaration Ends
         ****************************************/

        // Constructor
        public StudentView() {
                // Page Button Configuration
                msv.buttonConfiguration(previousButton, nextButton, deleteButton, addButton, updateRecordButton,
                                backToDetailsButton, createStudentButton, createStudentBackButton);

                // Page Labels Configuration
                msv.labelConf(headingLabel, messageLabel, firstNameLabel, lastNameLabel, emailLabel, userIdLabel);

                // Input Fields Configuration
                msv.textFieldConf(firstNameField, lastNameField, emailField, userIdField);

                /***************************************
                 * Frame Configuration
                 ****************************************/
                // Appending contents to the page
                msv.frameConf(pageFrame, previousButton, nextButton, deleteButton, addButton, updateRecordButton,
                                backToDetailsButton, headingLabel, messageLabel, firstNameLabel, lastNameLabel,
                                emailLabel, userIdLabel, firstNameField, lastNameField, emailField, userIdField);

                // Setting the properties of the JFrame
                pageFrame.setTitle("Students Details");
                msv.frameDisplay(pageFrame);
        }

}
