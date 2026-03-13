package Excepciones;

public class ValidacionDirector extends RuntimeException {
    public ValidacionDirector(String message) {
        super("Solo puede haber un director");
    }
}
