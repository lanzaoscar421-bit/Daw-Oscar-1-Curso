module org.example.usuariosman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens usuariosman to javafx.fxml;
    exports usuariosman;
}