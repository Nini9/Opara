import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController extends StudentDetails implements ActionListener {
    /***************************************
     * Variable Declaration Begin
     ****************************************/
    StudentView sv = new StudentView();

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
         * Calling the test method from the StudentDetails Class in order to add the
         * create students instance to the student arraylist
         * 
         * Calling the printDetails when the program gets instantiated
         */
        test();
        printDetails();
        // Calls to test and printdetails method ends

        /*****************************************************
         * Action Listener Addition to the Buttons Starts
         ******************************************************/
        sv.lButton.addActionListener(this);
        sv.rButton.addActionListener(this);
        sv.delButton.addActionListener(this);
        sv.addButton.addActionListener(this);
        sv.updateButton.addActionListener(this);
        sv.createStudentButton.addActionListener(this);
        /*****************************************************
         * Action Listener Addition to the Buttons Ends
         ******************************************************/
    }

    // This method calls and append the present details that will be sent to the
    // view
    public void printDetails() {
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
        sv.text1.setText("");
        sv.text2.setText("");
        sv.text3.setText("");
        sv.text4.setText("");
    }

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
            printDetails();
        }

        else if (e.getSource() == sv.updateButton) {
            studentArray.get(num).setFirstName(sv.text1.getText());
            studentArray.get(num).setLastName(sv.text2.getText());
            studentArray.get(num).setEmail(sv.text3.getText());
            studentArray.get(num).setUserID(sv.text4.getText());

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
    }
}
