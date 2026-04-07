package org.example.Exceptions;

public class ValidacionDNI extends Exception {
    public ValidacionDNI(String message) {
        super("Error al insertar un cliente, No se puede tener Dnis repetidos");
    }
}
