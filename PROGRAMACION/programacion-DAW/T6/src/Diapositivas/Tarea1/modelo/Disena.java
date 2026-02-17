package Diapositivas.Tarea1.modelo;

public class Disena {
    private int id;
    private String nombre;
    private String fecha;
    private int nota;

    public Disena(int id, String nombre, String fecha, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disena [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", nota=" + nota + "]";
    }
}
