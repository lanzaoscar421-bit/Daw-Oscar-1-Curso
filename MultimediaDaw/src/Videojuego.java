public class Videojuego extends Articulo{

    private String plataforma;
    private Pegi pegi;
    private double preciofijo;

    public Videojuego(String id, String titulo, String plataforma, Pegi pegi) {
        super(id, titulo);
        this.plataforma = plataforma;
        this.pegi = pegi;
        this.preciofijo = preciofijo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public Pegi getPegi() {
        return pegi;
    }

    public double getPreciofijo() {
        return preciofijo;
    }
}
