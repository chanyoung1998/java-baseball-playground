package study;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Formula {
    private static final String REG = "^\\d+(\\s[+\\-*/]\\s\\d+)*$";
    private static final Pattern PATTERN = Pattern.compile(REG);
    private static final String FORMULA_SPLITTER = " ";
    private String formula;
    private String[] operations;
    private int[] operands;
    public String getFormula() {
        return formula;
    }

    public String[] getOperations() {
        return operations;
    }

    public int[] getOperands() {
        return operands;
    }


    public void writeFormula(InputStream in) {
        Scanner scanner = new Scanner(in);
        String input = scanner.nextLine().trim();
        isValidFormula(input);
        setFormula(input);
        setOperands(input);
        setOperations(input);
    }
    public void writeFormula(String input) {
        isValidFormula(input);
        setFormula(input);
        setOperands(input);
        setOperations(input);
    }

    private static void isValidFormula(String input) {

        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalStateException("invalid input");
        }
    }

    private void setFormula(String formula) {
        this.formula = formula;
    }

    private void setOperands(String input) {

        String[] temp = input.split(FORMULA_SPLITTER);
        int[] operands = new int[(int) (Math.ceil(temp.length) / 2 + 1)];

        for (int i = 0; i < temp.length; i = i + 2) {
            String strNumber = temp[i];
            int number = Integer.parseInt(strNumber);
            operands[i / 2] = number;
        }

        this.operands = operands;
    }

    private void setOperations(String input) {
        String[] temp = input.split(FORMULA_SPLITTER);
        String[] operations = new String[(int) Math.ceil(temp.length / 2)];

        for (int i = 1; i < temp.length; i = i + 2) {
            String operation = temp[i];
            operations[i / 2] = operation;
        }
        this.operations = operations;
    }


}
