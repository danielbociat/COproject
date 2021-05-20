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
        System.out.println("E");
    }

    public void piButtonOnAction(ActionEvent event) {
        System.out.println("PI");
    }

    public void phiButtonOnAction(ActionEvent event) {
        System.out.println("PHI");
    }
}
