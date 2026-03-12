import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

//Link GitHub https://github.com/lanzaoscar421-bit/Daw-Oscar-1-Curso/tree/main/DawBank-Oscar%20-Modificado/DawBank-Oscar

public class DawBank {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        CuentaBancaria Oscar = null;


        final String pathDawBank = "./src/Resources/";
        final String fileNameDawBank= "DawBank.dat";
        boolean fileModeVideodaw = false;



        System.out.println("*********************************");
        System.out.println("Bienvenido a tu Cuenta de banco🧃");
        System.out.println("*********************************");

        System.out.println("Desea cargar los datos?");
        System.out.println("Pulsa S si lo desea, si no pulsa N");

        String cargarOpcion = sc.nextLine();

        if (cargarOpcion.equalsIgnoreCase("S")){
            try (FileInputStream file = new FileInputStream(pathDawBank + fileNameDawBank);
                 ObjectInputStream reader = new ObjectInputStream(file)) {

                Object obj = reader.readObject();
                if (obj instanceof CuentaBancaria) {
                    Oscar = (CuentaBancaria) obj;
                    System.out.println("Datos cargados correctamente de la aldea: " + Oscar.toString());
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo para cargar los datos.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Ha habido un problema al cargar: " + e.getMessage());
            }


        }else{
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

            System.out.println("Inserte el Titular de tu Cuenta Bancaria");
            String cliente = sc.nextLine();

            String DNI;
            do {
                sc = new Scanner(System.in);
                System.out.println("Inserte SU DNI");
                System.out.println("El DNI consta de 8 números + 1 letra ");
                System.out.println("Ejemplo: 12345678Z");
                DNI = sc.nextLine();
                if (!PatronDNI(DNI)){
                    System.out.println("Error, vuelve a insertar el DNI");
                }
            } while (!PatronDNI(DNI));


            LocalDate fechaNacimiento = null;

            System.out.println("Inserte su fecha de nacimiento");
            System.out.println("Ejemplo: 2007-12-06");

            while (fechaNacimiento == null) {
                try {
                    fechaNacimiento = LocalDate.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
                }
            }

            String  numeroTelefono;
            do {
                sc = new Scanner(System.in);
                System.out.println("Inserte SU numero de telefono");
                System.out.println("Ejemplo: 612345678");
                numeroTelefono = sc.nextLine();
                if (!PatronTelefono(numeroTelefono)){
                    System.out.println("Error, vuelve a insertar el DNI");
                }
            } while (!PatronTelefono(numeroTelefono));

            String eMail;
            do {
                sc = new Scanner(System.in);
                System.out.println("Inserte Email");
                System.out.println("Ejemplo: prueba.email23@gmail.com");
                eMail = sc.nextLine();
                if (!PatronEmail(eMail)){
                    System.out.println("Error, vuelve a insertar el DNI");
                }
            } while (!PatronEmail(eMail));


            System.out.println("Por ultimo, inserte su direccion");
            String direccion;
            direccion = sc.nextLine();

             Oscar = new CuentaBancaria(Iban,new Cliente(cliente,DNI,fechaNacimiento,numeroTelefono,eMail,direccion));
        }



        String opcion = "0";
        while (!opcion.equals("9")){
            sc = new Scanner(System.in);

            menu();


            opcion = sc.nextLine();

            switch (opcion) {

                case "1":

                    System.out.println("Esta es tu informacion de la cuenta");
                    System.out.println(Oscar.toString());

                    break;

                case "2":

                    System.out.println("Este es tu Iban: ");
                    System.out.println(Oscar.getIban());

                    break;

                case "3":
                    System.out.println("Este es tu Titular: ");
                    System.out.println(Oscar.getCliente().getNombre());
                    System.out.println("Informacion del titular");
                    System.out.println(Oscar.getCliente());

                    break;
                case "4":
                    System.out.println("Este es tu Saldo: ");
                    System.out.println(Oscar.getSaldo());

                    break;
                case "5":
                    System.out.println("Inserte la cantidad de dinero que dese ");
                    double cantidadIngresar;
                    try {
                        cantidadIngresar = sc.nextDouble();
                        Oscar.ingresar(cantidadIngresar);
                    }catch (AvisarHaciendaException e){ //Menos 50 minimo
                        System.out.println(e.getMessage());
                    }catch (InputMismatchException e){
                        System.out.println("Porfavor inserte un numero para ingresar");
                    }


                    break;
                case "6":


                    System.out.println("Inserte el dinero que desea retirar");

                    double retirarDinero;
                    try {
                        retirarDinero = sc.nextDouble();
                        Oscar.retirar(retirarDinero);
                    }catch (AvisarHaciendaException e){
                        System.out.println(e.getMessage());
                    }catch (CuentaException e){
                        System.out.println(e.getMessage());
                    }catch (InputMismatchException e){
                        System.out.println("Porfavor inserte un numero para retirar");
                    }

                    break;
                case "7":
                    Oscar.informacionMovimientos();

                    break;

                case "8":


                    try(FileOutputStream file = new FileOutputStream(pathDawBank+fileNameDawBank, fileModeVideodaw);
                        ObjectOutputStream buffer = new ObjectOutputStream(file)){

                        buffer.writeObject(Oscar);
                        System.out.println("Todo se guardo Correctamente");


                    } catch (IOException e) {
                        System.err.println("Ha habido un problema al guardar: " + e.getMessage());
                    }

                    break;
                case "9":
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

    private static void menu() {
        System.out.println("Pulse 1 para acceder a los datos de la cuenta ");

        System.out.println("Pulse 2 para ver el Iban");

        System.out.println("Pulse 3 para mostrar el titular");

        System.out.println("Pulse 4 para mostrar el saldo");

        System.out.println("Pulse 5 para insertar dinero en la cuenta");

        System.out.println("Pulse 6 para retirar Dinero");

        System.out.println("Pulsa 7 para ver los movimientos realizados de la cuenta");

        System.out.println("Pulsa 8 para guardar datos");

        System.out.println("Pulse 9 para salir de este programa");
    }


    //Metodos patrones

    static boolean patronIban (String Iban){
        String Patron = "[A-Z]{2}[0-9]{22}";
        return Pattern.matches(Patron,Iban);
    }
    static boolean PatronDNI(String DNI){
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron,DNI);
    }
    static boolean PatronTelefono(String telefono) {
        String Patron = "[0-9]{9}";
        return Pattern.matches(Patron, telefono);
    }
    static boolean PatronEmail(String email) {
        String Patron = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(Patron, email);
    }
}