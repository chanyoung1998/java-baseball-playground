package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operations {

    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operations(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operations getSymbol(String symbol) {

        for (Operations op : Operations.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalStateException("invalid symbol");
    }
    public Integer operate(Integer first, Integer second) {

        if (Objects.isNull(first) || Objects.isNull(second)) {
            throw new IllegalStateException("operands can not be null");
        }
        return this.operation.apply(first, second);
    }


}
