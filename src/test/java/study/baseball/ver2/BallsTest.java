package study.baseball.ver2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    public void balls_1strike_1ball_1nothing() throws Exception
    {
        Balls com = new Balls(List.of(1, 2, 3));
        Balls user = new Balls(List.of(1, 3, 4));
        assertThat(com.playGame(user)).isEqualTo(new Result(1, 1, 1));
    }

    @Test
    public void balls_1strike_0ball_2nothing() throws Exception
    {
        Balls com = new Balls(List.of(1, 2, 3));
        Balls user = new Balls(List.of(1, 4, 5));
        assertThat(com.playGame(user)).isEqualTo(new Result(1, 0, 2));
    }

    @Test
    public void balls_0strike_3ball_0nothing() throws Exception
    {
        Balls com = new Balls(List.of(1, 2, 3));
        Balls user = new Balls(List.of(2, 3, 1));
        assertThat(com.playGame(user)).isEqualTo(new Result(0, 3, 0));


    }
}
