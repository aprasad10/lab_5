module com.example.lab_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_5 to javafx.fxml;
    exports com.example.lab_5;
}