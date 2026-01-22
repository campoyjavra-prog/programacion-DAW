package actividad20;

public class Rectangulo extends Figura {
    private int ancho;
    private int alto;

    public Rectangulo(String nombre, int ancho, int alto) {
        super(nombre);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public int calcularArea() {
        // Area = ancho * alto
        return ancho * alto;
    }

    @Override
    public int calcularPerimetro() {
        // Perimetro = 2 * (ancho + alto)
        return 2 * (ancho + alto);
    }
}
