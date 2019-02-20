package com.gasappsolution.hydraulicPage.Pressure;

public class LowPressureLost implements Pressure {
    double Pr = 0.101325 + 0.001 * 5;
    double Pm;
    final double Acons = 626;
    double daPa = 180;

    LowPressureLost lowPressureLost;

    @Override
    public LowPressureLost param() {
        return lowPressureLost;
    }

    @Override
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2) {
        return 626.1 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2 / 10, 5));
    }

    @Override
    public double getDaPa() {
        return daPa;
    }

    @Override
    public double getPm() {
        return Pm;
    }

    @Override
    public double getAconst() {
        return Acons;
    }
}