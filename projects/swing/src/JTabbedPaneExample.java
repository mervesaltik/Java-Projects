import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JTabbedPaneExample extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton btnEnter;
    private JButton GOTOMENUBAREXAMPLEButton;
    private JPasswordField passwordField1;

    public JTabbedPaneExample(){
        setTitle("JTabbedPane Example");
        setSize(510,415);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel1);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                String pass = passwordField1.getText();
                if (text.equals("merve") && pass.equals("Merve1234")) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else if (!text.equals("merve") && pass.equals("Merve1234")) {
                    JOptionPane.showMessageDialog(null, "Login Name is wrong!");
                } else if (text.equals("merve")) {
                    JOptionPane.showMessageDialog(null, "Password is wrong!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Name or password is wrong!");
                }
            }
        });
        GOTOMENUBAREXAMPLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuBarExample jbe = new JMenuBarExample();
                jbe.setVisible(true);
            }
        });
    }

    public static void main(String[] args){
        JTabbedPaneExample jtp = new JTabbedPaneExample();
        jtp.setVisible(true);
    }
}
