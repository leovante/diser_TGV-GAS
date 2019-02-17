package gasappsolution;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingController {

    @FXML
    void settingBtn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/setting.fxml"));
        Stage stageSetting = new Stage();
        stageSetting.setTitle("Настройки");
        stageSetting.setScene(new Scene(root));
        Image ico = new Image("iconLogo.png");
        stageSetting.getIcons().add(ico);
        stageSetting.show();
    }


}
