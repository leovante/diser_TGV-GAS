package com.gasappsolution.gasTypePage;

import com.gasappsolution.gasTypePage.gases.Gas;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;
import java.util.concurrent.ExecutionException;
import javax.swing.*;


public class ParamCalc {
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
    //получаемые параметры
    private double Qnc;
    private double Qvc;
    private double viscosityKinematic;
    private double wobbe;
    private double dencity;
    private double capacity;

    public ParamCalc(Gas gas) {
        try {
            this.CH4 = gas.getCH4();
            this.C2H6 = gas.getC2H6();
            this.C3H8 = gas.getC3H8();
            this.C4H10 = gas.getC4H10();
            this.C5H12 = gas.getC5H12();
            this.N2 = gas.getN2();
            this.CO2 = gas.getCO2();
            this.CO = gas.getCO();
            this.H2S = gas.getH2S();
            this.H2 = gas.getH2();
            this.H2O = gas.getH2O();
            this.O2 = gas.getO2();
            this.other = gas.getOther();
        } catch (NullPointerException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Ошибка в газовом справочнике, не удалось присвоить параметры.",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public double calcQnc() {
        if (validator()) {
            ComponentsParams mas = new ComponentsParams();
            double i = CH4 * mas.Qnc().get(EnumComp.CH4) +
                    C2H6 * mas.Qnc().get(EnumComp.C2H6) +
                    C3H8 * mas.Qnc().get(EnumComp.C3H8) +
                    C4H10 * mas.Qnc().get(EnumComp.C4H10) +
                    C5H12 * mas.Qnc().get(EnumComp.C5H12) +
                    N2 * mas.Qnc().get(EnumComp.N2) +
                    CO2 * mas.Qnc().get(EnumComp.CO2) +
                    CO * mas.Qnc().get(EnumComp.CO) +
                    H2S * mas.Qnc().get(EnumComp.H2S) +
                    H2 * mas.Qnc().get(EnumComp.H2) +
                    H2O * mas.Qnc().get(EnumComp.H2O) +
                    O2 * mas.Qnc().get(EnumComp.O2);
            this.Qnc = i;
            return i;
        }
        return 0;
    }

    public double calcQvc() {
        if (validator()) {
            ComponentsParams mas = new ComponentsParams();
            Qvc = CH4 * mas.Qvc().get(EnumComp.CH4) +
                    C2H6 * mas.Qvc().get(EnumComp.C2H6) +
                    C3H8 * mas.Qvc().get(EnumComp.C3H8) +
                    C4H10 * mas.Qvc().get(EnumComp.C4H10) +
                    C5H12 * mas.Qvc().get(EnumComp.C5H12) +
                    N2 * mas.Qvc().get(EnumComp.N2) +
                    CO2 * mas.Qvc().get(EnumComp.CO2) +
                    CO * mas.Qvc().get(EnumComp.CO) +
                    H2S * mas.Qvc().get(EnumComp.H2S) +
                    H2 * mas.Qvc().get(EnumComp.H2) +
                    H2O * mas.Qvc().get(EnumComp.H2O) +
                    O2 * mas.Qvc().get(EnumComp.O2);
            return Qvc;
        }
        return 0;
    }

    public double calcDensity() {
        if (validator()) {
            ComponentsParams mas = new ComponentsParams();
            dencity = CH4 * mas.density().get(EnumComp.CH4) +
                    C2H6 * mas.density().get(EnumComp.C2H6) +
                    C3H8 * mas.density().get(EnumComp.C3H8) +
                    C4H10 * mas.density().get(EnumComp.C4H10) +
                    C5H12 * mas.density().get(EnumComp.C5H12) +
                    N2 * mas.density().get(EnumComp.N2) +
                    CO2 * mas.density().get(EnumComp.CO2) +
                    CO * mas.density().get(EnumComp.CO) +
                    H2S * mas.density().get(EnumComp.H2S) +
                    H2 * mas.density().get(EnumComp.H2) +
                    H2O * mas.density().get(EnumComp.H2O) +
                    O2 * mas.density().get(EnumComp.O2);

            return dencity;
        }
        return 0;
    }

    public double calcWobbe() {
        if (validator()) {
            calcQnc();
            calcDensity();
            wobbe = Qnc / (Math.sqrt(dencity * 1.2));
            return wobbe;
        }
        return 0;
    }

    boolean validator() {
        double sum =
                this.CH4 +
                        this.C2H6 +
                        this.C3H8 +
                        this.C4H10 +
                        this.C5H12 +
                        this.N2 +
                        this.CO2 +
                        this.CO +
                        this.H2S +
                        this.H2 +
                        this.H2O +
                        this.O2 +
                        this.other;
        if (sum > 1 | sum < 1) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Состав газа = " + sum * 100 + "%",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(sum);
            throw new NullPointerException();
        } else if (sum == 1) {
            return true;
        }
        return false;
    }

    //сетеры геттеры
    public void setCH4(double CH4) {
        this.CH4 = CH4;
        validator();
    }

    public void setC2H6(double c2H6) {
        C2H6 = c2H6;
        validator();
    }

    public void setC3H8(double c3H8) {
        C3H8 = c3H8;
        validator();
    }

    public void setC4H10(double c4H10) {
        C4H10 = c4H10;
        validator();
    }

    public void setC5H12(double c5H12) {
        C5H12 = c5H12;
        validator();
    }

    public void setN2(double n2) {
        N2 = n2;
        validator();
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
        validator();
    }

    public void setCO(double CO) {
        this.CO = CO;
        validator();
    }

    public void setH2S(double h2S) {
        H2S = h2S;
        validator();
    }

    public void setH2(double h2) {
        H2 = h2;
        validator();
    }

    public void setH2O(double h2O) {
        H2O = h2O;
        validator();
    }

    public void setO2(double o2) {
        O2 = o2;
        validator();
    }

    public void setOther(double other) {
        this.other = other;
        validator();
    }

    public double getQnc() {
        calcQnc();
        return Qnc;
    }

    public double getQvc() {
        calcQvc();
        return Qvc;
    }

    public double getViscosityKinematic() {
        return viscosityKinematic;
    }

    public double getWobbe() {
        calcWobbe();
        return calcWobbe();
    }

    public double getDencity() {
        calcDensity();
        return dencity;
    }

    public double getCapacity() {
        return capacity;
    }
}