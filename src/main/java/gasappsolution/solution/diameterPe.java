package gasappsolution.solution;

import java.util.ArrayList;

public class diameterPe {
   private double Dr = 0;
   private double Ds = 0;


     public diameterPe() {
        ArrayList<Integer> list_diameters = new ArrayList<Integer>();
        list_diameters.add(0, 20);
        list_diameters.add(1, 25);
        list_diameters.add(2, 32);
        list_diameters.add(3, 40);
        list_diameters.add(4, 50);
        list_diameters.add(5, 63);
        list_diameters.add(6, 75);
        list_diameters.add(7, 90);
        list_diameters.add(8, 110);
        list_diameters.add(9, 125);
        list_diameters.add(10, 140);
        list_diameters.add(11, 160);
        list_diameters.add(12, 180);
        list_diameters.add(13, 200);
        list_diameters.add(14, 225);
        list_diameters.add(15, 250);
        list_diameters.add(16, 280);
        list_diameters.add(17, 315);
        list_diameters.add(18, 355);
        list_diameters.add(19, 400);
        list_diameters.add(20, 450);
        list_diameters.add(21, 500);

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
        this.Ds = Ds;
    }

    public double getDiam(){
      return Ds;
    }

   public void setDiam(double Dr){
      this.Dr = Dr;
   }
}
