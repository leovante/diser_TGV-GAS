package gasappsolution.paramPage;

import java.util.LinkedHashMap;
import java.util.Map;

import static gasappsolution.paramPage.GasComponents.*;

public class Biogas implements Gas {

    @Override
    public Map create () {
        Map<GasComponents, Double> comp = new LinkedHashMap<>();
        comp.put(CH4, 63.0);
        comp.put(C2H6, 0.0);
        comp.put(C3H8, 0.0);
        comp.put(C4H10, 0.0);
        comp.put(C5H12, 0.0);
        comp.put(N2, 0.0);
        comp.put(CO2, 33.0);
        comp.put(CO, 0.0);
        comp.put(H2S, 2.0);
        comp.put(H2, 1.0);
        comp.put(H2O, 0.0);
        comp.put(O2, 0.0);
        return comp;
    }
}