package com.gasappsolution;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class btnAboutProgram {


    public void display() throws IOException {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("О программе");
        window.setMinWidth(250);

        Parent root = FXMLLoader.load(getClass().getResource("aboutProgram.fxml"));
        window.setScene(new Scene(root));
    }

}
