import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Gremio {

    private List<Heroe> heroes;
    private List <Mision> misiones;

    public Gremio() {
        this.heroes = new LinkedList<>();
        this.misiones = new LinkedList<>();
    }

    //Heroe
    //Misiones

    


    @Override
    public String toString() {
        return "Gremio{" +
                "heroes=" + heroes +
                ", misiones=" + misiones +
                '}';
    }
}
