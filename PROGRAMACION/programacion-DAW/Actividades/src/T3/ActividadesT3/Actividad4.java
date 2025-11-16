package ActividadesT3;

public class Actividad4 {
    
     public static int[] eliminarValor(int[] array, int valor) {
        int[] nuevoArray = new int[array.length - 1];  // Creamos un nuevo array con tamaño menor
        int j = 0;

        // Recorremos el array original
        for (int i = 0; i < array.length; i++) {
            // Si el valor no es el que queremos eliminar, lo copiamos al nuevo array
            if (array[i] != valor) {
                nuevoArray[j++] = array[i]; // Añadimos al nuevo array
            }
        }

        return nuevoArray;  // Retornamos el nuevo array
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 7, 8}; // Array de ejemplo
        int valorABorrar = 2; // El valor a eliminar

        // Llamamos a la función para eliminar el valor
        array = eliminarValor(array, valorABorrar);

        // Imprimimos el array resultante
        System.out.print("Array después de eliminar el valor: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
