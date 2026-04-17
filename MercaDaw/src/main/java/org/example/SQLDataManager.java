package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión a la base de datos MySQL.
 *
 * Proporciona un método estático para obtener una conexión
 * utilizando JDBC, centralizando la configuración de acceso
 * a la base de datos del sistema MercaDaw.
 */
public class SQLDataManager {

    /**
     * Driver JDBC utilizado para la conexión con MySQL.
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * URL base de conexión a MySQL.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/";

    /**
     * Nombre del esquema o base de datos.
     */
    private static final String SCHEMA = "mercaDaw";

    /**
     * Usuario de acceso a la base de datos.
     */
    private static final String USUARIO = "root";

    /**
     * Contraseña del usuario de la base de datos.
     */
    private static final String CLAVE = "daw12";

    // Casa (configuración alternativa comentada)
    // private static final String CLAVE = "2006";

    /**
     * Establece y devuelve una conexión a la base de datos MySQL.
     *
     * Este método carga el driver JDBC y crea una conexión
     * utilizando los datos de configuración definidos en la clase.
     *
     * @return Connection objeto de conexión a la base de datos,
     *         o null si ocurre algún error.
     */
    public static Connection getConnection() {

        Connection conn = null;

        try {

            // Carga del driver JDBC
            Class.forName(DRIVER);

            // Establece conexión con la base de datos
            conn = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return conn;
    }
}