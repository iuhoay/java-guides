package dev.iuhoay.cor;

/**
 * "Chain of Responsibility" pattern.
 *
 * <p>
 * The Chain of Responsibility pattern is a behavioral pattern that allows you to pass requests along a chain of handlers.
 */
public class Main {
    public static void main(String[] args) {
        Handler handler1 = new RequestOneHandler();
        Handler handler2 = new RequestTwoHandler();
        handler1.setNextHandler(handler2);

        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};

        for (int request : requests) {
            System.out.println("Request: " + request);
            handler1.handleRequest(request);
        }
        System.out.println("Done.");
    }
}
