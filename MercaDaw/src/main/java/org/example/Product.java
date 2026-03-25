package org.example;

public class Product {


    private int id;
    private String referencia;
    private String name;
    private String description;
    private int cantidad;
    private double price;
    private int descuento;
    private int iva;
    private boolean aplicarDTO;

    public int getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrice() {
        return price;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicarDTO() {
        return aplicarDTO;
    }

    public Product setAplicarDTO(boolean aplicarDTO) {
        this.aplicarDTO = aplicarDTO;
        return this;
    }

    public Product(int id, String referencia, String name, String description, int cantidad, double price, int descuento, int iva, boolean aplicarDTO) {
        this.id = id;
        this.referencia = referencia;
        this.name = name;
        this.description = description;
        this.cantidad = cantidad;
        this.price = price;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDTO = aplicarDTO;
    }

    public Product(int id, String description, int cantidad, double price, int descuento, boolean aplicarDTO) {
        this.id = id;
        this.description = description;
        this.cantidad = cantidad;
        this.price = price;
        this.descuento = descuento;
        this.aplicarDTO = aplicarDTO;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cantidad=" + cantidad +
                ", price=" + price +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", aplicarDTO=" + aplicarDTO +
                '}';
    }
}
