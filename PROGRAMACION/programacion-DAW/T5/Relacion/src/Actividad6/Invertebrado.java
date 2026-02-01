package Actividad6;

public abstract class Invertebrado extends Animal {
    protected boolean tieneConcha; // Atributo específico

    public Invertebrado(String nombre, boolean tieneConcha) {
        super(nombre);
        this.tieneConcha = tieneConcha;
    }

    @Override
    public String toString() {
        String concha = tieneConcha ? "Sí" : "No";
        return super.toString() + " (Invertebrado, ¿Concha?: " + concha + ")";
    }
}
