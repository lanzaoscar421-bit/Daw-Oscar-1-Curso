package org.example;

import java.sql.Date;
import java.time.LocalDate;

public class Cliente {

    private int id;
    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String numSocio;
    private LocalDate fechaBaja;

    public Cliente(int id ,String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
    }

    public Cliente(int id, String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio, LocalDate fechaBaja) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", numSocio='" + numSocio + '\'' +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}
