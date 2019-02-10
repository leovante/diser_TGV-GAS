package gasappsolution;

import gasappsolution.hydraulicPage.Pressure.FactoryPressure;
import gasappsolution.hydraulicPage.Pressure.Pressure;
import gasappsolution.hydraulicPage.Pressure.PressureType;
import gasappsolution.hydraulicPage.ReSolution;
import gasappsolution.hydraulicPage.TapHydraulic;
import gasappsolution.hydraulicPage.Tube.FactoryTube;
import gasappsolution.hydraulicPage.Tube.Tube;
import gasappsolution.hydraulicPage.Tube.TubeType;
import gasappsolution.paramPage.FactoryGas;
import gasappsolution.paramPage.Gas;
import gasappsolution.paramPage.GasType;
import gasappsolution.paramPage.GasParam;
import gasappsolution.speedPage.TapSpeed;
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

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class MainController {
    Utilities util = new Utilities();
    TapHydraulic tapHydraulic;
    TapSpeed tapSpeed;
    UserData userData = new UserData();

    private Gas gas;
    private GasParam gasParam;
    private Pressure pressure;
    private Tube tube;

    private double gasSpeed2;

    // Первая вкладка
    @FXML
    private TextField ch4;
    @FXML
    private TextField c2h6;
    @FXML
    private TextField c3h8;
    @FXML
    private TextField c4h10;
    @FXML
    private TextField c5h12;
    @FXML
    private TextField n2;
    @FXML
    private TextField co2;
    @FXML
    private TextField co;
    @FXML
    private TextField h2s;
    @FXML
    private TextField h2;
    @FXML
    private TextField h2o;
    @FXML
    private TextField o2;
    @FXML
    private TextField plotnost;
    // Вторая вкладка
    @FXML
    private Label pressOnSystem;
    @FXML
    private Label textPaUd;
    @FXML
    private Label textPaUd2;
    @FXML
    private Label textDPaonLenght;
    @FXML
    private Label textDPaonLenght2;
    @FXML
    private MenuButton pressureMenuButton;
    @FXML
    private MenuButton pipeMaterial;
    @FXML
    private MenuButton gasTypeMenuBtn;
    @FXML
    private TextField setSredPressure1;
    @FXML
    private TextField getdPa;
    @FXML
    private TextField getRashod1;
    @FXML
    private TextField getGasl;
    @FXML
    private TextField getDensity;
    @FXML
    private TextField setRDiamGas;
    @FXML
    private TextField setSpeed1;
    @FXML
    private TextField setStdiam;
    @FXML
    private TextField setRe1;
    @FXML
    private TextField setdPaUdel;
    @FXML
    private TextField setdPaRaschLenght1;
    // Третья вкладка
    @FXML
    private TextField setSredPressure2;
    @FXML
    private TextField setDiamGas2;
    @FXML
    private TextField getRashod2;
    @FXML
    private TextField setSpeed2;
    @FXML
    private TextField setRe2;
    @FXML
    private TextField setdPaUde2;
    @FXML
    private TextField setdPaRaschLenght2;
    @FXML
    private Button btnOK;

    @FXML
    void natureGasBtn() {
        gas = new FactoryGas().getGas(GasType.NatureGas);
        gasTypeMenuBtn.setText("Природный газ");
        paramPageAction(gas.create());
    }

    @FXML
    void biogasBtn() {
        gas = new FactoryGas().getGas(GasType.Biogas);
        gasTypeMenuBtn.setText("Биогаз");
        paramPageAction(gas.create());
    }

    void paramPageAction(Map gas) {
        gasParam = new GasParam(gas);
        ch4.setText(String.valueOf(gasParam.getCH4()));
        c2h6.setText(String.valueOf(gasParam.getC2H6()));
        c3h8.setText(String.valueOf(gasParam.getC3H8()));
        c4h10.setText(String.valueOf(gasParam.getC4H10()));
        c5h12.setText(String.valueOf(gasParam.getC5H12()));
        n2.setText(String.valueOf(gasParam.getN2()));
        co2.setText(String.valueOf(gasParam.getCO2()));
        co.setText(String.valueOf(gasParam.getCO()));
        h2s.setText(String.valueOf(gasParam.getH2S()));
        h2.setText(String.valueOf(gasParam.getH2()));
        h2o.setText(String.valueOf(gasParam.getH2O()));
        o2.setText(String.valueOf(gasParam.getO2()));
        this.gas.setDensity(gasParam.getGasMix());
        density();
    }

    void density() {
        plotnost.setText(String.valueOf(
                String.format(
                        Locale.US, "%.4f", gas.getDensity())));
    }

    /*тут старое*/
    @FXML
    void setWebLowPressure() {
        this.pressure = new FactoryPressure()
                .getPressure(PressureType.low)
                .param();
        pressureMenuButton.setText("Сеть низкого давления");
        getdPa.setText("180");
        pressOnSystem.setText("давление в сети (даПа)");
        textPaUd.setText("Удельные потери (Па/м)");
        textPaUd2.setText("Удельные потери (Па/м)");
        setSredPressure1.setText("-");
        setSredPressure2.setText("-");
        textDPaonLenght.setText("длине газ-да (Па)");
        textDPaonLenght2.setText("длине газ-да (Па)");
    }

    @FXML
    void setWebHightPressure() {
        this.pressure = new FactoryPressure()
                .getPressure(PressureType.hight)
                .param();
        pressureMenuButton.setText("Сеть среднего и высокого давления");
        getdPa.setText("0.18");
        pressOnSystem.setText("давление в сети (МПа)");
        textPaUd.setText("Удельные потери (МПа/м)");
        textPaUd2.setText("Удельные потери (МПа/м)");
        textDPaonLenght.setText("длине газ-да (МПа²)");
        textDPaonLenght2.setText("длине газ-да (МПа²)");
        setSredPressure1.setText("0.325");
        setSredPressure2.setText("0.325");
    }

    @FXML
    public void setPipeToSteel() {
        pipeMaterial.setText("Сталь");
        this.tube = new FactoryTube()
                .getTube(TubeType.Steel)
                .param();
    }

    @FXML
    public void setPipeToPolyethylene() {
        pipeMaterial.setText("Полиэтилен");
        this.tube = new FactoryTube()
                .getTube(TubeType.Steel)
                .param();
    }

    @FXML
    void handleExitMenuButton(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    void handleButtonSetting(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/setting.fxml"));
        Stage stageSetting = new Stage();
        stageSetting.setTitle("Настройки");
        stageSetting.setScene(new Scene(root));
        stageSetting.show();
    }

    @FXML
    public void handleButtonAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/aboutProgram.fxml"));
        Stage stageAbout = new Stage();
        stageAbout.setTitle("О программе");
        stageAbout.setScene(new Scene(root));
        Image ico = new Image("iconLogo.png");
        stageAbout.getIcons().add(ico);
        stageAbout.show();
    }

    @FXML
    void resetMenuButton(ActionEvent event) throws IOException {
        setWebLowPressure();
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

        setDiamGas2.setText("0");
        setDiamGas2.setText("0");
        getRashod2.setText("1144");
        getRashod2.setText("1144");
        setSpeed2.setText(null);
        setRe2.setText(null);
        setdPaRaschLenght2.setText(null);
        setdPaUde2.setText(null);
        plotnost.setText(null);
    }

    @FXML
    void inquiryQuestionBtnOK() {
        Stage stageAbout = (Stage) btnOK.getScene().getWindow();
        stageAbout.close();
    }

    @FXML
    void calculateBtn1() {
        try {
            userData.setdPa(Double.parseDouble(getdPa.getText()));
            userData.setLength(Double.parseDouble(getGasl.getText()));
            userData.setRashod1(Double.parseDouble(getRashod1.getText()));
            userData.setDensity(Double.parseDouble(getDensity.getText()));

            tapHydraulic = new TapHydraulic(gas, gasParam, pressure, tube, userData);

            setdPaUdel.setText(util.toText(tapHydraulic.getPaUd()));
            setRDiamGas.setText(util.toText(tapHydraulic.getDr()));
            setStdiam.setText(util.toText(tapHydraulic.getDs()));
            setDiamGas2.setText(util.toText(tapHydraulic.getDs()));
            setRe1.setText(util.toText(tapHydraulic.getRe()));
            setdPaRaschLenght1.setText(util.toText(tapHydraulic.getPnPk()));
            setSpeed1.setText(util.toText(tapHydraulic.getV()));

            if (pressure.equals(PressureType.low)) {
                if (tapHydraulic.getV() > 7) {
                    setSpeed1.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed1.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (pressure.equals(PressureType.hight)) {
                if (tapHydraulic.getV() > 25) {
                    setSpeed1.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed1.setStyle("-fx-text-inner-color: black;");
                }
            }
        } catch (Exception ex) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Проверь корректность введенных данных",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void calculateBtn2() {
        try {
            userData.setDs2(Double.parseDouble(setDiamGas2.getText()));
            userData.setRashod2(Double.parseDouble(getRashod2.getText()));
            userData.setDensity(Double.parseDouble(getDensity.getText()));
            userData.setLength(Double.parseDouble(getGasl.getText()));

            tapSpeed = new TapSpeed(gas, gasParam, pressure, tube, userData, tapHydraulic);

            gasSpeed2 = sol.V1(Rashod2, Ds2);
            setSpeed2.setText(util.toText(gasSpeed2));
            setRe2.setText(util.toText(Re2));
            setdPaUde2.setText(util.toText(setdPaUdel.getText()));
            setdPaRaschLenght2.setText(util.toText(PnPk2));



            // Рейнольдс
            ReSolution reynolds = new ReSolution();
            double Ds2a = Ds2 / 10;
            double Re2 = reynolds.getReynolds(Rashod2, Ds2a);
            // Удельные потери
            // Падение давления
            double PnPk2 = sol.PnPk(Ds2, Re2, Rashod2, Density, Length);



            if (pressure.equals(PressureType.low)) {
                if (gasSpeed2 > 7) {
                    setSpeed2.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed2.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (pressure.equals(PressureType.hight)) {
                if (gasSpeed2 > 25) {
                    setSpeed2.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed2.setStyle("-fx-text-inner-color: black;");
                }
            }
        } catch (Exception ex) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Проверь корректность введенных данных",
                    "Ошибка расчета",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}