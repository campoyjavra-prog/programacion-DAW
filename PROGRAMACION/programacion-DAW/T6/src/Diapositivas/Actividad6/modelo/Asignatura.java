package Diapositivas.Actividad6.modelo;

public class Asignatura {
    private String codigo;
    private String nombre;
    private int numeroHoras;
    private int idProfesor;

    public Asignatura(String codigo, String nombre, int numeroHoras, int idProfesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.idProfesor = idProfesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return String.format("Cod: %s | %s | %d horas | ID Prof: %d", codigo, nombre, numeroHoras, idProfesor);
    }
}
