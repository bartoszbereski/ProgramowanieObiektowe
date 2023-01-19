import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static JFrame f;
    static JTextField textfield;
    static JButton[] NumButtons = new JButton[10];
    static JButton[] FuncButton = new JButton[6];
    static JButton addButton, difButton, mulButton, divButton;
    static JButton eqButton, clcButton;
    static JPanel panel;
    private static final Font scoreFont = new Font("Arial", Font.BOLD, 16);
    private static int num1 = 0, num2 = 0, result = 0;
    static String operator;
    static boolean dividingByZero, lastInputEqual = false, lastInputAction = true, solved = true, hasBeenSolved = true;

    public static void selectOperator(String newOperator) {
        if (lastInputAction) {
            operator = newOperator;
            solved = false;
            return;
        }
        if (textfield.getText().isEmpty()) {
            num1 = 0;
            operator = newOperator;
            solved = false;
            lastInputAction = true;
            lastInputEqual = false;
            return;
        }
        if (!solved) {
            calculate();
            solved = true;
        }
        operator = newOperator;
        num1 = Integer.parseInt(textfield.getText());
        solved = false;
        lastInputAction = true;
        lastInputEqual = false;
    }

    public static void calculate() {
        if (operator == null) {
            solved = true;
            lastInputEqual = false;
            lastInputAction = true;
            hasBeenSolved = true;
            if (!textfield.getText().isEmpty()) {
                num1 = Integer.parseInt(textfield.getText());
            }
            return;
        }
        if (lastInputEqual) {
            num1 = result;
        } else {
            result = num1;
            num2 = Integer.parseInt(textfield.getText());
        }
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
            case "/":
                if (num2 == 0) {
                    clcButton.doClick();
                    textfield.setForeground(Color.red);
                    textfield.setText("ERROR: DIVISION BY ZERO");
                    dividingByZero = true;
                    return;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                break;
        }
        textfield.setText(String.valueOf(result));
        lastInputEqual = true;
        lastInputAction = false;
        solved = true;
    }

    static ActionListener myActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource().equals(NumButtons[i])) {
                    textfield.setForeground(Color.black);
                    if (lastInputEqual) {
                        textfield.setText("");
                        operator = null;
                    }
                    if (lastInputAction) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText().concat(NumButtons[i].getText()));
                    lastInputAction = false;
                    lastInputEqual = false;
                }
            }
            if (e.getSource().equals(addButton)) {
                selectOperator(addButton.getText());
            }
            if (e.getSource().equals(difButton)) {
                selectOperator(difButton.getText());
            }
            if (e.getSource().equals(mulButton)) {
                selectOperator(mulButton.getText());
            }
            if (e.getSource().equals(divButton)) {
                selectOperator(divButton.getText());
            }
            if (e.getSource().equals(eqButton)) {
                calculate();
            }
            if (e.getSource().equals(clcButton)) {
                textfield.setText("");
                num1 = 0;
                num2 = 0;
                operator = null;
                lastInputEqual = false;
                lastInputAction = true;
                hasBeenSolved = true;
                dividingByZero = false;
                textfield.setForeground(Color.black);
            }
        }
    };

    public static void createAndShowGUI() {
        f = new JFrame("My First Calculator - v.3.1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 250);
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
            FuncButton[i].addActionListener(myActionListener);
            FuncButton[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            NumButtons[i] = new JButton(String.valueOf(i));
            NumButtons[i].addActionListener(myActionListener);
            NumButtons[i].setFocusable(false);
        }
        panel = new JPanel();
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

        f.setBackground(Color.black);
        panel.setBackground(Color.lightGray);
        f.getContentPane().setBackground(Color.lightGray);

        f.add(panel);
        f.add(textfield);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
