public class Actividad11 {
        // Realiza un método genérico que localiza un elemento a
        // buscar en el array o devuelva -1 si no lo encuentra

        public static <T> int buscar(T[] array, T elemento) {
                for (int i = 0; i < array.length; i++) {
                        if (array[i].equals(elemento)) {
                                return i;
                        }
                }
                return -1;
        }

        public static void main(String[] args) {
                Integer[] numeros = { 1, 2, 3, 4, 5 };
                String[] palabras = { "hola", "adios", "mundo" };

                System.out.println("Buscando el número 3: " + buscar(numeros, 3));
                System.out.println("Buscando el número 6: " + buscar(numeros, 6));
                System.out.println("Buscando la palabra 'mundo': " + buscar(palabras, "mundo"));
                System.out.println("Buscando la palabra 'adiós': " + buscar(palabras, "adiós")); // al llevar tilde
                                                                                                 // devuelve -1
        }
}
