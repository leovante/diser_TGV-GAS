package gasappsolution.gases;

import gasappsolution.Components;

import java.util.LinkedHashMap;
import java.util.Map;

public class NatureGas implements Gas, Components {

    @Override
    public Map param () {
        Map<String, Double> comp = new LinkedHashMap<String, Double>();
        comp.put(CH4, 4.4);
        comp.put(C2H6, 4.4);
        comp.put(C3H8, 4.4);
        comp.put(C4H10, 4.4);
        comp.put(C5H12, 4.4);
        comp.put(N2, 4.4);
        comp.put(CO2, 4.4);
        comp.put(CO, 4.4);
        comp.put(H2S, 4.4);
        comp.put(H2, 4.4);
        comp.put(H2O, 4.4);
        comp.put(O2, 4.4);
        return comp;
        }
}
