import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFormInterface extends JFrame{
    private JTextField txtNumber1,txtNumber2,txtOperation,txtResult;
    private JButton btnCalculate;
    private JLabel number1,number2;
    private JPanel Calculator;
    public GuiFormInterface() {
        setTitle("An Example of Basic GUI Components");
        setSize(500,400);
        add(Calculator);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String s=txtOperation.getText();
                int number1=Integer.parseInt(txtNumber1.getText());
                int number2=Integer.parseInt(txtNumber2.getText());
                if(s.equals("+")) {
                    int result= number1+number2;
                    String str = Integer.toString(result);
                    txtResult.setText(str);
                } else if (s.equals("-")) {
                    int result = number1-number2;
                    String str = Integer.toString(result);
                    txtResult.setText(str);
                } else if (s.equals("*")) {
                    int result = number1*number2;
                    String str = Integer.toString(result);
                    txtResult.setText(str);
                } else if (s.equals("/")) {
                    if (number2 == 0) {
                        throw new ArithmeticException("Division by zero error");
                    }
                    int result = number1 / number2;
                    String str = Integer.toString(result);
                    txtResult.setText(str);
                } else {
                    throw new IllegalArgumentException("Invalid operation: " + txtOperation);
                }

            } catch (NumberFormatException ex) {
                txtResult.setText("Invalid input");
            } catch (ArithmeticException ex) {
                txtResult.setText("Error: Division by zero");
            } catch (IllegalArgumentException ex) {
                txtResult.setText("Error: " + ex.getMessage());
            }
            }
        });
    }
    public static void main(String[] args) {
        GuiFormInterface gfi = new GuiFormInterface();
        gfi.setVisible(true);

    }
}