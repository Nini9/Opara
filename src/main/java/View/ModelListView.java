package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class ModelListView {
    // Setting the app logo
    private ImageIcon logo = new ImageIcon("logo.png");

    // Method to set the display of button on the page
    public void buttonConfiguration(JButton backToMain, JLabel headingLabel, JButton addNewRecordButton) {
        backToMain.setBounds(10, 10, 120, 30);
        backToMain.setFocusable(false);

        headingLabel.setBounds(200, 10, 300, 30);
        headingLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));

        addNewRecordButton.setBounds(40, 415, 200, 30);
        addNewRecordButton.setFocusable(false);
    }

    // Method to append page content to the page frame
    public void frameAdd(JScrollPane scrollBar, JFrame frame, JButton backToMain, JLabel headingLabel,
            JButton addNewButton) {
        frame.add(scrollBar);
        frame.add(backToMain);
        frame.add(headingLabel);
        frame.add(addNewButton);
    }

    // Method to configure the page frame
    public void frameConf(JFrame frame) {
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(logo.getImage());
        frame.setVisible(true);
    }

    // Method to set the details of the details table
    public void tableHeading(DefaultTableModel model, JTable table) {
        String[] columnNames = { "First Name", "Last Name" };
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.getTableHeader().setEnabled(false);
    }

}
