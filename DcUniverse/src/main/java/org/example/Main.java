package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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



        //Todos los nombres de lo heroes
        List<String> heroeNames = SQLAccessDCuniverse.getCharactersName();

        for (String heroeName : heroeNames) {
            System.out.println(heroeName);
        }
        //

        System.out.println("\n");

        // Todos los heroes
        List<Character> heroeCharacters = SQLAccessDCuniverse.getCharacters();
        for (Character heroeCharacter : heroeCharacters) {
            System.out.println(heroeCharacter);
        }
        //


        System.out.println("\n");

        //Buscar Heroe por id
        System.out.print("Enter character ID: ");
        int id = sc.nextInt();

        Character ch = SQLAccessDCuniverse.getCharacter(id);
        System.out.println(ch);
        //

        System.out.println("\n");


        //Buscar Heroe por nombre
        System.out.print("Enter character name: ");
        String name = sc.nextLine();
        List<Character> ch2 = SQLAccessDCuniverse.getCharacterByName(name);
        if(ch2.isEmpty()){
            System.out.println("No character found with that name");
        }else{
            for(Character character : ch2){
                System.out.println(character);
            }
        }
        //

        System.out.println("\n");


        //



    }
}