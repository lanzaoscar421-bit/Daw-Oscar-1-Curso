import javax.naming.NamingEnumeration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CuentaBancaria {

    private String iban;
    private Cliente cliente;
    private double saldo;
    private ArrayList<Movimientos> nuevoMovimiento;

    //Constructor
    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.saldo = 0;
        this.cliente = cliente;
        this.nuevoMovimiento = new ArrayList<>();
    }


    public String getIban() {
        return iban;
    }

    public Cliente getCliente() {
        return cliente;
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
        nuevoMovimiento.add(new Movimientos(cantidad, "ingreso"));

        if (cantidad > 3000){
            throw new AvisarHaciendaException(cliente.getNombre(),iban,"ingreso superior a 3000");
        }





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
