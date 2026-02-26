public class Validaciones extends Exception {
    public Validaciones(String message) {
        super("Error, los elemenos como el DNI, CIF, o numero de identidicacion no se puecen repetir");
    }
}
