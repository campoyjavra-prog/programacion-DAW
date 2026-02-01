package Actividad6;

import java.util.ArrayList;

public class Ejercicio6 {

    public static void main(String[] args) {

        // Polimorfismo puro: Lista de la clase abuela "Animal"
        ArrayList<Animal> zoologico = new ArrayList<>();

        // Añadimos Vertebrados
        zoologico.add(new Mamifero("León"));
        zoologico.add(new Ave("Águila"));

        // Añadimos Invertebrados
        zoologico.add(new Artropodo("Araña"));

        System.out.println("--- CLASIFICACIÓN ANIMAL ---");

        for (Animal a : zoologico) {
            // Muestro los datos (llama al toString del padre o hijo correspondiente)
            System.out.println(a.toString());

            // Ejecuto la acción específica de cada uno
            a.accion();

            // Ejemplo de uso de instanceof para diferenciar ramas
            if (a instanceof Vertebrado) {
                System.out.println("-> Tipo: Posee columna vertebral.");
            } else {
                System.out.println("-> Tipo: No tiene huesos.");
            }
            System.out.println("-----------------------------");
        }
    }
}