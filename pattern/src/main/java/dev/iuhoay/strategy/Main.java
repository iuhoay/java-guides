package dev.iuhoay.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println("Strategy:");
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        System.out.println("--------------------");

        System.out.println("Strategy Factory:");

        String[] ops = {"+", "-", "*"};

        Arrays.stream(ops)
                .map(Main::execute)
                .forEach(System.out::println);

        System.out.println("Done.");
    }

    private static String execute(String op) {
        return "10 %s 5 = %d".formatted(op, StrategyFactory.getStrategy(op).execute(10, 5));
    }

}
