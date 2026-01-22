import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Actividad9 {
    public static void main(String[] args) {
        try {
            // Lectura del contenido del fichero JSON
            Object ob = new JSONParser().parse(new FileReader("./PROGRAMACION/programacion-DAW/T5/heroes.json"));
            // Convertir objeto a JSON y procesarlo
            JSONObject js = (JSONObject) ob;
            // Accediendo a cada componente clave JSON
            String publisher = (String) js.get("superhero");
            String alter_ego = (String) js.get("alter_ego");
            System.out.println("El publisher es: " + publisher);
            System.out.println("El alter ego es: " + alter_ego);
            // Leyendo el array guardado en la clave de phoneNumbers
            JSONArray arr = (JSONArray) js.get("phoneNumbers");
            // Recorrer cada elemento
            for (Object item : arr) {
                JSONObject data = (JSONObject) item;
                String post_id = (String) data.get("phone-number");
                System.out.println(post_id);
            }
        } catch (Exception e) {
            System.err.println("ALGO HA FALLADO EN LA LECTURA JSON");
        }

    }
}
