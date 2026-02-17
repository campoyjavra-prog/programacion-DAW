package Diapositivas.Tarea1.modelo;

public class Realiza {
    private int nota;
    private String fecha;

    public Realiza(int nota, String fecha) {
        this.nota = nota;
        this.fecha = fecha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Realiza [nota=" + nota + ", fecha=" + fecha + "]";
    }
}
