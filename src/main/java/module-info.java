module cs {
    requires javafx.controls;
    requires javafx.fxml;

    opens cs01.controller.javafx to javafx.fxml;
    exports cs01;
}