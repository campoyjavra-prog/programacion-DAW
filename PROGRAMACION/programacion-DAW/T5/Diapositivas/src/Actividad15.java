import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Actividad15 {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            // Leemos el fichero
            Object obj = parser.parse(new FileReader("./PROGRAMACION/programacion-DAW/T5/heroes.json"));

            // Lo pasamos a Array porque es una lista
            JSONArray arrayHeroes = (JSONArray) obj;

            // Creamos el mapa
            Map<String, List<Heroe>> mapa = new HashMap<>();

            // Recorremos el array del json
            for (Object o : arrayHeroes) {
                JSONObject jsonH = (JSONObject) o;

                // Sacamos los datos.
                String nombre = (String) jsonH.get("superhero");
                String editorial = (String) jsonH.get("publisher");

                // Creamos nuestro objeto Heroe
                Heroe h = new Heroe(nombre, editorial);

                // Comprobamos si la editorial ya está en el mapa
                if (!mapa.containsKey(editorial)) {
                    // Si no está, creamos la lista vacía y la metemos
                    mapa.put(editorial, new ArrayList<Heroe>());
                }

                // Como existe, se saca la lista y se añade al heroe
                List<Heroe> lista = mapa.get(editorial);
                lista.add(h);
            }

            // Imprimimos el resultado
            System.out.println("Listado de héroes por editorial:");

            // Recorro las claves (editoriales) una a una
            for (String claveEditorial : mapa.keySet()) {
                System.out.println("< Editorial > " + claveEditorial);

                // Se saca la lista de esa editorial
                List<Heroe> listaHeroes = mapa.get(claveEditorial);

                // Se recorre la lista para imprimir cada héroe
                for (Heroe h : listaHeroes) {
                    System.out.println("-\t" + h);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}