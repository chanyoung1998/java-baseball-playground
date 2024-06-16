package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final Map<String, Operations> operationsMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(op->op.symbol, op -> op)));

    public static Operations getSymbol(String symbol) {

        Operations op = operationsMap.get(symbol);
        if (Objects.isNull(op)) {
            throw new IllegalStateException("invalid symbol");
        }
        return op;
    }
    public Integer operate(Integer first, Integer second) {

        if (Objects.isNull(first) || Objects.isNull(second)) {
            throw new IllegalStateException("operands can not be null");
        }
        return this.operation.apply(first, second);
    }


}
