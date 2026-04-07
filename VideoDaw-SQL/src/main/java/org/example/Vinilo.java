package org.example;

public class Vinilo {

    private int id;
    private String codigo;
    private String banda;
    private String titulo;
    private int genero;
    private boolean pa;
    private boolean isAlquilida;

    public Vinilo(int id, String codigo, String banda, String titulo, int genero ,boolean pa, boolean isAlquilida) {
        this.id = id;
        this.codigo = codigo;
        this.banda = banda;
        this.titulo = titulo;
        this.genero = genero;
        this.pa = pa;
        this.isAlquilida = isAlquilida;
    }

    public Vinilo(int id, String codigo,String banda ,String titulo, int genero,boolean pa) {
        this.id = id;
        this.codigo = codigo;
        this.banda = banda;
        this.titulo = titulo;
        this.genero = genero;
        this.pa = pa;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getBanda() {
        return banda;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getGenero() {
        return genero;
    }

    public boolean isPa() {
        return pa;
    }

    public boolean isAlquilida() {
        return isAlquilida;
    }

    @Override
    public String toString() {
        return "Vinilo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", banda='" + banda + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", pa=" + pa +
                ", isAlquilida=" + isAlquilida +
                '}';
    }
}
