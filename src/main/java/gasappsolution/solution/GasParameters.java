package gasappsolution.solution;

import gasappsolution.Components;
import gasappsolution.gases.Gas;

import javax.swing.*;
import java.awt.*;

public class GasParameters implements Components {
    private double CH4;
    private double C2H6;
    private double C3H8;
    private double C4H10;
    private double C5H12;
    private double N2;
    private double CO2;
    private double CO;
    private double H2S;
    private double H2;
    private double H2O;
    private double O2;

    private double Qnc;
    private double Qvc;
    private double viscosityKinematic;
    private double Wobbe;
    private double dencityNormalConditions;
    private double capacity;


    public GasParameters(Gas gas) {
        try {
            this.CH4 = (double) gas.param().get(CH4);
            this.C2H6 = (double) gas.param().get(C2H6);
            this.C3H8 = (double) gas.param().get(C3H8);
            this.C4H10 = (double) gas.param().get(C4H10);
            this.C5H12 = (double) gas.param().get(C5H12);
            this.N2 = (double) gas.param().get(N2);
            this.CO2 = (double) gas.param().get(CO2);
            this.CO = (double) gas.param().get(CO);
            this.H2S = (double) gas.param().get(H2S);
            this.H2 = (double) gas.param().get(H2);
            this.H2O = (double) gas.param().get(H2O);
            this.O2 = (double) gas.param().get(O2);
        }
        catch(NullPointerException e){
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Ты шо на ноль делишь?",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public double getCH4() {
        return CH4;
    }

    public double getC2H6() {
        return C2H6;
    }

    public double getC3H8() {
        return C3H8;
    }

    public double getC4H10() {
        return C4H10;
    }

    public double getC5H12() {
        return C5H12;
    }

    public double getN2() {
        return N2;
    }

    public double getCO2() {
        return CO2;
    }

    public double getCO() {
        return CO;
    }

    public double getH2S() {
        return H2S;
    }

    public double getH2() {
        return H2;
    }

    public double getH2O() {
        return H2O;
    }

    public double getO2() {
        return O2;
    }

    public double getQnc() {
        return Qnc;
    }

    public double getQvc() {
        return Qvc;
    }

    public GasParameters solution(){

        return null;
    }
}