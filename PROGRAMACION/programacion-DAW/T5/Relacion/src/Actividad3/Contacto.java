package Actividad3;

public class Contacto {
    // Atributos privados (Encapsulamiento)
    private String nombre;
    private String telefono;

    // Constructor
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters (Obligatorios)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para mostrarlo
    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Tlf: " + telefono;
    }
}
