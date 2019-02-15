package study.effective.ch07.item42;

import lombok.extern.slf4j.Slf4j;

import java.util.function.DoubleBinaryOperator;

@Slf4j
public enum OperationWithFunctionObjectFields {
    PLUS("+", (x,y)-> x+y),
    MINUS("-", (x,y)-> x-y),
    TIMES("*", (x,y)-> x*y),
    DIVIDE("/", (x,y)-> x/y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    OperationWithFunctionObjectFields(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x,y);
    }
    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        for( OperationWithFunctionObjectFields op : OperationWithFunctionObjectFields.values() ){
            log.info("x {} y = {}", op, op.apply(x,y));
        }
    }
}
