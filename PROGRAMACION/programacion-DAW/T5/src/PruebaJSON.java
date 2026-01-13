import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PruebaJSON {
    public static void main(String[] args) {
        try{
        // Lectura del contenido del fichero JSON
        Object ob = new JSONParser().parse(new FileReader("./PROGRAMACION/programacion-DAW/T5/JSONFile.json"));
        // Convertir objeto a JSON y procesarlo
        JSONObject js = (JSONObject) ob;
        //Accediendo a cada componente clave JSON
        String firstName = (String) js.get("firstName");
        String lastName = (String) js.get("lastName");
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        // Leyendo el array guardado en la clave de phoneNumbers
        JSONArray arr = (JSONArray) js.get("phoneNumbers");
        // Recorrer cada elemento 
        for (Object item : arr) {
            JSONObject data = (JSONObject) item;
            String post_id = (String) data.get("phone-number");
            System.out.println(post_id);
        }
        }
        catch(Exception e){
            System.err.println("ALGO HA FALLADO EN LA LECTURA JSON");
        }

    }
}
