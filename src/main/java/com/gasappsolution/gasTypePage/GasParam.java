package com.gasappsolution.gasTypePage;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

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
    private double other;

    private double Qnc;
    private double Qvc;
    private double viscosityKinematic;
    private double Wobbe;
    private double dencityNormalConditions;
    private double capacity;



    public double calcDensity() {
        MassaGases mas = new MassaGases();
        double i = CH4/100 * mas.massa().get(GasComponents.CH4) +
                C2H6/100 * mas.massa().get(GasComponents.C2H6) +
                C3H8/100 * mas.massa().get(GasComponents.C3H8) +
                C4H10/100 * mas.massa().get(GasComponents.C4H10) +
                C5H12/100 * mas.massa().get(GasComponents.C5H12) +
                N2/100 * mas.massa().get(GasComponents.N2) +
                CO2/100 * mas.massa().get(GasComponents.CO2) +
                CO/100 * mas.massa().get(GasComponents.CO) +
                H2S/100 * mas.massa().get(GasComponents.H2S) +
                H2/100 * mas.massa().get(GasComponents.H2) +
                H2O/100 * mas.massa().get(GasComponents.H2O) +
                O2/100 * mas.massa().get(GasComponents.O2);
        return i;
    }

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
            if (gas.get(GasComponents.other) != null)
                this.other = (double) gas.get(GasComponents.other);
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

    public double getOther() {
        return other;
    }

    public double getQnc() {
        return Qnc;
    }

    public double getQvc() {
        return Qvc;
    }

    public void setCH4(double CH4) {
        this.CH4 = CH4;
    }

    public void setC2H6(double c2H6) {
        C2H6 = c2H6;
    }

    public void setC3H8(double c3H8) {
        C3H8 = c3H8;
    }

    public void setC4H10(double c4H10) {
        C4H10 = c4H10;
    }

    public void setC5H12(double c5H12) {
        C5H12 = c5H12;
    }

    public void setN2(double n2) {
        N2 = n2;
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }

    public void setCO(double CO) {
        this.CO = CO;
    }

    public void setH2S(double h2S) {
        H2S = h2S;
    }

    public void setH2(double h2) {
        H2 = h2;
    }

    public void setH2O(double h2O) {
        H2O = h2O;
    }

    public void setO2(double o2) {
        O2 = o2;
    }

    public void setOther(double other) {
        this.other = other;
    }
}