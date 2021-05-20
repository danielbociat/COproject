package uiControllers;

import bench.IBenchmark;
import bench.cpu.CPUFixedVsFloatingPoint;
import bench.cpu.NumberRepresentation;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import java.net.URL;

public class GeneralController {

    protected static final String IDLE_BUTTON_STYLE = "-fx-background-color: #FF9999;";
    protected static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #FFCCCC";

    public boolean isRunning = false;

    public void initButton(Button button) {
        if(isRunning == false) {
            button.setStyle(IDLE_BUTTON_STYLE);
            button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
            button.setOnMouseExited(e -> button.setStyle(IDLE_BUTTON_STYLE));
        }
    }

    public void changeWindow(Button button, String windowName, int width, int height) {
        try {
            URL resource = getClass().getClassLoader().getResource(windowName);
            if (resource != null) {
                Parent layout = FXMLLoader.load(resource);
                Stage stage = (Stage) button.getScene().getWindow();
                PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
                delay.setOnFinished(e -> stage.setScene(new Scene(layout, width, height)));
                delay.play();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean popUpAnswer(Button button) {
        boolean result = false;
        PopUpController.result = false;
        try {
            URL resource = getClass().getClassLoader().getResource("PopUpWindow.fxml");
            Stage currentStage = (Stage) button.getScene().getWindow();
            if (resource != null) {
                FXMLLoader loader = new FXMLLoader(resource);
                Parent layout = loader.load(resource);

                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(layout, 300, 200));
                newStage.setTitle("Are you sure?");
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.showAndWait();
                newStage.centerOnScreen();

                result = PopUpController.result;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void exit(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void exitWithPopUp(Button button) {
        if(popUpAnswer(button))
            exit(button);
    }

    public void back(Button button) {
        changeWindow(button, "StartWindow.fxml", 600, 400);
    }

    public boolean checkInput(String string) {
        return string.length() > 0 && string.length() < 7 && string.matches("[0-9]*");
    }

    public void invalidInputPopUp(Button button) {
        try {
            URL resource = getClass().getClassLoader().getResource("InvalidInputPopUpWindow.fxml");
            Stage currentStage = (Stage) button.getScene().getWindow();
            if (resource != null) {
                FXMLLoader loader = new FXMLLoader(resource);
                Parent layout = loader.load(resource);

                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(layout, 300, 200));
                newStage.setTitle("Invalid input!!");
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.showAndWait();
                newStage.centerOnScreen();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public double run(String c, int digits){
        ITimer timer = new Timer();
        ILog log = /* new FileLogger("bench.log"); */new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark bench = new CPUFixedVsFloatingPoint();
        if(c == "PI")
        {
            bench.initialize(digits, NumberRepresentation.PI);
        }
        else if(c == "E")
        {
            bench.initialize(digits, NumberRepresentation.E);
        }
        else
        {
            bench.initialize(digits, NumberRepresentation.PHI);
        }
        bench.warmUp();
        timer.start();
        bench.run();

        long time = timer.stop();
        log.writeTime("Finished in", time, timeUnit);

        bench.clean();
        log.close();
        log.writeTime("Finished in", time, timeUnit);
        bench.clean();
        log.close();
        return time;
    }
}
