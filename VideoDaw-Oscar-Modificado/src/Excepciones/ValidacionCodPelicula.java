package Excepciones;

public class ValidacionCodPelicula extends Exception {
    public ValidacionCodPelicula(String message) {
        super("El codigo de pelicula no se puede repetir, porfavor inserte otro numero");
    }
}
