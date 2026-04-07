package org.example.Exceptions;

public class ValidacionDNI extends Exception {
    public ValidacionDNI(String message) {
        super("Error no se puede repetir el DNI");
    }
}
