package org.example;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class SQLAccessMercaDaw {


    //Metodo para ver todos los productos
    public static List<Product>getProductos(){

        List<Product> productos = new LinkedList<>();

        //Consulta Sql
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

    //Ver todos los tipos que hay
    public static List<String> getTipos() {

        List<String> tipos = new LinkedList<>();
        String sql = "SELECT nombre FROM tipos";

        try (Connection con = SQLDataManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSets = statement.executeQuery(sql)) {

            while (resultSets.next()) {
                tipos.add(resultSets.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener tipos");
        }

        return tipos;
    }


    //Metodo para buscar Producto por referencia
    public static Product getProductoREF(String referencia){
        Product producto = null;

        //Consulta MySql
        String sqlProductosREF = "SELECT * FROM products WHERE referencia = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProductosREF)){

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

                producto = new Product(id,ref,tipo,name,description,cantidad,price,descuento,iva, aplicarDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }

    //Buscar por tipo

    public static Product getProductoTipo(int tipo){
        Product product = null;


        //Consulta MYSql
        String sqlTipo = "SELECT * FROM products WHERE tipo = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlTipo)){

            statement.setInt(1, tipo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ref = resultSet.getString(2);
                int tipo2 = resultSet.getInt(3);
                String name = resultSet.getString(4);
                String description = resultSet.getString(5);
                int cantidad1 = resultSet.getInt(6);
                double price = resultSet.getDouble(7);
                int descuento = resultSet.getInt(8);
                int iva = resultSet.getInt(9);
                boolean aplicarDTO = resultSet.getBoolean(10);

                product = new Product(id,ref,tipo2,name,description,cantidad1,price,descuento,iva, aplicarDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;

    }

    //Buscar producto por cantidad.

    public static Product getProductoCantatidad(int cantidad){
        Product producto = null;
        


        //Consulta MySql
        String sqlProductosREF = "SELECT * FROM products WHERE cantidad = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProductosREF)){

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

                producto = new Product(id,ref,tipo,name,description,cantidad1,price,descuento,iva, aplicarDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }


    //Insertar Producto

    public static int insertarProducto(Product product) {
        int response = -1;

        String sqlStatement = "INSERT INTO products (referencia, nombre, tipo, descripcion, cantidad, precio, descuento, iva, aplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = SQLDataManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlStatement)){


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

    public static int delProductRef(String ref) {

        int elements = -1;
        String sqlStatement = "DELETE FROM products WHERE referencia = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){
             statement.setString(1, ref);



            elements = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return elements;
    }

    public static int updateProducto(Product product) {
        int response = -1;

        //Actualizamos todos

        // (descripción, cantidad, precio, descuento, AplicarDto)
        String sqlStatment = "UPDATE products set descripcion = ?," + "cantidad = ?, precio = ?, descuento = ?,aplicarDTO = ? WHERE id = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatment)){

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


    public static Product buscarProducto(String ref) {
        List<Product> productos = getProductos();

        for (Product producto : productos) {
            if (producto.getReferencia().equalsIgnoreCase(ref)) {
                return producto;
            }
        }

        return null;
    }

}
