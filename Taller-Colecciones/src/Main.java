import java.util.Scanner;
//https://github.com/lanzaoscar421-bit/Herencia/tree/main/Taller-Colecciones
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String opcion = "";

        Taller taller = new Taller();

        System.out.println("Bienvenido al Taller 🚗");



        do {

            System.out.println("1. Añadir Coche");
            System.out.println("2. Eliminar Coche");
            System.out.println("3. Salir y ver las matriculas, los coches y todo el talles");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    taller.addCoche();
                    break;
                case "2":

                    taller.borrarCoche();
                    break;

                case "3":

                    System.out.println("Todas las matriculas");
                    taller.visualizarMatriculas();
                    System.out.println("********************");
                    System.out.println("Estos son todos los coches");//Solor color y marca
                    taller.visualizarCoches();
                    System.out.println("********************");
                    System.out.println("Todo el taller");
                    taller.visualizarTaller();





                    System.out.println("Adios.");
                    break;


                default:
                    System.out.println("Porfavor, inserte un numero del 1-6");
                    break;
            }

        }while (opcion != "3");


    }





}