import java.io.Serial;
import java.io.Serializable;

public class Cd extends Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = -2545894952210149067L;
    private String grupoCD;

    public Cd(String nombre, String calidad, String grupoVinilo, int codigoVinilo) {
        super(nombre, calidad);
        this.grupoCD = grupoVinilo;
    }

    public String getGrupoCD() {
        return grupoCD;
    }


    @Override
    public String toString() {
        return "Vinilo{" +
                "grupoVinilo='" + grupoCD + '\'' +
                '}';
    }
}

