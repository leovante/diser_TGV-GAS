package gasappsolution.gases;

import gasappsolution.Components;

import java.util.LinkedHashMap;
import java.util.Map;

public class Biogas implements Gas, Components {

    @Override
    public Map param () {
        Map<String, Double> comp = new LinkedHashMap<>();
        comp.put(CH4, 3.3);
        comp.put(C2H6, 3.3);
        comp.put(C3H8, 3.3);
        comp.put(C4H10, 3.3);
        comp.put(C5H12, 3.3);
        comp.put(N2, 3.3);
        comp.put(CO2, 3.3);
        comp.put(CO, 3.3);
        comp.put(H2S, 3.3);
        comp.put(H2, 3.3);
        comp.put(H2O, 3.3);
        comp.put(O2, 3.3);
        return comp;
    }
}