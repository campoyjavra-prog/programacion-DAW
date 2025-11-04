package RelacionT3;

public class Programa3 {
    
    public static void main(String[] args) {
        int[] numeros = {10, 23, 45, 3, 87, 56};  // Array de ejemplo

        // Llamada a la función que devuelve el valor máximo y mínimo
        int[] resultado = obtenerMaxMin(numeros);

        System.out.println("Máximo: " + resultado[0]);
        System.out.println("Mínimo: " + resultado[1]);
    }

    // Función que devuelve el valor máximo y mínimo del array
    public static int[] obtenerMaxMin(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        return new int[] {max, min};  // Devuelve un array con el máximo y mínimo
    }
}
