package gasappsolution;

import gasappsolution.hydraulicPage.Pressure.FactoryPressure;
import gasappsolution.hydraulicPage.Pressure.Pressure;
import gasappsolution.hydraulicPage.Pressure.PressureType;
import gasappsolution.hydraulicPage.TapHydraulic;
import gasappsolution.hydraulicPage.Tube.FactoryTube;
import gasappsolution.hydraulicPage.Tube.Tube;
import gasappsolution.hydraulicPage.Tube.TubeType;
import gasappsolution.gasTypePage.FactoryGas;
import gasappsolution.gasTypePage.Gas;
import gasappsolution.gasTypePage.GasType;
import gasappsolution.gasTypePage.GasParam;
import gasappsolution.speedPage.TapSpeed;
import gasappsolution.utilities.UserData;
import gasappsolution.utilities.Utilities;
import javafx.application.Platform;
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

import java.io.IOException;
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
    double gasSummator;

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
    private TextField other;
    @FXML
    private TextField density;
    // Вторая вкладка
    @FXML
    private Label pressOnSystemLabel;
    @FXML
    private Label paUdLabel;
    @FXML
    private Label paUd2Label;
    @FXML
    private Label dPaLenghtLabel;
    @FXML
    private Label dPaLenght2Label;
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
        paramPage(gas.create());
        gasTypeMenuBtn.setText("Природный газ");
    }

    @FXML
    void biogasBtn() {
        gas = new FactoryGas().getGas(GasType.Biogas);
        paramPage(gas.create());
        gasTypeMenuBtn.setText("Биогаз");
    }

    @FXML
    void networkBtn() {
        gas = new FactoryGas().getGas(GasType.NetworkGas);
        paramPage(gas.create());
        gasTypeMenuBtn.setText("Сетевой природный газ");
    }

    void paramPage(Map gas) {
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
        other.setText(String.valueOf(gasParam.getOther()));
        calculateParamPage();
    }


    @FXML
    void ch4Btn() {
        gasParam.setCH4(Double.parseDouble(ch4.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void c2h6Btn() {
        gasParam.setC2H6(Double.parseDouble(c2h6.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void c3h8Btn() {
        gasParam.setC3H8(Double.parseDouble(c3h8.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void c4h10Btn() {
        gasParam.setC4H10(Double.parseDouble(c4h10.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void c5h12Btn() {
        gasParam.setC5H12(Double.parseDouble(c5h12.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void n2Btn() {
        gasParam.setN2(Double.parseDouble(n2.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void co2Btn() {
        gasParam.setCO2(Double.parseDouble(co2.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void coBtn() {
        gasParam.setCO(Double.parseDouble(co.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void h2sBtn() {
        gasParam.setH2S(Double.parseDouble(h2s.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void h2Btn() {
        gasParam.setH2(Double.parseDouble(h2.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void h2oBtn() {
        gasParam.setH2O(Double.parseDouble(h2o.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void o2Btn() {
        gasParam.setO2(Double.parseDouble(o2.getText()));
        gasParamSummator();
        calculateParamPage();
    }

    @FXML
    void otherBtn() {
        gasParam.setOther(Double.parseDouble(other.getText()));
        gasParamSummator();
        calculateParamPage();

    }

    void gasParamSummator() {
        this.gasSummator =
                gasParam.getCH4()/100 +
                        gasParam.getC2H6()/100 +
                        gasParam.getC3H8()/100 +
                        gasParam.getC4H10()/100 +
                        gasParam.getC5H12()/100 +
                        gasParam.getN2()/100 +
                        gasParam.getCO2()/100 +
                        gasParam.getCO()/100 +
                        gasParam.getH2S()/100 +
                        gasParam.getH2()/100 +
                        gasParam.getH2O()/100 +
                        gasParam.getO2()/100;

        if (this.gasSummator > 1) {
            other.setStyle("-fx-text-inner-color: red;");
            gasParam.setOther(1 - gasSummator);
            other.setText(String.valueOf(gasParam.getOther()));
            System.out.println(">1; " + (1 - gasSummator));
        } else if (this.gasSummator < 1) {
            other.setStyle("-fx-text-inner-color: black;");
            gasParam.setOther(1 - gasSummator);
            other.setText(String.valueOf(1 - this.gasSummator));
            System.out.println("<1; " + (1 - gasSummator));
        } else if (this.gasSummator == 1) {
            other.setStyle("-fx-text-inner-color: black;");
            gasParam.setOther(1 - gasSummator);

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
            other.setText(String.valueOf(gasParam.getOther()));
            System.out.println("=1; " + (1 - gasSummator));
        }
    }

    void calculateParamPage() {
        this.gas.setDensity(gasParam.calcDensity());
        density.setText(util.toText(gas.getDensity()));
    }

    /*ТУТ СТАРОЕ*/
    @FXML
    void lowPressureBtn() {
        this.pressure = new FactoryPressure()
                .getPressure(PressureType.low);
        getdPa.setText(util.toText(pressure.getdPa()));
        setSredPressure1.setText(util.toText(pressure.getsPr()));
        setSredPressure2.setText(util.toText(pressure.getsPr()));

        pressureMenuButton.setText("Сеть низкого давления");
        pressOnSystemLabel.setText("давление в сети (даПа)");
        paUdLabel.setText("Удельные потери (Па/м)");
        paUd2Label.setText("Удельные потери (Па/м)");
        dPaLenghtLabel.setText("длине газ-да (Па)");
        dPaLenght2Label.setText("длине газ-да (Па)");
    }

    @FXML
    void hightPressureBtn() {
        this.pressure = new FactoryPressure()
                .getPressure(PressureType.hight);
        getdPa.setText(util.toText(pressure.getdPa()));
        setSredPressure1.setText(util.toText(pressure.getsPr()));
        setSredPressure2.setText(util.toText(pressure.getsPr()));

        pressureMenuButton.setText("Сеть среднего и высокого давления");
        pressOnSystemLabel.setText("давление в сети (МПа)");
        paUdLabel.setText("Удельные потери (МПа/м)");
        paUd2Label.setText("Удельные потери (МПа/м)");
        dPaLenghtLabel.setText("длине газ-да (МПа²)");
        dPaLenght2Label.setText("длине газ-да (МПа²)");
    }

    @FXML
    public void steelPipeBtn() {
        pipeMaterial.setText("Сталь");
        this.tube = new FactoryTube()
                .getTube(TubeType.Steel)
                .param();
    }

    @FXML
    public void polyethilenePipeBtn() {
        pipeMaterial.setText("Полиэтилен");
        this.tube = new FactoryTube()
                .getTube(TubeType.Steel)
                .param();
    }

    @FXML
    void exitBtn() {
        Platform.exit();
    }

    @FXML
    void settingBtn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/setting.fxml"));
        Stage stageSetting = new Stage();
        stageSetting.setTitle("Настройки");
        stageSetting.setScene(new Scene(root));
        stageSetting.show();
    }

    @FXML
    public void aboutBtn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/aboutProgram.fxml"));
        Stage stageAbout = new Stage();
        stageAbout.setTitle("О программе");
        stageAbout.setScene(new Scene(root));
        Image ico = new Image("iconLogo.png");
        stageAbout.getIcons().add(ico);
        stageAbout.show();
    }

    @FXML
    void resetBtn() {
        lowPressureBtn();
        steelPipeBtn();

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
        density.setText(null);
    }

    @FXML
    void inquiryQuestionBtnOK() {
        Stage stageAbout = (Stage) btnOK.getScene().getWindow();
        stageAbout.close();
    }

    @FXML
    void calculateBtn1() {
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
    }

    @FXML
    void calculateBtn2() {
        userData.setDs2(Double.parseDouble(setDiamGas2.getText()));
        userData.setRashod2(Double.parseDouble(getRashod2.getText()));
        userData.setDensity(Double.parseDouble(getDensity.getText()));
        userData.setLength(Double.parseDouble(getGasl.getText()));

        tapSpeed = new TapSpeed(gas, gasParam, pressure, tube, userData, tapHydraulic);

        setSpeed2.setText(util.toText(tapSpeed.getV2()));
        setRe2.setText(util.toText(tapSpeed.getRe()));
        setdPaUde2.setText(util.toText(tapSpeed.getPaUd()));
        setdPaRaschLenght2.setText(util.toText(tapSpeed.getPnPk()));

        if (pressure.equals(PressureType.low)) {
            if (tapSpeed.getV2() > 7) {
                setSpeed2.setStyle("-fx-text-inner-color: red;");
            } else {
                setSpeed2.setStyle("-fx-text-inner-color: black;");
            }
        }
        if (pressure.equals(PressureType.hight)) {
            if (tapSpeed.getV2() > 25) {
                setSpeed2.setStyle("-fx-text-inner-color: red;");
            } else {
                setSpeed2.setStyle("-fx-text-inner-color: black;");
            }
        }
    }
}