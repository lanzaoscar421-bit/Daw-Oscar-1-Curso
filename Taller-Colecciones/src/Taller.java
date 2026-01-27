import java.security.Key;
import java.util.*;
import java.util.regex.Pattern;

public class Taller {

    Scanner sc = new Scanner(System.in);

    Map<String,Coche> coches = new HashMap<>();


    public boolean addCoche(){
        boolean res = false;

        String colorAdd;
        String marcaAdd;
        String matriculaAdd;


        System.out.println("Introduce el Color del coche");
        colorAdd = sc.nextLine();

        System.out.println("Introduce la Marca del coche");
        marcaAdd = sc.nextLine();

        do {
            System.out.println("Inserte la matricula del coche");
            System.out.println("La matricula esta formada por 4 numero y 3 letras al final");
            matriculaAdd = sc.nextLine();
        } while (!PatronMatricula(matriculaAdd));


        new  Coche(colorAdd,marcaAdd);

        Coche nuevo = coches.put(matriculaAdd,new  Coche(colorAdd,marcaAdd));

        if(nuevo==null){
            System.out.println("Coche insertado correctamente");
        }else {
            System.out.println("Coche ya existe");
        }

        return res;
    }

    boolean borrarCoche(){
        boolean res = false;

        String cocheEliminar;

        System.out.println("Introduce la matricula del coche que quiere eliminar");
        cocheEliminar = sc.nextLine();


        Coche nuevo1 = coches.remove(cocheEliminar);

        if(nuevo1!=null){
            System.out.println("Coche eliminado correctamente");
        }else{
            System.out.println("Coche no fue eliminado, mire la matricula");
        }

        return res;
    }

    boolean visualizarMatriculas(){
        boolean res = false;
        String todasMatriculas;

        todasMatriculas = coches.keySet().toString();

        System.out.println(todasMatriculas);


        return res;
    }

    Boolean visualizarCoches(){
        boolean res = false;

        for (Coche coche : coches.values()){
            System.out.println(coche);
        }

        return res;
    }



    boolean visualizarTaller(){ //Solo color y marca
        boolean res = false;

        String todosCoches;

        todosCoches = coches.toString();

        System.out.println(todosCoches);
        return res;
    }


    static boolean PatronMatricula(String matricula) {
        String patron = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";
        return Pattern.matches(patron, matricula.toUpperCase());
    }






}
