import java.io.FileReader;
// REGLA JSON 1: Importar SIEMPRE org.json.simple.*
import org.json.simple.*;
import org.json.simple.parser.*; // Necesario para JSONParser en la versión 1.1.1 standard

public class PruebaJson {
    public static void main(String[] args) {

        // REGLA JSON 2: Lectura estándar
        JSONParser parser = new JSONParser();

        try {
            // Leemos el fichero config.json
            // OJO: Casteo a JSONObject obligatorio porque parse devuelve Object
            Object ob = parser.parse(new FileReader("./Tema5/config.json"));
            JSONObject jsonObject = (JSONObject) ob;

            // REGLA JSON 3: Extracción de datos con Casteo OBLIGATORIO
            // Sacamos el valor de la clave "usuario"
            String nombreUsuario = (String) jsonObject.get("usuario");

            // Mostrar el dato crudo
            System.out.println("Dato leído del JSON: " + nombreUsuario);

            // EJERCICIO: Guardarlo en una Caja<String>
            // Instanciamos la clase genérica especificando el tipo <String>
            Caja<String> miCaja = new Caja<>(nombreUsuario);

            // Mostramos el contenido usando la Caja
            System.out.println(miCaja.toString());

        } catch (Exception e) {
            System.out.println("Error leyendo el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
