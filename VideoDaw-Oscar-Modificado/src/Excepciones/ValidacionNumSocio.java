package Excepciones;

public class ValidacionNumSocio extends Exception {
    public ValidacionNumSocio(String message) {

        super("No se puede repetir el numero de Socio");
    }
}
