package Excepciones;

public class ValidacionDNI extends Exception {
    public ValidacionDNI(String message) {
        super("El dni no puede ser repetido");
    }
}
