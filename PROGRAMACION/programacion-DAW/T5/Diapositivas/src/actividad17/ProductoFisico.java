
public class ProductoFisico extends Producto {
    private double peso;
    private double costeEnvio;

    public ProductoFisico(int id, String nombre, double precio, double peso, double costeEnvio) {
        super(id, nombre, precio);
        this.peso = peso;
        this.costeEnvio = costeEnvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCosteEnvio() {
        return costeEnvio;
    }

    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }

    @Override
    public double precioFinal() {
        double total = super.getPrecio() + this.costeEnvio;

        if (this.peso > 2) {
            total = total + (total * 0.10);
        }

        return total;
    }

    @Override
    public String toString() {
        return "FÍSICO - " + super.toString() + " | Peso: " + peso + "kg | Envío: " + costeEnvio + "€";
    }
}
