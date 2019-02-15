package study.effective.ch07.item42;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum OperationWithConstantSpecific {
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    }, MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    }, TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    }, DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;

    OperationWithConstantSpecific(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        for( OperationWithConstantSpecific op : OperationWithConstantSpecific.values() ){
            log.info("x {} y = {}", op, op.apply(x,y));
        }
    }
}
