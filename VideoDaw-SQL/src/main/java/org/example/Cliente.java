package org.example;

import java.security.PrivilegedAction;
import java.time.LocalDate;
import java.util.Date;

public class Cliente {

    private int id;
    private String dni;
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;
    private String numSocio;
    private Date fechaBaja;

    public Cliente(int id ,String dni, String nombre, String direccion, Date fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
    }

    public Cliente(int id, String dni, String nombre, String direccion, Date fechaNacimiento, String numSocio, Date fechaBaja) {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public Date getFechaBaja() {
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
