package Tarea;

public class Persona implements Identificacion {

    protected String DNI;
    protected String nombre;
    protected String pape;

    public Persona() {
    }

    public Persona(String DNI, String nombre, String pape) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pape = pape;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String get() {
        return pape;
    }

    public void setPape(String pape) {
        this.pape = pape;
    }

    @Override
    public String identificarte() {
        return "Soy " + this.nombre + " con DNI " + this.DNI;
    }
}