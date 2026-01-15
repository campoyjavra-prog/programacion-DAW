import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad14 {
    // Dada una lista de marcas de coches, crea un programa
    // que cuente cuántas veces aparece cada una. Hazlo usando Map
    // usando sus métodos containsKey, get y put.

    public static void main(String[] args) {
        // Crear lista de marcas de coches
        List<String> coches = new ArrayList<>();
        coches.add("Toyota");
        coches.add("Ford");
        coches.add("Toyota");
        coches.add("Honda");
        coches.add("Ford");
        coches.add("Ford");
        coches.add("BMW");
        coches.add("Audi");

        // Crear Map para contar frecuencias
        Map<String, Integer> recuento = new HashMap<>();

        // Recorrer la lista y contar
        for (String coche : coches) {
            if (recuento.containsKey(coche)) {
                // Si existe, obtenemos su valor actual y le sumamos 1
                int cantidad = recuento.get(coche);
                recuento.put(coche, cantidad + 1);
            } else {
                // Si no existe, lo añadimos con valor 1
                recuento.put(coche, 1);
            }
        }

        // Mostrar resultados
        System.out.println("Se repiten las marcas de coches: " + recuento);
    }
}
