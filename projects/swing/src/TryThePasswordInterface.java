import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryThePasswordInterface extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton enterButton;
    private JLabel username;
    private JLabel password;
    private JPanel newPanel;
    public TryThePasswordInterface() {
        setTitle("Password Table");
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(newPanel);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = usernameField.getText();
                String pass = passwordField.getText();
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
    }

    public static void main(String[] args) {
        TryThePasswordInterface trp = new TryThePasswordInterface();
        trp.setVisible(true);
    }
}

