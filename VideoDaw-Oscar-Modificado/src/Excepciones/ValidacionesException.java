package Excepciones;

public class ValidacionesException extends Exception {
    public ValidacionesException(String message) {
        super("Error, los elemenos como el DNI, CIF, o numero de identidicacion no se puecen repetir");
    }
}
