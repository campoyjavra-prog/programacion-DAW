package actividad20;

import java.util.ArrayList;

public class CajaFiguras<T extends Figura> {
    private ArrayList<T> figuras;

    public CajaFiguras() {
        this.figuras = new ArrayList<>();
    }

    public void guardar(T figura) {
        figuras.add(figura);
    }

    public void mostrarContenido() {
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println(figuras.get(i).toString());
        }
    }

    public int calcularAreaTotal() {
        int total = 0;
        for (int i = 0; i < figuras.size(); i++) {
            total = total + figuras.get(i).calcularArea();
        }
        return total;
    }
}
