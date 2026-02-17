package Diapositivas.Tarea1.modelo;

public class Alumno {
    private int id;
    private String grupo;
    private int nif;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Alumno(int id, String grupo, int nif, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.grupo = grupo;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", grupo=" + grupo + ", nif=" + nif +
                ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + "]";
    }
}
