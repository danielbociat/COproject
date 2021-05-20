import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getClassLoader().getResource("StartWindow.fxml");
        if (resource != null) {
            Parent start_layout = FXMLLoader.load(resource);
            //noinspection SpellCheckingInspection
            primaryStage.setTitle("Uwuntu App");
            primaryStage.setScene(new Scene(start_layout, 600, 400));
            primaryStage.show();
        }
    }
}