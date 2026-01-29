import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;

    //Constructores
    public CuentaBancaria(String iban, String titular) {
        this.iban = iban; // El usuario puede meter el Iban que quiera
        this.titular = titular;//El usuario puede meter el Titular que quiera
        this.saldo = 0;// Al ser siempre 0 no pongo arriba, double Saldo
    }
    //Getters y setter
    //Getter para que se pueda acceder desde otra clase como main
    //Setter para modificar el valor
    //Y en las anteriores no pongo setters por el motivo de que no tiene sentido cambiar el valor


    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    //Mostrar informacion de la cuenta
    //Ahora pondremos public ya que queremos que se vea la informacion en las otras clases

    public String InformacionCuenta(){ //Esto serviria para poner toda la informacion que el usuario ah metido desde el main
        String Info = "";
        Info+="Iban: " + this.iban + "\n";//Ponemos this para que  pille el valor original
        Info+="Titular: " + this.titular + "\n";
        Info+="Saldo: " + this.saldo + "\n";
        return Info; //Ponemos return Info ya que devuelve la informacion Info

    }
    public void informacionMovimientos(){
        for (int i = 0; i<numeromovimientos; i++){
            System.out.println(movimientos[i].InformacionMovimiento());
        }

    }

    private Movimientos [] movimientos = new Movimientos[100];
    private int numeromovimientos = 0;






    public void ingresar (double cantidad){
        if(cantidad <= 0){
            System.out.println("La cantidad desea ingresar tiene que ser mayor a 0");
        } else if (cantidad >=3000) {
            System.out.println("Usted ingreso mucho dinero de Golpe, se notificara a Hacienda⚠️");
        }
        saldo += cantidad;//Para sumar la cantidad del sadldo
        movimientos [numeromovimientos] = new Movimientos(cantidad,"Ingreso" );
        numeromovimientos ++;

        //Aqui ira el registro de movimient
    }

    public void retirar (double cantidad){
        if(cantidad <= 0){
            System.out.println("Tienes que que sacar un minino de 1$ ");
        }
        else if (cantidad < 0){
            System.out.println("Tienes saldo negativo, porfavor ingerese dinero cuando pueda");
        }else if (cantidad > 3000){
            System.out.println("Usted Retiro mucho dinero de Golpe, se notificara a Hacienda⚠️");
        } else if (cantidad<=-50) {
            System.out.println("No puede retirar dinero con -50");
        }


            saldo -= cantidad;
            movimientos [numeromovimientos] = new Movimientos(cantidad,"Retirar" );
            numeromovimientos ++;

        }
//        Registro de movimiento
    }
