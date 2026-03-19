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
                String name = resultSets.getString(3);
                String description = resultSets.getString(4);
                int cantidad = resultSets.getInt(5);
                double price = resultSets.getDouble(6);
                int descuento = resultSets.getInt(7);
                int iva = resultSets.getInt(8);
                boolean aplicarDTO = resultSets.getBoolean(9);

                productos.add(new Product(id,referencia,name,description,cantidad,price,descuento,iva, aplicarDTO));


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
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
                String name = resultSet.getString(3);
                String description = resultSet.getString(4);
                int cantidad = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                int descuento = resultSet.getInt(7);
                int iva = resultSet.getInt(8);
                boolean aplicarDTO = resultSet.getBoolean(9);

                producto = new Product(id,ref,name,description,cantidad,price,descuento,iva, aplicarDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
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
                String name = resultSet.getString(3);
                String description = resultSet.getString(4);
                int cantidad1 = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                int descuento = resultSet.getInt(7);
                int iva = resultSet.getInt(8);
                boolean aplicarDTO = resultSet.getBoolean(9);

                producto = new Product(id,ref,name,description,cantidad1,price,descuento,iva, aplicarDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }

}
