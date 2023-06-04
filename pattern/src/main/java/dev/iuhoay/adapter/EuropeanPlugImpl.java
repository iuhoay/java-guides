package dev.iuhoay.adapter;

public class EuropeanPlugImpl implements EuropeanPlug {

    @Override
    public void provideElectricity() {
        System.out.println("Providing electricity to European plug");
    }

}
