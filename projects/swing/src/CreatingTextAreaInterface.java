import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatingTextAreaInterface extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton addButton;
    private JPanel textPanel;

    CreatingTextAreaInterface() {
        setTitle("Text Area Table" );
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(textPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = textArea2.getText();
                textArea1.append(s1);
                textArea1.append("\n");
                int caretPos = textArea1.getCaretPosition();
                String s2 = textArea3.getText();
                textArea1.insert(s2,caretPos);
                textArea2.setText("");
                textArea3.setText("");
            }
        });
    }
    public static void main(String[] args) {
        CreatingTextAreaInterface cta = new CreatingTextAreaInterface();
        cta.setVisible(true);
    }
}
