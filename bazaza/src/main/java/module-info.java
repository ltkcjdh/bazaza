module com.example.bazaza {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.bazaza to javafx.fxml;
    exports com.example.bazaza;
}