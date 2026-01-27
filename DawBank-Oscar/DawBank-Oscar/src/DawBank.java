import java.util.Scanner;
import java.util.regex.Pattern;

//Link GitHub https://github.com/lanzaoscar421-bit/Proyectos/tree/main/DawBank-Oscar

public class DawBank {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        //Primero pondremos para que el usuario ponga sus datos

        System.out.println("*********************************");
        System.out.println("Bienvenido a tu Cuenta de banco🧃");
        System.out.println("*********************************");


        System.out.println("Empecemos!!!");
        String Iban;
        do {
            System.out.println("Inserte el Iban");
            System.out.println("Instrucciones");
            System.out.println("***************");
            System.out.println("El Iban se compone de dos letras AL PRINCIPIO y despues 22 numeros (Los que quiera)");
            System.out.println("Ejemplo: ES6621000418401234567891");
            Iban = sc.nextLine();
        }while (!patronIban(Iban));

        System.out.println("Inserte el Titular de tu Cuenta Bancaria");     //Creamos cuenta primero ya que el usuario es tonto y puede ingresar dinero sin tener cuenta
        String Titular = sc.nextLine();

        CuentaBancaria Oscar = new CuentaBancaria(Iban, Titular);  //Creamos un objeto el cual es mi cuenta bancaria

        int limite =  -50;


        int opcion = 0;
        while (opcion != 8){

            System.out.println("Pulse 1 para acceder a los datos de la cuenta ");

            System.out.println("Pulse 2 para ver el Iban");

            System.out.println("Pulse 3 para mostrar el titular");

            System.out.println("Pulse 4 para mostrar el saldo");

            System.out.println("Pulse 5 para insertar dinero en la cuenta");

            System.out.println("Pulse 6 para retirar Dinero");

            System.out.println("Pulsa 7 para ver los movimientos realizados de la cuenta");

            System.out.println("Pulse 8 para salir de este programa");


            if (!sc.hasNextInt()) {
                System.out.println("Introduce un número (no letras).");
                sc.nextLine(); // Medida para usuarios
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("Esta es tu informacion de la cuenta");
                    Oscar.InformacionCuenta();
                    System.out.println(Oscar.InformacionCuenta());

                    break;

                case 2:

                    System.out.println("Este es tu Iban: ");
                    System.out.println(Oscar.getIban()); //Ponemos Get para llamar al Iban de Cuenta Bancaria

                    break;

                case 3:
                    System.out.println("Este es tu Titular: ");
                    System.out.println(Oscar.getTitular());

                    break;
                case 4:
                    System.out.println("Este es tu Saldo: ");
                    System.out.println(Oscar.getSaldo());

                    break;
                case 5:
                    System.out.println("Inserte la cantidad de dinero que desee ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    Oscar.ingresar(cantidad);

                    break;
                case 6:

                    System.out.println("Advertencia: ");
                    System.out.println("Si tu cuenta llega a -50$");
                    System.out.println("No te dejara retirar mas dinero");
                    System.out.println("***************************");

                    int cantidad2;
                    do {
                        System.out.println("Inserte la cantidad de dinero que desea retirar");
                        cantidad2 = sc.nextInt();
                    } while (cantidad2 < 0);
                    int saldodespues = (int) (Oscar.getSaldo() - cantidad2);
                    if (saldodespues >= limite) {
                        Oscar.retirar(cantidad2);
                        System.out.println("El limite de retirar dinero son hasta -50");
                        System.out.println("No podras retirar mas dinero");
                    }else {
                        System.out.println("Estas en numeros negativos");
                        System.out.println("Porfavor inserte Dinero");
                        System.out.println("**************************");
                    }
                    sc.nextLine();

                    if (Oscar.getSaldo() <= limite) {
                        System.out.println("Ingresa dinero en la cuenta para porder retirarlo");
                        return;
                    }

                    break;
                case 7:
                    System.out.println("Sus movimientos fueron : ");
                    Oscar.informacionMovimientos();

                    break;
                case 8:
                    System.out.println("***************");
                    System.out.println("Adios, Buen Dia");
                    System.out.println("***************");
                    break;
                default:
                    System.out.println("Porfavor inserte un numero");
                    break;
            }


        }



    }
    static boolean patronIban (String Iban){
        String Patron = "[A-Z]{2}[0-9]{22}";

        return Pattern.matches(Patron,Iban);
    }
}