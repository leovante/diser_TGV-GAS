package gasappsolution.solution;

import java.util.ArrayList;

public class TubeSolution {
    private static double Dr = 0;
    private static double Ds = 0;
    private static String type = "Сталь";

    public static void Solution(double Dr) {
        ArrayList<Integer> listSteelDiameters = new ArrayList<Integer>();
        listSteelDiameters.add(0, 6);
        listSteelDiameters.add(1, 8);
        listSteelDiameters.add(2, 10);
        listSteelDiameters.add(3, 15);
        listSteelDiameters.add(4, 20);
        listSteelDiameters.add(5, 25);
        listSteelDiameters.add(6, 32);
        listSteelDiameters.add(7, 40);
        listSteelDiameters.add(8, 50);
        listSteelDiameters.add(9, 65);
        listSteelDiameters.add(10, 80);
        listSteelDiameters.add(11, 90);
        listSteelDiameters.add(12, 100);
        listSteelDiameters.add(13, 125);
        listSteelDiameters.add(14, 150);
        listSteelDiameters.add(15, 200);
        listSteelDiameters.add(16, 250);
        listSteelDiameters.add(17, 300);
        listSteelDiameters.add(18, 350);
        listSteelDiameters.add(19, 414);
        listSteelDiameters.add(20, 518);
        listSteelDiameters.add(21, 616);
        listSteelDiameters.add(22, 704);
        listSteelDiameters.add(23, 802);

        ArrayList<Integer> listPolyethyleneDiameters = new ArrayList<Integer>();
        listPolyethyleneDiameters.add(0, 20);
        listPolyethyleneDiameters.add(1, 25);
        listPolyethyleneDiameters.add(2, 32);
        listPolyethyleneDiameters.add(3, 40);
        listPolyethyleneDiameters.add(4, 50);
        listPolyethyleneDiameters.add(5, 63);
        listPolyethyleneDiameters.add(6, 75);
        listPolyethyleneDiameters.add(7, 90);
        listPolyethyleneDiameters.add(8, 110);
        listPolyethyleneDiameters.add(9, 125);
        listPolyethyleneDiameters.add(10, 140);
        listPolyethyleneDiameters.add(11, 160);
        listPolyethyleneDiameters.add(12, 180);
        listPolyethyleneDiameters.add(13, 200);
        listPolyethyleneDiameters.add(14, 225);
        listPolyethyleneDiameters.add(15, 250);
        listPolyethyleneDiameters.add(16, 280);
        listPolyethyleneDiameters.add(17, 315);
        listPolyethyleneDiameters.add(18, 355);
        listPolyethyleneDiameters.add(19, 400);
        listPolyethyleneDiameters.add(20, 450);
        listPolyethyleneDiameters.add(21, 500);

        if (type == "Полиэтилен") {
            double Ds = listPolyethyleneDiameters.get(0);
            if (Dr < listPolyethyleneDiameters.get(listPolyethyleneDiameters.size() - 1)) {
                for (int i = 0; listPolyethyleneDiameters.get(i) < Dr; i++) {
                    Ds = listPolyethyleneDiameters.get(i);
                }
            } else {
                Ds = listPolyethyleneDiameters.get(listPolyethyleneDiameters.size() - 1);
            }
            TubeSolution.Ds = Ds;
        }
        if (type == "Сталь") {
            int i = 0;
            double Ds = listSteelDiameters.get(0);
            if (Dr < listSteelDiameters.get(listSteelDiameters.size() - 1)) {
                while (listSteelDiameters.get(i) < Dr) {
                    Ds = listSteelDiameters.get(i + 1);
                    i++;
                }
            } else {
                Ds = listSteelDiameters.get(listSteelDiameters.size() - 1);
            }
            TubeSolution.Ds = Ds;
        }
    }

    public static double getDs() {
        return Ds;
    }

    public void setType(String type) {
        this.type = type;
    }
}
