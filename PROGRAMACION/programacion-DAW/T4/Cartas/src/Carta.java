public class Carta {
    
    private int valor;
    private String palo;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        String nombreValor;
        switch (valor) {
            case 1: nombreValor = "As"; break;
            case 11: nombreValor = "Sota"; break;
            case 12: nombreValor = "Caballo"; break;
            case 13: nombreValor = "Rey"; break;
            default: nombreValor = String.valueOf(valor);
        }
        return nombreValor + " de " + palo;
    }
}