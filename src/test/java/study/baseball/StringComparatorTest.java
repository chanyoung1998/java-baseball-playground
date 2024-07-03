package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringComparatorTest {

    private StringComparator stringComparator;

    @BeforeEach
    public void init() {
        stringComparator = new StringComparator();
    }



    @Test
    public void parsing() throws Exception {

        int number = 123;
        String[] numberStrArr = stringComparator.parsing(number);
        assertThat(numberStrArr).containsExactly("1", "2", "3");

    }

    @ParameterizedTest
    @CsvSource(value = {"123,true", "112,false","111,false"})
    public void validation(Integer number, boolean expected) throws Exception {
        assertThat(stringComparator.validation(number)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,false", "2,false"})
    public void isStrike(Integer index, Boolean expected) throws Exception {
        int target = 123;
        int source = 134;
        assertThat(stringComparator.isStrike(stringComparator.parsing(target), stringComparator.parsing(source), index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,false", "1,true", "2,false"})
    public void isBall(Integer index, Boolean expected) throws Exception {
        int target = 123;
        int source = 134;
        assertThat(stringComparator.isBall(stringComparator.parsing(target), stringComparator.parsing(source), index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123,134,1,1,1", "123,123,3,0,0", "123,132,1,2,0","123,456,0,0,3","123,231,0,3,0"})
    public void calculate(int target, int source,int strike,int ball, int nothing) throws Exception {
        stringComparator.calculate(stringComparator.parsing(target), stringComparator.parsing(source));
        assertThat(stringComparator.getStrike()).isEqualTo(strike);
        assertThat(stringComparator.getBall()).isEqualTo(ball);
        assertThat(stringComparator.getNothing()).isEqualTo(nothing);
    }
}
