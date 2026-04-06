package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLAccessVideoDaw {


    //Ver todos los clientes
    public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        String sqlClientes = "SELECT * FROM clientes";

        try (Connection connection = SQLDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(sqlClientes)) {

            while (resultSets.next()) {
                int id = resultSets.getInt(1);
                String dni = resultSets.getString(2);
                String nombre = resultSets.getString(3);
                String direccion = resultSets.getString(4);
                Date fechaNacimiento = resultSets.getDate(5);
                String numSocio = resultSets.getString(6);
                Date fechaBaja = resultSets.getDate(7);

                clientes.add(new Cliente(id,dni,nombre,direccion,fechaNacimiento,numSocio,fechaBaja));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return clientes;
    }

    //Ver todos los vinilos
    public static List<Vinilo> getVinilos() {
        List <Vinilo> vinilos = new ArrayList<>();


        String sqlVinilos = "SELECT * FROM vinilos";


        try (Connection connection = SQLDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(sqlVinilos)) {

            while (resultSets.next()) {

                int id = resultSets.getInt(1);
                String codigo = resultSets.getString(2);
                String titulo = resultSets.getString(3);
                int genero = resultSets.getInt(4);
                boolean isAlquilada = resultSets.getBoolean(5);
                vinilos.add(new Vinilo(id, codigo, titulo, genero, isAlquilada));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return vinilos;
    }

    //Ver todos los tipos
    public static List<String> getGeneros (){
        List<String> generos = new ArrayList<>();

        String sqlTipos = "SELECT * FROM generos ORder by id asc";
        try (Connection con = SQLDataManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sqlTipos)) {

            while (rs.next()) {
                generos.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los generos");
        }



        return generos;
    }

}
