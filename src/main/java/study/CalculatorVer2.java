package study;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorVer2 {

    String formula;

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return this.formula;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        if(input.length() > 0) {
            return input;
        }
        throw new RuntimeException("input size can not be 0");
    }

    public int[] getOperands(String input) {

        String[] temp = input.split(" ");
        int[] numbers = new int[(int) (Math.ceil(temp.length) / 2 + 1)];

        for (int i = 0; i < temp.length; i = i + 2) {
            String strNumber = temp[i];
            isDigit(strNumber);
            int number = Integer.parseInt(strNumber);
            numbers[i / 2] = number;
        }
        return numbers;
    }

    public String[] getOperations(String input) {
        String[] temp = input.split(" ");
        String[] operations = new String[(int) Math.ceil(temp.length / 2)];

        for (int i = 1; i < temp.length; i = i + 2) {
            String operation = temp[i];
            isOperations(operation);
            operations[i / 2] = operation;
        }
        return operations;
    }

    public double calculate(String input) {

        Iterator operands = Arrays.stream(getOperands(input)).iterator();
        String[] operations = getOperations(input);

        int first = (int) operands.next();
        int second;

        for (String operation : operations) {
            Operations op = Operations.getSymbol(operation);
            second = (int) operands.next();
            first = op.operate(first, second);
        }
        return first;
    }

    public static void isDigit(String str) {
        String regExp = "^[0-9]*$";
        if (!Pattern.matches(regExp, str)) {
            throw new IllegalStateException("invalid operands");
        }
    }

    public static void isOperations(String str) {
        String regExp = "^[+\\-*/]$";
        if (!Pattern.matches(regExp, str)) {
            throw new IllegalStateException("invalid operations");
        }
    }


}
