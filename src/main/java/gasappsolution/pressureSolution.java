package gasappsolution;

import gasappsolution.mainController;

public class pressureSolution {
    /**
     * Здесь происходит расчет удельных потерь давления (низкого или высокого)
     * А так же расчет потерь давления
     */
    public double getPaUd(double dPa, double Length){
        int x = mainController.x;

        double PaUd = 0;
        if (x == 1){
            PaUd = dPa * 10 / (Length * 1.1);
        }
        if (x == 2){
            PaUd = dPa * 10 / (Length * 1.1);
        }
        return PaUd;
    }
    public double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2){
        int x = mainController.x;
        double PnPk = 0;
        if (x == 1){
             PnPk = 626.1 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5));
        }
        if (x == 2){
             PnPk = Math.sqrt(1.2687*0.0001 * lambda * Rashod * Rashod * Density * Length * 1.1 / (Math.pow(Ds2, 5)));
        }
        return PnPk;
    }
}