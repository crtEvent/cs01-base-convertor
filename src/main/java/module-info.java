module cs {
    requires javafx.controls;
    requires javafx.fxml;

    opens cs01 to javafx.fxml;
    exports cs01;
}