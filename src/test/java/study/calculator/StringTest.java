package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual.length).isEqualTo(2);
        assertThat(actual[0]).isEqualTo("1");
        assertThat(actual[1]).isEqualTo("2");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void subString(){
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAt() {
        String str = "abc";
        int errorIndex = str.length();
        assertThatThrownBy(() -> str.charAt(errorIndex)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("index out of range: 3");
    }



}


