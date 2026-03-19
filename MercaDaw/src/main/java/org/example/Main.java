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

        //Conexion a la base de datos
        ConexionSQL();
        //


        System.out.println("Bienvenido a MercaDaw");


        do {


            menu();
            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    VerProductos();
                    break;

                case"2":
                    BuscarRef(sc);
                    break;
                case "3":

                    break;

                case "4":

                    System.out.println("Inserte una cantidad para ver los productos con esa cantidad");
                    int cantidad = sc.nextInt();

                    Product cant = SQLAccessMercaDaw.getProductoCantatidad(cantidad);
                    System.out.println(cant);

                    break;
            }
        }while (!opcion.equals("9"));

    }

    private static void menu() {
        System.out.println("1. Mostrar todos los Productos en el Inventario.");
        System.out.println("2. Buscar producto por referencia.");
        System.out.println("3. Buscar productos por tipo.");
        System.out.println("4. Buscar producto por cantidad.");
        System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
        System.out.println("6. Eliminar Producto por referencia.");
        System.out.println("7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).");
        System.out.println("8. Insertar un nuevo tipo de producto.");
        System.out.println("9. Salir.");
    }

    private static void ConexionSQL() {
        Connection conn = SQLDataManager.getConnection();
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    System.out.println("✅ Ping correcto: conexión establecida con MySQL\n");
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Error");
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ No se pudo conectar a la base de datos");
        }
    }

    private static void BuscarRef(Scanner sc) {
        System.out.println("Inserta referencia del producto");
        String referencia = sc.nextLine();

        Product pd = SQLAccessMercaDaw.getProductoREF(referencia);
        System.out.println(pd);
    }

    private static void VerProductos() {
        System.out.println("Estos son los productos del Inventario\n");
        List<Product> productos = SQLAccessMercaDaw.getProductos();

        for(Product producto : productos){
            System.out.println(producto);
        }
    }
}