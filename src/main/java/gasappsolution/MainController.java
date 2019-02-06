package gasappsolution;

import gasappsolution.hydraulicPage.FactoryPressure;
import gasappsolution.hydraulicPage.Pressure;
import gasappsolution.hydraulicPage.PressureType;
import gasappsolution.paramPage.FactoryGas;
import gasappsolution.paramPage.Gas;
import gasappsolution.paramPage.GasType;
import gasappsolution.paramPage.GasParam;
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
    private Gas gas;
    private GasParam gasParam;

//    static String mItem = lowPressure;
    private double gasSpeed1;
    private double gasSpeed2;
//    private TubeSolution tubeSolution = new TubeSolution();

    private Pressure pressure;

    //==== Первая вкладка
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
    //==== Вторая вкладка
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
    //==== Третья вкладка
    @FXML
    private TextField setSredPressure2;
    @FXML
    private TextField getDiamGas2;
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
        plotnost();
    }

    void plotnost() {
        plotnost.setText(String.valueOf(
                String.format(
                        Locale.US, "%.4f", gasParam.getGasMix())));
    }
    /*тут старое*/
    @FXML
    void setWebLowPressure() {
        pressure = new FactoryPressure().getPressure(PressureType.low);
        pressureMenuButton.setText("Сеть низкого давления");
        hydraulicPageAction(pressure.param());

//        mItem = lowPressure;
        getdPa.setText("180");
        pressOnSystem.setText("давление в сети (даПа)");
        textPaUd.setText("Удельные потери (Па/м)");
        textPaUd2.setText("Удельные потери (Па/м)");
        TapHydrSolution.Pr = 0.101325 + 0.001 * 5;
        TapHydrSolution.Aconst = 626;
        setSredPressure1.setText("-");
        setSredPressure2.setText("-");
        textDPaonLenght.setText("длине газ-да (Па)");
        textDPaonLenght2.setText("длине газ-да (Па)");
    }

    @FXML
    void setWebHightPressure() {
//        mItem = hightPressure;
        pressureMenuButton.setText("Сеть среднего и высокого давления");
        getdPa.setText("0.18");
        pressOnSystem.setText("давление в сети (МПа)");
        textPaUd.setText("Удельные потери (МПа/м)");
        textPaUd2.setText("Удельные потери (МПа/м)");
        textDPaonLenght.setText("длине газ-да (МПа²)");
        textDPaonLenght2.setText("длине газ-да (МПа²)");
        setSredPressure1.setText("0.325");
        setSredPressure2.setText("0.325");
        TapHydrSolution.Pr = 0.101325 + 0.3;
        double sPr = Double.parseDouble(setSredPressure1.getText());
        TapHydrSolution.Aconst = 0.101325 / (sPr * 162 * Math.PI * Math.PI);
    }
    
    void hydraulicPageAction(Object pressure){
        pressure.
                //найти тот пример с двумя билдерами и сделать похожим образом
    }
    
    @FXML
    public void setPipeToSteel() {
        String type = "Сталь";
        pipeMaterial.setText(type);
        TapHydrSolution.n = 0.01;
        TapHydrSolution.m1const = 5;
        TapHydrSolution.mconst = 2;
        TapHydrSolution.Bconst = 0.022;
        tubeSolution.setType(type);
    }

    @FXML
    public void setPipeToPolyethylene() {
        String type = "Полиэтилен";
        pipeMaterial.setText(type);
        TapHydrSolution.n = 0.0007;
        TapHydrSolution.m1const = 4.75;
        TapHydrSolution.mconst = 1.75;
        TapHydrSolution.Bconst = 0.0446;
        tubeSolution.setType(type);
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

        getDiamGas2.setText("0");
        getDiamGas2.setText("0");
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
            double dPa = Double.parseDouble(getdPa.getText());
            double Length = Double.parseDouble(getGasl.getText());
            double Rashod1 = Double.parseDouble(getRashod1.getText());
            double Density = Double.parseDouble(getDensity.getText());
            // Удельные потери
            PressSolution pressure = new PressSolution();
            double PaUd = pressure.getPaUd(dPa, Length);
            setdPaUdel.setText(String.valueOf(String.format(Locale.US, "%.4f", PaUd)));
            // Диаметр расчетный
            TapHydrSolution solution = new TapHydrSolution();
            double Dr = solution.Dr(Density, Rashod1, PaUd);
            setRDiamGas.setText(String.valueOf(String.format(Locale.US, "%.1f", Dr)));
            // Диаметр стандартный
            TubeSolution.Solution(Dr);
            double Ds1 = TubeSolution.getDs();
            setStdiam.setText(String.valueOf((int) Ds1));
            getDiamGas2.setText(String.valueOf((int) Ds1));
            // Рейнольдс
            ReSolution reSolution = new ReSolution();
            double Ds1a = Ds1 / 10;
            double Re1 = reSolution.getReynolds(Rashod1, Ds1a);
            setRe1.setText(String.valueOf(String.format(Locale.US, "%.2f", Re1)));
            // Падение давления
            double PnPk1 = solution.PnPk(Ds1, Re1, Rashod1, Density, Length);
            setdPaRaschLenght1.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk1)));
            // Скорость
            gasSpeed1 = solution.V1(Rashod1, Ds1);
            setSpeed1.setText(String.valueOf(String.format(Locale.US, "%.2f", gasSpeed1)));
            if (mItem.equals(lowPressure)) {
                if (gasSpeed1 > 7) {
                    setSpeed1.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed1.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (mItem.equals(hightPressure)) {
                if (gasSpeed1 > 25) {
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
            double Ds2 = Double.parseDouble(getDiamGas2.getText());
            double Rashod2 = Double.parseDouble(getRashod2.getText());
            double Density = Double.parseDouble(getDensity.getText());
            double Length = Double.parseDouble(getGasl.getText());
            // Скорость
            TapHydrSolution sol = new TapHydrSolution();
            gasSpeed2 = sol.V1(Rashod2, Ds2);
            setSpeed2.setText(String.valueOf(String.format(Locale.US, "%.2f", gasSpeed2)));
            // Рейнольдс
            ReSolution reynolds = new ReSolution();
            double Ds2a = Ds2 / 10;
            double Re2 = reynolds.getReynolds(Rashod2, Ds2a);
            setRe2.setText(String.valueOf(String.format(Locale.US, "%.2f", Re2)));
            // Удельные потери
            setdPaUde2.setText(String.valueOf(String.format(Locale.US, "%.4f", Double.parseDouble(setdPaUdel.getText()))));
            // Падение давления
            double PnPk2 = sol.PnPk(Ds2, Re2, Rashod2, Density, Length);
            setdPaRaschLenght2.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk2)));
            if (mItem.equals(lowPressure)) {
                if (gasSpeed2 > 7) {
                    setSpeed2.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed2.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (mItem.equals(hightPressure)) {
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