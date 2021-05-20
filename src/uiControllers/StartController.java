package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private Button eButton;
    @FXML
    private Button piButton;
    @FXML
    private Button phiButton;

    public void initialize() {
        initButton(exitButton);
        initButton(eButton);
        initButton(piButton);
        initButton(phiButton);
    }

    public void exitButtonOnAction(ActionEvent event) {
        if (popUpAnswer(exitButton))
            exit(exitButton);
    }

    public void eButtonOnAction(ActionEvent event) {
        changeWindow(eButton, "EWindow.fxml", 600, 400);
    }

    public void piButtonOnAction(ActionEvent event) {
        changeWindow(eButton, "PiWindow.fxml", 600, 400);
    }

    public void phiButtonOnAction(ActionEvent event) {
        changeWindow(eButton, "PhiWindow.fxml", 600, 400);
    }
}
