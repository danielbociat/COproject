package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PhiController extends GeneralController{
    @FXML
    private Button backButton;
    @FXML
    private Button runButton;
    @FXML
    private TextField textField;
    @FXML
    private Label timeLabel;

    public void initialize() {
        initButton(backButton);
        initButton(runButton);
    }

    public void backButtonOnAction(ActionEvent event) {
        back(backButton);
    }

    public void runButtonOnAction() {
        if (checkInput(textField.getText())) {
            isRunning = true;
            backButton.setStyle("-fx-background-color: grey");
            int numDigits = Integer.parseInt(textField.getText());
            double time = run("PHI", numDigits);
            String timeString = String.format("%.4f",(time/1000000));
            timeLabel.setText("Finished in " + timeString + " miliseconds");
            isRunning = false;
            initButton(backButton);
        }
        else
            invalidInputPopUp(runButton);
    }
}
