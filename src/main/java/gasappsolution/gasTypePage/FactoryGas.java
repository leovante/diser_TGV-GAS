package gasappsolution.gasTypePage;

import javax.swing.*;
import java.awt.*;

public class FactoryGas implements AbstractFactoryGas {
    @Override
    public Gas getGas(GasType type) {
        try {
            if (type == GasType.Biogas) {
                return new Biogas();
            } else if (type == GasType.NatureGas) {
                return new NatureGas();
            } else if (type == GasType.NetworkGas) {
                return new NetworkGas();
            }
        } catch (NullPointerException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Не найдены параметры данного газа",
                    "Ошибка выбора",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }

//    public Gas getParam(Object object){
//        Gas gas = null;
//        if(object instanceof NatureGas){
//            gas = new NatureGas();
//        } else if (object instanceof Biogas){
//            gas = new Biogas();
//        }
//        return gas;
//    }
/*
    @Override
    public Biogas biogas() {
        return new Biogas();
    }

    @Override
    public NatureGas natureGas() {
        return new NatureGas();
    }
  */


}