import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/scene.fxml"));
        primaryStage.setTitle("TGV-GAS");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        Image ico = new Image("iconLogo.png"); primaryStage.getIcons().add(ico);
        setUserAgentStylesheet(STYLESHEET_MODENA);
    }
    public static void main(String[] args) {
        launch(args);
    }
}