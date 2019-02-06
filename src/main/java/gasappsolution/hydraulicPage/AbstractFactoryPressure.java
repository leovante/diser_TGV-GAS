package gasappsolution.hydraulicPage;

import gasappsolution.paramPage.Gas;
import gasappsolution.paramPage.GasType;

public interface AbstractFactoryPressure {

    Pressure getPressure(PressureType type);

}
