package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentListView {
    /***************************************
     * Variable Declaration Starts
     ****************************************/

    // Creating an instance of model list view class
    ModelListView mlv = new ModelListView();

    // Page Frame Declaration
    public JFrame studentListFrame = new JFrame();

    // Button Declaration
    public JButton backToMainButton = new JButton("Back to main");
    public JButton addButton = new JButton("Add New Student");
    

    // Page Title Declaration
    public JLabel headingLabel = new JLabel("Student Details");

    // Page Table Declaration
    public DefaultTableModel model = new DefaultTableModel();
    public JTable table = new JTable();

    // Constructor
    public StudentListView() {
        // Appending the table headings
        mlv.tableHeading(model, table);

        // Table Scroller
        JScrollPane jscroll = new JScrollPane(table);
        jscroll.setBounds(40, 60, 500, 350);

        // Page Button Position Function
        mlv.buttonConfiguration(backToMainButton, headingLabel, addButton);

        // Appending the contents to the page frame
        mlv.frameAdd(jscroll, studentListFrame, backToMainButton, headingLabel, addButton);

        // Setting page frame properties
        studentListFrame.setTitle("Students Details List");
        mlv.frameConf(studentListFrame);
    }
}
