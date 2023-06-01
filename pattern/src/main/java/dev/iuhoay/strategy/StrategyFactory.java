package dev.iuhoay.strategy;

public class StrategyFactory {
    public static Strategy getStrategy(String strategy) {
        switch (strategy) {
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSubtract();
            case "*":
                return new OperationMultiply();
            default:
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
        }
    }
}
