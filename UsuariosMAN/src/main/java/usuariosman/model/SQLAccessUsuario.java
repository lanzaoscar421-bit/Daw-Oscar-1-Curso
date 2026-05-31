package usuariosman.model;

import usuariosman.configuration.SQLDataBaseManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SQLAccessUsuario {

    public static boolean createUsuario(Usuario usuario) {

        boolean result = false;

        String sql = "INSERT INTO usuario (nombre, apellido, dni, fecha_nacimiento) VALUES (?,?,?,?)";

        try (Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,usuario.getNombre());
            statement.setString(2,usuario.getApellido());
            statement.setString(3,usuario.getDni());
            statement.setDate(4,java.sql.Date.valueOf(usuario.getFecha_nacimiento()));
            statement.execute();
            result = true;


        }catch (SQLException e){
            System.out.println("Error" + "\n" + e.getMessage());
        }

        return result;
    }

    public static List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (Connection connection = SQLDataBaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id_usuario = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate fecha_nacimiento = resultSet.getDate(5).toLocalDate();

                Usuario us = Usuario.builder()
                        .id_usuario(id_usuario)
                        .nombre(nombre)
                        .apellido(apellido)
                        .dni(dni)
                        .fecha_nacimiento(fecha_nacimiento)
                        .build();

                usuarios.add(us);
            }

        }catch (SQLException e){
            System.out.println("Error" + "\n" + e.getMessage());
        }

        return usuarios;
    }

    public static boolean deleteUsuario(int id_usuario) {
        boolean result = false;
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,id_usuario);
            statement.execute();
            result = true;
        }catch (SQLException e){
            System.out.println("Error" + "\n" + e.getMessage());
        }

        return result;
    }
}
