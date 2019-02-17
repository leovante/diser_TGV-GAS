/**
 * Расчет удельных потерь давления (низкого или высокого)
 * Расчет потерь давления
 */
package gasappsolution.hydraulicPage.Pressure;

public class HightPressureLost implements Pressure {
    double Pr = 0.101325 + 0.3;
    double Pm = 0.325; //усредненное давление газа (абсолютное в сети)
    double P0 = 0.101325;
    double Aconst = P0 / (Pm * 162 * Math.PI * Math.PI);
    double dPa = 0.18;

    HightPressureLost hightPressureLost;

    @Override
    public HightPressureLost param() {
        return hightPressureLost;
    }

    @Override
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2) {
        return Math.sqrt(1.2687 * 0.0001 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5)));
    }

    @Override
    public double getDaPa() {
        return dPa;
    }

    @Override
    public double getPm() {
        return Pm;
    }

    @Override
    public double getAconst() {
        return Aconst;
    }
}