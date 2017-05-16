package com.gasappsolution;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.gasappsolution.solution.tubeSolution;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;

public class mainController {
    //==== Первая вкладка
    @FXML    Label pressOnSystem;
    @FXML    Label textPaUd;
    @FXML    Label textPaUd2;
    @FXML    Label textDPaonLenght;
    @FXML    Label textDPaonLenght2;
    @FXML    MenuButton pressureMenuButton;
    @FXML    MenuButton pipeMaterial;
    @FXML    TextField setSredPressure1;
    @FXML    TextField getdPa;
    @FXML    TextField getRashod1;
    @FXML    TextField getGasl;
    @FXML    TextField getDensity;
    @FXML    TextField setRDiamGas;
    @FXML    TextField setSpeed1;
    double V1;
    @FXML    TextField setStdiam;
    @FXML    TextField setRe1;
    @FXML    TextField setdPaUdel;
    @FXML    TextField setdPaRaschLenght1;
    //==== Вторая вкладка
    @FXML    TextField setSredPressure2;
    @FXML    TextField getDiamGas2;
    @FXML    TextField getRashod2;
    @FXML    TextField setSpeed2;
    double V2;
    @FXML    TextField setRe2;
    @FXML    TextField setdPaUde2;
    @FXML    TextField setdPaRaschLenght2;
    @FXML    Button btnOK;

    private Stage stageAbout;
    static int x = 1;

