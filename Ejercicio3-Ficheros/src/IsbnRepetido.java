public class IsbnRepetido extends Exception {
    public IsbnRepetido(String message) {
        super("Error, El Isbn esta repetido");
    }
}
