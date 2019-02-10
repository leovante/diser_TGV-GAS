package gasappsolution.speedPage;

import gasappsolution.UserData;
import gasappsolution.hydraulicPage.Pressure.Pressure;
import gasappsolution.hydraulicPage.TapHydraulic;
import gasappsolution.hydraulicPage.Tube.Tube;
import gasappsolution.paramPage.Gas;
import gasappsolution.paramPage.GasParam;

import static java.lang.Math.log10;

public class TapSpeed {
    private Gas gas;
    private GasParam gasParam;
    private Pressure pressure;
    private Tube tube;
    private UserData userData;
    private TapHydraulic tapHydraulic;

    final double Pn = 0.101325;
    final double zn = 0.9981;
    final double Tn = 273.15;

    double m1const = 5;    //коэффициент в СП 42.101.2003 таблица 7
    double mconst = 2;     //коэффициент в СП 42.101.2003 таблица 7
    double Bconst = 0.022; //коэффициент в СП 42.101.2003 таблица 7
    double Aconst = 626;   //коэффициент в СП 42.101.2003 таблица 6
    double zr = 0.9981;
    double Tr = 273.15;
    double n = 0.01;
    double Pr = 0.101325 + 0.001 * 5;

    double V2;
    double Ds;
    double Re;
    double PnPk;
    double PaUd;

    public TapSpeed(Gas gas
            , GasParam gasParam
            , Pressure pressure
            , Tube tube
            , UserData userData
            , TapHydraulic tapHydraulic) {
        this.gas = gas;
        this.gasParam = gasParam;
        this.pressure = pressure;
        this.tube = tube;
        this.userData = userData;
        this.tapHydraulic = tapHydraulic;
        Ds2();
        getReynolds();
        V2();
        PnPk();
    }

    // Диаметр стандартный
    public void Ds2() {
        Ds = userData.getDs2();
    }

    //число Рейнольдса
    public void getReynolds() {
        this.Re = 0.0354 * userData.getRashod2() / (Ds / 10 * gas.getVv());
    }

    //Лямбда
    public double getlambda() {
        double lambda = 0;
        if (Re < 2000) {
            lambda = 64 / Re;
        }
        if (Re > 2000 && Re < 4000) {
            lambda = 0.0025 * Math.pow(Re, 0.333);
        }
        if (Re > 4000) {
            if (n / Ds < 23) {
                if (Re > 4000 && Re < 100000) {
                    lambda = 0.3164 / Math.pow(Re, 0.25);
                }
                if (Re > 100000) {
                    lambda = 1 / (Math.pow(1.821 * log10(Re) - 1.64, 2));
                }
            } else {
                lambda = 0.11 * Math.pow(n / Ds + 68 / Re, 0.25);
            }
        }
        return lambda;
    }

    // Скорость
    public void V2() {
        this.V2 = 4 * userData.getRashod1() * Pn * zr * Tr / (Ds * Ds * Pr * Tn * Math.PI * zn * 3.6) * 1000;
    }

    // Падение давления
    public void PnPk() {
        this.PnPk = pressure.getPressureLost(
                getlambda()
                , userData.getRashod1()
                , userData.getDensity()
                , userData.getLength()
                , Ds);
    }

    public double getV2() {
        return V2;
    }

    public double getDs() {
        return Ds;
    }

    public double getRe() {
        return Re;
    }

    public double getPnPk() {
        return PnPk;
    }

    public double getPaUd() {
        return PaUd;
    }
}