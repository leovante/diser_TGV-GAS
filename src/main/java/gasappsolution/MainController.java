package gasappsolution;

import gasappsolution.solution.ReynoldsSolution;
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
import gasappsolution.solution.TubeSolution;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;

public class MainController {
    static String mItem = "lowPress";
    private double gasSpeed1;
    private double gasSpeed2;
    private TubeSolution tubeSolution = new TubeSolution();

    //==== Первая вкладка
    @FXML
    private Label pressOnSystemLabel;
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
    private TextField setSpeed1Field;
    @FXML
    private TextField setStdiam;
    @FXML
    private TextField setRe1;
    @FXML
    private TextField setdPaUdel;
    @FXML
    private TextField setdPaRaschLenght1;

    //==== Вторая вкладка
    @FXML
    private TextField setSredPressure2;
    @FXML
    private TextField getDiamGas2;
    @FXML
    private TextField getRashod2;
    @FXML
    private TextField setSpeed2Field;
    @FXML
    private TextField setRe2;
    @FXML
    private TextField setdPaUde2;
    @FXML
    private TextField setdPaRaschLenght2;
    @FXML
    private Button btnOK;



    public MainController() {
    }

    @FXML
    public void initialize() {
    }


    @FXML
    void setMitem1() {
        mItem = "lowPress";
        pressureMenuButton.setText("Сеть низкого давления");
        getdPa.setText("180");
        pressOnSystemLabel.setText("давление в сети (даПа)");
        textPaUd.setText("Удельные потери (Па/м)");
        textPaUd2.setText("Удельные потери (Па/м)");
        MarkSolution.Pr = 0.101325 + 0.001 * 5;
        MarkSolution.Aconst = 626;
        setSredPressure1.setText("-");
        setSredPressure2.setText("-");
        textDPaonLenght.setText("длине газ-да (Па)");
        textDPaonLenght2.setText("длине газ-да (Па)");
    }

    @FXML
    void setMitem2() {
        mItem = "hightPress";
        pressureMenuButton.setText("Сеть среднего и высокого давления");
        getdPa.setText("0.18");
        pressOnSystemLabel.setText("давление в сети (МПа)");
        textPaUd.setText("Удельные потери (МПа/м)");
        textPaUd2.setText("Удельные потери (МПа/м)");
        textDPaonLenght.setText("длине газ-да (МПа²)");
        textDPaonLenght2.setText("длине газ-да (МПа²)");
        setSredPressure1.setText("0.325");
        setSredPressure2.setText("0.325");
        MarkSolution.Pr = 0.101325 + 0.3;
        double sPr = Double.parseDouble(setSredPressure1.getText());
        MarkSolution.Aconst = 0.101325 / (sPr * 162 * Math.PI * Math.PI);
    }


    @FXML
    public void setPipeToSteel() {
        String type = "Сталь";
        pipeMaterial.setText(type);
        MarkSolution.n = 0.01;
        MarkSolution.m1const = 5;
        MarkSolution.mconst = 2;
        MarkSolution.Bconst = 0.022;
        tubeSolution.setType(type);
    }

