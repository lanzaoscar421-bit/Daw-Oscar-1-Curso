public class Caja implements Comparable<Caja> {

    private String nombre;
    private int cantidad;


    public Caja(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cajas{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public int compareTo(Caja c) {

        if(c != null) {
            return this.nombre.compareToIgnoreCase(c.nombre);
        }

        return 1;
    }

}
