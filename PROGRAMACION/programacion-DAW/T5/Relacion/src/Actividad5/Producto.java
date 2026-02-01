package Actividad5;

// Abstracta: No se pueden hacer "new Producto()"
public abstract class Producto {

    // Atributos protected para que los hijos accedan directo
    // private, usar getters.
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters básicos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Precio: " + precio;
    }

    // Método abstracto: Los hijos OBLIGATORIAMENTE deben definir cómo se calcula
    public abstract double calcular(int cantidad);
}