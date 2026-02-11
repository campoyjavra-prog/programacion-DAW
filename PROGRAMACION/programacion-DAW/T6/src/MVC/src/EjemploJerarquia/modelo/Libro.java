package MVC.src.EjemploJerarquia.modelo;

public abstract class Libro {
    protected int id;
    protected String isbn;
    protected String titulo;
    protected String descripcion;
    protected int anioPublicacion;
    protected double precio;

    public Libro(int id, String isbn, String titulo, String descripcion, int anioPublicacion, double precio) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | ISBN: " + isbn + " | Precio: " + precio;
    }
}
