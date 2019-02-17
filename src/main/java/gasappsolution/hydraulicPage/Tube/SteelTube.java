package gasappsolution.hydraulicPage.Tube;

import java.util.ArrayList;

public class SteelTube implements Tube {
    double n = 0.01;
    double mconst = 2;
    double m1const = 5;
    double Bconst = 0.022;

    @Override
    public SteelTube param() {
        return this;
    }

    @Override
    public double getN() {
        return n;
    }

    @Override
    public double getM1const() {
        return m1const;
    }

    @Override
    public double getMconst() {
        return mconst;
    }

    @Override
    public double getBconst() {
        return Bconst;
    }

    @Override
    public double getDs(double Dr) {
        ArrayList<Integer> diamList = new ArrayList<Integer>();
        diamList.add(0, 6);
        diamList.add(1, 8);
        diamList.add(2, 10);
        diamList.add(3, 15);
        diamList.add(4, 20);
        diamList.add(5, 25);
        diamList.add(6, 32);
        diamList.add(7, 40);
        diamList.add(8, 50);
        diamList.add(9, 65);
        diamList.add(10, 80);
        diamList.add(11, 90);
        diamList.add(12, 100);
        diamList.add(13, 125);
        diamList.add(14, 150);
        diamList.add(15, 200);
        diamList.add(16, 250);
        diamList.add(17, 300);
        diamList.add(18, 350);
        diamList.add(19, 414);
        diamList.add(20, 518);
        diamList.add(21, 616);
        diamList.add(22, 704);
        diamList.add(23, 802);

        double Ds = 0;
        if (Dr < diamList.get(diamList.size() - 1)) {
            for (int i = 0; diamList.get(i) < Dr; i++) {
                Ds = diamList.get(i + 1);
            }
        } else {
            Ds = diamList.get(diamList.size() - 1);
        }
        return Ds;
    }
}