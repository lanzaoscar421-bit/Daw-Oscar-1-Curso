package org.example;

import java.sql.Connection;
import java.sql.SQLException;
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

                    buscarMetodoTipo(sc);


                    break;

                case "4":

                     // Busqueda por cantidad
                    busquedaCANT(sc);

                    break;

                case "5":


                    String referenciaADD;
                    do {
                        System.out.println("Ingresa la referencia del producto");
                        System.out.println("Patron: 'REF000' ");
                        referenciaADD = sc.nextLine();
                    }while (!PatronReferencia(referenciaADD));

                    System.out.println("Ahora inserta los tipos");
                    System.out.println("Tipos disponibles:");

                    List<String> tiposADD = SQLAccessMercaDaw.getTipos();

                    int iadd = 1;
                    for (String tipo : tiposADD) {
                        System.out.println(iadd + ". " + tipo);
                        iadd++;
                    }

                    int tipoADD;
                    do {
                        System.out.println("Elige el tipo (numero):");
                        tipoADD = sc.nextInt();
                    } while (tipoADD <= 0 || tipoADD > tiposADD.size());

                    sc.nextLine();


                    System.out.println("Inserte el nombre del producto");
                    String nombreADD = sc.nextLine();

                    System.out.println("Inserte la descripcion del producto");
                    String descripcionADD = sc.nextLine();

                    System.out.println("Inserte la cantidad del producto");
                    int cantidadADD = sc.nextInt();

                    System.out.println("Inserte la precio del producto");
                    double precioADD = sc.nextDouble();

                    System.out.println("Inserte el descuento del producto");
                    int descuentoADD = sc.nextInt();

                    //
                    sc.nextLine();

                    int iva = 21;

                    boolean aplicarDPT = false;
                    String opcionDescuento;

                    do {
                        System.out.println("Inserte desea aplicar el descuento");
                        System.out.println("S-N");
                         opcionDescuento = sc.nextLine();
                    }while (!opcionDescuento.equalsIgnoreCase("S") && !opcionDescuento.equalsIgnoreCase("N"));

                    if (opcionDescuento.equalsIgnoreCase("S")) {
                        aplicarDPT = true;
                    }else if (opcionDescuento.equals("N")) {
                        aplicarDPT = false;
                    }else{
                        System.out.println("");
                    }


                    Product nuevoProducto = new Product(-1,referenciaADD,tipoADD,nombreADD,descripcionADD,cantidadADD,precioADD,descuentoADD,iva,aplicarDPT);
                    int addProducto = SQLAccessMercaDaw.insertarProducto(nuevoProducto);

                    List<Product> productos = SQLAccessMercaDaw.getProductos();

                    for(Product producto : productos){
                        System.out.println(producto);
                    }

                    break;
                case "6":

                    productDel(sc);

                    break;
                case "7":

                    updateProduct(sc);

                    break;
                case "8":

                    insertarTipos(sc);


                    break;
                case "9":

                    System.out.println("Adios.");

                    break;
            }
        }while (!opcion.equals("9"));

    }

    private static void insertarTipos(Scanner sc) {
        System.out.println("Inserte el nuevo tipo que quieres insertar");
        String tipoNuevoADD = sc.nextLine();

        SQLAccessMercaDaw.insertarTipo(tipoNuevoADD);

        List<String> tiposVER = SQLAccessMercaDaw.getTipos();
        for (String tipo : tiposVER) {
            System.out.println(tipo + "\n" );
        }
    }

    private static void buscarMetodoTipo(Scanner sc) {
        //Buscar Producto por tipo
        List<String> tipos = SQLAccessMercaDaw.getTipos();

        int i = 1;
        for (String tipo : tipos) {
            System.out.println(i + ". " + tipo);
            i++;
        }

        int tipoBuscar;
        do {
            System.out.println("Elige el tipo (numero):");
            tipoBuscar = sc.nextInt();
        } while (tipoBuscar <= 0 || tipoBuscar > tipos.size());

        sc.nextLine();

        List<Product> productoPorTipo;

        productoPorTipo = SQLAccessMercaDaw.getProductoTipo(tipoBuscar);

        for (Product producto : productoPorTipo) {
            System.out.println(producto);
        }
    }

    private static void updateProduct(Scanner sc) {
        List<Product> productos4 = SQLAccessMercaDaw.getProductos();

        for(Product producto : productos4){
            System.out.println(producto);
        }


        System.out.println("Ingrese el ID del producto a actualizar:");
        int idProductoUpdate = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.println("Inserte la nueva descripcion del producto");
        String updateDescripcion = sc.nextLine();

        System.out.println("Inserte la nueva cantidad del producto");
        int cantidadNueva = sc.nextInt();

        System.out.println("Inserte el nuevo precio del producto");
        double precioNueva = sc.nextDouble();

        System.out.println("Inserte el nuevo descuento del producto");
        int descuentoNueva = sc.nextInt();

        System.out.println("Inserte Si quiere descuento");
        boolean aplicarDPTUpdate = false;
        String opcionDescuentoUpdate;
        do {
            System.out.println("Inserte desea aplicar el descuento");
            System.out.println("S-N");
            opcionDescuentoUpdate = sc.nextLine();
        }while (!opcionDescuentoUpdate.equalsIgnoreCase("S") && !opcionDescuentoUpdate.equalsIgnoreCase("N"));

        if (opcionDescuentoUpdate.equals("S")) {
            aplicarDPTUpdate = true;
        }else if (opcionDescuentoUpdate.equals("N")) {
            aplicarDPTUpdate = false;
        }else{
            System.out.println("");
        }


        Product productoSeleccionado = new Product(idProductoUpdate,updateDescripcion, cantidadNueva, precioNueva, descuentoNueva, aplicarDPTUpdate);

        int resultado = SQLAccessMercaDaw.updateProducto(productoSeleccionado);

        if(resultado == 0){
            System.out.println("No se encontro el producto a actualizar");
        }else{
            System.out.println("Se Actualizo correctamente");
        }
    }

    private static void productDel(Scanner sc) {
        List<Product> productos3 = SQLAccessMercaDaw.getProductos();

        for(Product producto : productos3){
            System.out.println(producto);
        }

        System.out.println("Ahora inserte la referencia para eliminar");
        String referenciaDel = sc.nextLine();

        int delProucto = SQLAccessMercaDaw.delProductRef(referenciaDel);

        if(delProucto == 0){
            System.out.println("No se encontro el referencia del producto");
        }else{
            System.out.println("Se borro correctamente");
        }
    }

    private static void busquedaCANT(Scanner sc) {
        System.out.println("Inserte una cantidad para ver los productos con esa cantidad");
        int cantidad = sc.nextInt();

        Product cant = SQLAccessMercaDaw.getProductoCantatidad(cantidad);
        if(cant != null) {
            System.out.println(cant);
        }else{
            System.out.println("No existen productos con esa cantidad");
        }
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

    static boolean PatronReferencia(String referencia) {
        String Patron = "^REF\\d{3}$";
        return Pattern.matches(Patron, referencia);
    }
}