package uiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReaperController extends GeneralController{
    @FXML
    private Button backButton;
    @FXML
    private Button runButton;
    @FXML
    private Button displayButton;
    @FXML
    private TextField digitsField;
    @FXML
    private TextField threadField;
    @FXML
    private Label timeLabel;
    @FXML
    private Label scoreLabel;

    @Override
    public void initButton(Button button) {
        String IDLE_BUTTON_STYLE = "-fx-background-color: #006835;";
        String HOVERED_BUTTON_STYLE = "-fx-background-color: #007845;";
        button.setStyle(IDLE_BUTTON_STYLE);
        button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
        button.setOnMouseExited(e -> button.setStyle(IDLE_BUTTON_STYLE));
    }

    public void initialize() {
        initButton(backButton);
        initButton(runButton);
    }

    public void backButtonOnAction(ActionEvent event) {
        back(backButton);
    }

    public void runButtonOnAction() {
        System.out.println("Placeholder!");
    }
}
