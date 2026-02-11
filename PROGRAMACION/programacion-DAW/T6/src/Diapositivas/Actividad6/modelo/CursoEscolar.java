package Diapositivas.Actividad6.modelo;

public class CursoEscolar {
    private int id;
    private int anioInicio;
    private int anioFin;

    public CursoEscolar(int id, int anioInicio, int anioFin) {
        this.id = id;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Curso: %d - %d", id, anioInicio, anioFin);
    }
}
