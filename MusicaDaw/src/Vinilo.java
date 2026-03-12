import java.io.Serial;
import java.io.Serializable;

public class Vinilo extends Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5104716950564833559L;
    private String grupoVinilo;

    public Vinilo(String nombre, String calidad) {
        super(nombre, calidad);
        this.grupoVinilo = grupoVinilo;
    }

    public String getGrupoVinilo() {
        return grupoVinilo;
    }


    @Override
    public String toString() {
        return "Vinilo{" +
                "grupoVinilo='" + grupoVinilo + '\'' +
                '}';
    }
}
