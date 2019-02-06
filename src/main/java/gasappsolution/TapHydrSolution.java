package gasappsolution;

import gasappsolution.hydraulicPage.PressSolution;
import gasappsolution.sortament.DiameterSteel;
import gasappsolution.hydraulicPage.ReSolution;

public class TapHydrSolution {
    public double m1const = 5;    //коэффициент в СП 42.101.2003 таблица 7
    public double mconst = 2;     //коэффициент в СП 42.101.2003 таблица 7
    public double Bconst = 0.022; //коэффициент в СП 42.101.2003 таблица 7
    public double Aconst = 626;   //коэффициент в СП 42.101.2003 таблица 6
    public final double Pn = 0.101325;
    public final double zn = 0.9981;
    public final double Tn = 273.15;
    public double zr = 0.9981;
    public double Tr = 273.15;
    public double n = 0.01;
    public double Pr = 0.101325 + 0.001 * 5;

    // Диаметр расчетный
    public double Dr(double Density, double Rashod1, double PaUd) {
        double Dr = Math.pow((Aconst * Bconst * Density * Math.pow(Rashod1, mconst)) / PaUd, 1 / m1const) * 10;
        return Dr;
    }
    // Диаметр стандартный
    public double Ds1(double Dr) {
        DiameterSteel Diameters = new DiameterSteel();
        double Dstandart = Diameters.getDiam(Dr);
        double Ds1 = (double) Dstandart;
        return Ds1;
    }
    // Падение давления
    public double PnPk(double Ds1, double Re1, double Rashod1, double Density, double Length) {
        ReSolution reynoldsSolution = new ReSolution();
        Ds1 = Ds1 / 10;
        double lambda1 = reynoldsSolution.getlambda(Ds1, Re1, n);
        PressSolution pressure = new PressSolution();
        double PnPk = pressure.getPressureLost(lambda1, Rashod1, Density, Length, Ds1);
        return PnPk;
    }
    // Скорость
    public double V1(double Rashod1, double Ds1) {
        double V1 = 4 * Rashod1 * Pn * zr * Tr / (Ds1 * Ds1 * Pr * Tn * Math.PI * zn * 3.6) * 1000;
        return V1;
    }
}