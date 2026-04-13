package org.example;

// import com.google.protobuf.Internal;

import org.example.Exceptions.ValidacionDNI;
import org.example.Exceptions.ValidacionPA;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String opcion = "";

        ConexionSQL();

        System.out.println("Bienvenido a VideoDaw");

        do {

            System.out.println("Pulse 1 crear y registrar Vinilo");
            System.out.println("Pulse 2 crear y registrar cliente");
            System.out.println("Pulsa 3 compra Vinilo");
            System.out.println("Pulsa 4 devolver Vinilo");
            System.out.println("Pulsa 5 dar de baja cliente");
            System.out.println("Pulsa 6 dar de baja Vinilo");
            System.out.println("Pulsa 7 ver informacion cliente y vinilos");
            System.out.println("Pulsa 8 ver los generos de los vinilos");
            System.out.println("Pulsa 9 ver toda la info de las compras");
            System.out.println("Pulsa 10 si desea Salir");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    //Metodo Insertar vinilos
                    insertarVinilo(sc);
                    break;
                case "2":
                    String dniAdd;
                    do {
                        System.out.println("El DNI consta de 8 números + 1 letra ");
                        System.out.println("Ejemplo: 12345678Z");
                        System.out.println("El Dni no se puede repetir");
                        dniAdd = sc.nextLine();
                    }while (!PatronDNI(dniAdd));

                    System.out.println("Inserte su nombre");
                    String nombre = sc.nextLine();

                    System.out.println("Inserte su direccion");
                    String direccion = sc.nextLine();

                    System.out.println("Inserte su fecha de Nacimiento");

                    LocalDate fechaNacimiento = null;

                    System.out.println("Inserte su fecha de nacimiento");
                    System.out.println("Ejemplo de formato: 2007-12-06");

                    while (fechaNacimiento == null) {
                        try {
                            fechaNacimiento = LocalDate.parse(sc.nextLine());

                        } catch (Exception e) {
                            System.out.println("Por favor, inserte bien el formato (YYYY-MM-DD)");
                        }
                    }

                    int nextNuCliente = SQLAccessVideoDaw.contarClientes() + 1;
                    String numClienteADD = String.format("SOC%03d", nextNuCliente);


                    try {
                        //Controlar el Dni que no se pueda repetir
                        SQLAccessVideoDaw.validarDni(dniAdd);
                        Cliente nuevoCliente = new Cliente(-1,dniAdd,nombre,direccion,fechaNacimiento,numClienteADD);
                        int addCliente = SQLAccessVideoDaw.insertarCliente(nuevoCliente);
                        System.out.println("Insertado Correctamente");
                    }catch (ValidacionDNI e){
                        System.out.println(e.getMessage());
                    }
                    break;


                case "3":

                    System.out.println("Inserte primero el Dni: ");

                    verClientesDisponibles();

                    String dniAL;
                    do {
                        System.out.println("El DNI consta de 8 números + 1 letra ");
                        System.out.println("Ejemplo: 12345678Z");
                        dniAL = sc.nextLine();
                    }while (!PatronDNI(dniAL));


                    verVinilosDisponibles();

                    System.out.println("Ahora inserte el codigo del vinilo que quieres alquilar");
                    String codigoViniloAL = sc.nextLine();

                    try {

                        SQLAccessVideoDaw.validarCompra(dniAL,codigoViniloAL);
                        int compra = SQLAccessVideoDaw.insertarCompra(dniAL, codigoViniloAL);

                        if (compra > 0) {
                            System.out.println("Comprado correctamente");
                        } else {
                            System.out.println("Error al realizar la compra");
                        }

                    }catch (ValidacionPA e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "4":

                    verVinilosCompradosNoDevueltos();


                    System.out.println("Inserte el Dni del cliente: ");
                    String dniClienteDev = sc.nextLine();

                    System.out.println("Inserte el codigo del vinilo: ");
                    String codigoViniloDev = sc.nextLine();



                    int devolucion = SQLAccessVideoDaw.devolverVinilo(dniClienteDev, codigoViniloDev);
                    if (devolucion > 0) {
                        System.out.println("Devolucion correctamente");
                    }else {
                        System.out.println("Error al devolver vinilo");
                    }

                    break;

                case "5":
                    //Dar de baja clientes
                    verClientesDisponibles();
                    System.out.println("Inserte el Dni del cliente que quieres dar de Baja");
                    String dniClienteBaja = sc.nextLine();


                    int bajaCliente =  SQLAccessVideoDaw.bajaCliente(dniClienteBaja);

                    if (bajaCliente > 0) {
                        System.out.println("Baja correctamente");
                    }else{
                        System.out.println("Error al baja cliente");
                    }


                    break;
                case "6":
                    //Dar de baja Vinilos

                    verClientesDisponibles();
                    System.out.println("Inserte el codigo de vinilo que quieres dar de baja");
                    String codigoViniloBaja = sc.nextLine();

                    int bajaVinilo = SQLAccessVideoDaw.bajaVinilo(codigoViniloBaja);

                    if (bajaVinilo > 0) {
                        System.out.println("Baja correctamente");
                    }else{
                        System.out.println("Error al baja al vinilo");
                    }


                    break;
                case "7":
                    //Ver Clientes y Vinilos
                    verClientes();
                    //
                    verVinilos();
                    break;
                case "8":
                    //Ver genero de Vinilos
                    verGeneros();
                    break;
                case "9":
                    //Ver todos los Compras
                    verCompras();
                    break;
                case "10":
                    //Despedida
                    System.out.println("Adios.");
                    break;
            }
        }while(!opcion.equals("10"));
    }

    private static void verVinilosCompradosNoDevueltos() {
        List<String> verVinilosNoDevueltos = SQLAccessVideoDaw.verVinilosCompradosNoDevueltos();
        for(String vinilo : verVinilosNoDevueltos) {
            System.out.println(vinilo);
        }
    }

    private static void verCompras() {
        System.out.println("Compras: ");
        List<String> compras = SQLAccessVideoDaw.getCompras(); 
        for(String str : compras) {
            System.out.println(str);
        }
    }

    static boolean PatronDNI(String DNI){
        String Patron = "[0-9]{8}[A-Z]";
        return Pattern.matches(Patron,DNI);
    }


    private static void insertarVinilo(Scanner sc) {
        System.out.println("Inserta la banda del Vinilo");
        String bandaADD = sc.nextLine();

        System.out.println("Inserta el titulo del Vinilo");
        String tituloADD = sc.nextLine();

        System.out.println("Inserta el  numero del genero del Vinilo");
        List <String> generos = SQLAccessVideoDaw.getGeneros();
        for(String s : generos) {
            System.out.println(s);
        }
        int opcionGenero;

        do {
            System.out.println("Elige el un numero de los disponibles para insertar un genero");
            opcionGenero = sc.nextInt();
        } while (opcionGenero <= 0 || opcionGenero > generos.size());


        String opcionPA;
        boolean paADD = false;

        sc.nextLine();
        do {
            System.out.println("Este vinilo tiene Parental Advisory?");
            System.out.println("S-N");
            opcionPA = sc.nextLine();
        }while (!opcionPA.equalsIgnoreCase("N") && !opcionPA.equalsIgnoreCase("S"));

        if(opcionPA.equalsIgnoreCase("S")){
            paADD = true;
        }else {
            paADD = false;
        }


        int nextId = SQLAccessVideoDaw.contarVinilos() + 1;
        String codigoADD = String.format("VIN%03d", nextId);

        Vinilo nuevoVinilo = new Vinilo(-1,codigoADD ,bandaADD,tituloADD,opcionGenero,paADD);
        int addVinilo = SQLAccessVideoDaw.insertarVinilo(nuevoVinilo);
        System.out.println("Vinilo Insertado exitosamente");
    }

    private static void verClientes() {
        System.out.println("Clientes: ");
        List <Cliente> clientes = SQLAccessVideoDaw.getClientes();

        for(Cliente c : clientes) {
            System.out.println(c + "\n");
        }
    }

    private static void verVinilos() {
        System.out.println("Vinilos: ");

        List <Vinilo> vinilos = SQLAccessVideoDaw.getVinilos();
        for(Vinilo v : vinilos) {
            System.out.println(v + "\n");
        }
    }

    private static void verVinilosDisponibles(){
        System.out.println("VinilosDisponibles: ");

        List<Vinilo> vinilos = SQLAccessVideoDaw.getVinilosDisponibles();
        for(Vinilo v : vinilos) {
            System.out.println(v + "\n");
        }
    }

    private static void verClientesDisponibles(){
        System.out.println("ClientesDisponibles: ");
        List<Cliente> clientes = SQLAccessVideoDaw.getClientesActivos();
        for(Cliente c : clientes) {
            System.out.println(c + "\n");
        }
    }

    private static void verGeneros() {
        System.out.println("Generos: ");

        List <String> generos = SQLAccessVideoDaw.getGeneros();
        for(String s : generos) {
            System.out.println(s);
        }
    }

    private static void ConexionSQL() {
        Connection conn = SQLDataManager.getConnection();
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    System.out.println("Ping correcto: conexión establecida con MySQL\n");
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("Eror");
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos");
        }
    }

}