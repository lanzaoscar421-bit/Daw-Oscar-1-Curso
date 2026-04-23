package org.example.apppersonasfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.apppersonasfx.model.Persona;

public class PersonasController {

    Persona pp;
    private ObservableList<Persona> personas = FXCollections.observableArrayList();


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}