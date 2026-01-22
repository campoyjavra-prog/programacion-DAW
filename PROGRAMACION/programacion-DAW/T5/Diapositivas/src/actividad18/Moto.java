package actividad18;

public class Moto extends Vehiculo {

    public Moto(String matricula) {
        super(matricula);
    }

    @Override
    public int velocidadMaxima() {
        return 200; // Velocidad moto
    }
}
