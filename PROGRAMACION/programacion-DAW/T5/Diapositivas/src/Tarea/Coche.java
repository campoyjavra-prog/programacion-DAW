package Tarea;

public class Coche extends Vehiculo {

    private int anchura;
    private int altura;

    public Coche() {
        super();
    }

    public Coche(String matricula, String marca, String modelo, int anchura, int altura) {
        super(matricula, marca, modelo);
        this.anchura = anchura;
        this.altura = altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
