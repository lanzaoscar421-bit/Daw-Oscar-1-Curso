import Excepciones.ValidacionDNI;
import Excepciones.ValidacionDirector;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Empresa implements Serializable {



    @Serial
    private static final long serialVersionUID = 8811024307035672149L;
    private String nombre;
    private String cif;
    private LocalDate fechFundacion;

    private List<Trabajador> trabajadores;



    public Empresa(String nombre, String cif, LocalDate fechFundacion) {
        this.nombre = nombre;
        this.cif = cif;
        this.fechFundacion = fechFundacion;
        this.trabajadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechFundacion() {
        return fechFundacion;
    }

    //Trabajadores
    public void addTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public int numeroTrabajadores(){

        return trabajadores.size();
    }

    public boolean infoTrabajadores(){

        if(trabajadores.isEmpty()){
            System.out.println("No existe el trabajador");
        }else{
            for(Trabajador trabajador : trabajadores){
                System.out.println(trabajador);
            }
        }

        return false;
    }

    public boolean validarDni(String dni) throws ValidacionDNI {
        boolean resultado = false;

        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getDni().equals(dni)) {
                throw new ValidacionDNI("El dni no se puede repetir");
            }
        }
        return resultado;
    }


    public void removeTrabajador(Trabajador trabajador) {
        trabajadores.remove(trabajador);
    }


//    public boolean eliminarTrabajador (Trabajador trabajadorElimninado) {
//        boolean resultado = false;
//
//        trabajadorElimninado = null;
//
//        for (Trabajador trabajador : trbajadores) {
//            if(trabajador.getDni().equals(trabajadorElimninado.getDni())){
//                trabajadorElimninado = trabajador;
//                break;
//            }
//        }
//
//        if(trabajadorElimninado != null){
//            trbajadores.remove(trabajadorElimninado);
//            System.out.println("Trabajador eliminado");
//        }else{
//            System.out.println("No existe el trabajador");
//        }
//
//        return resultado;
//    }

    public Trabajador buscarTrabajador(String dni) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getDni().equals(dni)) {
                return trabajador;
            }
        }
        return null;
    }


    // Ver todos los trabajadores de la empresa
     public int verEmpresa() {
        for (Trabajador trabajador : trabajadores) {
            System.out.println(trabajador);
        }
         return 0;
     }

    //Numero de trabajadores en la empresa

    public int numeroTrabajadoresEp() {

        int total = 0;
        for (Trabajador t : trabajadores) {
            total += numeroTrabajadores();
        }
        if (total == 0) {
            System.out.println("No existe el trabajadores");
        }
        return total;
    }

    //Director


    public boolean validarDirector() throws ValidacionDirector {
        boolean resultado = false;



        return resultado;
    }

    public String Departamentos(Departamento departamento){
        String resultado = "";
        String coste = "";
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getDepartamento().equals(departamento)) {
                resultado += trabajador;
            }
        }

        resultado += "";
        return resultado;
    }


    public String oraganigrama(){
        String resultado = "";


        return resultado;
    }
    @Override
    public String toString() {
        String info = "";
        info += "===== INFORMACIÓN DEl La empresa =====\n";
        info += "Nombre: " + this.nombre + "\n";
        info += "Fundacion: " + this.fechFundacion + "\n";
        info += "Fecha creacion: " + this.fechFundacion + "\n";
        for (Trabajador trabajador : trabajadores){
            info += trabajador+"\n";
        }
        info += "--------------------------------------\n";
        return info;
    }

}
