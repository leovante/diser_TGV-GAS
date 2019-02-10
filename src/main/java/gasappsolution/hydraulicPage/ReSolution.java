/**
 * Здесь происходит расчет рейнольдса в зависимости от:
 * Расхода и диаметра
 * <p>
 * А также здесь рассчитывается лямбда в зависимости от:
 * диамтера, рейнольдса и шероховатости трубы
 */
package gasappsolution.hydraulicPage;

import static java.lang.Math.log10;

public class ReSolution {
//    double Re;
//    double D;
//    double vv;
//    double n;
//    double q;
//
//    public ReSolution(double d, double vv, double n, double q) {
//        D = d;
//        this.vv = vv;
//        this.n = n;
//        this.q = q;
//    }
//
//    public ReSolution getReynolds() {
//        this.Re = 0.0354 * q / (D / 10 * vv);
//        return this;
//    }
//
//    public double getlambda() {
//        double lambda = 0;
//        if (Re < 2000) {
//            lambda = 64 / Re;
//        }
//        if (Re > 2000 && Re < 4000) {
//            lambda = 0.0025 * Math.pow(Re, 0.333);
//        }
//        if (Re > 4000) {
//            if (n / D < 23) {
//                if (Re > 4000 && Re < 100000) {
//                    lambda = 0.3164 / Math.pow(Re, 0.25);
//                }
//                if (Re > 100000) {
//                    lambda = 1 / (Math.pow(1.821 * log10(Re) - 1.64, 2));
//                }
//            } else {
//                lambda = 0.11 * Math.pow(n / D + 68 / Re, 0.25);
//            }
//        }
//        return lambda;
//    }
}