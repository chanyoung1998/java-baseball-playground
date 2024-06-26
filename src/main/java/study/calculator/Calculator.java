package study.calculator;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {

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
            operations[i / 2] = operation;
        }
        return operations;
    }

    public double calculate(String input) {

        int[] operands = getOperands(input);
        String[] operations = getOperations(input);

        double first = operands[0];
        double second;

        for (int i = 0; i < operations.length; i++) {

            String op = operations[i];
            second = operands[i + 1];

            if (Objects.equals(op, "+")) {
                first += second;
            }else if (Objects.equals(op, "-")) {
                first -= second;
            }else if (Objects.equals(op, "*")) {
                first *= second;
            }  else if (Objects.equals(op, "/")) {
                first /= second;
            }

        }
        return first;


    }
}
