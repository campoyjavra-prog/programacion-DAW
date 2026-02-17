package Diapositivas.Tarea1.modelo;

public class Examen_Teorico {
    private int id;
    private String titulo;
    private String fecha;
    private int numero_preguntas;

    public Examen_Teorico(int id, String titulo, String fecha, int numero_preguntas) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.numero_preguntas = numero_preguntas;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroPreguntas() {
        return numero_preguntas;
    }

    public void setNumeroPreguntas(int numero_preguntas) {
        this.numero_preguntas = numero_preguntas;
    }

    @Override
    public String toString() {
        return "Examen_Teorico [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha +
                ", numero_preguntas=" + numero_preguntas + "]";
    }
}
