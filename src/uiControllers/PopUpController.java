package uiControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpController extends GeneralController{
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    public void initialize() {
        initButton(yesButton);
        initButton(noButton);
    }

    public void yesButtonOnActon() {
        System.out.println("Yes");
        exit(yesButton);
    }

    public void noButtonOnActon() {
        System.out.println("No");
        exit(noButton);
    }
}
