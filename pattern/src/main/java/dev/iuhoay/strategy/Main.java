package dev.iuhoay.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Strategy Factory:");

        Input[] inputs = {
                new Input(10, 5, "+"),
                new Input(10, 5, "-"),
                new Input(10, 5, "*"),
        };

        Arrays.stream(inputs).forEach(Input::execute);

        System.out.println("Done.");
    }

    record Input(int a, int b, String op) {
        public void execute() {
            System.out.println("10 %s 5 = %d".formatted(op, StrategyFactory.getStrategy(op).execute(a, b)));
        }
    }

}
