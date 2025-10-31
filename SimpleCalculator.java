package com.mycompany.simplecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class SimpleCalculator {
    private final JFrame frame;
    private final JTextField textField;
    private double num1, num2, result;
    private String operator = "";

    public SimpleCalculator() {
        // Create the main frame
        frame = new JFrame("Simple Calculator");
        frame.setSize(300, 300);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the text field for displaying the result
        textField = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 4);
        textField.setBorder(border);
        textField.setEditable(false);
        Font font = new Font("Cambria", Font.BOLD, 20);
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(20, 40));
        frame.add(textField, BorderLayout.NORTH);

        // Create panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Define button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(font);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (Character.isDigit(command.charAt(0))) {
                textField.setText(textField.getText() + command);
            } else if (command.equals("C")) {
                textField.setText("");
                num1 = num2 = result = 0;
                operator = "";
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                }
                textField.setText(String.valueOf(result));
                operator = "";
            } else {
                if (!operator.isEmpty()) {
                    return;
                }
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}