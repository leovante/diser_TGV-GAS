package gasappsolution.solution;
import static java.lang.Math.log10;

/**Здесь происходит расчет рейнольдса в зависимости от:
 * Расхода и диаметра
 *
 * А также здесь рассчитывается лямбда в зависимости от:
 * диамтера, рейнольдса и шероховатости трубы
 */
public class ReynoldsSolution {
    double vv = 14.3 * 0.000001; //коэффициент кинематической вязкости

    public double getReynolds(double Rashod, double D) {
        double Re = 0.0354 * Rashod / (D * vv);
        return Re;
    }

    public double getlambda(double D, double Re, double n) {
        double lambda = 0;
        if (Re < 2000) {
            lambda = 64 / Re;
        }
        if (Re > 2000 && Re < 4000) {
            lambda = 0.0025 * Math.pow(Re, 0.333);
        }
        if (Re > 4000) {
            if (n / D < 23) {
                if (Re > 4000 && Re < 100000) {
                    lambda = 0.3164 / Math.pow(Re, 0.25);
                }
                if (Re > 100000) {
                    lambda = 1 / (Math.pow(1.821 * log10(Re) - 1.64, 2));
                }
            } else {
                lambda = 0.11 * Math.pow(n / D + 68 / Re, 0.25);
            }
        }
        return lambda;
    }
}