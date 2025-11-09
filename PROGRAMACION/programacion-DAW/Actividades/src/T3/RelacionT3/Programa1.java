package RelacionT3;

public class Programa1 {
    public static void main(String[] args) {
        // Crear el vector dinámico
        int[] vector = null;

        // Insertar un valor
        vector = push(vector, 3);

        // Insertar otro valor
        vector = push(vector, 5);

        // Mostrar los elementos del vector
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i] + " ");
        }

        // Eliminar el último valor (pop)
        vector = pop(vector);

        // Mostrar los elementos del vector después de pop
        System.out.println("Pop:");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i] + " ");
        }
    }

    // Función push: Añade un valor al final del array
    public static int[] push(int[] array, int valor) {
        int longitud;
        if (array == null) {
            longitud = 0; // Si el array es nulo, inicializamos longitud a 0
        } else {
            longitud = array.length; // Si no es nulo, usamos su longitud actual
        }

        // Crear un nuevo array con espacio adicional para el nuevo valor
        int[] salida = new int[longitud + 1];

        // Copiar los elementos del array original al nuevo array
        for (int i = 0; i < longitud; i++) {
            salida[i] = array[i];
        }

        // Añadir el nuevo valor al final del nuevo array
        salida[longitud] = valor;

        return salida; // Devolver el nuevo array
    }

    // Función pop: Elimina el último valor del array y lo devuelve
    public static int[] pop(int[] array) {
        if (array == null || array.length == 0) {
            return array; // Si el array es nulo o está vacío, no hacemos nada
        }

        // Obtener el valor a eliminar
        int valor = array[array.length - 1];

        // Crear un nuevo array con un tamaño reducido
        int[] nuevo = new int[array.length - 1];

        // Copiar los elementos del array original al nuevo array
        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = array[i];
        }

        return nuevo; // Devolver el nuevo array
    }
}