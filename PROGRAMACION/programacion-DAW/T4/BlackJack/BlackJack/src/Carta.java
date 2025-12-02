
public class Carta {
    private Palo palo;  // Usamos el enum para los palos
    private int valor;   // El valor de la carta (2-10, J, Q, K, A)

    // Constructor
    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    // Getters
    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    // Método toString (para imprimir la carta)
    @Override
    public String toString() {
        String valorStr;
        if (valor == 11) valorStr = "J";
        else if (valor == 12) valorStr = "Q";
        else if (valor == 13) valorStr = "K";
        else if (valor == 1) valorStr = "A";
        else valorStr = Integer.toString(valor);
        return valorStr + " de " + palo;
    }
}
