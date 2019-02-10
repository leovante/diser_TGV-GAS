package gasappsolution.paramPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class NatureGas implements Gas {
    double vv = 14.3 * 0.000001; //коэффициент кинематической вязкости
    double density;


    @Override
    public double getVv() {
        return vv;
    }

    @Override
    public double getDensity() {
        return density;
    }

    @Override
    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public Map create () {
        Map<GasComponents, Double> comp = new LinkedHashMap<>();
        comp.put(GasComponents.CH4, 68.5);
        comp.put(GasComponents.C2H6, 14.5);
        comp.put(GasComponents.C3H8, 7.6);
        comp.put(GasComponents.C4H10, 3.5);
        comp.put(GasComponents.C5H12, 1.0);
        comp.put(GasComponents.N2, 3.5);
        comp.put(GasComponents.CO2, 1.4);
        comp.put(GasComponents.CO, 0.0);
        comp.put(GasComponents.H2S, 0.0);
        comp.put(GasComponents.H2, 0.0);
        comp.put(GasComponents.H2O, 0.0);
        comp.put(GasComponents.O2, 0.0);
        return comp;
        }
}