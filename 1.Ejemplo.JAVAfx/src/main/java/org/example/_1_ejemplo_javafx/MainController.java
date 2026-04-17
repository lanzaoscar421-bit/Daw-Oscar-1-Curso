package org.example._1_ejemplo_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Producto;

public class MainController {

    private Producto producto;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hola!"); //Una vez pulsado coge el padel del Welcome y pone este texto.
    }
}