public class AvisarHaciendaException extends RuntimeException {
    private String titular;
    private String iban;
    private String operacion;
    public AvisarHaciendaException(String message){

        super(message);
    }
}
