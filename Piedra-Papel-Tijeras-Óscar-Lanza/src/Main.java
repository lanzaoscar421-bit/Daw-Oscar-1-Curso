import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Piedra-Papel-Tijeras-Óscar-Lanza


        System.out.println("********************************");
        System.out.println("-Piedra 🪨 -Papel🗞️ -Tijeras✂️ ");
        System.out.println("********************************");

        int opcion = 0;
        int jugador = 0;
        int ordenador = 0;
        char eleccion = 0;

        while(opcion != 4){

            System.out.println("===================================================================================");
            System.out.println("Pulsa 1: Pulsa la tecla 1 si no sabe jugar a este juego y quieres saber las normas ");
            System.out.println("===================================================================================");
            System.out.println("Pulsa 2: Pulsa la tecla 2 para empezar el juego ");
            System.out.println("================================================");
            System.out.println("Pulsa la tecla 3 si quiere ver la lista de juegos");
            System.out.println("==============================================");
            System.out.println("Pulsa la tecla 4 si desea salir del Programa");
            System.out.println("============================================");


            System.out.println(" ");
            opcion = scanner.nextInt();


            switch (opcion){

                    case 1:
                        System.out.println("###########################################################################################################################");
                        System.out.println("Usted Acaba de Pulsa el 1");
                        System.out.println(" ");
                        System.out.println("El juego de piedra, papel o tijeras consiste en que dos jugadores eligen una de las tres opciones: piedra, papel o tijeras.");
                        System.out.println("La piedra gana a la tijera, la tijera gana al papel y el papel gana a la piedra.");
                        System.out.println("Si ambos eligen lo mismo, hay empate y se repite la ronda.");
                        System.out.println("########################################################################################################################### ");

                        break;
                    case 2:
                        System.out.println("Usted Acaba de Pulsa el 2");
                        System.out.println(" ");
                        System.out.println("----------------------");
                        System.out.println("Empecemos con el Juego");
                        System.out.println("Pero antes de Nada");
                        System.out.println("Si quiere 🪨 Pulsa P");
                        System.out.println("Si quiere 🗞️ Pulsa L");
                        System.out.println("Si quiere ✂️ Pulsa T");
                        System.out.println("----------------------");

                        //Ahora pondremos que las letraS P-T-L Valgan numeros

                        //Parte del jugador

                        System.out.println("Tu opcion, Porfavor Las letras que sean en MAYUSCULAS.");
                        eleccion = scanner.next().charAt(0);

                        if (eleccion == 'P') {
                            jugador = 1;
                        }

                        else if (eleccion == 'L') {
                            jugador = 2;
                        }
                        else if (eleccion == 'T') {
                            jugador = 3;
                        }
                        else {
                            System.out.println("Opcion no Valida, o pruebe a poner las letras en Mayusculas la siguente vez.");
                        }


                        //Parte de la maquina
                        System.out.println("Opcion completamente random de la maquina");
                        ordenador = (int) (Math.random()*3+1); // 1,2,3 como siempre

                        char ordenadorLetra = 0;

                        if (ordenador == 1) {
                            ordenadorLetra = 'P';
                        }
                        else if (ordenador == 2) {
                            ordenadorLetra = 'L';
                        }
                        else if (ordenador == 3) {
                            ordenadorLetra = 'T';
                        }

                        System.out.println( ordenadorLetra);



                        //Parte Generica
                        if(jugador==ordenador){
                            System.out.println("Empate!, los dos tuvisteis la misma respuesta, Pulsa 2 para volver a empezar!!");
                        }

                        //Parte de Victorias
                        if(jugador == 1 && ordenador == 3){
                            System.out.println("Escogiste Piedra y la Maquina Tijeras");
                            System.out.println("Ganaste!!!");
                        }
                        else  if(jugador == 2 && ordenador == 1){
                            System.out.println("Escogiste papel y el ordenador piedra");
                            System.out.println("Ganaste!!!");

                        }
                        else if (jugador == 3 && ordenador == 2){
                            System.out.println("Escogiste tijeras y el ordenador papel");
                            System.out.println("Ganaste!!!");
                        }



                        //Parte de Derrotas
                        else if  (jugador == 1 && ordenador == 2){
                            System.out.println("Escogiste piedra y el ordenador papel");
                            System.out.println("Perdiste!!!");
                        }
                        else if (jugador == 2 && ordenador == 3){
                            System.out.println("Escogiste papel y el ordenador tijeras");
                            System.out.println("Perdiste!!!");
                        }
                        else if (jugador == 3 && ordenador == 1){
                            System.out.println("Escogiste Tijeras y el ordenador piedra");
                            System.out.println("Perdiste!!!");
                        }



                        //





                        System.out.println("---------------------------------------------");
                        System.out.println(" ");
                        System.out.println("Quiere volver a jugar?? Si asi desea pulse 2");
                        System.out.println(" ");

                        break;
                    case 3:
                        System.out.println("Estamos en proceso de ello, disculpe las molestias");
                        System.out.println("💀💀💀💀");


                        break;
                    case 4:
                        System.out.println("Adios un Placer.");
                        System.out.println("-----------------");

                        break;
                }


        }




    }
}