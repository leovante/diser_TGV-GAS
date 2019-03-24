package com.gasappsolution.gasTypePage;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.gasappsolution.gasTypePage.EnumComp.*;

public class ComponentsParams {

    public Map<EnumComp, Double> density() {
        //плотность в кг/м3
        Map<EnumComp, Double> density = new LinkedHashMap();
        density.put(CH4, 0.7168);
        density.put(C2H6, 1.356);
        density.put(C3H8, 2.0037);
        density.put(C4H10, 2.703);
        density.put(C5H12, 3.457);
        density.put(N2, 1.25);
        density.put(CO2, 1.9768);
        density.put(CO, 1.25);
        density.put(H2S, 1.5392);
        density.put(H2, 0.08987);
        density.put(H2O, 0.768);
        density.put(O2, 1.42895);
        return density;
    }

    public Map<EnumComp, Double> Qnc() {
        Map<EnumComp, Double> nizTeplotaSgoraniya = new LinkedHashMap();
        nizTeplotaSgoraniya.put(CH4, 35.880);
        nizTeplotaSgoraniya.put(C2H6, 64.360);
        nizTeplotaSgoraniya.put(C3H8, 93.180);
        nizTeplotaSgoraniya.put(C4H10, 123.570);
        nizTeplotaSgoraniya.put(C5H12, 156.630);
        nizTeplotaSgoraniya.put(N2, 0.0);
        nizTeplotaSgoraniya.put(CO2, 0.0);
        nizTeplotaSgoraniya.put(CO, 12.5);
        nizTeplotaSgoraniya.put(H2S, 23.37);
        nizTeplotaSgoraniya.put(H2, 4.1);
        nizTeplotaSgoraniya.put(H2O, 0.0);
        nizTeplotaSgoraniya.put(O2, 0.0);
        return nizTeplotaSgoraniya;
    }

    public Map<EnumComp, Double> Qvc() {
        Map<EnumComp, Double> nizTeplotaSgoraniya = new LinkedHashMap();
        nizTeplotaSgoraniya.put(CH4, 39.820);
        nizTeplotaSgoraniya.put(C2H6, 70.31);
        nizTeplotaSgoraniya.put(C3H8, 101.21);
        nizTeplotaSgoraniya.put(C4H10, 133.8);
        nizTeplotaSgoraniya.put(C5H12, 169.27);
        nizTeplotaSgoraniya.put(N2, 0.0);
        nizTeplotaSgoraniya.put(CO2, 0.0);
        nizTeplotaSgoraniya.put(CO, 12.75);
        nizTeplotaSgoraniya.put(H2S, 25.35);
        nizTeplotaSgoraniya.put(H2, 4.1);
        nizTeplotaSgoraniya.put(H2O, 0.0);
        nizTeplotaSgoraniya.put(O2, 0.0);
        return nizTeplotaSgoraniya;
    }
}