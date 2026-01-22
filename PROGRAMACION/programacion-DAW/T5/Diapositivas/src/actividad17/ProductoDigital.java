
public class ProductoDigital extends Producto {
    private String urlDescarga;
    private double tamanoMB;

    public ProductoDigital(int id, String nombre, double precio, String urlDescarga, double tamanoMB) {
        super(id, nombre, precio);
        this.urlDescarga = urlDescarga;
        this.tamanoMB = tamanoMB;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    public void setTamanoMB(double tamanoMB) {
        this.tamanoMB = tamanoMB;
    }

    @Override
    public String toString() {
        return "DIGITAL - " + super.toString() + " | URL: " + urlDescarga + " | Tamaño: " + tamanoMB + "MB";
    }
}
