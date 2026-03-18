package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        //Conexion a la base de datos
        Connection conn = SQLDataManager.getConnection();
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    System.out.println("✅ Ping correcto: conexión establecida con MySQL");
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Error");
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ No se pudo conectar a la base de datos");
        }
        //


    }
}