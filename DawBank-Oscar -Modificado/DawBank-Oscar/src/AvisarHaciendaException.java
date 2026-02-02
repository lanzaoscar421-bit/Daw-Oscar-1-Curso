public class AvisarHaciendaException extends Exception {
    private String titular;
    private String iban;
    private String operacion;
    public AvisarHaciendaException(String message,String titular,String iban){
        super("hiciste un movimiento con demasiado dinero, se avisara a hacienda");

        this.titular = null;
        this.iban = null;
        this.operacion = null;
    }


    @Override
    public String toString() {
        return "AvisarHaciendaException{" +
                "titular='" + titular + '\'' +
                ", iban='" + iban + '\'' +
                ", operacion='" + operacion + '\'' +
                '}';
    }
}
