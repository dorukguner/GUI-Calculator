import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    private final Calculator calculator;
    private final String button;

    public Listener(Calculator calculator, JButton button) {
        this.calculator = calculator;
        this.button = button.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.setDisplay(getNewDisplay(calculator.getDisplay()));
    }

    public String getNewDisplay(String display) {
        if (calculator.isShouldClear() && !button.equals("=")) {
            display = "";
            calculator.setShouldClear(false);
        }
        switch (button) {
            case "DEL":
                if (display.length() > 0) {
                    if (display.charAt(display.length() - 1) == 's') {
                        return display.substring(0, display.length() - 3);
                    }
                    return display.substring(0, display.length() - 1);
                }
                return display;
            case "AC":
            case "C":
                return "";
            case "=":
                calculator.setShouldClear(true);
                int decimalCount = 0;
                for (int i = 0; i < display.length(); i++) {
                    if (display.charAt(i) == '.') {
                        decimalCount++;
                    }
                }
                System.out.println(display.lastIndexOf("Ans") + ", " + display.indexOf('.'));
                if (decimalCount > 1
                        || (display.indexOf('.') >= 0 && display.lastIndexOf("Ans") >= display.indexOf('.'))) {
                    return "Err";
                } else {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    try {
                        display = display.replaceAll("Ans", calculator.getPrevAns());
                        String ans = String.valueOf(engine.eval(display));
                        calculator.setPrevAns(ans);
                        return ans;
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }
            default:
                return display + (button);
        }
    }
}
