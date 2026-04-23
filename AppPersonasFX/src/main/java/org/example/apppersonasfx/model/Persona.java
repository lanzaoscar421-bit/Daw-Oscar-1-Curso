package org.example.apppersonasfx.model;

public class Persona {

    private String dni;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String phone;

    //Constructor con parametros
    public Persona(String dni, String name, String surname, String email, int age, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    //Constructor Con la Clase PersonaBuilder
    public Persona (PersonaBuilder personaBuilder) {
        this .dni = builder().getDni();
        this.name = builder().getName();
        this.surname = builder().getSurname();
        this.email = builder().getEmail();
        this.age = builder().getAge();
        this.phone = builder().getPhone();
    }

    //Constructor sin parametros
    public Persona() {}

    //Getters
    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }


    //Setters
    public Persona setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public Persona setName(String name) {
        this.name = name;
        return this;
    }

    public Persona setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Persona setEmail(String email) {
        this.email = email;
        return this;
    }

    public Persona setAge(int age) {
        this.age = age;
        return this;
    }

    public Persona setPhone(String phone) {
        this.phone = phone;
        return this;
    }



    //To String de la clase
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }


    //Metodos
    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }



}