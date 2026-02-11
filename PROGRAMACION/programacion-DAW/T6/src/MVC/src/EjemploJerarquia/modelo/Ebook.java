package MVC.src.EjemploJerarquia.modelo;

public class Ebook extends Libro {
    private String tamanio;

    public Ebook(int id, String isbn, String titulo, String descripcion, int anioPublicacion, double precio,
            String tamanio) {
        super(id, isbn, titulo, descripcion, anioPublicacion, precio);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return super.toString() + " | [Ebook] Tamaño: " + tamanio;
    }
}
