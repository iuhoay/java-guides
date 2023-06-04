package dev.iuhoay.adapter;

public class PlugAdapter implements AmericanPlug {
    private EuropeanPlug plug;

    PlugAdapter(EuropeanPlug plug) {
        this.plug = plug;
    }

    @Override
    public void drawPower() {
        plug.provideElectricity();
    }

}
