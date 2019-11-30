package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Izotov V.A. on 30.11.2019.
 */
public class Calculator {
    private String operation = "  ...  ";
    private static double resultMath = 0;


    public static void main(String[] args) {
        new Calculator();
    }

    private Calculator() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 240);

        JPanel container = new JPanel(new GridBagLayout());
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        final JTextField field1 = new JTextField(10);
        constraints.gridy = 0;
        constraints.gridx = 0;
        container.add(field1, constraints);


        final JLabel label1 = new JLabel(operation);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 1;
        container.add(label1, constraints);

        final JTextField field2 = new JTextField(10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 2;
        container.add(field2, constraints);

        final JLabel label2 = new JLabel("  =  ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 3;
        container.add(label2, constraints);


        String result = " ...          ";
        final JLabel resultLabel = new JLabel(result);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 4;
        container.add(resultLabel, constraints);

        JButton button1 = new JButton("+");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 2;
        constraints.gridx = 0;
        container.add(button1, constraints);

        JButton button2 = new JButton("-");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 3;
        constraints.gridx = 0;
        container.add(button2, constraints);

        JButton button3 = new JButton("*");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 4;
        constraints.gridx = 0;
        container.add(button3, constraints);

        JButton button4 = new JButton("/");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 5;
        constraints.gridx = 0;
        container.add(button4, constraints);

        JButton button5 = new JButton("Степень");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 6;
        constraints.gridx = 0;
        container.add(button5, constraints);

        ActionListener listenerOperation = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    assumingCorrectNumberFormats(e);
                } catch (NumberFormatException e2) {
                    resultLabel.setText("Error: Reenter Number.");
                }
            }


            void assumingCorrectNumberFormats(ActionEvent e) {

                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("+")) {
                    operation = "  +  ";
                    label1.setText(operation);
                    resultMath = stringToDouble(field1.getText()) + stringToDouble(field2.getText());
                    resultLabel.setText(Double.toString(resultMath));
                } else if (actionCommand.equals("-")) {
                    operation = "  -  ";
                    label1.setText(operation);
                    resultMath = stringToDouble(field1.getText()) - stringToDouble(field2.getText());
                    resultLabel.setText(Double.toString(resultMath));
                } else if (actionCommand.equals("*")) {
                    operation = "  *  ";
                    label1.setText(operation);
                    resultMath = stringToDouble(field1.getText()) * stringToDouble(field2.getText());
                    resultLabel.setText(Double.toString(resultMath));
                } else if (actionCommand.equals("/")) {
                    operation = "  /  ";
                    label1.setText(operation);
                    resultMath = stringToDouble(field1.getText()) / stringToDouble(field2.getText());
                    resultLabel.setText(Double.toString(resultMath));
                } else if (actionCommand.equals("Степень")) {
                    operation = "  в степени  ";
                    label1.setText(operation);
                    resultMath = Math.pow((stringToDouble(field1.getText())), stringToDouble(field2.getText()));
                    resultLabel.setText(Double.toString(resultMath));
                }

            }

            private double stringToDouble(String stringObject) {
                return Double.parseDouble(stringObject.trim());
            }
        };

        button1.addActionListener(listenerOperation);
        button2.addActionListener(listenerOperation);
        button3.addActionListener(listenerOperation);
        button4.addActionListener(listenerOperation);
        button5.addActionListener(listenerOperation);

        frame.setContentPane(container);
        frame.setVisible(true);
    }
}