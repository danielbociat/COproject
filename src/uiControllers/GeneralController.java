package uiControllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class GeneralController {

    protected static final String IDLE_BUTTON_STYLE = "-fx-background-color: #FF9999;";
    protected static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #FFCCCC";

    public void initButton(Button button) {
        button.setStyle(IDLE_BUTTON_STYLE);
        button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
        button.setOnMouseExited(e -> button.setStyle(IDLE_BUTTON_STYLE));
    }

    public void changeWindow(Button button, String windowName, int width, int height) {
        try {
            URL resource = getClass().getClassLoader().getResource(windowName);
            if (resource != null) {
                Parent layout = FXMLLoader.load(resource);
                Stage stage = (Stage) button.getScene().getWindow();
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(e -> stage.setScene(new Scene(layout, width, height)));
                delay.play();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openNewWindow(Button button, String windowName, int width, int height, String title) {
        try {
            URL resource = getClass().getClassLoader().getResource(windowName);
            Stage currentStage = (Stage) button.getScene().getWindow();
            if (resource != null) {
                Parent layout = FXMLLoader.load(resource);
                Stage newStage = new Stage();
                newStage.setScene(new Scene(layout, width, height));
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setX(currentStage.getX() + currentStage.getWidth() + 5);
                newStage.setY(currentStage.getY());
                newStage.setTitle(title);
                newStage.showAndWait();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void popUp(Button button) {
        openNewWindow(button, "PopUpWindow.fxml", 300, 200, "Sure?");
    }

    public void exit(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
