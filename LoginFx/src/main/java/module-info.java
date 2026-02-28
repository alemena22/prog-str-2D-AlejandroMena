module com.example.loginfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginfx to javafx.fxml;
    opens com.example.loginfx.controllers to javafx.fxml;
    exports com.example.loginfx;
}