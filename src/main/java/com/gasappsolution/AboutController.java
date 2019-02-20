package com.gasappsolution;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutController {
    @FXML
    private Button btnOK;

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
    void inquiryQuestionBtnOK() {
        Stage stageAbout = (Stage) btnOK.getScene().getWindow();
        stageAbout.close();
    }

}
