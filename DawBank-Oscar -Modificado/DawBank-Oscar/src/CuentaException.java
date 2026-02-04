public class CuentaException extends Exception {

    public CuentaException(String message) {
        super("Con este movimiento tendras menos de -50 euros, no puedes retirar mas");

    }


}
