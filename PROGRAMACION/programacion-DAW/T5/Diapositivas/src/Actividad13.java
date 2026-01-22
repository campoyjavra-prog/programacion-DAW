import java.util.ArrayList;
import java.util.List;

public class Actividad13<T> {

    // Usamos List como estructura de almacenamiento interna
    private List<T> elementos;

    public Actividad13() {
        this.elementos = new ArrayList<>();
    }

    // OPERACIÓN: Insertar (Push)
    public void insertar(T objeto) {
        elementos.add(objeto);
    }

    // OPERACIÓN: Borrar/Extraer el último (Pop)
    public T borrar() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        // Eliminamos y devolvemos el último elemento (el de arriba de la pila)
        return elementos.remove(elementos.size() - 1);
    }

    // OPERACIÓN: Devolver valor sin borrar (Peek)
    public T devolverValor() {
        if (estaVacia()) {
            return null;
        }
        return elementos.get(elementos.size() - 1);
    }

    // OPERACIÓN: Buscar (devuelve la posición desde el tope)
    public int buscar(T objeto) {
        return elementos.indexOf(objeto);
    }

    // Método auxiliar para verificar si hay datos
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila: " + elementos.toString();
    }
}
