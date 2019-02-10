package gasappsolution.hydraulicPage.Pressure;

public interface Pressure {
    Pressure param();

    double getPaUd(double dPa, double Length);

    double getPressureLost(double lambda, double Rashod, double Density, double Length, double Ds2);

    double getdPa();

    double getsPr();
}
