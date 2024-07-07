package study.baseball.ver2;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            this.balls.add(new Ball(balls.get(i), i + 1));
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
    public Result playGame(Balls others) {

        Result result = new Result();
        for (int i = 0; i < 3; i++) {

            Ball other = others.getBalls().get(i);

            boolean strike = this.balls.stream().anyMatch(com -> com.isStrike(other));
            boolean ball = this.balls.stream().anyMatch(com -> com.isBall(other));

            if (strike) {
                result.strike();
                continue;
            }
            if (ball) {
                result.ball();
                continue;
            }
            result.nothing();
        }
        return result;

    }
}
