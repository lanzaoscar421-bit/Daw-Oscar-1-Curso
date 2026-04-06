package org.example;

public class Vinilo {

    private int id;
    private String codigo;
    private String titulo;
    private int genero;
    private boolean isAlquilida;

    public Vinilo(int id, String codigo, String titulo, int genero, boolean isAlquilida) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.isAlquilida = isAlquilida;
    }

    public Vinilo(int id, String titulo, int genero) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getGenero() {
        return genero;
    }

    public boolean isAlquilida() {
        return isAlquilida;
    }


    @Override
    public String toString() {
        return "Vinilo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", isAlquilida=" + isAlquilida +
                '}';
    }
}
