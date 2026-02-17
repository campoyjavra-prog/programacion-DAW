package Diapositivas.Tarea1.modelo;

public class Practica {
    private int id;
    private String titulo;
    private String dificultad;

    public Practica(int id, String titulo, String dificultad) {
        this.id = id;
        this.titulo = titulo;
        this.dificultad = dificultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Practica [id=" + id + ", titulo=" + titulo + ", dificultad=" + dificultad + "]";
    }
}
