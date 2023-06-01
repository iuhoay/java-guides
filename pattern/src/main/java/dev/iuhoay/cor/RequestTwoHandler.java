package dev.iuhoay.cor;

public class RequestTwoHandler extends Handler {
    @Override
    protected boolean handle(int request) {
        if (request >= 5 && request < 20) {
            System.out.println("ConcreteHandler2 handles " + request);
            return true;
        }
        return false;
    }
}
