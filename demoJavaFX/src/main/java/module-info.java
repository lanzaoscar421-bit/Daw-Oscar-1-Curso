module org.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demojavafx to javafx.fxml;
    exports org.example.demojavafx;
}