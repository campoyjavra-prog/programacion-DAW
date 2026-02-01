package Actividad8;

import Actividad7.Vehiculo;
import Actividad7.Coche;
import java.util.ArrayList;

public class Ejercicio8 {

    public static void main(String[] args) {

        // 1. Lista polimórfica (Admite cualquier hijo de Vehiculo)
        ArrayList<Vehiculo> lista = new ArrayList<>();

        // 2. Añadimos mezcla de tipos
        lista.add(new Coche("Ford")); // Solo Vehiculo
        lista.add(new Avion("Boeing")); // Vehiculo + Volador
        lista.add(new Helicoptero("Apache")); // Vehiculo + Volador
        lista.add(new Coche("Seat"));

        System.out.println("--- GESTIÓN DE TRÁFICO AÉREO Y TERRESTRE ---");

        // 3. Recorremos la lista
        for (Vehiculo v : lista) {

            // TODOS pueden arrancar (porque son Vehículos)
            v.arrancar();

            // 4. SOLO los que sean "Voladores" pueden volar
            // Usamos instanceof preguntando por la INTERFAZ, no por la clase
            if (v instanceof Volador) {
                // Casteo necesario para usar métodos de la interfaz
                Volador volador = (Volador) v;
                volador.volar();
            }

            System.out.println("--------------------");
        }
    }
}