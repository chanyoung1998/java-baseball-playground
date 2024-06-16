package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest3 {

    private CalculatorVer3 calculator;

    @BeforeEach
    void init() {
        calculator = new CalculatorVer3();
        String actual = "2 + 3 * 4 / 2";
        System.setIn(new ByteArrayInputStream(actual.getBytes()));
    }
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10","1 + 3 * 5, 20","12 + 3 - 5 * 2, 20","12 - 2 + 100 / 10,11"})
    void setFolmula(String folmula,int expected) {
        calculator.setFormula(folmula);
        double actual = calculator.calculate();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 @ 2","1 * + - 2","1 + 2  - 3"})
    void checkOperations(String folmula) {

        assertThatThrownBy(() -> calculator.setFormula(folmula))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("invalid input");
    }


}
