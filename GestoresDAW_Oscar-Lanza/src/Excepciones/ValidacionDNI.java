package Excepciones;
public class ValidacionDNI extends RuntimeException {
    public ValidacionDNI(String message) {
        super("El dni de un trabajador no puede ser repetido Inserte otra vez el dni");
    }
}
