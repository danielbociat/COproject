package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PhiController extends GeneralController{
    @FXML
    private Button backButton;
    @FXML
    private Button runButton;
    @FXML
    private TextField textField;

    public void initialize() {
        initButton(backButton);
    }

    public void backButtonOnAction(ActionEvent event) {
        backWithPopUp(backButton);
    }

    public void runButtonOnAction() {
        if (checkInput(textField.getText())) {
            int numDigits = Integer.parseInt(textField.getText());
            System.out.println(numDigits * 10);
        }
        else
            System.out.println("Invalid input!");
    }
}
