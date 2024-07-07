package study.baseball.ver2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    public void ball_init_1부터_9숫자가_아니면_예외() throws Exception {
        assertThatThrownBy(() -> new Ball(0, 1)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void strike() throws Exception
    {
        Ball com = new Ball(1, 1);
        assertThat(com.isStrike(new Ball(1, 1))).isTrue();
    }

    @Test
    public void ball() throws Exception
    {
        Ball com = new Ball(1, 1);
        assertThat(com.isBall(new Ball(1, 2))).isTrue();
    }

    @Test
    public void nothing() throws Exception
    {
        Ball com = new Ball(1, 1);
        assertThat(com.isNothing(new Ball(2,1))).isTrue();
    }
}
