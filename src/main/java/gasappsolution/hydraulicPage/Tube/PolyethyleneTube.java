package gasappsolution.hydraulicPage.Tube;

public class PolyethyleneTube implements Tube {
    double n = 0.0007;
    double m1const = 4.75;
    double mconst = 1.75;
    double Bconst = 0.0446;

    @Override
    public PolyethyleneTube param() {
        return this;
    }

    @Override
    public double getN() {
        return 0;
    }

    @Override
    public double getM1const() {
        return 0;
    }

    @Override
    public double getMconst() {
        return 0;
    }

    @Override
    public double getBconst() {
        return 0;
    }
}