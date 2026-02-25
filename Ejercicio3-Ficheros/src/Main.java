import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        final String path = "./src/resources/";
        final String fileName = "Biblioteca.dat";
        boolean fileMode = false;

        LinkedList<Libro> libros = new LinkedList<>();


        String opcion = "";

        do {

            Menu();


            opcion = sc.nextLine();


            switch (opcion) {
                case "1":
                    System.out.println("Inserte el ISBN del libro");
                    String isbnAdd = sc.nextLine();
                    System.out.println("Inserte el titulo del libro");
                    String tituloAdd = sc.nextLine();
                    System.out.println("Inserte el autor del libro");
                    String autorAdd = sc.nextLine();
                    System.out.println("Inserte el editora del libro");
                    String editoraAdd = sc.nextLine();


                    try {
                        validarISBN(libros,isbnAdd);
                        Libro libroNuevo = new Libro(isbnAdd,tituloAdd,autorAdd,editoraAdd);
                        libros.add(libroNuevo);

                        System.out.println("Libro añadido correctamente");

                    }catch (IsbnRepetido e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "2":

                    System.out.println("Estos son los libros Exsistentes:");


                    if (libros.isEmpty()) {
                        System.out.println("No hay libros");
                    }for (Libro libro : libros) {
                        System.out.println(libro);
                    }


                    break;
                case "3":

                    System.out.println("Inserte el ISBN del libro para eliminar");
                    String isbnDele = sc.nextLine();
                    boolean eliminado = false;

                    for (Libro libro : libros) {
                        if(libro.getISBN().equals(isbnDele)){
                            libros.remove(libro);
                            eliminado = true;
                        }
                    }

                    if(eliminado){
                        System.out.println("Libro eliminado correctamente");
                    }else{
                        System.out.println("ISBN inexistente");
                    }

                    break;
                case "4":
                    System.out.println("Se van a guardar en el fichero");

                    try (FileOutputStream file = new FileOutputStream(path+fileName,fileMode);
                         ObjectOutputStream buffer = new ObjectOutputStream(file)) {
                        for (Libro libro : libros) {
                            buffer.writeObject(libro);
                        }

                        System.out.println("Libro o Libros guardado exitosamente");
                    }catch (IOException e){
                        System.out.println("Error al abrir el archivo" + e.getMessage());
                    }

                    break;
                case "5":

                    System.out.println("Adios.");
                    break;

                default:
                    System.err.println("Porfavor inserte un numero del 1-5 🙏🏻🔥");

                    break;

            }


        }while(!opcion.equals("5"));


    }//Metodos


    private static void validarISBN (LinkedList<Libro> libros, String isbn) throws IsbnRepetido{
        for  (Libro libro : libros) {
            if (libro.getISBN().equals(isbn)) {
                throw new IsbnRepetido("");
            }
        }
    }



    private static void Menu() {
        System.out.println("1. Crear Libro y registrarlo en la Biblioteca (ISBN único)");
        System.out.println("2. Mostrar Libros existentes por (ISBN, titulo, Autor, Fecha)");
        System.out.println("3. Eliminar Libro por ISBN");
        System.out.println("4. Guardar Libros en el fichero");
        System.out.println("5. Guardar y Salir");
    }
}
