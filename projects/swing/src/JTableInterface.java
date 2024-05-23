import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableInterface extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton btnAge;
    JTableInterface(){
        setTitle("Data Table");
        setSize(500,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        String[] column = {"Name", "Surname", "Job"};
        Object[][] row = {{"Merve", "Saltık", "Software Engineer"}, {"Ali", "Yılmaz", "Doctor"},
                {"Ayşe", "Kaya", "Computer Engineer"}};

        table1.setModel(new DefaultTableModel(row,column));
        table1.setRowHeight(0,15);
        table1.setGridColor(Color.BLUE);
        add(panel1);

        btnAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
                dtm.addColumn("Age", new Integer[] {22,28,30});
            }
        });
    }

    public static void main(String[] args) {
        JTableInterface tableInterface = new JTableInterface();
        tableInterface.setVisible(true);
    }

}
