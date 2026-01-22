public class Actividad10 {

    // Realiza un método genérico que intercambie el
    // contenido de
    // dos posiciones indicadas como parámetro

    public static <T> void intercambiar(T[] array, int pos1, int pos2) {
        T aux = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = aux;
    }

    public static void main(String[] args) {
        // Prueba con Strings
        String[] palabras = { "Hola", "Mundo", "Java" };
        System.out.println("Antes: " + java.util.Arrays.toString(palabras));

        intercambiar(palabras, 0, 2); // Cambia "Hola" por "Java"

        System.out.println("Después: " + java.util.Arrays.toString(palabras));

        // Prueba con Integers
        Integer[] numeros = { 10, 20, 30, 40 };
        intercambiar(numeros, 1, 2); // Cambia 20 por 30
        System.out.println("Números invertidos 1 y 2: " + java.util.Arrays.toString(numeros));
    }
}
