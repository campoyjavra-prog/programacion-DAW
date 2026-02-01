import java.util.HashMap;

public class EjercicioHashMap {
    public static void main(String[] args) {

        // REGLA MAP 1: Declaración y uso de objetos propios
        // Clave: String (DNI), Valor: Objeto Alumno
        HashMap<String, Alumno> listaClase = new HashMap<>();

        // Añadimos 2 alumnos usando .put()
        listaClase.put("12345678A", new Alumno("Pepe", 6.5));
        listaClase.put("87654321Z", new Alumno("Maria", 9.2));

        // REGLA MAP DE ORO: Recorrer iterando sobre las CLAVES (keySet)
        // NO usamos entrySet()
        System.out.println("--- LISTADO DE ALUMNOS ---");

        for (String dni : listaClase.keySet()) {

            System.out.println("DNI (Clave): " + dni);

            // PATRÓN OBLIGATORIO: Recuperamos el valor usando la clave DENTRO del bucle
            Alumno alumno = listaClase.get(dni);

            System.out.println("Datos (Valor): " + alumno.toString());
            System.out.println("-------------------------");
        }
    }
}
