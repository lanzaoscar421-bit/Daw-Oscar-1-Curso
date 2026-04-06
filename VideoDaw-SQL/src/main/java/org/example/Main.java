package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("Pulsa 3 alquilar Vinilo");
            System.out.println("Pulsa 4 devolver Vinilo");
            System.out.println("Pulsa 5 dar de baja cliente");
            System.out.println("Pulsa 6 dar de baja Vinilo");
            System.out.println("Pulsa 7 ver informacion cliente y vinilos");
            System.out.println("Pulsa 8 ver los generos de los vinilos");
            System.out.println("Pulsa 9 ver toda la info de los alquileres");
            System.out.println("Pulsa 10 si desea Salir");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":



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
                    //Ver todos los alquileres

                    break;
                case "10":

                    System.out.println("Adios.");
                    break;
            }
        }while(!opcion.equals("10"));

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