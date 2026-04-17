module org.example._1_ejemplo_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example._1_ejemplo_javafx to javafx.fxml;
    exports org.example._1_ejemplo_javafx;
}