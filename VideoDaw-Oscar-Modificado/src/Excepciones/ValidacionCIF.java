package Excepciones;

public class ValidacionCIF extends Exception {
    public ValidacionCIF(String message) {
        super("Error, El cif no puede ser repetido");
    }
}
