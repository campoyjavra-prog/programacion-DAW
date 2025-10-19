package T2.ActividadesT2;

import java.util.Scanner;

public class ActividadBucles7 {
    //Algoritmo MCD
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //Leer a y b
        System.out.println("Ingresa un valor: ");
         int a=scanner.nextInt();
        System.out.println("Ingresa un segundo valor: ");
        int b=scanner.nextInt();
        
        a=Math.abs(a);
        b=Math.abs(b);

        while (b != 0) {
            int resto=a % b;
            a=b;
            b=resto;
        }

        System.out.println("El MCD es: " +a);

        scanner.close();
    }
}

