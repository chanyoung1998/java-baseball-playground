package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest2 {

    private CalculatorVer2 calculator;

    @BeforeEach
    void init() {
        calculator = new CalculatorVer2();
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

    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10","1 + 3 * 5, 20"})
    void setFolmula(String folmula,int expected) {
        calculator.setFormula(folmula);
        double actual = calculator.calculate(calculator.getFormula());
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 @ 2"})
    void checkOperations(String folmula) {
        calculator.setFormula(folmula);
        assertThatThrownBy(() -> calculator.calculate(calculator.getFormula()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("invalid operations");
    }


    @ParameterizedTest
    @ValueSource(strings = {"1 * + - 2"})
    void checkOperands(String folmula) {
        calculator.setFormula(folmula);
        assertThatThrownBy(() -> calculator.calculate(calculator.getFormula()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("invalid operands");
    }


}
