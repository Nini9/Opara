import java.awt.event.*;
import javax.swing.JTable;

public final class StudentController extends SerializedDataCollection implements ActionListener, MouseListener {
    /***************************************
     * Variable Declaration Begin
     ****************************************/
    // StudentView sv = new StudentView();
    StudentView sv = new StudentView();
    StudentListView slv = new StudentListView();

    // ArrayList Tracker Start
    private int num = 0; // Tracker for the current position in the arraylist
    private int arrayLength; // Total size of the arraylist
    // ArrayList Tracker Ends

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    StudentController() {
        /*
         * LIST-VIEW DESIGN SYSTEM filling the list table with the content from the
         * arraylist
         */
        deSerialize();
        populateAllView();

        /*****************************************************
         * Action Listener Addition to the Buttons Starts
         ******************************************************/
        sv.lButton.addActionListener(this);
        sv.rButton.addActionListener(this);
        sv.delButton.addActionListener(this);
        sv.addButton.addActionListener(this);
        sv.updateButton.addActionListener(this);
        sv.createStudentButton.addActionListener(this);
        sv.backButton.addActionListener(this);
        slv.table.addMouseListener(this);
        /*****************************************************
         * Action Listener Addition to the Buttons Ends
         ******************************************************/
    }

    // This method calls and append the present details that will be sent to the
    // single view class
    public void printDetails() {
        deSerialize();

        sv.text1.setText(studentArray.get(num).getFirstName());
        sv.text2.setText(studentArray.get(num).getLastName());
        sv.text3.setText(studentArray.get(num).getEmail());
        sv.text4.setText(studentArray.get(num).getUserID());
    }

    // This method toggles off and on the button on the page when a new student is
    // to be added
    public void btnToggle(Boolean toggle) {
        sv.lButton.setVisible(toggle);
        sv.rButton.setVisible(toggle);
        sv.delButton.setVisible(toggle);
        sv.updateButton.setVisible(toggle);
        sv.addButton.setVisible(toggle);
        sv.delButton.setVisible(toggle);
        sv.backButton.setVisible(toggle);
        sv.text1.setText("");
        sv.text2.setText("");
        sv.text3.setText("");
        sv.text4.setText("");
    }

    // This method toggles off and on the button on the page based on the mouse
    // event
    public void btnMouseEvent(Boolean leftToggle, Boolean rightToggle) {
        sv.lButton.setEnabled(leftToggle);
        sv.rButton.setEnabled(rightToggle);
    }

    /**
     *
     * Action Controller for the page
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        arrayLength = studentArray.size();

        if (e.getSource() == sv.lButton) {
            if (num <= 0) {
                sv.lButton.setEnabled(false);
            } else {
                sv.lButton.setEnabled(true);
                sv.rButton.setEnabled(true);
                num--;
                printDetails();
                if (num <= 0) {
                    sv.lButton.setEnabled(false);
                }
            }
        }

        else if (e.getSource() == sv.rButton) {
            sv.lButton.setEnabled(true);
            if (num != arrayLength) {
                num++;
                printDetails();
                if (num == arrayLength - 1) {
                    sv.rButton.setEnabled(false);
                }
            }
        }

        else if (e.getSource() == sv.delButton) {
            studentArray.remove(num);
            if (num != 0) {
                num--;
            }

            serialize();
            printDetails();
        }

        else if (e.getSource() == sv.updateButton) {
            studentArray.get(num).setFirstName(sv.text1.getText());
            studentArray.get(num).setLastName(sv.text2.getText());
            studentArray.get(num).setEmail(sv.text3.getText());
            studentArray.get(num).setUserID(sv.text4.getText());

            serialize();

            printDetails();
        }

        else if (e.getSource() == sv.addButton) {
            sv.createStudentButton.setVisible(true);
            btnToggle(false);
            sv.frame.add(sv.createStudentButton);
        }

        else if (e.getSource() == sv.createStudentButton) {
            if (sv.text1.getText().isEmpty() || sv.text2.getText().isEmpty() || sv.text3.getText().isEmpty()
                    || sv.text4.getText().isEmpty()) {
                sv.errorLabel.setVisible(true);
            } else {
                // Create a new student
                Student newStudent = new Student(sv.text1.getText(), sv.text2.getText(), sv.text3.getText(),
                        sv.text4.getText(), "Freshman");

                // Adding the new student to the page
                studentArray.add(newStudent);
                serialize();

                arrayLength = studentArray.size();

                // Setting the value of num(array index tracker)
                num = arrayLength - 1;

                // Toggle on all the button on the page
                btnToggle(true);

                // Making the create student button invisible on the page
                sv.errorLabel.setVisible(false);
                sv.createStudentButton.setVisible(false);

                // Display the added result
                printDetails();

                // Disable the next button and enable the previous button
                sv.rButton.setEnabled(false);
                sv.lButton.setEnabled(true);
            }

        }

        else if (e.getSource() == sv.backButton) {
            slv.model.setRowCount(0);
            populateAllView();
            slv.frame.setVisible(true);
            sv.frame.setVisible(false);
        }
    }

    // Appends the studentArray details to the single view table
    public void populateAllView() {
        studentArray.forEach(student -> {
            slv.model.addRow(new Object[] { student.getFirstName(), student.getLastName(), student.getEmail(),
                student.getUserID() });
        });
    }

    // mouse-event interface override
    @Override
    public void mouseClicked(MouseEvent e) {
        arrayLength = studentArray.size();

        if (e.getSource() == slv.table) {
            JTable target = (JTable) e.getSource();

            slv.frame.setVisible(false);

            num = target.getSelectedRow(); // select a row

            printDetails();
            sv.frame.setVisible(true);

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

}
