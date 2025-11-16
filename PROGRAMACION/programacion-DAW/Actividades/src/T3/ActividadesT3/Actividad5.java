package ActividadesT3;

public class Actividad5 {
    
    // Función para insertar un valor en una posición específica del array
    public static int[] insertarValor(int[] array, int valor, int posicion) {
        // Verificamos si la posición indicada es mayor que el tamaño actual del array
        if (posicion > array.length) {
            // Si la posición es mayor, se ajusta al tamaño máximo del array
            posicion = array.length;
        }
        
        // Creamos un nuevo array con un tamaño mayor
        int[] nuevoArray = new int[array.length + 1];
        
        // Copiamos todos los elementos del array original hasta la posición indicada
        for (int i = 0; i < posicion; i++) {
            nuevoArray[i] = array[i];
        }
        
        // Insertamos el valor en la posición indicada
        nuevoArray[posicion] = valor;
        
        // Copiamos el resto de los elementos del array original al nuevo array
        for (int i = posicion; i < array.length; i++) {
            nuevoArray[i + 1] = array[i];
        }
        
        // Si la posición indicada era mayor al tamaño del array original, el array se llena con ceros automáticamente
        return nuevoArray; // Retornamos el nuevo array
    }

    public static void main(String[] args) {
        // Definimos un array de ejemplo
        int[] array = {3, 5, 7, 8};
        int valor = 10; // Valor a insertar
        int posicion = 5; // Posición donde insertar el valor (mayor al tamaño actual)

        // Llamamos a la función para insertar el valor en la posición indicada
        array = insertarValor(array, valor, posicion);

        // Imprimimos el nuevo array con el valor insertado
        System.out.print("Array después de insertar el valor: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
