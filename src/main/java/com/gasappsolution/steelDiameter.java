package com.gasappsolution;

import java.util.ArrayList;

public class steelDiameter {
     double getDiameters(double Dr) {
        ArrayList<Integer> list_diameters = new ArrayList<Integer>();
        list_diameters.add(0, 6);
        list_diameters.add(1, 8);
        list_diameters.add(2, 10);
        list_diameters.add(3, 15);
        list_diameters.add(4, 20);
        list_diameters.add(5, 25);
        list_diameters.add(6, 32);
        list_diameters.add(7, 40);
        list_diameters.add(8, 50);
        list_diameters.add(9, 65);
        list_diameters.add(10, 80);
        list_diameters.add(11, 90);
        list_diameters.add(12, 100);
        list_diameters.add(13, 125);
        list_diameters.add(14, 150);
        list_diameters.add(15, 200);
        list_diameters.add(16, 250);
        list_diameters.add(17, 300);
        list_diameters.add(18, 350);
        list_diameters.add(19, 414);
        list_diameters.add(20, 518);
        list_diameters.add(21, 616);
        list_diameters.add(22, 704);
        list_diameters.add(23, 802);

        int i = 0;
        double Ds = list_diameters.get(0);
        if (Dr<802) {
            while (list_diameters.get(i) < Dr) {
                Ds = list_diameters.get(i + 1);
                i++;
            }
        }
        else{
            Ds = list_diameters.get(list_diameters.size()-1);
        }

        return Ds;
    }
}
