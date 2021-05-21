package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.lang.Math;

public class AlgoController extends GeneralController{
    @FXML
    private Button backButton;
    @FXML
    private Button runButton;
    @FXML
    private Button displayButton;
    @FXML
    private TextField textField;
    @FXML
    private Label timeLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label algoLabel;
    @FXML
    private TextArea textArea;

    private boolean displaying = false;
    public static String algo = "E";

    public void initialize() {
        initButton(backButton);
        initButton(runButton);
        initButton(displayButton);
        textArea.setVisible(displaying);
        algoLabel.setText("digits of " + algo);
    }

    public void backButtonOnAction(ActionEvent event) {
        back(backButton);
    }

    public void runButtonOnAction() {
        if (checkInput(textField.getText())) {
            isRunning = true;
            backButton.setStyle("-fx-background-color: grey");
            backButton.setDisable(true);
            timeLabel.setText("");
            scoreLabel.setText("");

            int numDigits = Integer.parseInt(textField.getText());
            double time = run(algo, numDigits);
            time = (time/1000000);

            String timeString = String.format("%.4f", time);
            timeLabel.setText(timeString + " mili");
            String scoreString = String.format("%.0f", numDigits/Math.sqrt(time));
            scoreLabel.setText(scoreString);

            if(displaying) {
                textArea.setText(toDisplay);
            }

            isRunning = false;
            initButton(backButton);
            backButton.setDisable(false);
        }
        else
            invalidInputPopUp(runButton);
    }

    public void displayButtonOnAction() {
        if (displaying) {
            displaying = false;
            textArea.setVisible(displaying);
        }
        else {
            displaying = true;
            textArea.setVisible(displaying);
        }
    }
}
