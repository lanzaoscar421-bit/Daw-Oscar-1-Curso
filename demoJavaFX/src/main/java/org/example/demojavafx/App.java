package org.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml")); //El fichero que tiene que apuntar
        Scene scene = new Scene(fxmlLoader.load(), 640, 640); //Este carga la escena y enseña el tamaño
        stage.setTitle("Hello!");//El titulo
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}