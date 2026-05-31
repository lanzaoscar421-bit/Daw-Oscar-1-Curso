package usuariosman.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLDataBaseManager {

    private static String DRIVER = null;
    private static String URL = null;
    private static String SCHEMA = null;
    private static String USUARIO = null;
    private static String CLAVE = null;

    private static final String path = "./src/main/resources/";
    private static final String fileName = "SQl/SQLConfig.dat";

    public static Connection getConnection() {
        Connection connection = null;

        if (DRIVER == null) {
            leerFichero();
        }

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);

        } catch (ClassNotFoundException e) {
            System.err.println("Error de acceso al driver " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }

        return connection;
    }

    private static void leerFichero() {

        try (FileReader file = new FileReader(path + fileName);
             BufferedReader bufferReader = new BufferedReader(file)) {
            String linea = "";

            linea = bufferReader.readLine();

            if (linea != null) {
                String[] datosLinea = linea.split("'");
                DRIVER = datosLinea[1].trim();
            }

            linea = bufferReader.readLine();

            if (linea != null) {
                String[] datosLinea = linea.split("'");
                URL = datosLinea[1].trim();
            }

            linea = bufferReader.readLine();

            if (linea != null) {
                String[] datosLinea = linea.split("'");
                SCHEMA = datosLinea[1].trim();
            }

            linea = bufferReader.readLine();

            if (linea != null) {
                String[] datosLinea = linea.split("'");
                USUARIO = datosLinea[1].trim();
            }

            linea = bufferReader.readLine();

            if (linea != null) {
                String[] datosLinea = linea.split("'");
                CLAVE = datosLinea[1].trim();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al leer");
        }
    }
}