    @FXML
    public void setPipeToPolyethylene() {
        String type = "Полиэтилен";
        pipeMaterial.setText(type);
        MarkSolution.n = 0.0007;
        MarkSolution.m1const = 4.75;
        MarkSolution.mconst = 1.75;
        MarkSolution.Bconst = 0.0446;
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
    void handleResetMenuButton(ActionEvent event) throws IOException {
        setMitem1();
        setPipeToSteel();

        getdPa.setText("180");
        getRashod1.setText("1144");
        getGasl.setText("41");
        getDensity.setText("0.72");
        setRDiamGas.setText(null);
        setStdiam.setText(null);
        setdPaUdel.setText(null);
        setSpeed1Field.setText(null);
        setRe1.setText(null);
        setdPaRaschLenght1.setText(null);

        getDiamGas2.setText("0");
        getDiamGas2.setText("0");
        getRashod2.setText("1144");
        getRashod2.setText("1144");
        setSpeed2Field.setText(null);
        setRe2.setText(null);
        setdPaRaschLenght2.setText(null);
        setdPaUde2.setText(null);
    }

    @FXML
    void inquiryQuestionBtnOK() {
        Stage stageAbout = (Stage) btnOK.getScene().getWindow();
        stageAbout.close();
    }

    @FXML
    void tabHyraulic(ActionEvent event) {
        try {
            double dPa = Double.parseDouble(getdPa.getText());
            double Length = Double.parseDouble(getGasl.getText());
            double Rashod1 = Double.parseDouble(getRashod1.getText());
            double Density = Double.parseDouble(getDensity.getText());

            //==== Удельные потери
            PressureSolution pressure = new PressureSolution();
            double PaUd = pressure.getPaUd(dPa, Length);
            setdPaUdel.setText(String.valueOf(String.format(Locale.US, "%.4f", PaUd)));

            //==== Диаметр расчетный
            MarkSolution solution = new MarkSolution();
            double Dr = solution.Dr(Density, Rashod1, PaUd);
            setRDiamGas.setText(String.valueOf(String.format(Locale.US, "%.1f", Dr)));
            //==== Диаметр стандартный
            TubeSolution.Solution(Dr);
            double Ds1 = TubeSolution.getDs();
            setStdiam.setText(String.valueOf((int) Ds1));
            getDiamGas2.setText(String.valueOf((int) Ds1));

            //==== Рейнольдс
            ReynoldsSolution reynoldsSolution = new ReynoldsSolution();
            double Ds1a = Ds1 / 10;
            double Re1 = reynoldsSolution.getReynolds(Rashod1, Ds1a);
            setRe1.setText(String.valueOf(String.format(Locale.US, "%.2f", Re1)));

            //==== Падение давления
            double PnPk1 = solution.PnPk(Ds1, Re1, Rashod1, Density, Length);
            setdPaRaschLenght1.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk1)));

            //==== Скорость
            gasSpeed1 = solution.V1(Rashod1, Ds1);
            setSpeed1Field.setText(String.valueOf(String.format(Locale.US, "%.2f", gasSpeed1)));

            if (mItem.equals("lowPress")) {
                if (gasSpeed1 > 7) {
                    setSpeed1Field.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed1Field.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (mItem.equals("hightPress")) {
                if (gasSpeed1 > 25) {
                    setSpeed1Field.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed1Field.setStyle("-fx-text-inner-color: black;");
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
    void tabGasSpeed(ActionEvent event) {
        try {
            double Ds2 = Double.parseDouble(getDiamGas2.getText());
            double Rashod2 = Double.parseDouble(getRashod2.getText());
            double Density = Double.parseDouble(getDensity.getText());
            double Length = Double.parseDouble(getGasl.getText());

            //==== Скорость
            MarkSolution sol = new MarkSolution();
            gasSpeed2 = sol.V1(Rashod2, Ds2);
            setSpeed2Field.setText(String.valueOf(String.format(Locale.US, "%.2f", gasSpeed2)));

            //==== Рейнольдс
            ReynoldsSolution reynolds = new ReynoldsSolution();
            double Ds2a = Ds2 / 10;
            double Re2 = reynolds.getReynolds(Rashod2, Ds2a);
            setRe2.setText(String.valueOf(String.format(Locale.US, "%.2f", Re2)));

            //==== Удельные потери
            setdPaUde2.setText(String.valueOf(String.format(Locale.US, "%.4f", Double.parseDouble(setdPaUdel.getText()))));

            //==== Падение давления
            double PnPk2 = sol.PnPk(Ds2, Re2, Rashod2, Density, Length);
            setdPaRaschLenght2.setText(String.valueOf(String.format(Locale.US, "%.4f", PnPk2)));

            if (mItem.equals("lowPress")) {
                if (gasSpeed2 > 7) {
                    setSpeed2Field.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed2Field.setStyle("-fx-text-inner-color: black;");
                }
            }
            if (mItem.equals("hightPress")) {
                if (gasSpeed2 > 25) {
                    setSpeed2Field.setStyle("-fx-text-inner-color: red;");
                } else {
                    setSpeed2Field.setStyle("-fx-text-inner-color: black;");
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