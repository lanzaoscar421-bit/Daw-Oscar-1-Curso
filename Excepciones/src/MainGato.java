package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.print("Ingrese a 5 gatos\n");
        ArrayList<Gato> gatos = new ArrayList<>();

        while(gatos.size()<5){
            try {



                System.out.print("Ingrese nombre:\n");
                System.out.print("El nombre del gato tiene que tener al menos 3 letras, en su defecto se pondra Michi\n");

                String nombre = sc.nextLine();

                System.out.print("Ingrese edad, el gato tiene que tener minimo 0 años y un numero logico de edad, si pones un numero negativo o uno exageradp, se pondra que tiene 1 año por defecto\n");
                int edad = Integer.parseInt(sc.nextLine());

                Gato gato = new Gato(nombre, edad);
                gatos.add(gato);

                System.out.println("Gato añadido correctamente (" + gatos.size() + "/5)\n");

            }catch (NombreGatoException e){
                System.out.println(e.getMessage());
            }catch (EdadGatoException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                /* Pongo un NumberFormatException ya que al pedir la edad lo pido con Integer.parseInt(sc.nextLine()); y con eso salta el NumberFormatException y no el InputMismatchException con lo cual no haria falta controlarlo */
                System.out.println(e.getMessage());
            }
        }

        for(Gato gato : gatos) {
            System.out.println(gato.toString());
        }







        


        















    }
}
