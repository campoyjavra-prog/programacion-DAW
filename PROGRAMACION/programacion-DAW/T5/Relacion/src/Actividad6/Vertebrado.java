package Actividad6;

public abstract class Vertebrado extends Animal {
    protected int numeroHuesos; // Atributo específico

    public Vertebrado(String nombre, int numeroHuesos) {
        super(nombre);
        this.numeroHuesos = numeroHuesos;
    }

    @Override
    public String toString() {
        return super.toString() + " (Vertebrado con " + numeroHuesos + " huesos)";
    }
}