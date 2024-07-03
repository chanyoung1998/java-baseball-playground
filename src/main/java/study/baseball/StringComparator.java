package study.baseball;

import java.util.*;

public class StringComparator {

    private int strike;
    private int ball;
    private int nothing;

    public StringComparator() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public String[] parsing(Integer number) {
        String numberStr = String.valueOf(number);
        String[] ret = new String[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            ret[i] = numberStr.substring(i, i + 1);
        }
        return ret;
    }

    public boolean validation(Integer number) {
        Set<String> check = new HashSet<>();
        for (String s : parsing(number)) {
            if (!check.contains(s)) {
                check.add(s);
            } else {
                return false;
            }
        }
        return true;
    }

    public void calculate(String[] targetArr, String[] sourceArr) {
        for (int i = 0; i < targetArr.length; i++) {
            if (isStrike(targetArr, sourceArr, i)) {
                strike += 1;
                continue;
            }
            if (isBall(targetArr, sourceArr, i)) {
                ball += 1;
                continue;
            }
            nothing += 1;
        }
    }

    public boolean isStrike(String[] targetArr, String[] sourceArr, int index) {
        return targetArr[index].equals(sourceArr[index]);
    }

    public boolean isBall(String[] targetArr, String[] sourceArr, int index) {
        return !targetArr[index].equals(sourceArr[index])
                && Arrays.stream(targetArr).anyMatch(s -> s.equals(sourceArr[index]));
    }
}
