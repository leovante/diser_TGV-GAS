package com.gasappsolution.hydraulicPage.Tube;

public interface Tube {
    Tube param();

    double getN();

    double getM1const();

    double getMconst();

    double getBconst();

    double getDs(double Dr);
}
