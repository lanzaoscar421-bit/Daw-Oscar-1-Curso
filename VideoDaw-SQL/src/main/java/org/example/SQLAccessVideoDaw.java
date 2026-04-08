package org.example;

import org.example.Exceptions.ValidacionDNI;

import java.sql.*;
import java.time.LocalDate;
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
                LocalDate fechaNacimiento = resultSets.getDate(5).toLocalDate();
                String numSocio = resultSets.getString(6);

                java.sql.Date fechaBajaSQL = resultSets.getDate(7);
                LocalDate fechaBaja = (fechaBajaSQL != null) ? fechaBajaSQL.toLocalDate() : null;

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
                String banda = resultSets.getString(3);
                String titulo = resultSets.getString(4);
                int genero = resultSets.getInt(5);
                boolean pa = resultSets.getBoolean(6);
                boolean isAlquilada = resultSets.getBoolean(7);
                vinilos.add(new Vinilo(id, codigo, banda,titulo, genero, pa ,isAlquilada));
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

    //Añadir Vinilos metodo
    public static int insertarVinilo(Vinilo vinilo) {
        int response = -1;

        String sqlStatement = "Insert into vinilos (codigo, banda, titulo, genero, pa) values (? ,?, ?, ?, ?)";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlStatement)){

            statement.setString(1, vinilo.getCodigo());
            statement.setString(2, vinilo.getBanda());
            statement.setString(3, vinilo.getTitulo());
            statement.setInt(4, vinilo.getGenero());
            statement.setBoolean(5,vinilo.isPa());

            response=statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    //Añadir Clientes metodo
    public static int insertarCliente(Cliente cliente) {
        int response = -1;

        String sqlStatement = "Insert into clientes (dni, nombre, direccion, fechaNacimiento, numSocio) values (? ,?, ?, ?, ?)";


        try (Connection connection = SQLDataManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlStatement)){


            statement.setString(1, cliente.getDni());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getDireccion());
            statement.setDate(4, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            statement.setString(5, cliente.getNumSocio());

            response=statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }


    //Contador de Vinilos
    public static int contarVinilos() {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM vinilos";

        try (Connection connection = SQLDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return total;
    }

    //Validar DNI Controlado con Excepcio
    public static boolean validarDni (String dni) throws ValidacionDNI{
        boolean resultado = false;

        for (Cliente cliente : getClientes()){
            if (cliente.getDni().equalsIgnoreCase(dni)){
                throw new ValidacionDNI("");
            }
        }


        return resultado;
    }

    //Contador de clientes
    public static int contarClientes (){
        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM clientes";

        try (Connection connection = SQLDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return total;
    }


    //Buscar usuario por dni
    public static  int getClienteDNI (String dni){
        int response = -1;

        String sql = "SELECT id FROM clientes WHERE dni = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dni);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                response = rs.getInt("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    //Buscar vinilo por codigo
    public static int getIdViniloPorCodigo(String codigo) {
        int response = -1;

        String sql = "SELECT id FROM vinilos WHERE codigo = ? AND isAlquilado = false";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, codigo);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                response = rs.getInt("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    //Alquilar Vinilo a Usuario
    public static int insertarCompra(String dni,String codigo){
        int response = -1;

        int clienteId = getClienteDNI(dni.trim());
        int viniloId = getIdViniloPorCodigo(codigo.trim());

        if (clienteId == -1) {
            System.out.println("Cliente no existe");
            return response;
        }

        if (viniloId == -1) {
            System.out.println("Vinilo no disponible o no existe");
            return response;
        }

        String sqlInsert = "INSERT INTO compras (cliente_id, vinilo_id, fechaAlquiler, fechaDevolucion) VALUES (?, ?, CURDATE(), NULL)";
        String sqlUpdate = "UPDATE vinilos SET isAlquilado = true WHERE id = ?";

        try (Connection connection = SQLDataManager.getConnection()) {

            PreparedStatement stInsert = connection.prepareStatement(sqlInsert);
            stInsert.setInt(1, clienteId);
            stInsert.setInt(2, viniloId);
            response = stInsert.executeUpdate();

            PreparedStatement stUpdate = connection.prepareStatement(sqlUpdate);
            stUpdate.setInt(1, viniloId);
            stUpdate.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }


    }
