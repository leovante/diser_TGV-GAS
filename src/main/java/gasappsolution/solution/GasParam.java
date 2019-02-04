package gasappsolution.solution;

import gasappsolution.gases.GasComponents;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import static gasappsolution.gases.GasComponents.*;

public class GasParam {
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

    public GasParam(Map gas) {
        try {
            if (gas.get(GasComponents.CH4) != null)
                this.CH4 = (double) gas.get(GasComponents.CH4);
            if (gas.get(GasComponents.C2H6) != null)
                this.C2H6 = (double) gas.get(GasComponents.C2H6);
            if (gas.get(GasComponents.C3H8) != null)
                this.C3H8 = (double) gas.get(GasComponents.C3H8);
            if (gas.get(GasComponents.C4H10) != null)
                this.C4H10 = (double) gas.get(GasComponents.C4H10);
            if (gas.get(GasComponents.C5H12) != null)
                this.C5H12 = (double) gas.get(GasComponents.C5H12);
            if (gas.get(GasComponents.N2) != null)
                this.N2 = (double) gas.get(GasComponents.N2);
            if (gas.get(GasComponents.CO2) != null)
                this.CO2 = (double) gas.get(GasComponents.CO2);
            if (gas.get(GasComponents.CO) != null)
                this.CO = (double) gas.get(GasComponents.CO);
            if (gas.get(GasComponents.H2S) != null)
                this.H2S = (double) gas.get(GasComponents.H2S);
            if (gas.get(GasComponents.H2) != null)
                this.H2 = (double) gas.get(GasComponents.H2);
            if (gas.get(GasComponents.H2O) != null)
                this.H2O = (double) gas.get(GasComponents.H2O);
            if (gas.get(GasComponents.O2) != null)
                this.O2 = (double) gas.get(GasComponents.O2);
        } catch (NullPointerException e) {
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
}