package src;

public class EdadGatoException extends Exception  {

    private int edad;
    public EdadGatoException(int edad) {
        super("La edad del gato no puede ser menor a 0, asi que se puso 1 año de edad\n");
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "EdadGato{" +
                "edad=" + edad +
                '}';
    }
}
