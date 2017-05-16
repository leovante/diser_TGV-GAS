package com.gasappsolution;

import com.gasappsolution.Solution.markSolution;
import com.gasappsolution.Solution.reynoldsSolution;
import com.gasappsolution.Solution.steelDiameter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class mainController {
    //==== Первая вкладка
    @FXML    Label pressOnSystem;
    @FXML    MenuButton pressureMenuButton;
    @FXML    MenuButton pipeMaterial;
    @FXML    TextField setSredPressure1;
    @FXML    TextField getdPa;
    @FXML    TextField getRashod1;
    @FXML    TextField getGasl;
    @FXML    TextField getDensity;
    //@FXML    Button btnSolution1;    //кнопки расчета
    @FXML    TextField setRDiamGas;
    @FXML    TextField setSpeed1;
    @FXML    TextField setStdiam;
    @FXML    TextField setRe1;
    @FXML    TextField setdPaUdel;
    @FXML    TextField setdPaRaschLenght1;
    //==== Вторая вкладка
    @FXML    TextField setSredPressure2;
    @FXML    TextField getDiamGas2;
    @FXML    TextField getRashod2;
    //@FXML    Button btnSolution2;        //кнопка расчета
    @FXML    TextField setSpeed2;
    @FXML    TextField setRe2;
    @FXML    TextField setdPaUde2;
    @FXML    TextField setdPaRaschLenght2;

    static int x = 1;
    @FXML
    void setMitem1() {
        x = 1;
        pressureMenuButton.setText("Сеть низкого давления");
        getdPa.setText("180");
        pressOnSystem.setText("Давление в сети (даПа)");
        markSolution.Pr = 0.101325 + 0.001 * 5;
    }
    @FXML
    void setMitem2() {
        x = 2;
        pressureMenuButton.setText("Сеть среднего и высокого давления");
        getdPa.setText("0.18");
        pressOnSystem.setText("Давление в сети (МПа)");
        markSolution.Pr =0.101325 + 0.3;
    }
    @FXML
    public void setPipe1() {
        pipeMaterial.setText("Сталь");
        markSolution.n = 0.01;                        //сталь
    }
    @FXML
    public void setPipe2() {
        pipeMaterial.setText("Полиэтилен");
        markSolution.n = 0.0007;                      //полиэтилен
    }
    @FXML
    public void btn2() {
/*
   не работает. Должна открывать страницу БГТУ с моим кубком по нажатию кнопки

        Hyperlink link = new Hyperlink();
        link.setText("http://tgv.bstu.ru/olimp_tgv_2016");
        link.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });*/
    }

    @FXML
    void handleButtonAction(ActionEvent a) throws IOException {
       // Pute route = new Pute();

       // String a = getClass().getResource("autors.fxml");
        Parent root1 = FXMLLoader.load(getClass().getResource("autors.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    @FXML
    void handleButtonSolution1(ActionEvent event) throws  IOException{
        double dPa = Double.parseDouble(getdPa.getText());
        double Length = Integer.parseInt(getGasl.getText());
        double Rashod1 = Integer.parseInt(getRashod1.getText());
        double Density = Double.parseDouble(getDensity.getText());

        //==== Удельные потери
        pressureSolution pressure = new pressureSolution();
        double PaUd = pressure.getPaUd(dPa, Length);
        setdPaUdel.setText(String.valueOf(String.format(Locale.US, "%.4f", PaUd)));

        //==== Диаметр расчетный
        markSolution sol = new markSolution();
        double Dr = sol.Dr(Density, Rashod1, PaUd);
        setRDiamGas.setText(String.valueOf(String.format(Locale.US, "%.1f", Dr)));

        //==== Диаметр стандартный
        steelDiameter Diameters = new steelDiameter();
        double Ds1 = Diameters.getDiameters(Dr);
        setStdiam.setText(String.valueOf((int) Ds1));
        getDiamGas2.setText(String.valueOf((int) Ds1));

        //==== Рейнольдс
        reynoldsSolution reynolds = new reynoldsSolution();
        double Ds1a = Ds1 / 10;
        double Re1 = reynolds.getReynolds(Rashod1, Ds1a);
        setRe1.setText(String.valueOf(String.format(Locale.US, "%.2f", Re1)));

        //==== Падение давления
        double PnPk1 = sol.PnPk(Ds1, Re1, Rashod1, Density, Length);
        setdPaRaschLenght1.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk1)));

        //==== Скорость
        double V1 = sol.V1(Rashod1, Ds1);
        setSpeed1.setText(String.valueOf(String.format(Locale.US, "%.2f", V1)));
    }

    @FXML
    void handleButtonSolution2(ActionEvent event) throws IOException{
        double Ds2 = Double.parseDouble(getDiamGas2.getText());
        double Rashod2 = Integer.parseInt(getRashod2.getText());
        double Density = Double.parseDouble(getDensity.getText());
        double Length = Integer.parseInt(getGasl.getText());

        //==== Скорость
        markSolution sol = new markSolution();
        double V2 = sol.V1(Rashod2, Ds2);
        setSpeed2.setText(String.valueOf(String.format(Locale.US, "%.2f", V2)));

        //==== Рейнольдс
        reynoldsSolution reynolds = new reynoldsSolution();
        double Ds2a = Ds2 / 10;
        double Re2 = reynolds.getReynolds(Rashod2, Ds2a);
        setRe2.setText(String.valueOf(String.format(Locale.US, "%.2f", Re2)));

        //==== Удельные потери
        setdPaUde2.setText(String.valueOf(String.format(Locale.US, "%.2f", Double.parseDouble(setdPaUdel.getText()))));

        //==== Падение давления
        double PnPk2 = sol.PnPk(Ds2, Re2, Rashod2, Density, Length);
        setdPaRaschLenght2.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk2)));

    }

    @FXML
    public void initialize() {

    }
}