package Tarea;

public class Propietario extends Persona {

    private String direccion;

    public Propietario() {
        super();
    }

    public Propietario(String DNI, String nombre, String pape, String direccion) {
        super(DNI, nombre, pape);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
