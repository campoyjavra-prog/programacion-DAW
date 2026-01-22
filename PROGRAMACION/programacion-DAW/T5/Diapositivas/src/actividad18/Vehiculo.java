package actividad18;

public abstract class Vehiculo {
    protected String matricula;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public abstract int velocidadMaxima();

    public void mostrarInfo() {
        System.out.println("Vehículo con matrícula: " + matricula + " | Vel. Máxima: " + velocidadMaxima() + " km/h");
    }
}
