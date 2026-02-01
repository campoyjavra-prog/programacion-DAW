package Actividad6;

public abstract class Animal {
    protected String nombre; // Protected para que los hijos accedan

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto: Cada animal se mueve/comunica diferente
    public abstract void accion();

    @Override
    public String toString() {
        return "Animal: " + nombre;
    }
}
