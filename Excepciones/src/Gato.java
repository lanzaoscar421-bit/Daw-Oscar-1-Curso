package src;

public class Gato {

    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws NombreGatoException, EdadGatoException {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreGatoException {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreGatoException("El nombre debe tener 3 letras minimo");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadGatoException {
        if (edad < 0 ) {
            throw new EdadGatoException(edad);
        }else if (edad > 22) {
            throw new EdadGatoException(edad);
        }

        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }


}
