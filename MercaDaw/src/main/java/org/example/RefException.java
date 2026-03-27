package org.example;

public class RefException extends Exception {
    public RefException(String message) {
        super("No se puede repetir Referencia, Vuelva a insertar otro producto pero con otra referencia");
    }
}
