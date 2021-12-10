package View;

import javax.swing.*;

import java.awt.Font;

public class ModelView {
    /***************************************
     * Variable Declaration Starts
     ****************************************/
    // JFrame Declaration Starts
    public JFrame frame = new JFrame();
    // JFrame Declaration Ends

    // JLabel Declaration Starts
    public JLabel headingLabel = new JLabel("WELCOME");
    public JLabel instruction = new JLabel("What do you want to check today?");
    // JLabel Declaration Ends

    // JButton Declaration Starts
    public JButton studentModelButton = new JButton("Student Details");
    public JButton staffModelButton = new JButton("Staff Details");
    // JButton Declaration Ends

    // ImageIcon for Logo Declaration
    ImageIcon logo = new ImageIcon("logo.png");
    JLabel iconLabel = new JLabel();

    /***************************************
     * Variable Declaration Ends
     ****************************************/

    // Constructor
    public ModelView() {
        /***************************************
         * Button Configuration Starts
         ****************************************/
        studentModelButton.setBounds(60, 150, 250, 50);
        studentModelButton.setFocusable(false);

        staffModelButton.setBounds(60, 220, 250, 50);
        staffModelButton.setFocusable(false);

        /***************************************
         * Logo Image Configuration Starts
         ****************************************/
        iconLabel.setIcon(logo);
        iconLabel.setBounds(150, 10, 50, 50);

        /***************************************
         * Label Configuration Start
         ****************************************/
        // Label Bound Setting
        headingLabel.setBounds(120, 56, 200, 50);
        instruction.setBounds(80, 86, 230, 50);

        // Label Font Setting
        headingLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));

        /***************************************
         * Frame Configuration Start
         ****************************************/
        // Frame Properities Added
        frame.add(headingLabel);
        frame.add(instruction);
        frame.add(studentModelButton);
        frame.add(staffModelButton);
        frame.add(iconLabel);

        // Setting the properties of the JFrame
        frame.setTitle("Welcome Page");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(logo.getImage());
        frame.setVisible(false);
        /***************************************
         * Frame Configuration Ends
         ****************************************/
    }

}
