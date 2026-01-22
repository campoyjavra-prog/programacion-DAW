package actividad20;

public abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract int calcularArea();

    public abstract int calcularPerimetro();

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Area: " + calcularArea() + ", Perimetro: " + calcularPerimetro();
    }

}
