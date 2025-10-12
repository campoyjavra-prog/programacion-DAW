package ActividadesT2;

public class ActividadFunciones2 {

    public static boolean esPar(int numero) {
        return numero %2==0;
    }

    public static boolean esDivisible3(int numero) {
        return numero %3==0;
    }

    public static void imprimirParesDivisiblesPor3() {
        System.out.println("Números pares divisibles por 3 que hay entre 1 y 20:");
        for (int i=1;i<=20;i++) {
            if (esPar(i) && esDivisible3(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        imprimirParesDivisiblesPor3();
    }
}
