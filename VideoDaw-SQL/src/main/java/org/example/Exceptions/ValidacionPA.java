package org.example.Exceptions;

public class ValidacionPA extends Exception {
    public ValidacionPA(String message) {
        super("Si el cliente es menor de edad, no puede alquilar estos productos");
    }
}
