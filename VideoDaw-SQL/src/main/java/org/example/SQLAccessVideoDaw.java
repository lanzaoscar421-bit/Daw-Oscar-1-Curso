package org.example;

import org.example.Exceptions.ValidacionDNI;
import org.example.Exceptions.ValidacionPA;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
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
                boolean isComprada = resultSets.getBoolean(7);
                java.sql.Date fechaBajaSQL = resultSets.getDate(8);
                LocalDate fechaBaja = (fechaBajaSQL != null) ? fechaBajaSQL.toLocalDate() : null;

                vinilos.add(new Vinilo(id, codigo, banda,titulo, genero, pa ,isComprada, fechaBaja));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return vinilos;
    }
    //Ver todos los alquileres
    public static List<String> getCompras() {
        List<String> compras = new ArrayList<>();

        String sqlcompras= "SELECT c.id, cl.dni, cl.nombre, v.codigo, v.titulo, c.fechaCompra, c.fechaDevolucion " +
                "FROM compras c " +
                "JOIN clientes cl ON c.cliente_id = cl.id " +
                "JOIN vinilos v ON c.vinilo_id = v.id";

        try (Connection connection = SQLDataManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlcompras)) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | DNI: " + rs.getString("dni") +
                                " | Nombre: " + rs.getString("nombre") +
                                " | Código: " + rs.getString("codigo") +
                                " | Título: " + rs.getString("titulo") +
                                " | Fecha compra: " + rs.getDate("fechaCompra") +
                                " | Fecha devolución: " + rs.getDate("fechaDevolucion")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return compras;
    }

    //Ver vinilos los cuales son comprados y no fueron devueltos
    public static List <String> verVinilosCompradosNoDevueltos() {

        List<String> vinilos = new ArrayList<>();

        String sql = "SELECT c.id, cl.dni, cl.nombre, v.codigo, v.titulo, c.fechaCompra " +
                "FROM compras c " +
                "JOIN clientes cl ON c.cliente_id = cl.id " +
                "JOIN vinilos v ON c.vinilo_id = v.id " +
                "WHERE c.fechaDevolucion IS NULL " +
                "ORDER BY c.fechaCompra ASC";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            System.out.println("Vinilos Comprados que no fueron devueltos");

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                System.out.println(
                        "ID Compra: " + rs.getInt("id") +
                                " | DNI: " + rs.getString("dni") +
                                " | Cliente: " + rs.getString("nombre") +
                                " | Código Vinilo: " + rs.getString("codigo") +
                                " | Título: " + rs.getString("titulo") +
                                " | Fecha Compra: " + rs.getDate("fechaCompra")
                );
            }

            if (!hayDatos) {
                System.out.println("No hay vinilos comprados que no fueron devueltos.");
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

    //Bucar Vinilo solo por codigo
    public static int getViniloCodigo(String codigo){
        int response = -1;
        String sql = "SELECT id FROM vinilos WHERE codigo = ?";

        try (Connection con = SQLDataManager.getConnection();
        PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, codigo);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                response = rs.getInt("id");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return response;
    }



    //Buscar vinilo por codigo cuando no es comprado
    public static int getIdViniloPorCodigo(String codigo) {

        String sql = "SELECT id, isComprada FROM vinilos WHERE codigo = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, codigo.trim());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                boolean isComprada = rs.getBoolean("isComprada");

                if (isComprada) {
                    System.out.println("Este vinilo ya está comprado");
                    return -1;
                }

                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }

    public static int getIdViniloPorCodigoDev(String codigo) {
        int response = -1;

        String sql = "SELECT id FROM vinilos WHERE codigo = ? and isComprada = true";

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

    //Dar de baja a Cliente
    public static int bajaCliente(String dni) {
        int response = -1;

        int clienteId = getClienteDNI(dni);
        if (clienteId == -1) {
            System.out.println("Cliente no encontrado");
        }

        String sqlUpdate = "UPDATE clientes SET fechaBaja = CURDATE() WHERE id = ?";

        try (Connection connection =  SQLDataManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlUpdate)) {

            statement.setInt(1, clienteId);
            response=statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return  response;
    }

    //Dar de baja Vinilo
    public static int bajaVinilo(String codigo) {
        int response = -1;

        int codigoVin = getViniloCodigo(codigo);
        if (codigoVin == -1) {
            System.out.println("Vinilo no encontrado");
        }

        String sqlUpdate = "Update vinilos set fechaBaja = CURDATE() WHERE id = ?";

        try (Connection connection = SQLDataManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlUpdate)) {

            statement.setInt(1, codigoVin);
            response=statement.executeUpdate();

        }catch (SQLException e){
            e.getMessage();
        }

        return response;
    }

    //Comprar Vinilo a Usuario
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

        String sqlInsert = "INSERT INTO compras (cliente_id, vinilo_id, fechaCompra, fechaDevolucion) VALUES (?, ?, CURDATE(), NULL)";
        String sqlUpdate = "UPDATE vinilos SET isComprada = true WHERE id = ?";

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

    public static int devolverVinilo(String dni,String codigo){
        int response = -1;

        int clienteId = getClienteDNI(dni.trim());
        int viniloId = getIdViniloPorCodigoDev(codigo.trim());

        if (clienteId == -1) {
            System.out.println("Cliente no existe");
            return response;
        }

        if (viniloId == -1) {
            System.out.println("Vinilo no disponible o no existe");
            return response;
        }

        String sqlUpdateCompra = "UPDATE compras SET fechaDevolucion = CURDATE() " +
                "WHERE cliente_id = ? AND vinilo_id = ? AND fechaDevolucion IS NULL";

        String sqlUpdateVinilo = "UPDATE vinilos SET isComprada = false WHERE id = ?";


        try (Connection connection = SQLDataManager.getConnection()) {

            PreparedStatement stInsert = connection.prepareStatement(sqlUpdateCompra);
            stInsert.setInt(1, clienteId);
            stInsert.setInt(2, viniloId);
            response = stInsert.executeUpdate();

            PreparedStatement stUpdate = connection.prepareStatement(sqlUpdateVinilo);
            stUpdate.setInt(1, viniloId);
            stUpdate.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return response;
    }


    public static void validarCompra(String dni, String codigoVinilo) throws ValidacionPA {

        String sql = "SELECT c.fechaNacimiento, v.pa " +
                "FROM clientes c, vinilos v " +
                "WHERE c.dni = ? AND v.codigo = ?";

        try (Connection connection = SQLDataManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dni);
            statement.setString(2, codigoVinilo);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                LocalDate fechaNacimiento = rs.getDate("fechaNacimiento").toLocalDate();
                boolean pa = rs.getBoolean("pa");

                int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

                if (edad < 18 && pa) {
                    throw new ValidacionPA("");
                }

            } else {
                throw new ValidacionPA("");
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }


    }
