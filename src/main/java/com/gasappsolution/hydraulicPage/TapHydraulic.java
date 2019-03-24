/**
 * Здесь происходит расчет рейнольдса в зависимости от:
 * Расхода и диаметра
 * <p>
 * А также здесь рассчитывается лямбда в зависимости от:
 * диамтера, рейнольдса и шероховатости трубы
 */
package com.gasappsolution.hydraulicPage;

import com.gasappsolution.SnipConstants;
import com.gasappsolution.utilities.UserData;
import com.gasappsolution.hydraulicPage.Pressure.Pressure;
import com.gasappsolution.hydraulicPage.Tube.Tube;
import com.gasappsolution.gasTypePage.gases.Gas;
import com.gasappsolution.gasTypePage.ParamCalc;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.log10;

public class TapHydraulic implements SnipConstants {
    private Gas gas;
    private ParamCalc paramCalc;
    private Pressure pressure;
    private Tube tube;
    private UserData userData;

    double PaUd;
    double Dr;
    double Ds;
    double Re;
    double V;
    double PnPk;

    public TapHydraulic(Gas gas, ParamCalc paramCalc, Pressure pressure, Tube tube, UserData userData) {
        this.gas = gas;
        this.paramCalc = paramCalc;
        this.pressure = pressure;
        this.tube = tube;
        this.userData = userData;
        PaUd();
        Dr();
        Ds1();
        getReynolds();
        V1();
        PnPk();
    }

    // Удельные потери давления
    public void PaUd() {
        try {
            this.PaUd = userData.getdPa() * 10 / (userData.getLength() * 1.1);
        } catch (NullPointerException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Вы не выбрали категорию сети",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Диаметр расчетный
    public void Dr() {
        try {
            this.Dr = Math.pow((pressure.getAconst() * tube.getBconst() * paramCalc.calcDensity()
                    * Math.pow(userData.getRashod1(), tube.getMconst()))
                    / PaUd, 1 / tube.getM1const()) * 10;
            System.out.println();
        } catch (NullPointerException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Проверьте заполненность данных на предыдущей вкладке",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Диаметр стандартный
    public void Ds1() {
        try {
            Ds = tube.getDs(Dr);
        } catch (NullPointerException e) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Вы не выбрали материал газопровода",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
    }

    //число Рейнольдса
    public void getReynolds() {
        this.Re = 0.0354 * userData.getRashod1() / (Ds / 10 * gas.getVv());
    }

    //Лямбда
    public double getlambda() {
        double lambda = 0;
        if (Re < 2000) {
            lambda = 64 / Re;
        }
        if (Re > 2000 && Re < 4000) {
            lambda = 0.0025 * Math.pow(Re, 0.333);
        }
        if (Re > 4000) {
            if (n / Ds < 23) {
                if (Re < 100000) {
                    lambda = 0.3164 / Math.pow(Re, 0.25);
                }
                if (Re > 100000) {
                    lambda = 1 / (Math.pow(1.821 * log10(Re) - 1.64, 2));
                }
            } else {
                lambda = 0.11 * Math.pow(n / Ds + 68 / Re, 0.25);
            }
        }
        return lambda;
    }

    // Скорость
    public void V1() {
        this.V = 4 * userData.getRashod1() * Pn * zr * Tr / (Ds * Ds * Pr * Tn * Math.PI * zn * 3.6) * 1000;
    }

    // Падение давления
    public void PnPk() {
        this.PnPk = pressure.getPressureLost(
                getlambda()
                , userData.getRashod1()
                , paramCalc.getDencity()
                , userData.getLength()
                , Ds);
    }

    public double getRe() {
        return Re;
    }

    public double getDr() {
        return Dr;
    }

    public double getDs() {
        return Ds;
    }

    public double getPaUd() {
        return PaUd;
    }

    public double getV() {
        return V;
    }

    public double getPnPk() {
        return PnPk;
    }
}