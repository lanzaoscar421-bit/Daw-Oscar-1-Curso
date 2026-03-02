package Excepciones;

public class ValidacionEdad extends RuntimeException {
    public ValidacionEdad(String message) {
        super("No puedes ser menor de edad");
    }
}
