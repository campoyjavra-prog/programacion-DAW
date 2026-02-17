package Diapositivas.Tarea1.modelo;

public class Practica_Disena_Profesor {
    private String fecha;

    public Practica_Disena_Profesor(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Practica_Disena_Profesor [fecha=" + fecha + "]";
    }
}
