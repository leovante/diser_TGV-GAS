package com.gasappsolution.hydraulicPage.Pressure;

public interface Pressure {
    Pressure param();

    double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2);

    double getDaPa();

    double getPm();

    double getAconst();
}
