import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class Libro implements Serializable {

    @Serial static final long serialVersionUID = -1853810266396432077L;
    private String ISBN;
    private String titulo;
    private String autor;
    private String editora;


    public Libro(String ISBN, String titulo, String autor, String editora) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }




    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora=" + editora +
                '}';
    }
}
