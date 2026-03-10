import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class MediaDaw implements Serializable {


    private static final long serialVersionUID = -5286574360333094248L;
    private HashMap<String, Cliente> clientes;
    private HashMap<String,Articulo> articulos;
    private String cif;
    private String nombre;
    private LocalDate fechaCreacion;

    public MediaDaw(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.clientes = new HashMap<>();
        this.articulos = new HashMap<>();
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    //Clientes

    public void addCliente(Cliente cliente){
        clientes.put(cliente.getDni(), cliente);
    }

    public void infoClientes(){

        if (clientes.isEmpty()){
            System.out.println("No exsisten Clientes");
        }else{
            for (Cliente cliente : clientes.values()){
                System.out.println(cliente);
            }
        }

    }
    //Articulos
    public void addArticulo(Articulo articulo){
        articulos.put(articulo.getId(),articulo);
    }


    public void infoArticulos(){

        if (articulos.isEmpty()){
            System.out.println("No hay articulos");
        }else{
            for (Articulo articulo : articulos.values()){
                System.out.println(articulo);
            }
        }

    }

    public boolean alquilarArticulo(Cliente c, Articulo a){
        Boolean resultado = false;

        if (a!=null && c!=null&& a.isDisponible() == true ) {

        }

        return resultado;
    }


    @Override
    public String toString() {
        return "MediaDaw{" +
                "clientes=" + clientes +
                ", articulos=" + articulos +
                ", cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
