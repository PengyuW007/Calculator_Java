import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers;
    JButton[] operators;
    JButton addition, subtraction, multiplication, division, sqr, decimal, clear, delete, equation;
    JPanel panel;
    Font font;

    double num1, num2, result;
    String operator;

    final int WIDTH = 420;
    final int HEIGHT = 550;

    public Calculator() {
        /*** window ***/
        frame = new JFrame("Calculator");
        frame.setSize(WIDTH, HEIGHT);

        /*** text ***/
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        font = new Font("Times New Roman", Font.BOLD, 30);
        textField.setFont(font);
        frame.add(textField);

        /*** Num 1, Num2 and Result ***/
        num1 = 0;
        num2 = 0;
        result = 0;
        /*** BUTTONS ***/
        //Operator buttons
        operators = new JButton[9];
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        sqr = new JButton("^");

        decimal = new JButton(".");
        clear = new JButton("C");
        delete = new JButton("<");
        equation = new JButton("=");

        operators[0] = addition;
        operators[1] = subtraction;
        operators[2] = multiplication;
        operators[3] = division;
        operators[4] = sqr;

        operators[5] = decimal;
        operators[6] = clear;
        operators[7] = delete;
        operators[8] = equation;


        for (int i = 0; i < 9; i++) {
            operators[i].addActionListener(this);
            operators[i].setFont(font);
            operators[i].setFocusable(false);
        }

        //numbers button
        numbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }


        clear.setBounds(50, 430, 100, 50);
        delete.setBounds(150, 430, 100, 50);
        equation.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.white);

        //numbers button visible in the panel
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addition);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtraction);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiplication);
        panel.add(sqr);
        panel.add(numbers[0]);
        panel.add(decimal);
        panel.add(division);

        //to make delete and clear button visible in the panel
        frame.add(delete);
        frame.add(clear);
        frame.add(equation);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if hit numbers button, then shows them in text field
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //if hit operations button, then shows them in text field
        for (int i = 0; i < 5; i++) {
            if (e.getSource() == operators[i]) {
                num1 = Double.parseDouble(textField.getText());
                operator = operators[i].getText();
                textField.setText("");
            }
        }

        if(e.getSource()==decimal){
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == equation) {
            num2 = Double.parseDouble(textField.getText());
            if (operator == "+") {
                result = num1 + num2;
                System.out.println(num1 + operator + num2 + " " + result);
            } else if (operator == "-") {
                result = num1 - num2;
                System.out.println(num1 + operator + num2 + " " + result);
            } else if (operator == "*") {
                result = num1 * num2;
                System.out.println(num1 + operator + num2 + " " + result);
            } else if (operator == "/") {
                result = num1 / num2;
                System.out.println(num1 + operator + num2 + " " + result);
            } else if (operator == "^") {
                result = Math.pow(num1, num2);
                System.out.println(num1 + operator + num2 + " " + result);
            }
        }

        if (e.getSource() == clear) {
            textField.setText("");
        } else if (e.getSource() == delete) {
            String line = textField.getText();
            textField.setText(line.substring(0, line.length() - 1));
        }

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