        @FXML
    void setMitem1() {
        x = 1;
        pressureMenuButton.setText("Сеть низкого давления");
        getdPa.setText("180");
        pressOnSystem.setText("давление в сети (даПа)");
        textPaUd.setText("Удельные потери (Па/м)");
        textPaUd2.setText("Удельные потери (Па/м)");
        markSolution.Pr = 0.101325 + 0.001 * 5;
        markSolution.Aconst = 626;
        setSredPressure1.setText("-");
        setSredPressure2.setText("-");
        textDPaonLenght.setText("длине газ-да (Па)");
        textDPaonLenght2.setText("длине газ-да (Па)");
    }
    @FXML
    void setMitem2() {
        x = 2;
        pressureMenuButton.setText("Сеть среднего и высокого давления");
        getdPa.setText("0.18");
        pressOnSystem.setText("давление в сети (МПа)");
        textPaUd.setText("Удельные потери (МПа/м)");
        textPaUd2.setText("Удельные потери (МПа/м)");
        textDPaonLenght.setText("длине газ-да (МПа²)");
        textDPaonLenght2.setText("длине газ-да (МПа²)");
        setSredPressure1.setText("0.325");
        setSredPressure2.setText("0.325");
        markSolution.Pr =0.101325 + 0.3;
        double sPr = Double.parseDouble(setSredPressure1.getText());
        double sP = 0.101325/(sPr*162*Math.PI*Math.PI);
        markSolution.Aconst = sP;
    }
    tubeSolution tube = new tubeSolution();
    @FXML
    public void setPipeToSteel() {
        String type = "Сталь";
        pipeMaterial.setText(type);
        markSolution.n = 0.01;
        markSolution.m1const = 5;
        markSolution.mconst = 2;
        markSolution.Bconst = 0.022;
        tube.setType(type);
    }
    @FXML
    public void setPipeToPolyethylene() {
        String type = "Полиэтилен";
        pipeMaterial.setText(type);
        markSolution.n = 0.0007;
        markSolution.m1const = 4.75;
        markSolution.mconst = 1.75;
        markSolution.Bconst = 0.0446;
        tube.setType(type);
    }
    @FXML
    void handleExitMenuButton (ActionEvent event) throws IOException{
        Platform.exit();
    }
    @FXML
    void handleButtonSetting(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/setting.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Настройки");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void handleButtonAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("aboutProgram.fxml"));
        stageAbout = new Stage();
        stageAbout.setTitle("О программе");
        stageAbout.setScene(new Scene(root));
        Image ico = new Image("iconLogo.png"); stageAbout.getIcons().add(ico);
        stageAbout.show();
    }
    @FXML
    void handleResetMenuButton(ActionEvent event) throws  IOException{
        setMitem1();
        setPipeToSteel();

        getdPa.setText("180");
        getRashod1.setText("1144");
        getGasl.setText("41");
        getDensity.setText("0.72");
        setRDiamGas.setText(null);
        setStdiam.setText(null);
        setdPaUdel.setText(null);
        setSpeed1.setText(null);
        setRe1.setText(null);
        setdPaRaschLenght1.setText(null);

        getDiamGas2.setText("0");
        getDiamGas2.setText("0");
        getRashod2.setText("1144");
        getRashod2.setText("1144");
        setSpeed2.setText(null);
        setRe2.setText(null);
        setdPaRaschLenght2.setText(null);
        setdPaUde2.setText(null);
    }
    @FXML
    void inquiryQuestionBtnOK(){
        Stage stageAbout = (Stage) btnOK.getScene().getWindow();
        stageAbout.close();
    }
    @FXML
    void handleButtonSolution1(ActionEvent event) {
        try {
            double dPa = Double.parseDouble(getdPa.getText());
            double Length = Double.parseDouble(getGasl.getText());
            double Rashod1 = Double.parseDouble(getRashod1.getText());
            double Density = Double.parseDouble(getDensity.getText());

            //==== Удельные потери
            pressureSolution pressure = new pressureSolution();
            double PaUd = pressure.getPaUd(dPa, Length);
            setdPaUdel.setText(String.valueOf(String.format(Locale.US, "%.4f", PaUd)));

            //==== Диаметр расчетный
            markSolution solution = new markSolution();
            double Dr = solution.Dr(Density, Rashod1, PaUd);
            setRDiamGas.setText(String.valueOf(String.format(Locale.US, "%.1f", Dr)));
            //==== Диаметр стандартный
            tubeSolution.Solution(Dr);
            double Ds1 = tubeSolution.getDs();
            setStdiam.setText(String.valueOf((int) Ds1));
            getDiamGas2.setText(String.valueOf((int) Ds1));

            //==== Рейнольдс
            reynoldsSolution reynoldsSolution = new reynoldsSolution();
            double Ds1a = Ds1 / 10;
            double Re1 = reynoldsSolution.getReynolds(Rashod1, Ds1a);
            setRe1.setText(String.valueOf(String.format(Locale.US, "%.2f", Re1)));

            //==== Падение давления
            double PnPk1 = solution.PnPk(Ds1, Re1, Rashod1, Density, Length);
            setdPaRaschLenght1.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk1)));

            //==== Скорость
            V1 = solution.V1(Rashod1, Ds1);
            setSpeed1.setText(String.valueOf(String.format(Locale.US, "%.2f", V1)));

            if (x==1){
                if(V1>7){
                    setSpeed1.setStyle("-fx-text-inner-color: red;");
                }else{setSpeed1.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (x==2){
                if(V1>25){
                    setSpeed1.setStyle("-fx-text-inner-color: red;");
                }else {setSpeed1.setStyle("-fx-text-inner-color: black;");
                }
            }

        }catch(Exception ex){
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Проверь корректность введенных данных",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    void handleButtonSolution2(ActionEvent event) {
        try {
            double Ds2 = Double.parseDouble(getDiamGas2.getText());
            double Rashod2 = Double.parseDouble(getRashod2.getText());
            double Density = Double.parseDouble(getDensity.getText());
            double Length = Double.parseDouble(getGasl.getText());

            //==== Скорость
            markSolution sol = new markSolution();
            V2 = sol.V1(Rashod2, Ds2);
            setSpeed2.setText(String.valueOf(String.format(Locale.US, "%.2f", V2)));

            //==== Рейнольдс
            reynoldsSolution reynolds = new reynoldsSolution();
            double Ds2a = Ds2 / 10;
            double Re2 = reynolds.getReynolds(Rashod2, Ds2a);
            setRe2.setText(String.valueOf(String.format(Locale.US, "%.2f", Re2)));

            //==== Удельные потери
            setdPaUde2.setText(String.valueOf(String.format(Locale.US, "%.4f", Double.parseDouble(setdPaUdel.getText()))));

            //==== Падение давления
            double PnPk2 = sol.PnPk(Ds2, Re2, Rashod2, Density, Length);
            setdPaRaschLenght2.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk2)));

            if (x==1){
                if(V2>7){
                    setSpeed2.setStyle("-fx-text-inner-color: red;");
                }else {setSpeed2.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (x==2){
                if(V2>25){
                    setSpeed2.setStyle("-fx-text-inner-color: red;");
                }else {setSpeed2.setStyle("-fx-text-inner-color: black;");
                }
            }

        }catch(Exception ex){
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Проверь корректность введенных данных",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    public void initialize() {
    }
}