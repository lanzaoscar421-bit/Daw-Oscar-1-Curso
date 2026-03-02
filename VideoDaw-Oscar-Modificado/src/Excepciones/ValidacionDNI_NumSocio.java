package Excepciones;

public class ValidacionDNI_NumSocio extends Exception {
    public ValidacionDNI_NumSocio(String message) {

        super("No se puede repetir el dni ni el numero de socio");
    }
}
