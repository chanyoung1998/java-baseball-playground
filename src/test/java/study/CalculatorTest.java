package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        String actual = "2 + 3 * 4 / 2";
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
    }

    @Test
    void getInput() {
        String actual = calculator.getInput();
        assertThat(actual).isEqualTo("2 + 3 * 4 / 2");
    }


    @Test
    void getOperands() {
        int[] operands = calculator.getOperands(calculator.getInput());
        assertThat(operands).contains(2);
        assertThat(operands).contains(3);
        assertThat(operands).contains(4);
        assertThat(operands).containsExactly(2, 3, 4, 2);
    }

    @Test
    void getOperations() {
        String[] operands = calculator.getOperations(calculator.getInput());
        assertThat(operands).contains("+");
        assertThat(operands).contains("*");
        assertThat(operands).contains("/");
        assertThat(operands).containsExactly("+","*","/");
    }

    @Test
    void calculate() {
        double actual = calculator.calculate(calculator.getInput());
        assertThat(actual).isEqualTo(10);
    }


}
