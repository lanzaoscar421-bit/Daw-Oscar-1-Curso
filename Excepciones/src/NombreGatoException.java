package src;

public class NombreGatoException extends Exception {

    public String nombre;
    public NombreGatoException(String message) {
        super("El nombre del gato no puede tener menos de dos letras, Asi que se puso por defecto Michi\n");
        this.nombre = message;
    }

    @Override
    public String toString() {
        return "NombreGato{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
