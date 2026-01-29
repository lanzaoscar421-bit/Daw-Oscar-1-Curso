import javax.naming.NamingEnumeration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;
    private ArrayList<Movimientos> nuevoMovimiento;

    //Constructor
    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        this.nuevoMovimiento = new ArrayList<>();
    }


    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    //Metodos


    //InformacionMovimientos
    public void informacionMovimientos(){


    }


    //Ingresar
    public void ingresar (double cantidad) throws AvisarHaciendaException{

        double limite = 3000;

        if(cantidad <= 0){
            System.out.println("Porfavor ingrese un minimo de dinero");
            return;
        }

        if (cantidad >= limite){
            System.out.println("Se avisara a hacienda");
        }


        saldo += cantidad;





    }

    //Retirar

    public void retirar (double cantidad){

        if(cantidad <= 0){
            System.out.println("Porfavor retire un minimo de dinero");
        }

        }


    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", nuevoMovimiento=" + nuevoMovimiento +
                '}';
    }
}
