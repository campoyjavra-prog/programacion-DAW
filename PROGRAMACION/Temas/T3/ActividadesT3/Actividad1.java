package ActividadesT3;

public class Actividad1 {
    
        // Esta función busca un número en un array y devuelve su índice o -1 si no se encuentra.
    public static int buscarNumero(int[] array, int numero) {
        // Recorremos todo el array buscando el número
        for (int i = 0; i < array.length; i++) {
            // Si encontramos el número, retornamos su índice
            if (array[i] == numero) {
                return i;
            }
        }
        // Si no encontramos el número, devolvemos -1
        return -1;
    }

    public static void main(String[] args) {
        // Definimos un array de ejemplo
        int[] numeros = {5, 8, 3, 12, 7, 4};
        // El número que queremos buscar
        int numeroABuscar = 12;
        
        // Llamamos a la función para buscar el número
        int resultado = buscarNumero(numeros, numeroABuscar);
        
        // Si el resultado no es -1, significa que el número fue encontrado
        if (resultado != -1) {
            System.out.println("El número " + numeroABuscar + " está en el índice: " + resultado);
        } else {
            System.out.println("El número no se encuentra en el array.");
        }
    }
}
