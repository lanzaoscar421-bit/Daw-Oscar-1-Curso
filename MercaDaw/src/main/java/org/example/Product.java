package org.example;

/**
 * Clase que representa un producto dentro del sistema MercaDaw.
 *
 * Contiene toda la información relevante de un producto como su identificador,
 * referencia, tipo, nombre, descripción, cantidad disponible, precio,
 * descuento, IVA y si se le aplica descuento.
 */
public class Product {

    /**
     * Identificador único del producto.
     */
    private int id;

    /**
     * Referencia del producto (formato tipo REF000).
     */
    private String referencia;

    /**
     * Tipo de producto (relacionado con la tabla de tipos).
     */
    private int tipo;

    /**
     * Nombre del producto.
     */
    private String name;

    /**
     * Descripción del producto.
     */
    private String description;

    /**
     * Cantidad disponible en inventario.
     */
    private int cantidad;

    /**
     * Precio del producto.
     */
    private double price;

    /**
     * Porcentaje de descuento aplicado al producto.
     */
    private int descuento;

    /**
     * Porcentaje de IVA aplicado al producto.
     */
    private int iva;

    /**
     * Indica si se debe aplicar el descuento al producto.
     */
    private boolean aplicarDTO;

    /**
     * Obtiene el ID del producto.
     *
     * @return ID del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la referencia del producto.
     *
     * @return Referencia del producto
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Obtiene el tipo del producto.
     *
     * @return Tipo del producto
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return Descripción del producto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return Cantidad en inventario
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Obtiene el descuento aplicado al producto.
     *
     * @return Porcentaje de descuento
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * Obtiene el IVA del producto.
     *
     * @return Porcentaje de IVA
     */
    public int getIva() {
        return iva;
    }

    /**
     * Indica si el producto tiene aplicado descuento.
     *
     * @return true si se aplica descuento, false en caso contrario
     */
    public boolean isAplicarDTO() {
        return aplicarDTO;
    }

    /**
     * Establece si se debe aplicar descuento al producto.
     *
     * @param aplicarDTO true para aplicar descuento, false en caso contrario
     * @return El propio objeto Product (permite encadenamiento de métodos)
     */
    public Product setAplicarDTO(boolean aplicarDTO) {
        this.aplicarDTO = aplicarDTO;
        return this;
    }

    /**
     * Constructor completo de la clase Product.
     *
     * @param id Identificador del producto
     * @param referencia Referencia del producto
     * @param tipo Tipo del producto
     * @param name Nombre del producto
     * @param description Descripción del producto
     * @param cantidad Cantidad disponible
     * @param price Precio del producto
     * @param descuento Descuento aplicado
     * @param iva IVA aplicado
     * @param aplicarDTO Indica si se aplica descuento
     */
    public Product(int id, String referencia, int tipo, String name, String description, int cantidad, double price, int descuento, int iva, boolean aplicarDTO) {
        this.id = id;
        this.referencia = referencia;
        this.tipo = tipo;
        this.name = name;
        this.description = description;
        this.cantidad = cantidad;
        this.price = price;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDTO = aplicarDTO;
    }

    /**
     * Constructor utilizado para actualizar productos.
     *
     * Solo incluye los campos modificables.
     *
     * @param id Identificador del producto
     * @param description Nueva descripción
     * @param cantidad Nueva cantidad
     * @param price Nuevo precio
     * @param descuento Nuevo descuento
     * @param aplicarDTO Indica si se aplica descuento
     */
    public Product(int id, String description, int cantidad, double price, int descuento, boolean aplicarDTO) {
        this.id = id;
        this.description = description;
        this.cantidad = cantidad;
        this.price = price;
        this.descuento = descuento;
        this.aplicarDTO = aplicarDTO;
    }

    /**
     * Devuelve una representación en texto del producto.
     *
     * @return Cadena con todos los datos del producto
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", tipo=" + tipo +
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