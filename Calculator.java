import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    //TREAT ANS AS A VARIABLE

    private String display = "0";
    private String prevAns = "0";
    private boolean shouldClear = true;
    private JTextField displayArea = new JTextField(20);


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.pack();
        calculator.setLocationRelativeTo(null);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }

    public Calculator() {
        initUI();
    }

    private void initUI() {

        JPanel displayPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        displayArea.setHorizontalAlignment(SwingConstants.RIGHT);
        displayArea.setText(display);
        displayArea.setEditable(false);

        displayPanel.setLayout(new GridBagLayout());
        inputPanel.setLayout(new GridLayout(4,5));

        JButton oneButton = new JButton("1");
        oneButton.addActionListener(new Listener(this, oneButton));
        JButton twoButton = new JButton("2");
        twoButton.addActionListener(new Listener(this, twoButton));
        JButton threeButton = new JButton("3");
        threeButton.addActionListener(new Listener(this, threeButton));
        JButton fourButton = new JButton("4");
        fourButton.addActionListener(new Listener(this, fourButton));
        JButton fiveButton = new JButton("5");
        fiveButton.addActionListener(new Listener(this, fiveButton));
        JButton sixButton = new JButton("6");
        sixButton.addActionListener(new Listener(this, sixButton));
        JButton sevenButton = new JButton("7");
        sevenButton.addActionListener(new Listener(this, sevenButton));
        JButton eightButton = new JButton("8");
        eightButton.addActionListener(new Listener(this, eightButton));
        JButton nineButton = new JButton("9");
        nineButton.addActionListener(new Listener(this, nineButton));
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new Listener(this, zeroButton));
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new Listener(this, multiplyButton));
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new Listener(this, divideButton));
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new Listener(this, plusButton));
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new Listener(this, minusButton));
        JButton decimalButton = new JButton(".");
        decimalButton.addActionListener(new Listener(this, decimalButton));
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new Listener(this, clearButton));
        JButton allClearButton = new JButton("AC");
        allClearButton.addActionListener(new Listener(this, allClearButton));
        JButton deleteButton = new JButton("DEL");
        deleteButton.addActionListener(new Listener(this, deleteButton));
        JButton AnsButton = new JButton("Ans");
        AnsButton.addActionListener(new Listener(this, AnsButton));
        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new Listener(this, equalsButton));

        inputPanel.add(sevenButton);
        inputPanel.add(eightButton);
        inputPanel.add(nineButton);
        inputPanel.add(clearButton);
        inputPanel.add(allClearButton);
        inputPanel.add(fourButton);
        inputPanel.add(fiveButton);
        inputPanel.add(sixButton);
        inputPanel.add(multiplyButton);
        inputPanel.add(divideButton);
        inputPanel.add(oneButton);
        inputPanel.add(twoButton);
        inputPanel.add(threeButton);
        inputPanel.add(plusButton);
        inputPanel.add(minusButton);
        inputPanel.add(zeroButton);
        inputPanel.add(decimalButton);
        inputPanel.add(deleteButton);
        inputPanel.add(AnsButton);
        inputPanel.add(equalsButton);

        displayPanel.add(displayArea);
        add(displayPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
        displayArea.setText(display);
    }

    public String getPrevAns() {
        return prevAns;
    }

    public void setPrevAns(String prevAns) {
        this.prevAns = prevAns;
    }

    public boolean isShouldClear() {
        return shouldClear;
    }

    public void setShouldClear(boolean shouldClear) {
        this.shouldClear = shouldClear;
    }
}
