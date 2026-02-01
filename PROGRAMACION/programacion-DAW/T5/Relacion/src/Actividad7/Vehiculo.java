package Actividad7;

public abstract class Vehiculo {

    // Protected para que Coche y Moto accedan sin getters (estilo herencia simple)
    protected String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    // Método concreto: Ya tiene código, los hijos lo heredan tal cual
    public void frenar() {
        System.out.println("El vehículo " + marca + " está frenando.");
    }

    // Método abstracto: Los hijos OBLIGATORIAMENTE deben decir cómo arrancan
    public abstract void arrancar();
}
