import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers;
    JButton[] operators;
    JButton addition, subtraction, multiplication, division, sqr, sqrRoot, clear, delete, equation;
    JPanel panel;
    Font font;

    final int WIDTH =700;
    final int HEIGHT = 700;

    public Calculator() {
        /*** window ***/
        frame = new JFrame("Calculator");
        frame.setSize(WIDTH, HEIGHT);

        /*** text ***/
        textField = new JTextField();
        textField.setBounds(50, 25, 400, 50);
        font = new Font("Times New Roman", Font.BOLD, 30);
        textField.setFont(font);
        frame.add(textField);

        //textField.setEditable(false);

        /*** BUTTONS ***/
        //Operator buttons
        operators = new JButton[9];
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        sqr = new JButton("^2");
        sqrRoot = new JButton("^(1/2)");
        clear = new JButton("C");
        delete = new JButton("<");
        equation = new JButton("=");

        operators[0] = addition;
        operators[1] = subtraction;
        operators[2] = multiplication;
        operators[3] = division;
        operators[4] = sqr;
        operators[5] = sqrRoot;
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

        delete.setBounds(230, 90, 100, 30);
        clear.setBounds(350, 90, 100, 30);

        panel = new JPanel();
        panel.setBounds(50, 80, 400, 300);
        panel.setLayout(new GridLayout(5, 4, 1, 1));
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
        panel.add(numbers[0]);

//to make delete and clear button visible in the panel
        //frame.add(delete);
        //frame.add(clear);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
