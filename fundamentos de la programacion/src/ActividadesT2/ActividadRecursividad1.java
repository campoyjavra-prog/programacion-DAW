package ActividadesT2;

public class ActividadRecursividad1 {
    //Función que devuelve la cantidad de dígitos de un número positivo
    public static int numeroDigitos (int n) {
        int contador=0;
        while (n>0) {
            n=n/10;
            contador++;
        }
        return contador;
    }
    public static void main(String[] args) {
        System.out.println(numeroDigitos(23445));
    }   
}
