import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class StudentView {
    /***************************************
     * Variable Declaration Starts
     ****************************************/
    // JButton Size Declaration Starts
    private int btnWidth = 100;
    private int btnHeight = 30;
    private int btnYAxis = 150;
    // JButton Size Ends

    // JFrame Declaration Starts
    JFrame frame = new JFrame();
    // JFrame Declaration Ends

    // JLabel Declaration Starts
    JLabel headingLabel = new JLabel("Student Details");
    JLabel errorLabel = new JLabel("All fields are mandatory");
    JLabel label1 = new JLabel("First Name");
    JLabel label2 = new JLabel("Last Name");
    JLabel label3 = new JLabel("Email");
    JLabel label4 = new JLabel("User ID");
    // JLabel Declaration Ends

    // JButton Declaration Starts
    JButton lButton = new JButton("Previous");
    JButton rButton = new JButton("Next");
    JButton delButton = new JButton("Delete");
    JButton addButton = new JButton("Add New");
    JButton updateButton = new JButton("Update");
    JButton createStudentButton = new JButton("Create New Sudent");
    // JButton Declaration Ends

    // JTextField Declaration Starts
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text4 = new JTextField();

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    StudentView() {
        /***************************************
         * Button Configuration Starts
         ****************************************/
        lButton.setBounds(10, btnYAxis, btnWidth, btnHeight);
        lButton.setFocusable(false);
        lButton.setEnabled(false);

        rButton.setBounds(420, btnYAxis, btnWidth, btnHeight);
        rButton.setFocusable(false);

        delButton.setBounds(10, 300, btnWidth, btnHeight);
        delButton.setFocusable(false);

        addButton.setBounds(120, 300, btnWidth, btnHeight);
        addButton.setFocusable(false);
        addButton.setEnabled(true);

        updateButton.setBounds(230, 300, btnWidth, btnHeight);
        updateButton.setFocusable(false);

        createStudentButton.setBounds(100, 300, 200, btnHeight);
        createStudentButton.setFocusable(false);

        /***************************************
         * Button Configuration End
         ****************************************/

        /***************************************
         * Label Configuration Start
         ****************************************/
        // Label Bound Setting
        headingLabel.setBounds(200, 6, 200, 50);
        errorLabel.setBounds(230, 35, 200, 50);
        label1.setBounds(140, 70, 120, 40);
        label2.setBounds(140, 120, 120, 40);
        label3.setBounds(140, 170, 120, 40);
        label4.setBounds(140, 220, 120, 40);

        // Label Font Setting
        headingLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        label1.setFont(new Font("Comic Sans", Font.BOLD, 15));
        label2.setFont(new Font("Comic Sans", Font.BOLD, 15));
        label3.setFont(new Font("Comic Sans", Font.BOLD, 15));
        label4.setFont(new Font("Comic Sans", Font.BOLD, 15));

        // Setting more properties for the error message label
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);

        /***************************************
         * Label Configuration Ends
         ****************************************/

        /***************************************
         * JTextField Configuration Start
         ****************************************/
        text1.setBounds(250, 70, 120, 40);
        text2.setBounds(250, 120, 120, 40);
        text3.setBounds(250, 170, 120, 40);
        text4.setBounds(250, 220, 120, 40);
        /***************************************
         * JTextField Configuration Ends
         ****************************************/

        /***************************************
         * Frame Configuration Start
         ****************************************/
        // Frame Properities Added
        frame.add(headingLabel);
        frame.add(lButton);
        frame.add(rButton);
        frame.add(delButton);
        frame.add(addButton);
        frame.add(updateButton);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(text4);
        frame.add(errorLabel);

        // Setting the properties of the JFrame
        frame.setTitle("Opara Assignment File");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setVisible(true);
        /***************************************
         * Frame Configuration Ends
         ****************************************/
    }

}
