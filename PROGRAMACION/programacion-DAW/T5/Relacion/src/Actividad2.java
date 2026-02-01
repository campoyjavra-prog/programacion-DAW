import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Actividad2 {

    public static void main(String[] args) {
        File fichero = new File("../../heroes.json");

        System.out.println("Leyendo fichero: " + fichero.getAbsolutePath());

        System.out.printf("%-20s %-20s %-30s\n", "SUPERHERO", "PUBLISHER", "FIRST_APPEARANCE");
        System.out.println("--------------------------------------------------------------------------------");

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fichero));
            String linea;

            String superhero = "";
            String publisher = "";
            String appearance = "";

            while ((linea = buffer.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("\"superhero\":")) {
                    superhero = limpiarValor(linea);
                } else if (linea.startsWith("\"publisher\":")) {
                    publisher = limpiarValor(linea);
                } else if (linea.startsWith("\"first_appearance\":")) {
                    appearance = limpiarValor(linea);
                }

                if (linea.equals("},") || linea.equals("}")) {

                    if (publisher.equals("DC Comics") && superhero.startsWith("G")) {
                        System.out.printf("%-20s %-20s %-30s\n", superhero, publisher, appearance);
                    }
                    superhero = "";
                    publisher = "";
                    appearance = "";
                }
            }
            buffer.close();

        } catch (Exception e) {
            System.out.println("Error leyendo el fichero JSON");
            e.printStackTrace();
        }
    }

    public static String limpiarValor(String linea) {
        int dosPuntos = linea.indexOf(":");

        if (dosPuntos == -1)
            return "";

        String valor = linea.substring(dosPuntos + 1);

        valor = valor.replace("\"", "");
        valor = valor.replace(",", "");

        return valor.trim();
    }
}