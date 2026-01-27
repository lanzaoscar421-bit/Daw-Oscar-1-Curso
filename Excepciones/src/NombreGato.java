public class NombreGato extends RuntimeException {

    public String nombre;
    public NombreGato(String message) {
        super("El nombre del gato no puede tener menos de dos letras, Asi que se puso por defecto Michi");
        this.nombre = message;
    }

    @Override
    public String toString() {
        return "NombreGato{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
