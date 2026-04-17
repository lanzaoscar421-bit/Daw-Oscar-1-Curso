package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) del sistema MercaDaw.
 *
 * Esta clase se encarga de gestionar todas las operaciones
 * relacionadas con la base de datos MySQL:
 * - Consultas SELECT
 * - Inserciones
 * - Actualizaciones
 * - Eliminaciones
 *
 * Trabaja con la tabla products y tipos.
 */
public class SQLAccessMercaDaw {

    /**
     * Obtiene todos los productos almacenados en la base de datos.
     *
     * @return Lista de productos
     */
    public static List<Product> getProductos() {

        List<Product> productos = new LinkedList<>();

        String SQLproducts = "SELECT * FROM products";

        try (Connection connection = SQLDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(SQLproducts)) {

            while (resultSets.next()) {
                int id = resultSets.getInt(1);
                String referencia = resultSets.getString(2);
                int tipo = resultSets.getInt(3);
                String name = resultSets.getString(4);
                String description = resultSets.getString(5);
                int cantidad = resultSets.getInt(6);
                double price = resultSets.getDouble(7);
                int descuento = resultSets.getInt(8);
                int iva = resultSets.getInt(9);
                boolean aplicarDTO = resultSets.getBoolean(10);

                productos.add(new Product(id, referencia, tipo, name, description, cantidad, price, descuento, iva, aplicarDTO));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    /**
     * Obtiene todos los tipos de productos disponibles.
     *
     * @return Lista de tipos en formato "id - nombre"
     */
    public static List<String> getTipos() {

        List<String> tipos = new LinkedList<>();
        String sql = "SELECT * FROM tipos ORDER BY id DESC;";

        try (Connection con = SQLDataManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                tipos.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener tipos");
        }

        return tipos;
    }

    /**
     * Busca un producto por su referencia exacta.
     *
     * @param referencia Referencia del producto
     * @return Producto encontrado o null si no existe
     */
    public static Product getProductoREF(String referencia) {

        Product producto = null;

        String sqlProductosREF = "SELECT * FROM products WHERE referencia = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProductosREF)) {

            statement.setString(1, referencia);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ref = resultSet.getString(2);
                int tipo = resultSet.getInt(3);
                String name = resultSet.getString(4);
                String description = resultSet.getString(5);
                int cantidad = resultSet.getInt(6);
                double price = resultSet.getDouble(7);
                int descuento = resultSet.getInt(8);
                int iva = resultSet.getInt(9);
                boolean aplicarDTO = resultSet.getBoolean(10);

                producto = new Product(id, ref, tipo, name, description, cantidad, price, descuento, iva, aplicarDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }

    /**
     * Obtiene todos los productos filtrados por tipo.
     *
     * @param tipo ID del tipo de producto
     * @return Lista de productos filtrados
     */
    public static List<Product> getProductoTipo(int tipo) {

        List<Product> productos = new ArrayList<>();

        String sqlTipo = "SELECT * FROM products WHERE tipo = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlTipo)) {

            statement.setInt(1, tipo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ref = resultSet.getString(2);
                int tipo2 = resultSet.getInt(3);
                String name = resultSet.getString(4);
                String description = resultSet.getString(5);
                int cantidad = resultSet.getInt(6);
                double price = resultSet.getDouble(7);
                int descuento = resultSet.getInt(8);
                int iva = resultSet.getInt(9);
                boolean aplicarDTO = resultSet.getBoolean(10);

                productos.add(new Product(id, ref, tipo2, name, description, cantidad, price, descuento, iva, aplicarDTO));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    /**
     * Obtiene productos filtrados por cantidad exacta.
     *
     * @param cantidad Cantidad a buscar
     * @return Lista de productos
     */
    public static List<Product> getProductoCantatidad(int cantidad) {

        List<Product> productos = new ArrayList<>();

        String sql = "SELECT * FROM products WHERE cantidad = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cantidad);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ref = resultSet.getString(2);
                int tipo = resultSet.getInt(3);
                String name = resultSet.getString(4);
                String description = resultSet.getString(5);
                int cantidad1 = resultSet.getInt(6);
                double price = resultSet.getDouble(7);
                int descuento = resultSet.getInt(8);
                int iva = resultSet.getInt(9);
                boolean aplicarDTO = resultSet.getBoolean(10);

                productos.add(new Product(id, ref, tipo, name, description, cantidad1, price, descuento, iva, aplicarDTO));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    /**
     * Inserta un nuevo producto en la base de datos.
     *
     * @param product Producto a insertar
     * @return número de filas afectadas
     */
    public static int insertarProducto(Product product) {

        int response = -1;

        String sqlStatement =
                "INSERT INTO products (referencia, nombre, tipo, descripcion, cantidad, precio, descuento, iva, aplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {

            statement.setString(1, product.getReferencia());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getTipo());
            statement.setString(4, product.getDescription());
            statement.setInt(5, product.getCantidad());
            statement.setDouble(6, product.getPrice());
            statement.setInt(7, product.getDescuento());
            statement.setInt(8, product.getIva());
            statement.setBoolean(9, product.isAplicarDTO());

            response = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    /**
     * Elimina un producto por su referencia.
     *
     * @param ref referencia del producto
     * @return número de filas afectadas
     */
    public static int delProductRef(String ref) {

        int elements = -1;

        String sqlStatement = "DELETE FROM products WHERE referencia = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {

            statement.setString(1, ref);

            elements = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return elements;
    }

    /**
     * Actualiza un producto existente.
     *
     * @param product producto con los nuevos datos
     * @return número de filas afectadas
     */
    public static int updateProducto(Product product) {

        int response = -1;

        String sqlStatment =
                "UPDATE products set descripcion = ?, cantidad = ?, precio = ?, descuento = ?, aplicarDTO = ? WHERE id = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatment)) {

            statement.setString(1, product.getDescription());
            statement.setInt(2, product.getCantidad());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getDescuento());
            statement.setBoolean(5, product.isAplicarDTO());
            statement.setInt(6, product.getId());

            response = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    /**
     * Valida que la referencia no exista ya en la base de datos.
     *
     * @param referencia referencia a comprobar
     * @return true si es válida
     * @throws RefException si la referencia ya existe
     */
    public static boolean validarReferencia(String referencia) throws RefException {

        for (Product product : getProductos()) {
            if (product.getReferencia().equals(referencia)) {
                throw new RefException("");
            }
        }

        return false;
    }

    /**
     * Busca un producto por referencia (sin SQL).
     *
     * @param ref referencia del producto
     * @return producto encontrado o null
     */
    public static Product buscarProducto(String ref) {

        List<Product> productos = getProductos();

        for (Product producto : productos) {
            if (producto.getReferencia().equalsIgnoreCase(ref)) {
                return producto;
            }
        }

        return null;
    }

    /**
     * Inserta un nuevo tipo de producto.
     *
     * @param nombre nombre del tipo
     * @return filas afectadas
     */
    public static int insertarTipo(String nombre) {

        int response = -1;

        String sqlStatement = "INSERT INTO tipos (nombre) VALUES (?)";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)) {

            statement.setString(1, nombre);

            response = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

}