package org.example.apppersonasfx.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {


//    //Clase
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String SCHEMA = "personasAPP";
    private static final String USUARIO = "root";
    private static final String CLAVE = "daw12";


    //Casa
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/";
//    private static final String SCHEMA = "personasAPP";
//    private static final String USUARIO = "root";
//    private static final String CLAVE = "2006";

    public static Connection getConnection() {

        Connection conn = null;

        try {

            //Busca la clase por el nombre del driver
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL+SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return conn;
    }
}