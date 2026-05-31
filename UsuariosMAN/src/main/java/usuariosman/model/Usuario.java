package usuariosman.model;

import java.time.LocalDate;

public class Usuario {

    private int id_usuario;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;

    public Usuario(int id_usuario, String nombre, String apellido,
                   String dni, LocalDate fecha_nacimiento) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario (UsuarioBuilder builder) {

        this.id_usuario = builder.getId_usuario();
        this.nombre = builder.getNombre();
        this.apellido = builder.getApellido();
        this.dni = builder.getDni();
        this.fecha_nacimiento = builder.getFecha_nacimiento();
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public Usuario setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Usuario setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Usuario setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Usuario setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }


    public static UsuarioBuilder builder() {return new UsuarioBuilder();}
}
