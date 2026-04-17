package org.example.demojavafx;

import Model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    private Producto producto;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!"); //Una vez pulsado coge el padel del Welcome y pone este texto.
    }
}