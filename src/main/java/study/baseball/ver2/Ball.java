package study.baseball.ver2;

import java.util.Objects;

public class Ball {
    int number;
    int place;

    public Ball(int number, int place) {
        if (1 > number || 9 < number) {
            throw new IllegalStateException("숫자는 1~9까지의 숫자여야 합니다.");

        }
        this.number = number;
        this.place = place;
    }

    boolean isStrike(Ball ball) {
        return this.equals(ball);
    }

    boolean isBall(Ball ball) {
        return !this.equals(ball) && this.number == ball.number;

    }

    boolean isNothing(Ball ball) {
        return this.number != ball.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && place == ball.place;
    }

}
