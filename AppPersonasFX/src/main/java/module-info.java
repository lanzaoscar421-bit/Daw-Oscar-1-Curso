module org.example.apppersonasfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.apppersonasfx to javafx.fxml;
    exports org.example.apppersonasfx;
}