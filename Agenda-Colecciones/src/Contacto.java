import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Contacto implements Comparable<Contacto>{


    Agenda nuevaAgenda;


    private String nombre;
    private String telefono;
    private String correo;


    public Contacto(String nombre, String  telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                '}';
    }

    //Metodos

    public int compareTo(Contacto otro) {
         this.nombre.compareTo(otro.getNombre());
        return this.telefono.compareToIgnoreCase(otro.telefono);
    }
}


