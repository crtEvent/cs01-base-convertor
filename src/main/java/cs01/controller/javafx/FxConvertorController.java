package cs01.controller.javafx;

import cs01.model.BaseJobProcessor;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxConvertorController implements Initializable {

    private BaseJobProcessor baseJobProcessor;

    @FXML
    private VBox rootContainer;
    @FXML
    private Label dialogTitle;
    @FXML
    private TextField param1;
    @FXML
    private TextField result;
    @FXML
    private Label errorMessageLabel;

    public void setBaseJobProcessor(BaseJobProcessor baseJobProcessor) {
        this.baseJobProcessor = baseJobProcessor;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        param1.textProperty()
            .addListener((observable, oldValue, newValue) -> {
                String title = dialogTitle.textProperty().get();

                try {
                    if (newValue.isEmpty()) {
                        result.setText("");
                        errorMessageLabel.setText("");
                    } else if (Objects.equals(ConvertorType.BIN_2_DEC.generateTitle(), title)) {
                        result.setText(baseJobProcessor.callBin2dec(newValue));
                        errorMessageLabel.setText("");
                    } else if (Objects.equals(ConvertorType.DEC_2_BIN.generateTitle(), title)) {
                        result.setText(baseJobProcessor.callDec2bin(newValue));
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
