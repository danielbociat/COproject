package uiControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PopUpController extends GeneralController{
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    public static boolean result = false;

    public void initialize() {
        initButton(yesButton);
        initButton(noButton);
    }

    public void yesButtonOnActon() {
        result = true;
        exit(yesButton);
    }

    public void noButtonOnActon() {
        result = false;
        exit(noButton);
    }
}
