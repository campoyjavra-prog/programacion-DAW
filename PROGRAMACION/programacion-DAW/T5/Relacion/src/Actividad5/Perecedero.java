package Actividad5;

public class Perecedero extends Producto {

    private int diasCaducar;

    public Perecedero(String nombre, double precio, int diasCaducar) {
        // Primero SIEMPRE llamamos al padre
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + " - Caduca en: " + diasCaducar + " días";
    }

    @Override
    public double calcular(int cantidad) {
        double precioFinal = this.precio;

        // Reglas típicas de reducción de precio por caducidad
        if (diasCaducar == 1) {
            precioFinal = precioFinal / 4;
        } else if (diasCaducar == 2) {
            precioFinal = precioFinal / 3;
        } else if (diasCaducar == 3) {
            precioFinal = precioFinal / 2;
        }

        return precioFinal * cantidad;
    }
}
