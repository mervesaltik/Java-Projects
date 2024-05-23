import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonInterface extends JFrame {
    private JPanel newPanel;
    private JTextArea textArea1;
    private JRadioButton primeNumbersRadioButton;
    private JRadioButton multiples3And5RadioButton;
    private JButton button1;
    RadioButtonInterface() {
        setTitle("DISPLAY THE NUMBER");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(newPanel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (multiples3And5RadioButton.isSelected()) {
                    displayMultiplesOf3And5(textArea1);
                } else if (primeNumbersRadioButton.isSelected()) {
                    displayPrimeNumbers(textArea1);
                }
            }
        });
    }
        public static void main(String[] args) {
            RadioButtonInterface rbi = new RadioButtonInterface();
            rbi.setVisible(true);
        }
    private static void displayMultiplesOf3And5(JTextArea textArea) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 100; i++) {
            if (i % 15 == 0) {
                result.append(i).append(" ");
            }
        }
        textArea.setText(result.toString());
    }
    private static void displayPrimeNumbers(JTextArea textArea) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                result.append(i).append(" ");
            }
        }
        textArea.setText(result.toString());
    }
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            //16 sqrt(16) = 4     i = 2,3,4     16%4 == 0   so it is not prime.
            //17 sqrt(17) = 4,123105  i = 2,3,4  17%4  it is not zero, so it returns true.
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

