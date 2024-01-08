package cs01.controller.javafx;

import cs01.model.BaseJobProcessor;
import cs01.model.BaseValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxCalculatorController implements Initializable {

    private final BaseValidator baseValidator = new BaseValidator();
    private final BaseJobProcessor baseJobProcessor = new BaseJobProcessor();

    @FXML
    private VBox rootContainer;
    @FXML
    private TextField param1;
    @FXML
    private TextField param2;
    @FXML
    private TextField result;
    @FXML
    private Label errorMessageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        param1.textProperty()
            .addListener((observable, oldValue, newValue) -> {

                String param2Value = param2.textProperty().get();

                try {
                    baseValidator.validateStringBinary(newValue);

                    if (param2Value.isEmpty()) {
                        result.setText("");
                        errorMessageLabel.setText("두 번째 Binary 숫자를 입력해 주세요.");
                    } else {
                        result.setText(baseJobProcessor.callSumBinary(newValue, param2Value));
                        errorMessageLabel.setText("");
                    }
                } catch (Exception e) {
                    result.setText("");
                    errorMessageLabel.setText(e.getMessage());
                }
            });

        param2.textProperty()
            .addListener((observable, oldValue, newValue) -> {

                String param1Value = param1.textProperty().get();

                try {
                    baseValidator.validateStringBinary(newValue);

                    if (param1Value.isEmpty()) {
                        result.setText("");
                        errorMessageLabel.setText("첫 번째 Binary 숫자를 입력해 주세요.");
                    } else {
                        result.setText(baseJobProcessor.callSumBinary(param1Value, newValue));
                        errorMessageLabel.setText("");
                    }
                } catch (Exception e) {
                    result.setText("");
                    errorMessageLabel.setText(e.getMessage());
                }
            });
    }

    @FXML
    protected void onClose(ActionEvent e) {
        Stage dialogStage = (Stage) rootContainer.getScene().getWindow();
        dialogStage.close();
    }
}
