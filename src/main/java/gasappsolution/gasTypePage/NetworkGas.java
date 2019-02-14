package gasappsolution.gasTypePage;

import java.util.LinkedHashMap;
import java.util.Map;

import static gasappsolution.gasTypePage.GasComponents.*;
import static gasappsolution.gasTypePage.GasComponents.H2O;
import static gasappsolution.gasTypePage.GasComponents.O2;

public class NetworkGas implements Gas{
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
    public Map create() {
        Map<GasComponents, Double> comp = new LinkedHashMap<>();
        comp.put(CH4, 96.5);
        comp.put(C2H6, 1.87);
        comp.put(C3H8, 0.59);
        comp.put(C4H10, 0.093);
        comp.put(C5H12, 0.0173);
        comp.put(N2, 0.667);
        comp.put(CO2, 0.134);
        comp.put(CO, 0.0);
        comp.put(H2S, 0.0);
        comp.put(H2, 0.0011);
        comp.put(H2O, 0.0);
        comp.put(O2, 0.005);
        comp.put(other, 1.0);
        return comp;
    }
}
