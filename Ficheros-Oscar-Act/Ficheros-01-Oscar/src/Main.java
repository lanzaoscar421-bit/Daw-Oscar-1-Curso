import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);


        final String path = ".\\src\\resources\\";
        final String fileName = "Almacen.dat";

        LinkedList<Producto> listaProductos = new LinkedList<>();



        String opcion = "";

        do {

            Menu();


            opcion = sc.nextLine();


            switch (opcion) {
                case "1":

                    try {
                        System.out.println("Inserte el codigo");
                        String codigoInsert = sc.nextLine();

                        System.out.println("Inserte el nombre");
                        String nombreInsert = sc.nextLine();

                        System.out.println("Inserte La cantidad");
                        int cantidadInsert = sc.nextInt();

                        System.out.println("Inserte el precio");
                        double precioInsert = sc.nextDouble();

                        listaProductos.add(new Producto(codigoInsert, nombreInsert, cantidadInsert, precioInsert));

                    }catch (InputMismatchException e){
                        System.out.println("Error, porfavor inserte bien los datos");
                    }

                    System.out.println("Producto añadido");

                    break;
                case "2":

                    if (listaProductos.isEmpty()) {
                        System.out.println("No hay productos en la lista");
                    }else{
                        for (Producto producto : listaProductos) {
                            System.out.println(producto);
                        }
                    }
                    break;
                case "3":

                    System.out.println("Inserte el codigo para eliminar el producto" );
                    String codigoEliminar = sc.nextLine();


                    boolean eliminado = listaProductos.remove(codigoEliminar);

                    if (eliminado) {
                        System.out.println("Producto eliminado");
                    }else{
                        System.out.println("No existe el producto para eliminar el producto");
                    }

                    break;
                case "4":
                    
                    guardarProductos(path + fileName, listaProductos);
                    break;
                case "5":
                    System.out.println("Adios.");
                    break;

                default:
                    System.out.println("Porfavor, inserte un numero entre el 1-5");
                    break;

            }


        }while(!opcion.equals("5"));



        //Metodos
    }

    private static void guardarProductos(String ruta, LinkedList<Producto> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true))) {
            for (Producto p : lista) {
                bw.write(p.toFileString());
                bw.newLine();
            }
            System.out.println("Productos guardados en fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Error al guardar, inserte bien los datos: " + e.getMessage());
        }
    }

    private static void Menu() {
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar productos existentes");
        System.out.println("3. Eliminar producto por código");
        System.out.println("4. Guardar producto en el fichero");
        System.out.println("5. Salir");
  }
}