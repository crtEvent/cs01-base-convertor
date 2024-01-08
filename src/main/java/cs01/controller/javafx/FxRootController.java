package cs01.controller.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FxRootController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    protected void onBin2decButtonClick(ActionEvent e) throws IOException {
        openConvertorDialog(ConvertorType.BIN_2_DEC);
    }

    @FXML
    protected void onDec2binButtonClick(ActionEvent e) throws IOException {
        openConvertorDialog(ConvertorType.DEC_2_BIN);
    }

    @FXML
    protected void onSumBinaryButtonClick(ActionEvent e) throws IOException {
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Binary addition");

        Parent parent = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("/cs01/calculator-view.fxml")));

        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

    private void openConvertorDialog(ConvertorType type) throws IOException {
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle(type.generateTitle());

        Parent parent = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("/cs01/convertor-view.fxml")));
        Label dialogTitle = (Label) parent.lookup("#dialogTitle");
        dialogTitle.setText(type.generateTitle());
        Label param1Label = (Label) parent.lookup("#param1Label");
        param1Label.setText(type.getOrigin());
        Label resultLabel = (Label) parent.lookup("#resultLabel");
        resultLabel.setText(type.getTarget());

        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }
}