package actividad18;

public class Camion extends Vehiculo {

    public Camion(String matricula) {
        super(matricula);
    }

    @Override
    public int velocidadMaxima() {
        return 90; // Velocidad camión
    }
}
