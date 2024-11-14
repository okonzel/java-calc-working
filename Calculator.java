//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator implements ActionListener {
    Boolean isOparetoclicked = false;
    JFrame jf = new JFrame("calculator");
    JLabel DisplayLabel;
    JButton sevenbutton;
    JButton eightbutton;
    JButton ninebutton;
    JButton plusbutton;
    JButton fourbutton;
    JButton fivebutton;
    JButton sixbutton;
    JButton minbutton;
    JButton onebutton;
    JButton twobutton;
    JButton threebutton;
    JButton mulbutton;
    JButton dotbutton;
    JButton zerobutton;
    JButton equelbutton;
    JButton subbutton;
    JButton clearbutton;
    double newValue;
    double oldValue;
    int calculation;

    public Calculator() {
        this.jf.setBounds(0, 0, 500, 550);
        this.jf.setLayout((LayoutManager)null);
        this.jf.getContentPane().setBackground(Color.BLACK);
        this.DisplayLabel = new JLabel();
        this.DisplayLabel.setBounds(20, 30, 440, 90);
        this.DisplayLabel.setBackground(Color.white);
        this.DisplayLabel.setOpaque(true);
        this.DisplayLabel.setHorizontalAlignment(4);
        this.DisplayLabel.setForeground(Color.BLACK);
        this.DisplayLabel.setFont(new Font("arial", 0, 30));
        this.DisplayLabel.setVisible(true);
        this.jf.add(this.DisplayLabel);
        this.sevenbutton = new JButton("7");
        this.sevenbutton.setBounds(20, 150, 70, 70);
        this.sevenbutton.setFont(new Font("arial", 0, 20));
        this.sevenbutton.addActionListener(this);
        this.sevenbutton.setBackground(Color.white);
        this.sevenbutton.setOpaque(true);
        this.jf.add(this.sevenbutton);
        this.eightbutton = new JButton("8");
        this.eightbutton.setBounds(110, 150, 70, 70);
        this.eightbutton.setFont(new Font("arial", 0, 20));
        this.eightbutton.addActionListener(this);
        this.eightbutton.setBackground(Color.white);
        this.eightbutton.setOpaque(true);
        this.jf.add(this.eightbutton);
        this.ninebutton = new JButton("9");
        this.ninebutton.setBounds(200, 150, 70, 70);
        this.ninebutton.setFont(new Font("arial", 0, 20));
        this.ninebutton.addActionListener(this);
        this.ninebutton.setBackground(Color.white);
        this.ninebutton.setOpaque(true);
        this.jf.add(this.ninebutton);
        this.plusbutton = new JButton("+");
        this.plusbutton.setBounds(290, 150, 75, 70);
        this.plusbutton.setFont(new Font("arial", 0, 30));
        this.plusbutton.addActionListener(this);
        this.plusbutton.setBackground(Color.YELLOW);
        this.plusbutton.setOpaque(true);
        this.jf.add(this.plusbutton);
        this.minbutton = new JButton("-");
        this.minbutton.setBounds(385, 150, 75, 70);
        this.minbutton.setFont(new Font("arial", 0, 35));
        this.minbutton.addActionListener(this);
        this.minbutton.setBackground(Color.YELLOW);
        this.minbutton.setOpaque(true);
        this.jf.add(this.minbutton);
        this.fourbutton = new JButton("4");
        this.fourbutton.setBounds(20, 240, 70, 70);
        this.fourbutton.setFont(new Font("arial", 0, 20));
        this.fourbutton.addActionListener(this);
        this.fourbutton.setBackground(Color.white);
        this.fourbutton.setOpaque(true);
        this.jf.add(this.fourbutton);
        this.fivebutton = new JButton("5");
        this.fivebutton.setBounds(110, 240, 70, 70);
        this.fivebutton.setFont(new Font("arial", 0, 20));
        this.fivebutton.addActionListener(this);
        this.fivebutton.setBackground(Color.white);
        this.fivebutton.setOpaque(true);
        this.jf.add(this.fivebutton);
        this.sixbutton = new JButton("6");
        this.sixbutton.setBounds(200, 240, 70, 70);
        this.sixbutton.setFont(new Font("arial", 0, 20));
        this.sixbutton.addActionListener(this);
        this.sixbutton.setBackground(Color.white);
        this.sixbutton.setOpaque(true);
        this.jf.add(this.sixbutton);
        this.mulbutton = new JButton("x");
        this.mulbutton.setBounds(290, 240, 170, 70);
        this.mulbutton.setFont(new Font("arial", 0, 30));
        this.mulbutton.addActionListener(this);
        this.mulbutton.setBackground(Color.YELLOW);
        this.mulbutton.setOpaque(true);
        this.jf.add(this.mulbutton);
        this.onebutton = new JButton("1");
        this.onebutton.setBounds(20, 330, 70, 70);
        this.onebutton.setFont(new Font("arial", 0, 20));
        this.onebutton.addActionListener(this);
        this.onebutton.setBackground(Color.white);
        this.onebutton.setOpaque(true);
        this.jf.add(this.onebutton);
        this.twobutton = new JButton("2");
        this.twobutton.setBounds(110, 330, 70, 70);
        this.twobutton.setFont(new Font("arial", 0, 20));
        this.twobutton.addActionListener(this);
        this.twobutton.setBackground(Color.white);
        this.twobutton.setOpaque(true);
        this.jf.add(this.twobutton);
        this.threebutton = new JButton("3");
        this.threebutton.setBounds(200, 330, 70, 70);
        this.threebutton.setFont(new Font("arial", 0, 20));
        this.threebutton.addActionListener(this);
        this.threebutton.setBackground(Color.white);
        this.threebutton.setOpaque(true);
        this.jf.add(this.threebutton);
        this.subbutton = new JButton("/");
        this.subbutton.setBounds(290, 330, 170, 70);
        this.subbutton.setFont(new Font("arial", 0, 30));
        this.subbutton.addActionListener(this);
        this.subbutton.setBackground(Color.YELLOW);
        this.subbutton.setOpaque(true);
        this.jf.add(this.subbutton);
        this.dotbutton = new JButton(".");
        this.dotbutton.setBounds(20, 420, 70, 70);
        this.dotbutton.setFont(new Font("arial", 0, 50));
        this.dotbutton.addActionListener(this);
        this.dotbutton.setBackground(Color.white);
        this.dotbutton.setOpaque(true);
        this.jf.add(this.dotbutton);
        this.zerobutton = new JButton("0");
        this.zerobutton.setBounds(110, 420, 70, 70);
        this.zerobutton.setFont(new Font("arial", 0, 30));
        this.zerobutton.addActionListener(this);
        this.zerobutton.setBackground(Color.white);
        this.zerobutton.setOpaque(true);
        this.jf.add(this.zerobutton);
        this.equelbutton = new JButton("=");
        this.equelbutton.setBounds(200, 420, 70, 70);
        this.equelbutton.setFont(new Font("arial", 0, 30));
        this.equelbutton.addActionListener(this);
        this.equelbutton.setBackground(Color.WHITE);
        this.equelbutton.setOpaque(true);
        this.jf.add(this.equelbutton);
        this.clearbutton = new JButton("Clear");
        this.clearbutton.setBounds(290, 420, 170, 70);
        this.clearbutton.setFont(new Font("sans-serif", 0, 25));
        this.clearbutton.addActionListener(this);
        this.clearbutton.setBackground(Color.RED);
        this.clearbutton.setOpaque(true);
        this.jf.add(this.clearbutton);
        this.jf.setVisible(true);
        this.jf.setDefaultCloseOperation(3);
    }

    public static void main(String[] var0) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.sevenbutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("7");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "7");
            }
        } else if (var2 == this.eightbutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("8");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "8");
            }
        } else if (var2 == this.ninebutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("9");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "9");
            }
        } else if (var2 == this.fourbutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("4");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "4");
            }
        } else if (var2 == this.fivebutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("5");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "5");
            }
        } else if (var2 == this.sixbutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("6");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "6");
            }
        } else if (var2 == this.onebutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("1");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "1");
            }
        } else if (var2 == this.twobutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("2");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "2");
            }
        } else if (var2 == this.threebutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("3");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "3");
            }
        } else if (var2 == this.zerobutton) {
            if (this.isOparetoclicked) {
                this.DisplayLabel.setText("0");
                this.isOparetoclicked = false;
            } else {
                this.DisplayLabel.setText(this.DisplayLabel.getText() + "0");
            }
        } else if (var2 == this.dotbutton) {
            this.DisplayLabel.setText(this.DisplayLabel.getText() + ".");
        } else if (var2 == this.plusbutton) {
            this.isOparetoclicked = true;
            this.oldValue = Double.parseDouble(this.DisplayLabel.getText());
            this.calculation = 1;
        } else if (var2 == this.minbutton) {
            this.isOparetoclicked = true;
            this.oldValue = Double.parseDouble(this.DisplayLabel.getText());
            this.calculation = 2;
        } else if (var2 == this.mulbutton) {
            this.isOparetoclicked = true;
            this.oldValue = Double.parseDouble(this.DisplayLabel.getText());
            this.calculation = 3;
        } else if (var2 == this.subbutton) {
            this.isOparetoclicked = true;
            this.oldValue = Double.parseDouble(this.DisplayLabel.getText());
            this.calculation = 4;
        } else if (var2 == this.clearbutton) {
            this.DisplayLabel.setText("");
        } else if (var2 == this.equelbutton) {
            switch (this.calculation) {
                case 1:
                    this.newValue = this.oldValue + Double.parseDouble(this.DisplayLabel.getText());
                    if (Double.toString(this.newValue).endsWith(".0")) {
                        this.DisplayLabel.setText(Double.toString(this.newValue).replace(".0", ""));
                    } else {
                        this.DisplayLabel.setText(Double.toString(this.newValue));
                    }
                    break;
                case 2:
                    this.newValue = this.oldValue - Double.parseDouble(this.DisplayLabel.getText());
                    if (Double.toString(this.newValue).endsWith(".0")) {
                        this.DisplayLabel.setText(Double.toString(this.newValue).replace(".0", ""));
                    } else {
                        this.DisplayLabel.setText(Double.toString(this.newValue));
                    }
                    break;
                case 3:
                    this.newValue = this.oldValue * Double.parseDouble(this.DisplayLabel.getText());
                    if (Double.toString(this.newValue).endsWith(".0")) {
                        this.DisplayLabel.setText(Double.toString(this.newValue).replace(".0", ""));
                    } else {
                        this.DisplayLabel.setText(Double.toString(this.newValue));
                    }
                    break;
                case 4:
                    this.newValue = this.oldValue / Double.parseDouble(this.DisplayLabel.getText());
                    if (Double.toString(this.newValue).endsWith(".0")) {
                        this.DisplayLabel.setText(Double.toString(this.newValue).replace(".0", ""));
                    } else {
                        this.DisplayLabel.setText(Double.toString(this.newValue));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + this.calculation);
            }
        }

    }
}
