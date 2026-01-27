import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Galaxia {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a tu programa informativo Favorito 🌍");


        //Dentro del sistema Solar

        Planetas tierra = new Planetas(
                6371, 24, 5.97e24, 15, 9,
                149.6e6, 365, true
        );
        Planetas marte = new Planetas(
                3390, 24.6, 6.4e23, -63, 3,
                227.9e6, 687, false
        );
        Planetas venus = new Planetas(
                6051, 5832, 4.87e24, 464, 8,
                108.2e6, 225, false
        );
        Planetas mercurio = new Planetas(
                2439, 1408, 3.30e23, 167, 3,
                57.9e6, 88, false
        );
        Planetas jupiter = new Planetas(
                69911, 9.9, 1.90e27, -110, 24,
                778.5e6, 4333, true
        );
        Planetas saturno = new Planetas(
                58232, 10.7, 5.68e26, -140, 10,
                1434e6, 10759, false
        );
        planetaSistemaSolar result = new planetaSistemaSolar(tierra, marte, venus, mercurio, jupiter, saturno);


        //Fuera del Sistema Solar
        Planetas proximaB = new Planetas(
                7160, 11, 1.27e25, -39, 11,
                4.24e13, 11.2, false
        );

        Planetas kepler452b = new Planetas(
                7640, 26, 5.00e25, 20, 19,
                1.40e14, 385, false
        );

        Planetas trappist1e = new Planetas(
                5790, 6.1, 4.20e24, -20, 9,
                3.90e13, 6.1, false
        );

        //Satelites
        Satelites luna = new Satelites(
                1737, 655, 7.35e22, -20, 1,
                384400, 27, "Tierra"
        );

        Satelites phobos = new Satelites(
                11, 7.6, 1.07e16, -40, 0.003,
                9376, 0.32, "Marte"
        );

        Satelites deimos = new Satelites(
                6, 30.3, 1.48e15, -40, 1,
                23463, 1.26, "Marte"
        );

        Satelites europa = new Satelites(
                1560, 85.2, 4.80e22, -160, 1.3,
                670900, 3.55, "Júpiter"
        );




        String opcion = "";



        do{
            opciones();


            opcion = sc.nextLine();

            switch(opcion){

                case "1":

                    planetaSistemaSolar(tierra, marte, venus, mercurio, jupiter, saturno);

                    break;

                case "2":
                    satelites(luna, phobos, deimos, europa);


                    break;

                case "3":
                    planetasFueraSistema(proximaB, trappist1e, kepler452b);
                    break;

                case "4":
                    System.out.println("Muchas gracias Adios.");
                break;

                default:
                    System.out.println("Porfavor inserte una opcion entre el 1-3 gracias.");
                    break;
            }


        }while(!opcion.equals("4"));





    }

    private static void planetasFueraSistema(Planetas proximaB, Planetas trappist1e, Planetas kepler452b) {
        System.out.println("Informacion de la ProximaB:");
        proximaB.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Trappiste:");
        trappist1e.info();
        System.out.println("************************");
        System.out.println("Informacion sobre kepler452b:");
        kepler452b.info();
    }

    private static void satelites(Satelites luna, Satelites phobos, Satelites deimos, Satelites europa) {
        System.out.println("Informacion de la Luna:");
        luna.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Phobos:");
        phobos.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Deimos:");
        deimos.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Europa:");
        europa.info();
    }

    private static void planetaSistemaSolar(Planetas tierra, Planetas marte, Planetas venus, Planetas mercurio, Planetas jupiter, Planetas saturno) {
        System.out.println("Informacion de la Tierra:");
        tierra.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Marte:");
        marte.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Venus:");
        venus.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Mercurio:");
        mercurio.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Jupiter:");
        jupiter.info();
        System.out.println("************************");
        System.out.println("Informacion sobre Saturno:");
        saturno.info();
    }

    private static void opciones() {
        System.out.println("1. Para ver la informacion de los planetas que tenemos registrados");

        System.out.println("2. Para ver los planetas que tenemos registrados");

        System.out.println("3. Para ver los planetas fuera del sistema solar que tenemos registrados");
    }

    private record planetaSistemaSolar(Planetas tierra, Planetas marte, Planetas venus, Planetas mercurio, Planetas jupiter, Planetas saturno) {
    }
}