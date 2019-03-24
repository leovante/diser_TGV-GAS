package com.gasappsolution.gasTypePage.gases;

import java.util.Map;

public interface Gas {
    double getVv();

    Gas create();

    double getCH4();

    double getC2H6();

    double getC3H8();

    double getC4H10();

    double getC5H12();

    double getN2();

    double getCO2();

    double getCO();

    double getH2S();

    double getH2();

    double getH2O();

    double getO2();

    double getOther();
}