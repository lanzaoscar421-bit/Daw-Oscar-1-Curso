public abstract class Articulo {

    private String id;
    private String titulo;
    private boolean disponible;

    public Articulo(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
