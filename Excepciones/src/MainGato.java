import java.util.ArrayList;
import java.util.Scanner;

public class MainGato {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    //Ejercicio 5

//    String nombre = "";
//    int edad = 0;
//
//    Gato gato = null;
//
//    try {
//        System.out.println("Ingresa el nombre del gato: ");
//        nombre = sc.nextLine();
//        System.out.println("Ingresa el edad del gato: ");
//        edad = sc.nextInt();
//
//         gato = new Gato(nombre, edad);
//
//    }catch(NombreGato e){
//        System.out.println(e.getMessage());
//         gato = new Gato("Michi", edad);
//    }catch(EdadGato e) {
//        System.out.println(e.getMessage());
//        gato = new Gato(nombre, 1);
//    }catch (Exception e){
//        System.out.println("Se puso de nombre por defecto michi y de edad 1");
//        gato = new Gato("Michi", 1);
//    }finally {
//        System.out.println("Datos del gato: " + gato.toString());
//    }


        //Ejercicio 6

        ArrayList<Gato> gatos = new ArrayList<>();

        Gato nuevoGato = null;

        int contador = 0;

        while (contador < 5) {

            System.out.println("Introduce los dato del gato: " + (contador+1));


        }

        System.out.println("Inserte 5 gatos");















    }
}
