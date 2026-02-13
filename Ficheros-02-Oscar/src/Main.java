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


            opcion = sc.nextLine();matcher = {Matcher@1135} "java.util.regex.Matcher[pattern=.*(\r\n|[\n\r  ])|.+$ region=0,2 lastmatch=1\n]"… View


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
                        sc.nextLine();


                        listaProductos.add(new Producto(codigoInsert, nombreInsert, cantidadInsert, precioInsert));

                        System.out.println("Producto añadido");

                    }catch (InputMismatchException e){
                        System.out.println("Error, porfavor inserte bien los datos");
                    }


                    break;
                case "2":

                    if (listaProductos.isEmpty()) {
                        System.out.println("No hay productos.");
                    } else {
                        for (Producto p : listaProductos) {
                            System.out.println(p);
                        }
                    }

                    break;
                case "3":

                    System.out.println("Inserte el codigo para eliminar el producto" );
                    String codigoEliminar = sc.nextLine();


                    boolean eliminado = false;

                    for (Producto p : listaProductos) {
                        if (p.getCodigo().equals(codigoEliminar)) {
                            listaProductos.remove(p);
                            eliminado = true;
                            break;
                        }
                    }

                    break;

                case "4":

                    try(FileOutputStream file = new FileOutputStream(path + fileName,true);
                    DataOutputStream writer = new DataOutputStream(file)){

                        for (Producto producto : listaProductos) {
                            writer.writeUTF(producto.getCodigo());
                            writer.writeUTF(producto.getNombre());
                            writer.writeInt(producto.getCantidad());
                            writer.writeDouble(producto.getPrecio());
                        }

                    }catch (IOException e) {
                        System.out.println("Error al escribir el archivo" + e.getMessage());
                    }
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



    private static void Menu() {
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar productos existentes");
        System.out.println("3. Eliminar producto por código");
        System.out.println("4. Guardar producto en el fichero");
        System.out.println("5. Salir");
    }
}