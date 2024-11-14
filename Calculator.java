import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Calculator implements ActionListener {
    boolean isOperatorClicked = false;
    JFrame jf;
    JLabel historyLabel;   // History label
    JLabel displayLabel;
    double oldValue;
    int calculation;
    boolean isNewCalculation = true;
    boolean isInverse = false; // To track inverse mode
    boolean isPythagMode = false; // To track Pythagorean mode
    double sideA = 0; // To store side a
    JButton invButton; // Reference to the inverse button
    JButton[] trigButtons; // Array to store references to trig buttons
    String[] trigLabels = { "sin", "cos", "tan", "csc", "sec", "cot" }; // Base trig labels

    public Calculator() {
        try {
            // Set the system's look and feel for a modern appearance
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // Enable anti-aliasing for smoother graphics and text
            System.setProperty("awt.useSystemAAFontSettings", "on");
            System.setProperty("swing.aatext", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }

        jf = new JFrame("Calculator");
        jf.setSize(350, 670); // Adjusted window size
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.BLACK);

        // History Label
        historyLabel = new JLabel("");
        historyLabel.setBounds(10, 30, 330, 30); // Position above the main display
        historyLabel.setBackground(Color.BLACK);
        historyLabel.setOpaque(true);
        historyLabel.setHorizontalAlignment(JLabel.RIGHT);
        historyLabel.setForeground(Color.GRAY);
        historyLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        jf.add(historyLabel);

        // Display Label
        displayLabel = new JLabel("0");
        displayLabel.setBounds(10, 60, 330, 60); // Adjusted position
        displayLabel.setBackground(Color.BLACK);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));
        jf.add(displayLabel);

        // Trigonometric Buttons Panel
        JPanel trigPanel = new JPanel();
        trigPanel.setLayout(new GridLayout(2, 4, 5, 5)); // 2 rows, 4 columns
        trigPanel.setBounds(10, 130, 330, 90); // Adjusted position
        trigPanel.setBackground(Color.BLACK);

        String[] trigButtonLabels = { "sin", "cos", "tan", "csc", "sec", "cot", "Pythag", "Inv" };
        trigButtons = new JButton[trigLabels.length]; // Initialize trig buttons array
        for (int i = 0; i < trigButtonLabels.length; i++) {
            JButton button = createButton(trigButtonLabels[i], Color.DARK_GRAY, Color.WHITE);
            button.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
            button.addActionListener(this);
            trigPanel.add(button);
            if (trigButtonLabels[i].equals("Inv")) {
                invButton = button; // Save reference to the inverse button
            } else if (trigButtonLabels[i].equals("Pythag")) {
                // Do nothing
            } else {
                // Save references to trig buttons (excluding "Pythag" and "Inv")
                trigButtons[i] = button;
            }
        }
        jf.add(trigPanel);

        // Buttons Panel (Main Calculator Buttons)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBounds(10, 230, 330, 400); // Adjusted position and size
        buttonPanel.setBackground(Color.BLACK);

        // Button Labels
        String[] buttonLabels = {
                "AC", "+/-", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "", "0", ".", "=" // Empty string to align "0" under "2"
        };

        for (String label : buttonLabels) {
            JButton button;
            if (label.equals("")) {
                button = new JButton();
                button.setEnabled(false);
                button.setVisible(false);
                buttonPanel.add(button);
            } else {
                Color bgColor;
                Color fgColor = Color.WHITE;
                if (label.matches("[÷×\\-+=]")) {
                    bgColor = new Color(255, 159, 10); // Orange for operators
                } else if (label.equals("AC") || label.equals("+/-") || label.equals("%")) {
                    bgColor = Color.DARK_GRAY; // Dark gray for function buttons
                } else {
                    bgColor = new Color(51, 51, 51); // Medium gray for numbers
                }
                button = createButton(label, bgColor, fgColor);
                button.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }
        jf.add(buttonPanel);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Helper method to create buttons with rounded corners
    private JButton createButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        button.setUI(new RoundedButtonUI());
        return button;
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            if (command.matches("\\d")) {
                appendNumberToDisplay(command);
            } else if (command.equals(".")) {
                if (!displayLabel.getText().contains(".")) {
                    displayLabel.setText(displayLabel.getText() + ".");
                }
            } else if (command.equals("+/-")) {
                double value = Double.parseDouble(displayLabel.getText());
                value *= -1;
                displayLabel.setText(formatResult(value));
            } else if (command.equals("+") || command.equals("-") || command.equals("×") || command.equals("÷")) {
                isOperatorClicked = true;
                oldValue = Double.parseDouble(displayLabel.getText());
                calculation = command.charAt(0); // Save operator as int
                isNewCalculation = false;
                historyLabel.setText(formatHistory(oldValue, command));
            } else if (command.equals("=")) {
                double newValue = Double.parseDouble(displayLabel.getText());
                double result = 0;
                if (isPythagMode) {
                    // Calculate hypotenuse
                    double sideB = newValue;
                    result = Math.sqrt(sideA * sideA + sideB * sideB);
                    historyLabel.setText("√(" + formatResult(sideA) + "² + " + formatResult(sideB) + "²)");
                    displayLabel.setText(formatResult(result));
                    isPythagMode = false;
                    isNewCalculation = true;
                } else {
                    String operator = String.valueOf((char) calculation);
                    historyLabel.setText(formatHistory(oldValue, operator, newValue));
                    switch (calculation) {
                        case '+': result = oldValue + newValue; break;
                        case '-': result = oldValue - newValue; break;
                        case '×': result = oldValue * newValue; break;
                        case '÷':
                            if (newValue == 0) {
                                displayLabel.setText("Error");
                                isNewCalculation = true;
                                return;
                            }
                            result = oldValue / newValue;
                            break;
                    }
                    displayLabel.setText(formatResult(result));
                    isNewCalculation = true;
                }
            } else if (command.equals("AC")) {
                displayLabel.setText("0");
                historyLabel.setText("");
                oldValue = 0;
                calculation = 0;
                isOperatorClicked = false;
                isNewCalculation = true;
                isInverse = false;
                isPythagMode = false;
                updateInvButton(); // Reset inverse button appearance
            } else if (command.equals("Inv")) {
                isInverse = !isInverse;
                updateInvButton();
                updateTrigButtonLabels();
            } else if (command.equals("%")) {
                double value = Double.parseDouble(displayLabel.getText());
                value /= 100;
                displayLabel.setText(formatResult(value));
            } else if (command.equals("sin") || command.equals("cos") || command.equals("tan") ||
                    command.equals("csc") || command.equals("sec") || command.equals("cot") ||
                    command.equals("sin⁻¹") || command.equals("cos⁻¹") || command.equals("tan⁻¹") ||
                    command.equals("csc⁻¹") || command.equals("sec⁻¹") || command.equals("cot⁻¹")) {
                String baseCommand = command.replace("⁻¹", "");
                double value = Double.parseDouble(displayLabel.getText());
                double result = 0;
                String functionDisplay = command + "(" + value + ")";
                historyLabel.setText(functionDisplay);
                if (!command.contains("⁻¹")) {
                    // Regular trigonometric functions
                    double radians = Math.toRadians(value);
                    switch (baseCommand) {
                        case "sin": result = Math.sin(radians); break;
                        case "cos": result = Math.cos(radians); break;
                        case "tan": result = Math.tan(radians); break;
                        case "csc": result = 1 / Math.sin(radians); break;
                        case "sec": result = 1 / Math.cos(radians); break;
                        case "cot": result = 1 / Math.tan(radians); break;
                    }
                } else {
                    // Inverse trigonometric functions
                    if (baseCommand.equals("csc") || baseCommand.equals("sec") || baseCommand.equals("cot")) {
                        if (value == 0) {
                            displayLabel.setText("Error");
                            isNewCalculation = true;
                            return;
                        }
                    } else if (value < -1 || value > 1) {
                        displayLabel.setText("Error");
                        isNewCalculation = true;
                        return;
                    }
                    switch (baseCommand) {
                        case "sin": result = Math.toDegrees(Math.asin(value)); break;
                        case "cos": result = Math.toDegrees(Math.acos(value)); break;
                        case "tan": result = Math.toDegrees(Math.atan(value)); break;
                        case "csc": result = Math.toDegrees(Math.asin(1 / value)); break;
                        case "sec": result = Math.toDegrees(Math.acos(1 / value)); break;
                        case "cot": result = Math.toDegrees(Math.atan(1 / value)); break;
                    }
                }
                if (Double.isNaN(result) || Double.isInfinite(result)) {
                    displayLabel.setText("Error");
                } else {
                    displayLabel.setText(formatResult(result));
                }
                isNewCalculation = true;
            } else if (command.equals("Pythag")) {
                // Start Pythagorean mode
                sideA = Double.parseDouble(displayLabel.getText());
                isPythagMode = true;
                historyLabel.setText("a = " + formatResult(sideA) + ", enter b and press =");
                isNewCalculation = true;
            }
        } catch (NumberFormatException ex) {
            displayLabel.setText("Error");
            isNewCalculation = true;
        } catch (Exception ex) {
            displayLabel.setText("Error");
            isNewCalculation = true;
        }
    }

    private void appendNumberToDisplay(String number) {
        if (isNewCalculation || displayLabel.getText().equals("0") || isOperatorClicked) {
            displayLabel.setText(number);
            isOperatorClicked = false;
            isNewCalculation = false;
        } else {
            displayLabel.setText(displayLabel.getText() + number);
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return String.format("%.8f", result).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }

    private void updateInvButton() {
        if (isInverse) {
            invButton.setBackground(Color.WHITE);
            invButton.setForeground(Color.BLACK);
        } else {
            invButton.setBackground(Color.DARK_GRAY);
            invButton.setForeground(Color.WHITE);
        }
        invButton.repaint();
    }

    private void updateTrigButtonLabels() {
        for (int i = 0; i < trigLabels.length; i++) {
            if (trigButtons[i] != null) {
                if (isInverse) {
                    trigButtons[i].setText(trigLabels[i] + "⁻¹");
                } else {
                    trigButtons[i].setText(trigLabels[i]);
                }
            }
        }
    }

    private String formatHistory(double oldVal, String operator) {
        return formatResult(oldVal) + " " + operator;
    }

    private String formatHistory(double oldVal, String operator, double newVal) {
        return formatResult(oldVal) + " " + operator + " " + formatResult(newVal);
    }

    // Custom UI for rounded buttons
    class RoundedButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground(Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.setColor(c.getBackground());
            // Increase the arc width and height to make buttons more circular
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, size.height, size.height);
        }
    }
}
