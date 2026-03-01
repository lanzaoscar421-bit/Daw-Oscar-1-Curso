import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Iventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Link https://github.com/lanzaoscar421-bit/Daw-Oscar-1-Curso/tree/main/Actividad04-FicherosCombinados



        //Porductos

        final String path = "./src/Resources/";
        final String fileName = "productos.csv";
        boolean fileMode = false;


        //Almacen

        final String path2 = "./src/Resources/";
        final String fileName2 = "almacen.dat";
        boolean fileMode2 = false;

        //Productos random

        Producto p1 = new Producto("REF001", "Teclado mecanico", "Informatica", 10, 59.99, 10, 21, true);
        Producto p2 = new Producto("REF002", "Raton gaming", "Informatica", 15, 29.95, 5, 21, true);
        Producto p3 = new Producto("REF003", "Monitor 24 pulgadas", "Informatica", 8, 149.99, 15, 21, true);
        Producto p4 = new Producto("REF004", "Silla oficina", "Mobiliario", 5, 199.99, 20, 21, false);
        Producto p5 = new Producto("REF005", "Auriculares bluetooth", "Electronica", 12, 79.90, 10, 21, true);
        Producto p6 = new Producto("REF006", "Disco SSD 1TB", "Informatica", 6, 99.99, 5, 21, true);
        Producto p7 = new Producto("REF007", "Impresora multifuncion", "Electronica", 4, 129.99, 10, 21, false);
        Producto p8 = new Producto("REF008", "Tablet 10 pulgadas", "Electronica", 7, 219.99, 15, 21, true);
        Producto p9 = new Producto("REF009", "Webcam HD", "Informatica", 20, 39.99, 0, 21, false);
        Producto p10 = new Producto("REF010", "Altavoces PC", "Electronica", 9, 49.99, 5, 21, true);


        List<Producto> productos = new LinkedList<>();

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);


        try (FileOutputStream file = new FileOutputStream(path+fileName,fileMode);
        ObjectOutputStream buffer = new ObjectOutputStream(file)){


            for (Producto producto : productos) {
                buffer.writeObject(producto);
            }

            System.out.println("Producto guardado exitosamente");

        }catch(IOException e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }

        //Vinilos

        Producto vinilo1 = new Producto("VIN001", "Hybrid Theory - Linkin Park", "Vinilo Nu Metal", 5, 29.99, 10, 21, true);
        Producto vinilo2 = new Producto("VIN002", "Toxicity - System of a Down", "Vinilo Nu Metal", 4, 27.99, 5, 21, true);
        Producto vinilo3 = new Producto("VIN003", "Slipknot - Slipknot", "Vinilo Nu Metal", 3, 31.99, 15, 21, true);
        Producto vinilo4 = new Producto("VIN004", "Follow the Leader - Korn", "Vinilo Nu Metal", 6, 26.99, 10, 21, false);
        Producto vinilo5 = new Producto("VIN005", "White Pony - Deftones", "Vinilo Nu Metal", 2, 34.99, 20, 21, true);
        Producto vinilo6 = new Producto("VIN006", "Around the Fur - Deftones", "Vinilo Nu Metal", 3, 28.99, 5, 21, true);
        Producto vinilo7 = new Producto("VIN007", "Chocolate Starfish - Limp Bizkit", "Vinilo Nu Metal", 4, 25.99, 10, 21, false);
        Producto vinilo8 = new Producto("VIN008", "Infest - Papa Roach", "Vinilo Nu Metal", 5, 24.99, 0, 21, false);
        Producto vinilo9 = new Producto("VIN009", "Coal Chamber - Coal Chamber", "Vinilo Nu Metal", 2, 29.99, 15, 21, true);
        Producto vinilo10 = new Producto("VIN010", "Issues - Korn", "Vinilo Nu Metal", 3, 27.99, 5, 21, true);


        productos.add(vinilo1);
        productos.add(vinilo2);
        productos.add(vinilo3);
        productos.add(vinilo4);
        productos.add(vinilo5);
        productos.add(vinilo6);
        productos.add(vinilo7);
        productos.add(vinilo8);
        productos.add(vinilo9);
        productos.add(vinilo10);

        try (FileOutputStream file = new FileOutputStream(path2+fileName2,fileMode2);
             ObjectOutputStream buffer = new ObjectOutputStream(file)){


            for (Producto producto : productos) {
                buffer.writeObject(producto);
            }

            System.out.println("Vinilo guardado exitosamente");

        }catch(IOException e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }



        String opcion = "";

        do {

            sc = new Scanner(System.in);//Reiniciar Scanner

            Menu();


            opcion = sc.nextLine();


            switch (opcion) {



                case "1":

                    System.out.println("Productos registrados:");

                    for(Producto producto : productos) {
                        System.out.println(producto.toString());
                    }
                    break;
                case "2":

                    System.out.println("Para eliminar el Producto/Vinilo, debe insertar Su numero de referencia");
                    String referenciaDel = sc.nextLine();
                    boolean eliminado = false;

                    Producto productoEliminado = null;

                    for(Producto producto : productos) {
                        if (producto.getReferencia().equals(referenciaDel)) {
                            productoEliminado = producto;
                            break;
                        }
                    }

                    if (productoEliminado != null) {
                        productos.remove(productoEliminado);
                        System.out.println(" eliminado exitosamente");
                    }else{
                        System.out.println("Hubo un error, vuelva a inserta la referencia");
                    }

                    break;
                case "3":
                    System.out.println("Para registar un producto, inserte su referencia");
                    String referenciaAdd = sc.nextLine();
                    System.out.println("Ahora inserte el tipo");
                    String tipoAdd = sc.nextLine();
                    System.out.println("Ahora inserte el cantidad");
                    int cantidadAdd = sc.nextInt();
                    System.out.println("Ahora inserte el precio");
                    double precioAdd = sc.nextDouble();

                    Producto productonuevo = new Producto(referenciaAdd, tipoAdd, cantidadAdd, precioAdd);
                    productos.add(productonuevo);

                    try (FileOutputStream file = new FileOutputStream(path+fileName2,fileMode2);
                    ObjectOutputStream buffer = new ObjectOutputStream(file)){
                        buffer.writeObject(productonuevo);

                    }catch(IOException e){
                        System.out.println("Error al abrir el archivo" + e.getMessage());
                    }
                    break;
                case "4":

                    System.out.println("Adios.");

                    break;

                default:
                    System.err.println("Porfavor inserte un numero del 1-5 🙏🏻🔥");

                    break;

            }


        }while(!opcion.equals("5"));

    }
    private static void Menu() {
        System.out.println("1. Mostrar Productos en el Inventario.");
        System.out.println("2. Eliminar Producto por referencia.");
        System.out.println("3. Registrar producto en el Inventario.");
        System.out.println("4. Salir"); //(no permitir referencias repetidas)
    }
}