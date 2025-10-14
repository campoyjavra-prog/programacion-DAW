package ActividadesT2;

public class ActividadRecursividad3 {
   public static double potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }
    public static void main(String[] args) {
        System.out.println(potencia(2, 10));  
    }
}
