public class EdadGato extends RuntimeException {


    private int edad;
    public EdadGato(int edad) {
        super("La edad del gato no puede ser menor a 0, asi que se puso 1 año de edad");
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "EdadGato{" +
                "edad=" + edad +
                '}';
    }
}
