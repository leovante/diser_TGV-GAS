package gasappsolution.hydraulicPage.Pressure;

public class LowPressureLost implements Pressure {
    LowPressureLost lowPressureLost;
    double Pr = 0.101325 + 0.001 * 5;
    double Aconst = 626;

    @Override
    public LowPressureLost param() {
        return lowPressureLost;
    }

    @Override
    public double getPaUd(double dPa, double Length) {
        return dPa * 10 / (Length * 1.1);
    }

    @Override
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2) {
        return 626.1 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5));
    }
}