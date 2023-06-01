package dev.iuhoay.cor;

public abstract class Handler {
    private Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public void handleRequest(int request) {
        if (handle(request)) {
            return;
        }
        if (next != null) {
            next.handleRequest(request);
        }
    }

    protected abstract boolean handle(int request);
}
