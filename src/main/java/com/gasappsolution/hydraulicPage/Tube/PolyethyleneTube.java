package com.gasappsolution.hydraulicPage.Tube;

import java.util.ArrayList;

public class PolyethyleneTube implements Tube {
    double n = 0.0007;
    double mconst = 1.75;
    double m1const = 4.75;
    double Bconst = 0.0446;

    @Override
    public PolyethyleneTube param() {
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
        diamList.add(0, 20);
        diamList.add(1, 25);
        diamList.add(2, 32);
        diamList.add(3, 40);
        diamList.add(4, 50);
        diamList.add(5, 63);
        diamList.add(6, 75);
        diamList.add(7, 90);
        diamList.add(8, 110);
        diamList.add(9, 125);
        diamList.add(10, 140);
        diamList.add(11, 160);
        diamList.add(12, 180);
        diamList.add(13, 200);
        diamList.add(14, 225);
        diamList.add(15, 250);
        diamList.add(16, 280);
        diamList.add(17, 315);
        diamList.add(18, 355);
        diamList.add(19, 400);
        diamList.add(20, 450);
        diamList.add(21, 500);

        double Ds = 0;
        if (Dr < diamList.get(diamList.size() - 1)) {
            for (int i = 0; diamList.get(i) < Dr; i++) {
                Ds = diamList.get(i);
            }
        } else {
            Ds = diamList.get(diamList.size() - 1);
        }
        return Ds;
    }
}