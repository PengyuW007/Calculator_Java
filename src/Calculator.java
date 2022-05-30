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

    public Calculator() {
        /*** window ***/
        frame = new JFrame("Calculator");
        frame.setSize(500, 500);

        /*** text ***/
        textField =  new JTextField();
        textField.setBounds(50,25,400,50);
        font = new Font("Times New Roman",Font.BOLD,30);
        textField.setFont(font);
        frame.add(textField);

        //textField.setEditable(false);

        /*** BUTTONS ***/
        //Operator buttons
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        sqr = new JButton("^2");
        sqrRoot = new JButton("^(1/2)");
        clear = new JButton("C");
        delete = new JButton("<-");
        equation = new JButton("=");

        //operators[0]=

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
