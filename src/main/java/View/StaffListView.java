package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StaffListView {
    /***************************************
     * Variable Declaration Starts
     ****************************************/

    // Creating an instance of model list view class
    ModelListView mlv = new ModelListView();

    // Page Frame Declaration
    public JFrame staffListFrame = new JFrame();

    // Button Declaration
    public JButton backToMainButton = new JButton("Back to main");
    public JButton addButton = new JButton("Add New Staff");

    // Page Title Declaration
    public JLabel headingLabel = new JLabel("Staff Details");

    // Page Table Declaration
    public JTable table = new JTable();
    public DefaultTableModel model = new DefaultTableModel();

    // Constructor
    public StaffListView() {
        // Appending the table headings
        mlv.tableHeading(model, table);

        // Table Scroller
        JScrollPane jscroll = new JScrollPane(table);
        jscroll.setBounds(40, 60, 500, 350);

        // Page Button Position Function
        mlv.buttonConfiguration(backToMainButton, headingLabel, addButton);

        // Appending the contents to the page frame
        mlv.frameAdd(jscroll, staffListFrame, backToMainButton, headingLabel, addButton);

        // Setting page frame properties
        staffListFrame.setTitle("Staffs Details List");
        mlv.frameConf(staffListFrame);

    }
}
