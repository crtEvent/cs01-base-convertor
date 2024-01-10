package cs01;

import cs01.controller.javafx.FxRootController;
import cs01.model.BaseJobProcessor;
import cs01.model.BaseValidator;
import cs01.model.Calculator;
import cs01.model.Convertor;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            FxApplication.class.getResource("main-view.fxml"));
        Parent parent = fxmlLoader.load();

        var controller = (FxRootController) fxmlLoader.getController();
        controller.setBaseJobProcessor(new BaseJobProcessor(new Convertor(), new Calculator(), new BaseValidator()));

        Scene scene = new Scene(parent);
        stage.setTitle("CS01 Base Convertor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}