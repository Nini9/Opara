import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentListView {
    JFrame frame = new JFrame();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();

    // Constructor
    StudentListView() {
        String[] columnNames = { "First Name", "Last Name", "Email", "User ID" };
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.getTableHeader().setEnabled(false);

        JScrollPane jscroll = new JScrollPane(table);
        jscroll.setBounds(40, 20, 500, 350);

        frame.add(jscroll);
        frame.setTitle("Opara Assignment File");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setVisible(true);
    }
}
