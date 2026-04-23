package org.example.apppersonasfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PersonasController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}