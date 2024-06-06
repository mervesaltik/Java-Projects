import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuBarExample extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JMenuBar menuBar1;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuView;
    private JMenu menuHelp;
    private JMenuItem openItem;
    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem cutItem;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JTextArea textArea1;
    private JTextArea textArea2;
    public JMenuBarExample() {
        setTitle("MenuBar Example");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(panel1);

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Open Clicked"); } });
        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.cut(); } });
        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.paste(); } });
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.copy();
            }});
        }
    public static void main(String[] args){
        JMenuBarExample jbe = new JMenuBarExample();
        jbe.setVisible(true);

        }
    }


