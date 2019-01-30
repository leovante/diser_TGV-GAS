package gasappsolution;

public class PressureSolution extends MainController {
    /**
     * Здесь расчет удельных потерь давления (низкого или высокого)
     * А так же расчет потерь давления
     */
    public double getPaUd(double dPa, double Length){

        double PaUd = 0;
        if (mItem.equals(lowPressure)){
            PaUd = dPa * 10 / (Length * 1.1);
        }
        if (mItem.equals(hightPressure)){
            PaUd = dPa * 10 / (Length * 1.1);
        }
        return PaUd;
    }
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2){
        double PnPk = 0;
        if (mItem.equals(lowPressure)){
             PnPk = 626.1 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5));
        }
        if (mItem.equals(hightPressure)){
             PnPk = Math.sqrt(1.2687*0.0001 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5)));
        }
        return PnPk;
    }
}