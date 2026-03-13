package Excepciones;

public class ValidacionGerenteDep extends Exception {
    public ValidacionGerenteDep(String message) {
        super("No puede haber mas de 3 gerentes");
    }
}
