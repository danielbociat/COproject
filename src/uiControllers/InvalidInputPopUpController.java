package uiControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InvalidInputPopUpController extends GeneralController{
    @FXML
    private Button okButton;

    public static boolean result = false;

    public void initialize() {
        initButton(okButton);
    }

    public void okButtonOnActon() {
        exit(okButton);
    }
}
