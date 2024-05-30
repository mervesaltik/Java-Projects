import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

public class FromJListToAnotherJList extends JFrame{
    private JList<String> list1;
    private JList<String> list2;
    private JTextField textField1;
    private JButton btnAddToList;
    private JButton btnRemoveFromList;
    private JPanel panel1;
    final DefaultListModel<String> listModel1;
    final DefaultListModel<String> listModel2;
    public FromJListToAnotherJList() {

        listModel1 = new DefaultListModel<>();
        list1.setModel(listModel1);
        listModel2 = new DefaultListModel<>();
        list2.setModel(listModel2);

        setTitle("From JList To Another JList");
        setSize(480,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(panel1);

        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnAddToList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = textField1.getText();
                if (!courseName.isEmpty()) {
                    listModel1.addElement(courseName);
                    textField1.setText("");
                }
            }
        });

        btnRemoveFromList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selectedValues = list1.getSelectedValuesList();
                //Bu list kullanıcının liste1'de  sectigi degerleri icerir.
                for (String value : selectedValues) {
                    listModel1.removeElement(value);
                    listModel2.addElement(value);
                }
                list1.setBackground(Color.RED);
                list2.setBackground(Color.GREEN);
            }
        });
    }
        public static void main(String[] args) {
            FromJListToAnotherJList jlt = new FromJListToAnotherJList();
            jlt.setVisible(true);
        }
    }


