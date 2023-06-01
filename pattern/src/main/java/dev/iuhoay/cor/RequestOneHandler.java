package dev.iuhoay.cor;

public class RequestOneHandler extends Handler {
    @Override
    protected boolean handle(int request) {
        if (request >= 0 && request < 10) {
            System.out.println("ConcreteHandler1 handles " + request);
            return true;
        }
        return false;
    }
}
