import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {
    JFrame f;
    JTextField textfield;
    JButton[] NumButtons = new JButton[10];
    JButton[] FuncButton = new JButton[6];
    JButton addButton, difButton, mulButton, divButton;
    JButton eqButton, clcButton;
    JPanel panel;
    Font scoreFont = new Font("Arial", Font.BOLD, 16);
    double num1 = 0, num2 = 0, result = 0, tmp = 0;
    String previous, current, operator;

    Calculator() {
        current = "";
        previous = "";
        f = new JFrame("My First Calculator - v.0.1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 250);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(0, 5, 400, 50);
        textfield.setFont(scoreFont);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        difButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clcButton = new JButton("C");

        FuncButton[0] = addButton;
        FuncButton[1] = difButton;
        FuncButton[2] = mulButton;
        FuncButton[3] = divButton;
        FuncButton[4] = eqButton;
        FuncButton[5] = clcButton;

        for (int i = 0; i < 6; i++) {
            FuncButton[i].addActionListener(this);
            FuncButton[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            NumButtons[i] = new JButton(String.valueOf(i));
            NumButtons[i].addActionListener(this);
            NumButtons[i].setFocusable(false);
        }

        JPanel panel = new JPanel();
        panel.setBounds(0, 60, 400, 200);
        panel.setLayout(new GridLayout(5, 4, 10, 5));
        panel.add(NumButtons[1]);
        panel.add(NumButtons[2]);
        panel.add(NumButtons[3]);
        panel.add(FuncButton[0]);
        panel.add(NumButtons[4]);
        panel.add(NumButtons[5]);
        panel.add(NumButtons[6]);
        panel.add(FuncButton[1]);
        panel.add(NumButtons[7]);
        panel.add(NumButtons[8]);
        panel.add(NumButtons[9]);
        panel.add(FuncButton[2]);
        panel.add(NumButtons[0]);
        panel.add(FuncButton[5]);
        panel.add(FuncButton[4]);
        panel.add(FuncButton[3]);

        f.add(panel);
        f.add(textfield);
        f.setVisible(true);

    }

    public void selectOperator(String newOperator) {
        // if no number is entered yet
        if (current.isEmpty()) {
            operator = newOperator;
            return;
        }
        if (!previous.isEmpty()) {
            calculate();
        }
        operator = newOperator;
        previous = current;
        current = "";
    }

    public void updateOutput() {
        textfield.setText(current);
    }

    public void calculate() {
        if (previous.length() < 1 || current.length() < 1) {
            return;
        }
        double result = 0.0;
        double num1 = Double.parseDouble(previous);
        double num2 = Double.parseDouble(current);
        switch (operator) {
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "÷":
                result = num1 / num2;
                break;
            default:
                break;
        }
        current = String.valueOf(result);
        operator = null;
        previous = "";
    }

    public void appendToOutput(String num) {
        current += num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == NumButtons[i]) {
                appendToOutput(NumButtons[i].getText());
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            selectOperator(addButton.getText());
        }
        if (e.getSource() == difButton) {
            num1 = Double.parseDouble(textfield.getText());
            selectOperator(difButton.getText());
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            selectOperator(mulButton.getText());
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            selectOperator(divButton.getText());
        }
        if (e.getSource() == clcButton) {
            current = "";
            previous = "";
            operator = null;
        }
        updateOutput();
        if (e.getSource() == eqButton) {
            calculate();
        }
        updateOutput();
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }
}