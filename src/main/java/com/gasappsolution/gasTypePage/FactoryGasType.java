package com.gasappsolution.gasTypePage;

import com.gasappsolution.gasTypePage.gases.BiogasImpl;
import com.gasappsolution.gasTypePage.gases.Gas;
import com.gasappsolution.gasTypePage.gases.NetworkGasImpl;
import com.gasappsolution.gasTypePage.gases.SvalochniyGasImpl;

import javax.swing.*;
import java.awt.*;

public class FactoryGasType implements AbstractFactoryGas {
    @Override
    public Gas getGas(EnumGasType type) {
        try {
            if (type == EnumGasType.Biogas) {
                return new BiogasImpl();
            } else if (type == EnumGasType.NatureGas) {
                return new SvalochniyGasImpl();
            } else if (type == EnumGasType.NetworkGas) {
                return new NetworkGasImpl();
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
}