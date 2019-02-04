package gasappsolution.gases;

import java.util.LinkedHashMap;
import java.util.Map;

import static gasappsolution.gases.GasComponents.CH4;

public class Biogas implements Gas {

    @Override
    public Map create () {
        Map<GasComponents, Double> comp = new LinkedHashMap<>();
        comp.put(CH4, 3.3);
        comp.put(GasComponents.C2H6, 3.3);
        comp.put(GasComponents.C3H8, 3.3);
        comp.put(GasComponents.C4H10, 3.3);
        comp.put(GasComponents.C5H12, 3.3);
        comp.put(GasComponents.N2, 3.3);
        comp.put(GasComponents.CO2, 3.3);
        comp.put(GasComponents.CO, 3.3);
        comp.put(GasComponents.H2S, 3.3);
        comp.put(GasComponents.H2, 3.3);
        comp.put(GasComponents.H2O, 3.3);
        comp.put(GasComponents.O2, 3.3);
        return comp;
    }
}