import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationSwing extends JFrame {
    final JPanel panel1;
    final JButton button1;
    public OperationSwing() {
        panel1 = new JPanel();
        button1 = new JButton("Click To Start Operations");
        panel1.add(button1);

        add(panel1);

        setSize(300, 200);
        setTitle("Math Operations Dialogs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstNumber = JOptionPane.showInputDialog("Enter the first integer:");
                    int number1 = Integer.parseInt(firstNumber);

                    String secondNumber = JOptionPane.showInputDialog("Enter the second integer:");
                    int number2 = Integer.parseInt(secondNumber);

                    String[] options = {"Addition", "Subtraction", "Multiplication", "Division"};
                    int operation = JOptionPane.showOptionDialog(null, "Choose an operation:",
                            "Operation Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);

                    if (operation != JOptionPane.CLOSED_OPTION) {
                        // Confirm the operation
                        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to proceed with the selected operation?",
                                "Confirm Operation", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            if (operation == 0) {
                                int sum = number1 + number2;
                                JOptionPane.showMessageDialog(null, "The sum is " + sum, "Result", JOptionPane.PLAIN_MESSAGE);

                            } else if (operation == 1) {
                                int difference = number1 - number2;
                                JOptionPane.showMessageDialog(null, "The difference is " + difference, "Result", JOptionPane.PLAIN_MESSAGE);
                            } else if (operation == 2) {
                                int product = number1 * number2;
                                JOptionPane.showMessageDialog(null, "The product is " + product, "Result", JOptionPane.PLAIN_MESSAGE);
                            } else if (operation == 3) {
                                try {
                                    if (number2 == 0) {
                                        throw new ArithmeticException("Cannot divide by zero");
                                    }
                                    double quotient = (double) number1 / number2;
                                    JOptionPane.showMessageDialog(null, "The quotient is " + quotient, "Result", JOptionPane.PLAIN_MESSAGE);
                                } catch (ArithmeticException ex) {
                                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /* Swing is not thread-safe and all components must be initialized in EDT
    This will prevent problems such as deadlocking. */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                OperationSwing d = new OperationSwing();
                d.setVisible(true);
        } }); }
}
