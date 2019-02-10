/**
 * Расчет удельных потерь давления (низкого или высокого)
 * Расчет потерь давления
 */
package gasappsolution.hydraulicPage.Pressure;

public class HightPressureLost implements Pressure {
    HightPressureLost hightPressureLost;
    double Pr = 0.101325 + 0.3;
    double sPr = 0.325;
    double Aconst = 0.101325 / (sPr * 162 * Math.PI * Math.PI);

    @Override
    public HightPressureLost param() {
        return hightPressureLost;
    }

    @Override
    public double getPaUd(double dPa, double Length) {
        return dPa * 10 / (Length * 1.1);
    }

    @Override
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2) {
        return Math.sqrt(1.2687 * 0.0001 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5)));
    }
}