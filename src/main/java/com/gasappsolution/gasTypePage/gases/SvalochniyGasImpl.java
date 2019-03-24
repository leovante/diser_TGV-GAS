package com.gasappsolution.gasTypePage.gases;

public class SvalochniyGasImpl implements Gas {
    private final double CH4 = 0.685;
    private final double C2H6 = 0.145;
    private final double C3H8 = 0.076;
    private final double C4H10 = 0.035;
    private final double C5H12 = 0.01;
    private final double N2 = 0.035;
    private final double CO2 = 0.014;
    private final double CO = 0.0;
    private final double H2S = 0.0;
    private final double H2 = 0.0;
    private final double H2O = 0.0;
    private final double O2 = 0.0;
    private final double other = 0.0;
    private final double vv = 14.3 * 0.000001; //коэффициент кинематической вязкости

    @Override
    public Gas create() {
        return this;
    }

    @Override
    public double getCH4() {
        return CH4;
    }

    @Override
    public double getC2H6() {
        return C2H6;
    }

    @Override
    public double getC3H8() {
        return C3H8;
    }

    @Override
    public double getC4H10() {
        return C4H10;
    }

    @Override
    public double getC5H12() {
        return C5H12;
    }

    @Override
    public double getN2() {
        return N2;
    }

    @Override
    public double getCO2() {
        return CO2;
    }

    @Override
    public double getCO() {
        return CO;
    }

    @Override
    public double getH2S() {
        return H2S;
    }

    @Override
    public double getH2() {
        return H2;
    }

    @Override
    public double getH2O() {
        return H2O;
    }

    @Override
    public double getO2() {
        return O2;
    }

    @Override
    public double getOther() {
        return other;
    }

    @Override
    public double getVv() {
        return vv;
    }
}