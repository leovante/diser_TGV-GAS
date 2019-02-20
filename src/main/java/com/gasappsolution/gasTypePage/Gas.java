package com.gasappsolution.gasTypePage;

import java.util.Map;

public interface Gas {
    double getVv();

    double getDensity();

    void setDensity(double density);

    Map create();
}
