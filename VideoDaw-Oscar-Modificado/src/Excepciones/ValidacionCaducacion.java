package Excepciones;

public class ValidacionCaducacion extends Exception {
    public ValidacionCaducacion(String message) {
        super("Se paso el plazo de 2 dias, y se entrega con retraso");
    }
}
