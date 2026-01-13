import java.util.ArrayList;

public class Actividad13<T> {
    // Realiza una clase genérica que simule el comportamiento de una pila.
    // Operaciones: insertar, borrar, buscar, devolver, estaVacia y toString usando ArrayList.

    private ArrayList<T> datos;

    public Actividad13() {
        this.datos = new ArrayList<>();
    }

    // Inserta un elemento en la cima de la pila
    public void insertar(T valor) {
        datos.add(valor);
    }

    //Borra y devuelve el elemento de la cima. Devuelve null si la pila está vacía
    public T borrar() {
        if (estaVacia()) return null;
        return datos.remove(datos.size() - 1);
    }

    //Busca si el elemento existe en la pila. Devuelve true si está presente
    public boolean buscar(T valor) {
        return datos.contains(valor);
    }

    //Devuelve (peek) el elemento de la cima sin eliminarlo. Null si está vacía
    public T devolver() {
        if (estaVacia()) return null;
        return datos.get(datos.size() - 1);
    }

    //Indica si la pila está vacía.
    public boolean estaVacia() {
        return datos.isEmpty();
    }

    @Override
    public String toString() {
        // Mostrar la pila con la cima al final (como guarda ArrayList)
        return datos.toString();
    }

    // Pequeña demostración / prueba rápida
    public static void main(String[] args) {
        Actividad13<Integer> pila = new Actividad13<>();
        System.out.println("Pila vacía? " + pila.estaVacia());
        pila.insertar(10);
        pila.insertar(20);
        pila.insertar(30);
        System.out.println("Pila tras insertar 10,20,30: " + pila);
        System.out.println("Devolver (cima): " + pila.devolver());
        System.out.println("Buscar 20: " + pila.buscar(20));
        System.out.println("Borrar (pop): " + pila.borrar());
    }
}
