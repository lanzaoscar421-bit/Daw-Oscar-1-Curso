import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MusicaDaw implements Serializable {


    @Serial
    private static final long serialVersionUID = -2896494460187633600L;
    private Map <String,Producto> productos;
    private String nombre;
    private String id;

    public MusicaDaw(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.productos = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public void addProducto (Producto p){
        productos.put(p.getCod(),p);

    }

    public void eliminarProducto(String cod){
        if(productos.containsKey(cod)){
            productos.remove(cod);
            System.out.println("Producto eliminado correctamente");
        } else {
            System.out.println("No existe un producto con ese ID");
        }
    }

    public void mostrarProductos() {
        if(productos.isEmpty()){
            System.out.println("No hay productos en la tienda " + this.getNombre());
            return;
        }

        System.out.println("Productos de la tienda " + this.getNombre() + ":");
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            String cod = entry.getKey();
            Producto p = entry.getValue();
            System.out.println("ID: " + cod + " -> " + p);
        }
    }

    // Ver si un producto existe por ID (opcional, útil antes de añadir)
    public boolean existeProductoPorId(String cod){
        return productos.containsKey(cod);
    }
    @Override
    public String toString() {
        return "MusicaDaw{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
