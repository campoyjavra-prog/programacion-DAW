public class Actividad12 {
        // Realiza un método genérico que devuelve el máximo de dos valores

        public static <T extends Comparable<T>> T maximo(T a, T b) {
                if (a.compareTo(b) > 0) {
                        return a;
                } else {
                        return b;
                }
        }

        public static void main(String[] args) {
                System.out.println("Máximo de 5 y 10: " + maximo(5, 10));
                System.out.println("Máximo de 5.5 y 5.4: " + maximo(5.5, 5.4));
                System.out.println("Máximo de 'a' y 'b': " + maximo('a', 'b'));
        }
}
