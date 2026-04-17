package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase principal de la aplicación MercaDaw.
 *
 * Contiene el método main y la lógica de interacción con el usuario
 * mediante consola. Permite realizar operaciones CRUD sobre productos
 * almacenados en una base de datos.
 *
 * Funcionalidades principales:
 * - Mostrar productos
 * - Buscar productos
 * - Insertar, actualizar y eliminar productos
 * - Gestionar tipos de productos
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     *
     * Gestiona el menú interactivo y la entrada del usuario.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        // Conexion a la base de datos
        ConexionSQL();

        System.out.println("Bienvenido a MercaDaw");

        do {

            menu();

            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    // Ver todos los productos
                    VerProductos();
                    break;

                case "2":
                    // Buscar Producto por referencia
                    BuscarRef(sc);
                    break;

                case "3":
                    // Buscar producto por tipo
                    buscarMetodoTipo(sc);
                    break;

                case "4":
                    // Busqueda por cantidad
                    busquedaCANT(sc);
                    break;

                case "5":
                    // Insertar Producto
                    insertarProducto(sc);
                    break;

                case "6":
                    // Eliminar Producto
                    productDel(sc);
                    break;

                case "7":
                    // Actualizar Producto
                    updateProduct(sc);
                    break;

                case "8":
                    // Insertar más tipos
                    insertarTipos(sc);
                    break;

                case "9":
                    System.out.println("Adios.");
                    break;
            }
        } while (!opcion.equals("9"));

    }

    /**
     * Inserta un nuevo producto solicitando los datos al usuario.
     *
     * Valida la referencia, permite seleccionar tipo, e introduce
     * todos los campos necesarios antes de enviarlos a la base de datos.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void insertarProducto(Scanner sc) {
        String referenciaADD;
        do {
            System.out.println("Ingresa la referencia del producto");
            System.out.println("Patron: 'REF000' ");
            referenciaADD = sc.nextLine();
        } while (!PatronReferencia(referenciaADD));

        System.out.println("Ahora inserta los tipos");
        System.out.println("Tipos disponibles:");

        List<String> tiposADD = SQLAccessMercaDaw.getTipos();

        for (String tipo : tiposADD) {
            System.out.println(tipo);
        }

        int tipoADD;
        do {
            System.out.println("Elige el tipo un numero de los disponibles");
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

        sc.nextLine();

        int iva = 21;

        boolean aplicarDPT = false;
        String opcionDescuento;

        do {
            System.out.println("Inserte desea aplicar el descuento");
            System.out.println("S-N");
            opcionDescuento = sc.nextLine();
        } while (!opcionDescuento.equalsIgnoreCase("S") && !opcionDescuento.equalsIgnoreCase("N"));

        if (opcionDescuento.equalsIgnoreCase("S")) {
            aplicarDPT = true;
        } else if (opcionDescuento.equals("N")) {
            aplicarDPT = false;
        }

        try {
            SQLAccessMercaDaw.validarReferencia(referenciaADD);
            Product nuevoProducto = new Product(-1, referenciaADD, tipoADD, nombreADD, descripcionADD, cantidadADD, precioADD, descuentoADD, iva, aplicarDPT);
            int addProducto = SQLAccessMercaDaw.insertarProducto(nuevoProducto);
        } catch (RefException e) {
            System.out.println(e.getMessage());
        }

        List<Product> productos = SQLAccessMercaDaw.getProductos();

        for (Product producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Inserta un nuevo tipo de producto en la base de datos.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void insertarTipos(Scanner sc) {
        System.out.println("Inserte el nuevo tipo que quieres insertar");
        String tipoNuevoADD = sc.nextLine();

        SQLAccessMercaDaw.insertarTipo(tipoNuevoADD);

        List<String> tiposVER = SQLAccessMercaDaw.getTipos();
        for (String tipo : tiposVER) {
            System.out.println(tipo + "\n");
        }
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * Permite modificar descripción, cantidad, precio y descuento.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void updateProduct(Scanner sc) {
        List<Product> productos4 = SQLAccessMercaDaw.getProductos();

        for (Product producto : productos4) {
            System.out.println(producto);
        }

        System.out.println("Ingrese el ID del producto a actualizar:");
        int idProductoUpdate = sc.nextInt();
        sc.nextLine();

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
        } while (!opcionDescuentoUpdate.equalsIgnoreCase("S") && !opcionDescuentoUpdate.equalsIgnoreCase("N"));

        if (opcionDescuentoUpdate.equals("S")) {
            aplicarDPTUpdate = true;
        } else if (opcionDescuentoUpdate.equals("N")) {
            aplicarDPTUpdate = false;
        }

        Product productoSeleccionado = new Product(idProductoUpdate, updateDescripcion, cantidadNueva, precioNueva, descuentoNueva, aplicarDPTUpdate);

        int resultado = SQLAccessMercaDaw.updateProducto(productoSeleccionado);

        if (resultado == 0) {
            System.out.println("No se encontro el producto a actualizar");
        } else {
            System.out.println("Se Actualizo correctamente");
        }
    }

    /**
     * Elimina un producto a partir de su referencia.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void productDel(Scanner sc) {
        List<Product> productos3 = SQLAccessMercaDaw.getProductos();

        for (Product producto : productos3) {
            System.out.println(producto);
        }

        System.out.println("Ahora inserte la referencia para eliminar");
        String referenciaDel = sc.nextLine();

        int delProucto = SQLAccessMercaDaw.delProductRef(referenciaDel);

        if (delProucto == 0) {
            System.out.println("No se encontro el referencia del producto");
        } else {
            System.out.println("Se borro correctamente");
        }
    }

    /**
     * Busca productos por tipo.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void buscarMetodoTipo(Scanner sc) {
        List<String> tipos = SQLAccessMercaDaw.getTipos();

        for (String tipo : tipos) {
            System.out.println(tipo);
        }

        int tipoBuscar;
        do {
            System.out.println("Elige el tipo (numero):");
            tipoBuscar = sc.nextInt();
        } while (tipoBuscar <= 0 || tipoBuscar > tipos.size());

        sc.nextLine();

        List<Product> productoPorTipo = SQLAccessMercaDaw.getProductoTipo(tipoBuscar);

        for (Product producto : productoPorTipo) {
            System.out.println(producto);
        }
    }

    /**
     * Busca productos por cantidad.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void busquedaCANT(Scanner sc) {
        System.out.println("Inserte una cantidad para ver los productos con esa cantidad");
        int cantidad = sc.nextInt();

        List<Product> productoPorCantidad = SQLAccessMercaDaw.getProductoCantatidad(cantidad);

        for (Product producto : productoPorCantidad) {
            System.out.println(producto);
        }
    }

    /**
     * Muestra el menú de opciones por consola.
     */
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

    /**
     * Comprueba la conexión con la base de datos.
     *
     * Realiza un "ping" simple para verificar si la conexión
     * con MySQL se ha establecido correctamente.
     */
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

    /**
     * Busca un producto por su referencia.
     *
     * @param sc Scanner para entrada de datos
     */
    private static void BuscarRef(Scanner sc) {
        System.out.println("Inserta referencia del producto");
        String referencia = sc.nextLine();

        Product pd = SQLAccessMercaDaw.getProductoREF(referencia);
        System.out.println(pd);
    }

    /**
     * Muestra todos los productos disponibles en el inventario.
     */
    private static void VerProductos() {
        System.out.println("Estos son los productos del Inventario\n");
        List<Product> productos = SQLAccessMercaDaw.getProductos();

        for (Product producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Valida que una referencia cumpla el patrón definido.
     *
     * Formato válido: REF seguido de 3 dígitos (ejemplo: REF001).
     *
     * @param referencia Referencia a validar
     * @return true si cumple el patrón, false en caso contrario
     */
    static boolean PatronReferencia(String referencia) {
        String Patron = "^REF\\d{3}$";
        return Pattern.matches(Patron, referencia);
    }
}