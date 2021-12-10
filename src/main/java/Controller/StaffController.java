package Controller;

import View.*;
import Model.*;

import java.awt.event.*;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class StaffController extends SerializedDataCollection implements ActionListener, MouseListener {
    /***************************************
     * Variable Declaration Begin
     ****************************************/

    // Instance of Staff and Staff-list View Class
    StaffView sv = new StaffView();
    StaffListView slv = new StaffListView();

    // ArrayList Tracker
    private int num = 0; // Tracker for the current position in the arraylist
    private int arrayLength; // Total size of the arraylist
    private int duplicate_email_checker = 0;

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    StaffController() {
        /*
         * Deserializing the staff details and filling the staff-list table with the
         * content from the arraylist
         */
        deSerializeDetails(staffArray, "staffDetails");
        populateAllView();

        /*****************************************************
         * Appending Action Listener to the Page
         ******************************************************/
        sv.previousButton.addActionListener(this);
        sv.nextButton.addActionListener(this);
        sv.deleteButton.addActionListener(this);
        sv.addButton.addActionListener(this);
        sv.updateRecordButton.addActionListener(this);
        sv.createStaffButton.addActionListener(this);
        sv.backToDetailsButton.addActionListener(this);
        sv.createStaffBackButton.addActionListener(this);
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
        arrayLength = staffArray.size();

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

                staffArray.remove(num);
                if (num != 0) {
                    num--;
                }

                serializeDetails(staffArray);
                deSerializeDetails(staffArray, "staffDetails");
                arrayLength = staffArray.size();

                if (arrayLength <= 0) {
                    slv.model.setRowCount(0);
                    populateAllView();
                    slv.staffListFrame.setVisible(true);
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
            staffArray.forEach(staff -> {
                if (staff.getEmail().equals(sv.emailField.getText())
                        & !(staff.getEmail().equals(staffArray.get(num).getEmail()))) {
                    duplicate_email_checker++;
                }
            });

            if (sv.firstNameField.getText().isEmpty() || sv.lastNameField.getText().isEmpty()
                    || sv.emailField.getText().isEmpty() || sv.userIdField.getText().isEmpty()
                    || sv.serviceYearsField.getText().isEmpty()) {
                messageLabel(sv.messageLabel, "All fields are mandatory", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }
            // Checking the email field for an @ sign
            else if (!(sv.emailField.getText().contains("@"))) {
                messageLabel(sv.messageLabel, "Email Field must contain '@'", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }
            // Validating first and last name field for alphabets only
            else if (!(sv.firstNameField.getText().matches("[a-zA-Z]+"))
                    || !(sv.lastNameField.getText().matches("[a-zA-Z]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Name fields can only contains alphabets", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }
            // Validating first and last name field for alphabets only
            else if (!(sv.serviceYearsField.getText().matches("[0-9]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Service Year Field expects a number", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking for duplicate values in the email
            else if (duplicate_email_checker > 0) {
                messageLabel(sv.messageLabel, "Email exists already", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Update the record
            else {
                staffArray.get(num).setFirstName(sv.firstNameField.getText());
                staffArray.get(num).setLastName(sv.lastNameField.getText());
                staffArray.get(num).setEmail(sv.emailField.getText());
                staffArray.get(num).setUserID(sv.userIdField.getText());
                staffArray.get(num).setNumOfYears(Integer.valueOf(sv.serviceYearsField.getText()));

                serializeDetails(staffArray);

                messageLabel(sv.messageLabel, "Record updated successfully", Color.green, Color.white);
                itemRemover(sv.messageLabel);
                printDetails();
            }

        }

        // Logic processor for add new button
        else if (e.getSource() == sv.addButton | e.getSource() == slv.addButton) {
            deSerializeUserIdTracker();

            slv.staffListFrame.setVisible(false);
            sv.pageFrame.setVisible(true);
            sv.createStaffButton.setVisible(true);
            btnToggle(false);
            sv.userIdField.setText("Stf-" + String.valueOf(userIdGenerator[1]));
            sv.pageFrame.add(sv.createStaffButton);
            sv.pageFrame.add(sv.createStaffBackButton);
        }

        // Logic processor for create new staff button
        else if (e.getSource() == sv.createStaffButton) {
            duplicate_email_checker = 0;

            // Checking for duplicate value for email address
            staffArray.forEach(staff -> {
                if (staff.getEmail().equals(sv.emailField.getText())) {
                    duplicate_email_checker++;
                }
            });

            if (sv.firstNameField.getText().isEmpty() || sv.lastNameField.getText().isEmpty()
                    || sv.emailField.getText().isEmpty() || sv.userIdField.getText().isEmpty()
                    || sv.serviceYearsField.getText().isEmpty()) {
                messageLabel(sv.messageLabel, "All fields are mandatory", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking the email field for an @ sign
            else if (!(sv.emailField.getText().contains("@"))) {
                messageLabel(sv.messageLabel, "Email Field must contain '@'", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Validating first and last name field for alphabets only
            else if (!(sv.firstNameField.getText().matches("[a-zA-Z]+"))
                    || !(sv.lastNameField.getText().matches("[a-zA-Z]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Name fields can only contains alphabets", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Validating first and last name field for alphabets only
            else if (!(sv.serviceYearsField.getText().matches("[0-9]+"))) {
                sv.messageLabel.setBounds(130, 37, 300, 30);
                messageLabel(sv.messageLabel, "Service Year Field expects a number", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            // Checking for duplicate values in the email
            else if (duplicate_email_checker > 0) {
                messageLabel(sv.messageLabel, "Email exists already", Color.red, Color.white);
                itemRemover(sv.messageLabel);
            }

            else {
                // Create a new staff
                Staff newStaff = new Staff(sv.firstNameField.getText(), sv.lastNameField.getText(),
                        sv.emailField.getText(), sv.userIdField.getText(),
                        Integer.valueOf(sv.serviceYearsField.getText()));

                // Adding the new staff to the page
                staffArray.add(newStaff);
                serializeDetails(staffArray);

                // Increasing the user id tracker and serializing
                userIdGenerator[1]++;
                serializeUserIdTracker();

                arrayLength = staffArray.size();

                // Setting the value of num(array index tracker)
                num = arrayLength - 1;

                // Toggle on all the button on the page
                btnToggle(true);

                // Making the create staff button invisible on the page
                sv.messageLabel.setVisible(false);
                sv.createStaffButton.setVisible(false);

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
            slv.staffListFrame.setVisible(true);
            sv.pageFrame.setVisible(false);
        }

        // Logic processor for welcome page
        else if (e.getSource() == slv.backToMainButton) {
            slv.staffListFrame.setVisible(false);
            MainController mc = new MainController();
            mc.loginView.loginPageFrame.setVisible(false);
            mc.modelView.frame.setVisible(true);
        }

        // Logic processor for going backwards to staff details
        else if (e.getSource() == sv.createStaffBackButton) {

            deSerializeDetails(staffArray, "staffDetails");
            arrayLength = staffArray.size();

            if (arrayLength <= 0) {
                slv.model.setRowCount(0);
                populateAllView();
                slv.staffListFrame.setVisible(true);
                sv.pageFrame.setVisible(false);
            } else {

                // Toggle on all the button on the page
                btnToggle(true);

                // Making the create staff button invisible on the page
                sv.messageLabel.setVisible(false);
                sv.createStaffButton.setVisible(false);

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
        arrayLength = staffArray.size();

        if (e.getSource() == slv.table) {
            JTable target = (JTable) e.getSource();

            slv.staffListFrame.setVisible(false);

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
        deSerializeDetails(staffArray, "staffDetails");

        // Appending the right details to the Input Fields
        sv.firstNameField.setText(staffArray.get(num).getFirstName());
        sv.lastNameField.setText(staffArray.get(num).getLastName());
        sv.emailField.setText(staffArray.get(num).getEmail());
        sv.userIdField.setText(staffArray.get(num).getUserID());
        sv.serviceYearsField.setText(String.valueOf(staffArray.get(num).getNumOfYears()));
    }

    // This method toggles off and on the button on the page when a new staff is
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
        sv.serviceYearsField.setText("");
    }

    // This method toggles off and on the button on the page based on the mouse
    // event
    public void btnMouseEvent(Boolean leftToggle, Boolean rightToggle) {
        sv.previousButton.setEnabled(leftToggle);
        sv.nextButton.setEnabled(rightToggle);
    }

     // Appends the staffArray details to the single view table
    public void populateAllView() {
        staffArray.forEach(staff -> {
            slv.model.addRow(new Object[] { staff.getFirstName(), staff.getLastName() });
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
        arrayLength = staffArray.size();

        if (arrayLength <= 1) {
            btnMouseEvent(false, false);
        }
    }

}
