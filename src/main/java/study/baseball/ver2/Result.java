package study.baseball.ver2;

import java.util.Objects;

public class Result {

    private int strike;
    private int ball;
    private int nothing;


    public Result() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public Result(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public void strike() {
        strike += 1;
    }

    public void ball() {
        ball += 1;
    }

    public void nothing() {
        nothing += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return strike == result.strike && ball == result.ball && nothing == result.nothing;
    }
}
