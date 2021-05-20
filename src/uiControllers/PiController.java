package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PiController extends GeneralController{
    @FXML
    private Button backButton;

    public void initialize() {
        initButton(backButton);
    }

    public void backButtonOnAction(ActionEvent event) {
        backWithPopUp(backButton);
    }
}
