package study;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

public class CalculatorVer3 {
    Formula formula = new Formula();

    public void setFormula(String input) {
        formula.writeFormula(input);
    }
    public void setFormula(InputStream in) {
        formula.writeFormula(in);
    }


    public double calculate() {
        Iterator operands = Arrays.stream(formula.getOperands()).iterator();
        String[] operations = formula.getOperations();

        int first = (int) operands.next();
        int second;

        for (String operation : operations) {
            Operations op = Operations.getSymbol(operation);
            second = (int) operands.next();
            first = op.operate(first, second);
        }
        return first;
    }

}
