package src;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

//        Ejercicio 1

        System.out.println("Ejercicio 1");

        System.out.println("Introduce un numero");

        int a = 0;

        try {
            a = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Tienes que insertar un numero entero ");

        }

        System.out.println("Valor introducido: " + a);

//        Ejercicio 2

        System.out.println("Ejercicio 2");

        System.out.println("Introduce dos numero");

        int A = 0;
        int B = 0;

        try {
            A = sc.nextInt();
            B = sc.nextInt();
            int resultado = 0;

            resultado = A / B;

            System.out.println("Resultado: " + resultado);

        }catch (InputMismatchException e) {
            System.out.println(e.getMessage());

        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }


//        Ejercicio 3

        System.out.println("Ejercicio 3");


        double[] ejercicio5 = new double[4];

        System.out.println("Introduce numeros en el array");


        try {
            for (int i = 0; i < 20; i++) {
                System.out.print("Introduce el valor " + (i + 1) + ": ");
                ejercicio5[i] = sc.nextDouble();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("El valor no puede pasar de 5");
        }catch (InputMismatchException e){
            System.out.println("El valor no pueden ser letras, ni elementos raros");
        }catch (NullPointerException e){
            System.out.println("El valor no puede pasar de null");
        }

        //Ejercicio 4

        System.out.println("Ejercicio 4");

        int numero = 0;



        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserte un número:");
            try {
                numero = sc.nextInt();
                if (i <= 2) {
                    imprimePositivos(numero);
                } else {
                    imprimeNegativos(numero);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }

    }

    public static void imprimePositivos(int p) throws Exception{
        if(p<0){
            throw new  Exception ("El numero no puede ser menos de negativo");
        }else{
            System.out.println(p);
        }
    }

    public static void imprimeNegativos(int p) throws Exception{
        if(p>0){
            throw new Exception("El numero no puede ser positivo");
        }else {
            System.out.println(p);
        }
    }

}