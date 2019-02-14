package gasappsolution.gasTypePage;

import java.util.LinkedHashMap;
import java.util.Map;

import static gasappsolution.gasTypePage.GasComponents.*;

public class MassaGases {
    public Map<GasComponents, Double> massa() {
        Map<GasComponents, Double> plotnost = new LinkedHashMap();
        //плотность в кг/м3
        plotnost.put(CH4, 0.7168);
        plotnost.put(C2H6, 1.356);
        plotnost.put(C3H8, 2.0037);
        plotnost.put(C4H10, 2.703);
        plotnost.put(C5H12, 3.457);
        plotnost.put(N2, 1.25);
        plotnost.put(CO2, 1.9768);
        plotnost.put(CO, 1.25);
        plotnost.put(H2S, 1.5392);
        plotnost.put(H2, 0.08987);
        plotnost.put(H2O, 0.768);
        plotnost.put(O2, 1.42895);
        return plotnost;
    }
}