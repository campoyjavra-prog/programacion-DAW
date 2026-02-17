package Diapositivas.Tarea1.modelo;

public class Hace {
    private int nota;

    public Hace(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Hace [nota=" + nota + "]";
    }
}
