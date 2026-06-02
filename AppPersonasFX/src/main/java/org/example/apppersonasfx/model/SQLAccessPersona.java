package org.example.apppersonasfx.model;

import org.example.apppersonasfx.configuration.SQLDataBaseManager;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessPersona {


    //Metodo para ver todas las personas
    public static List<Persona> getAllPersonas(){

        List<Persona> personas = new LinkedList<>();

        //Sentencia
        String sql = "SELECT * FROM person";

        try (Connection conn = SQLDataBaseManager.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){


            while(resultSet.next()){
                String dni = resultSet.getNString(1);
                String name = resultSet.getNString(2);
                String surname = resultSet.getNString(3);
                String email = resultSet.getNString(4);
                int age = resultSet.getInt(5);
                String phone = resultSet.getNString(6);


                //Uso del patron Builder
                Persona p = Persona.builder()
                        .dni(dni)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();
                personas.add(p);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return null;
    }

    //Metodo para ver las personas por Dni
    public static Persona getpersonaDNI(String dni){
        Persona p = null;
        String sql = "SELECT * FROM person WHERE dni = ?";

        try (Connection conn = SQLDataBaseManager.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String dniDB = resultSet.getNString(1);
                String name = resultSet.getNString(2);
                String surname = resultSet.getNString(3);
                String email = resultSet.getNString(4);
                int age = resultSet.getInt(5);
                String phone = resultSet.getNString(6);


                //Uso del patron Builder
                p = Persona.builder()
                        .dni(dni)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return p;
    }

    //Metodo para buscar las personas por Email
    public static Persona getpersonaEmail(String email){
        Persona p = null;

        String sql = "SELECT * FROM person WHERE email = ?";

        try (Connection conn = SQLDataBaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String dni = resultSet.getNString(1);
                String name = resultSet.getNString(2);
                String surname = resultSet.getNString(3);
                String emailDB = resultSet.getNString(4);
                int age = resultSet.getInt(5);
                String phone = resultSet.getNString(6);


                //Uso del patron Builder
                p = Persona.builder()
                        .dni(dni)
                        .name(name)
                        .surname(surname)
                        .email(emailDB)
                        .age(age)
                        .phone(phone)
                        .build();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return p;
    }

    //Metodo Crear Persona
    public static boolean creatPersona(Persona persona){
        boolean result = false;

        //Setencia
        String sql = "INSERT INTO PERSON VALUES (dni,name,surname,email,age,phone) (?, ?, ?, ?, ?, ?)";

        try (Connection conn = SQLDataBaseManager.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getName());
            statement.setString(3, persona.getSurname());
            statement.setString(4, persona.getEmail());
            statement.setInt(5, persona.getAge());
            statement.setString(6, persona.getPhone());
            statement.execute();

            result = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return result;
    }

    //Metodo para eliminar personas
    public static boolean deletePersonaByDni(String dni){
        boolean result = false;

        String sql = "DELETE FROM PERSON WHERE dni = ?";

        try (Connection conn = SQLDataBaseManager.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, dni);
            statement.execute();

            result = true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    //Metodo para actualizar los datos de las personas
    public static boolean updatePersona(Persona persona){
        boolean result = false;

        String sql = "UPDATE person set name = ?, surname = ?, email = ?, age = ?, phone = ?, WHERE dni = ?";

        try (Connection conn = SQLDataBaseManager.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, persona.getName());
            statement.setString(2, persona.getSurname());
            statement.setString(3, persona.getEmail());
            statement.setInt(4, persona.getAge());
            statement.setString(5, persona.getPhone());

            //Para el where
            statement.setString(6, persona.getDni());
            //
            statement.executeUpdate();
            result = true;


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
    
}

