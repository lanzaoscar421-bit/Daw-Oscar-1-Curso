package org.example;

import java.time.LocalDate;

public class Vinilo {

    private int id;
    private String codigo;
    private String banda;
    private String titulo;
    private int genero;
    private boolean pa;
    private boolean isComprada;
    private LocalDate fechaBaja;

    public Vinilo(int id, String codigo, String banda, String titulo, int genero ,boolean pa, boolean isComprada, LocalDate fechaBaja) {
        this.id = id;
        this.codigo = codigo;
        this.banda = banda;
        this.titulo = titulo;
        this.genero = genero;
        this.pa = pa;
        this.isComprada = isComprada;
        this.fechaBaja = fechaBaja;
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

    public boolean isComprada() {
        return isComprada;
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
                ", isComprada=" + isComprada +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}
