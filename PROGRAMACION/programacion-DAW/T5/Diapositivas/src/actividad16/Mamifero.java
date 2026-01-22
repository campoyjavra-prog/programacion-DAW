package actividad16;

public class Mamifero extends Animal {
    private int gestacion;

    public Mamifero(String nombre, String tipo_alimentacion, int edad, int gestacion) {
        super(nombre, tipo_alimentacion, edad);
        this.gestacion = gestacion;
    }

    public int getGestacion() {
        return gestacion;
    }

    public void setGestacion(int gestacion) {
        this.gestacion = gestacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", gestacion='" + gestacion + "'";
    }
}
