package gasappsolution;

import gasappsolution.gases.Biogas;
import gasappsolution.gases.NatureGas;

public interface GasType {
    NatureGas natureGas = new NatureGas();
    Biogas bioGas = new Biogas();
}
