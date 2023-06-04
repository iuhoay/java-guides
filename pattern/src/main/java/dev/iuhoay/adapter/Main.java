package dev.iuhoay.adapter;

public class Main {
    public static void main(String[] args) {
        AmericanPlug americanPlug = new PlugAdapter(new EuropeanPlugImpl());
        americanPlug.drawPower();
    }
}
