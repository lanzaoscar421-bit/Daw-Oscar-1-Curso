import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);


        final String path = ".\\src\\resources\\";
        String fileName = "Almacen.dat";

        LinkedList<Producto> listaProductos = new LinkedList<>();

        try (FileReader file = new FileReader(path+fileName);
             BufferedReader bufferedReader = new BufferedReader(file);){

            String line = "";

            

        }






//        String opcion = "";
//
//        do {
//
//            Menu();
//
//
//            opcion = sc.nextLine();
//
//
//            switch (opcion) {
//                case "1":
//                    System.out.println("Inserte el codigo");
//                    String codigoInsert = sc.nextLine();
//                    System.out.println("Inserte el nombre");
//                    String nombreInsert = sc.nextLine();
//                    System.out.println("Inserte La cantidad");
//                    int cantidadInsert = sc.nextInt();
//                    System.out.println("Inserte el precio");
//                    double precioInsert = sc.nextDouble();
//
//
//
//
//
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//
//                    break;
//                case "4":
//
//                    break;
//                case "5":
//                    System.out.println("Adios.");
//                    break;
//
//                default:
//                    System.out.println("Porfavor, inserte un numero entre el 1-5");
//                    break;
//
//            }
//
//
//        }while(!opcion.equals("5"));
//
//
//
//        //Metodos
//    }
//
//    private static void Menu() {
//        System.out.println("1. Crear producto");
//        System.out.println("2. Mostrar productos existentes");
//        System.out.println("3. Eliminar producto por código");
//        System.out.println("4. Guardar producto en el fichero");
//        System.out.println("5. Salir");
  }
}