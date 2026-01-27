public class Gato {

    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreGato {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreGato("El nombre debe tener 3 letras minimo");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadGato {
        if (edad < 0) {
            throw new EdadGato(edad);
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
