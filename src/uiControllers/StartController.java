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
        exitWithPopUp(exitButton);
    }

    public void eButtonOnAction(ActionEvent event) {
        AlgoController.algo = "E";
        changeWindow(eButton, "AlgoWindow.fxml", 600, 400);
    }

    public void piButtonOnAction(ActionEvent event) {
        AlgoController.algo = "PI";
        changeWindow(eButton, "AlgoWindow.fxml", 600, 400);
    }

    public void phiButtonOnAction(ActionEvent event) {
        AlgoController.algo = "PHI";
        changeWindow(eButton, "AlgoWindow.fxml", 600, 400);
    }
}
