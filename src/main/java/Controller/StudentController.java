package Controller;

import View.*;
import Model.*;

import java.awt.event.*;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class StudentController extends SerializedDataCollection implements ActionListener, MouseListener {
    /***************************************
     * Variable Declaration Begin
     ****************************************/

    // Instance of Staff and Staff-list View Class
    StudentView sv = new StudentView();
    StudentListView slv = new StudentListView();

    // ArrayList Tracker Start
    private int num = 0; // Tracker for the current position in the arraylist
    private int arrayLength; // Total size of the arraylist
    private int duplicate_email_checker = 0;

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    StudentController() {
        /*
         * Deserializing the students details and filling the staff-list table with the
         * content from the arraylist
         */
        deSerializeDetails(studentArray, "studentsDetails");
        deSerializeUserIdTracker();
        populateAllView();

        /*****************************************************
         * Appending Action Listener to the Page
         ******************************************************/
        sv.previousButton.addActionListener(this);
        sv.nextButton.addActionListener(this);
        sv.deleteButton.addActionListener(this);
        sv.addButton.addActionListener(this);
        sv.updateRecordButton.addActionListener(this);
        sv.createStudentButton.addActionListener(this);
        sv.createStudentBackButton.addActionListener(this);
        sv.backToDetailsButton.addActionListener(this);
        slv.table.addMouseListener(this);
        slv.backToMainButton.addActionListener(this);
        slv.addButton.addActionListener(this);
    }

    /**
     *
     * Action Controller for the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Getting and Appending the current staff details to the arrayLength variable
        arrayLength = studentArray.size();

        // Logic processor for previous navigation button
        if (e.getSource() == sv.previousButton) {
            if (num <= 0) {
                sv.previousButton.setEnabled(false);
            } else {
                sv.previousButton.setEnabled(true);
                sv.nextButton.setEnabled(true);
                num--;
                printDetails();
                if (num <= 0) {
                    sv.previousButton.setEnabled(false);
                }
            }
        }

        // Logic processor for next navigation button
        else if (e.getSource() == sv.nextButton) {
            sv.previousButton.setEnabled(true);
            if (num != arrayLength) {
                num++;
                printDetails();
                if (num == arrayLength - 1) {
                    sv.nextButton.setEnabled(false);
                }
            }
        }

        // Logic processor for Delete button
        else if (e.getSource() == sv.deleteButton) {
            int result = sv.msv.deleteDialog();
            if (result == JOptionPane.YES_OPTION) {
                studentArray.remove(num);
                if (num != 0) {
                    num--;
                }

                serializeDetails(studentArray);

                deSerializeDetails(studentArray, "studentsDetails");
                arrayLength = studentArray.size();

                if (arrayLength <= 0) {
                    slv.model.setRowCount(0);
                    populateAllView();
                    slv.studentListFrame.setVisible(true);
                    sv.pageFrame.setVisible(false);
                } else {
                    messageLabel(sv.messageLabel, "Record deleted successfully", Color.green, Color.white);
                    itemRemover(sv.messageLabel);
                    buttonToggler();
                    printDetails();
                }

            } else {
                messageLabel(sv.messageLabel, "Delete operation cancelled", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

        }

        // Logic processor for updating record button
        else if (e.getSource() == sv.updateRecordButton) {
            duplicate_email_checker = 0;

            // Checking for a dupicate value in the email field
            studentArray.forEach(student -> {
                if (student.getEmail().equals(sv.emailField.getText())
                        & !(student.getEmail().equals(studentArray.get(num).getEmail()))) {
                    duplicate_email_checker++;
                }
            });

            if (sv.firstNameField.getText().isEmpty() || sv.lastNameField.getText().isEmpty()
                    || sv.emailField.getText().isEmpty() || sv.userIdField.getText().isEmpty()) {
                messageLabel(sv.messageLabel, "All fields are mandatory", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }
            // Checking the email field for an @ sign
            else if (!(sv.emailField.getText().contains("@"))) {
                messageLabel(sv.messageLabel, "Email Field must contain '@'", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            else if (!(sv.firstNameField.getText().matches("[a-zA-Z]+"))
                    || !(sv.lastNameField.getText().matches("[a-zA-Z]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Name fields can only contains alphabets", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking for duplicate values in the email
            else if (duplicate_email_checker > 0) {
                messageLabel(sv.messageLabel, "Email exists already", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            else {
                studentArray.get(num).setFirstName(sv.firstNameField.getText());
                studentArray.get(num).setLastName(sv.lastNameField.getText());
                studentArray.get(num).setEmail(sv.emailField.getText());
                studentArray.get(num).setUserID(sv.userIdField.getText());

                serializeDetails(studentArray);

                messageLabel(sv.messageLabel, "Record updated successfully", Color.green, Color.white);
                itemRemover(sv.messageLabel);

                printDetails();
            }
        }

        // Logic processor for add new button
        else if (e.getSource() == sv.addButton | e.getSource() == slv.addButton) {
            deSerializeUserIdTracker();

            slv.studentListFrame.setVisible(false);
            sv.pageFrame.setVisible(true);
            sv.createStudentButton.setVisible(true);
            btnToggle(false);
            sv.userIdField.setText("Std-" + String.valueOf(userIdGenerator[0]));
            sv.pageFrame.add(sv.createStudentButton);
            sv.pageFrame.add(sv.createStudentBackButton);
        }

        // Logic processor for create new staff button
        else if (e.getSource() == sv.createStudentButton) {
            duplicate_email_checker = 0;

            // Checking for duplicate value for email address
            studentArray.forEach(student -> {
                if (student.getEmail().equals(sv.emailField.getText())) {
                    duplicate_email_checker++;
                }
            });

            if (sv.firstNameField.getText().isEmpty() || sv.lastNameField.getText().isEmpty()
                    || sv.emailField.getText().isEmpty() || sv.userIdField.getText().isEmpty()) {
                messageLabel(sv.messageLabel, "All fields are mandatory", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking the email field for an @ sign
            else if (!(sv.emailField.getText().contains("@"))) {
                messageLabel(sv.messageLabel, "Email Field must contain '@'", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            else if (!(sv.firstNameField.getText().matches("[a-zA-Z]+"))
                    || !(sv.lastNameField.getText().matches("[a-zA-Z]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Name fields can only contains alphabets", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking for duplicate values in the email
            else if (duplicate_email_checker > 0) {
                messageLabel(sv.messageLabel, "Email exists already", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            else {
                // Create a new student
                Student newStudent = new Student(sv.firstNameField.getText(), sv.lastNameField.getText(),
                        sv.emailField.getText(), sv.userIdField.getText(), "Freshman");

                // Adding the new student to the page
                studentArray.add(newStudent);
                serializeDetails(studentArray);

                // Increasing the user id tracker and serializing
                userIdGenerator[0]++;
                serializeUserIdTracker();

                arrayLength = studentArray.size();

                // Setting the value of num(array index tracker)
                num = arrayLength - 1;

                // Toggle on all the button on the page
                btnToggle(true);

                // Making the create student button invisible on the page
                sv.messageLabel.setVisible(false);
                sv.createStudentButton.setVisible(false);

                // Display the added result
                messageLabel(sv.messageLabel, "Record added successfully", Color.green, Color.white);
                itemRemover(sv.messageLabel);
                printDetails();

                // Disable the next button and enable the previous button
                sv.nextButton.setEnabled(false);
                sv.previousButton.setEnabled(true);
            }

        }

        // Logic processor for back to list details button
        else if (e.getSource() == sv.backToDetailsButton) {
            slv.model.setRowCount(0);
            populateAllView();
            slv.studentListFrame.setVisible(true);
            sv.pageFrame.setVisible(false);
        }

        // Logic processor for welcome page
        else if (e.getSource() == slv.backToMainButton) {
            slv.studentListFrame.setVisible(false);
            MainController mc = new MainController();
            mc.loginView.loginPageFrame.setVisible(false);
            mc.modelView.frame.setVisible(true);
        }

        // Logic processor for going backwards to staff details
        else if (e.getSource() == sv.createStudentBackButton) {

            deSerializeDetails(studentArray, "studentsDetails");
            arrayLength = studentArray.size();

            if (arrayLength <= 0) {
                slv.model.setRowCount(0);
                populateAllView();
                slv.studentListFrame.setVisible(true);
                sv.pageFrame.setVisible(false);
            } else {
                // Toggle on all the button on the page
                btnToggle(true);

                // Making the create student button invisible on the page
                sv.messageLabel.setVisible(false);
                sv.createStudentButton.setVisible(false);

                // Display the added result
                printDetails();
            }

        }

    }

    /**
     *
     * Mouse-event interface override
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        arrayLength = studentArray.size();

        if (e.getSource() == slv.table) {
            JTable target = (JTable) e.getSource();

            slv.studentListFrame.setVisible(false);

            num = target.getSelectedRow(); // select a row

            printDetails();
            sv.pageFrame.setVisible(true);

            // Navigation button toggler
            if ((arrayLength - 1) == num) {
                btnMouseEvent(true, false);
            } else if (num == 0) {
                btnMouseEvent(false, true);
            } else if (num > 0) {
                btnMouseEvent(true, true);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }


    /**
     *
     * USER DEFINED METHODS FOR APP FUNCTIONALITY
     */

    // This method calls and append the present details that will be sent to the
    // single view class
    public void printDetails() {
        // Deserializing the staff details
        deSerializeDetails(studentArray, "studentsDetails");

        // Appending the right details to the Input Fields
        sv.firstNameField.setText(studentArray.get(num).getFirstName());
        sv.lastNameField.setText(studentArray.get(num).getLastName());
        sv.emailField.setText(studentArray.get(num).getEmail());
        sv.userIdField.setText(studentArray.get(num).getUserID());
    }

    // This method toggles off and on the button on the page when a new student is
    // to be added
    public void btnToggle(Boolean toggle) {
        sv.previousButton.setVisible(toggle);
        sv.nextButton.setVisible(toggle);
        sv.deleteButton.setVisible(toggle);
        sv.updateRecordButton.setVisible(toggle);
        sv.addButton.setVisible(toggle);
        sv.deleteButton.setVisible(toggle);
        sv.backToDetailsButton.setVisible(toggle);
        sv.firstNameField.setText("");
        sv.lastNameField.setText("");
        sv.emailField.setText("");
        sv.userIdField.setText("");
    }

    // This method toggles off and on the button on the page based on the mouse
    // event
    public void btnMouseEvent(Boolean leftToggle, Boolean rightToggle) {
        sv.previousButton.setEnabled(leftToggle);
        sv.nextButton.setEnabled(rightToggle);
    }

    // Appends the studentArray details to the single view table
    public void populateAllView() {
        studentArray.forEach(student -> {
            slv.model.addRow(new Object[] { student.getFirstName(), student.getLastName() });
        });
    }

    // Method to remove user message(error or success) after an action has been triggered
    public void itemRemover(JLabel label) {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
            }
        }, 3000);
    }

    // Method to show message to the user (success or error) after an action has been triggered
    public void messageLabel(JLabel label, String message, Color bgColor, Color textColor) {
        label.setText(message);
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setForeground(textColor);
        label.setVisible(true);
    }

    // Method to control the toggling on and off of the previous and next buttons
    public void buttonToggler() {
        arrayLength = studentArray.size();

        if (arrayLength <= 1) {
            btnMouseEvent(false, false);
        }
    }

}
