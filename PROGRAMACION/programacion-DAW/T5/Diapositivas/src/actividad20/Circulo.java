package actividad20;

public class Circulo extends Figura {
    private int radio;

    public Circulo(String nombre, int radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public int calcularArea() {
        // Area = PI * radio^2
        return (int) (Math.PI * radio * radio);
    }

    @Override
    public int calcularPerimetro() {
        // Perimetro = 2 * PI * radio
        return (int) (2 * Math.PI * radio);
    }
}
