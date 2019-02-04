package gasappsolution.gases;

import java.util.LinkedHashMap;
import java.util.Map;

public class NatureGas implements Gas {

    @Override
    public Map create () {
        Map<GasComponents, Double> comp = new LinkedHashMap<>();
        comp.put(GasComponents.CH4, 4.4);
        comp.put(GasComponents.C2H6, 4.4);
        comp.put(GasComponents.C3H8, 4.4);
        comp.put(GasComponents.C4H10, 4.4);
        comp.put(GasComponents.C5H12, 4.4);
        comp.put(GasComponents.N2, 4.4);
        comp.put(GasComponents.CO2, 4.4);
        comp.put(GasComponents.CO, 4.4);
        comp.put(GasComponents.H2S, 4.4);
        comp.put(GasComponents.H2, 4.4);
        comp.put(GasComponents.H2O, 4.4);
        comp.put(GasComponents.O2, 4.4);
        return comp;
        }
}