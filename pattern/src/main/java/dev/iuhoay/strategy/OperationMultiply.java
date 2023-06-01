package dev.iuhoay.strategy;

public class OperationMultiply implements Strategy {

    @Override
    public int execute(int num1, int num2) {
        return num1 * num2;
    }

}
