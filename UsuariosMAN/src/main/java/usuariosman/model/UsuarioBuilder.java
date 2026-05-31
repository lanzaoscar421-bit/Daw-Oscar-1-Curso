package usuariosman.model;

import java.time.LocalDate;

public class UsuarioBuilder {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public UsuarioBuilder id_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }
    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public UsuarioBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public UsuarioBuilder dni(String dni) {
        this.dni = dni;
        return this;
    }
    public UsuarioBuilder fecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
        return this;
    }

    public Usuario build() {return  new Usuario(id_usuario,nombre,apellido,dni,fecha_nacimiento);}

    public UsuarioBuilder () {}
}
