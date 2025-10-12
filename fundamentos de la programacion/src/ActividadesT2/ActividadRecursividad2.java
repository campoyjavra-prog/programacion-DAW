package ActividadesT2;

public class ActividadRecursividad2 {
    //Función que devuelve la suma de los números naturales desde 1 hasta N. Compara el código con el que se obtendría iterativo.
    public static int sumaNumeros (int n){
        int suma=0;
         for(int i=1;i<=n;i++){
            suma+=i;
         }
         return suma;
    }
    public static void main(String[] args) {
        int numero=4;
        System.out.println(sumaNumeros(numero));
    }
}
