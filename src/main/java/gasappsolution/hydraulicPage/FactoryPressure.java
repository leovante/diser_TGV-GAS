package gasappsolution.hydraulicPage;

public class FactoryPressure implements AbstractFactoryPressure {
    @Override
    public Pressure getPressure(PressureType type) {
        if (type == PressureType.low) {
            return new LowPressureLost();
        } else if (type == PressureType.hight) {
            return new HightPressureLost();
        }
        return null;
    }
}
