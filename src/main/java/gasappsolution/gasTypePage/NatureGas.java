package gasappsolution.gasTypePage;

import java.util.LinkedHashMap;
import java.util.Map;

import static gasappsolution.gasTypePage.GasComponents.*;

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
        comp.put(CH4, 68.5);
        comp.put(C2H6, 14.5);
        comp.put(C3H8, 7.6);
        comp.put(C4H10, 3.5);
        comp.put(C5H12, 1.0);
        comp.put(N2, 3.5);
        comp.put(CO2, 1.4);
        comp.put(CO, 0.0);
        comp.put(H2S, 0.0);
        comp.put(H2, 0.0);
        comp.put(H2O, 0.0);
        comp.put(O2, 0.0);
        comp.put(other, 0.0);
        return comp;
        }
}