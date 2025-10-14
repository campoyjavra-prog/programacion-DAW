package ACTIVIDADES14;

import java.util.Scanner;

public class Actividad10 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        // Leer a y b
        System.out.print("Introduce el primer número (a): ");
        int a = sc.nextInt();

        System.out.print("Introduce el segundo número (b): ");
        int b = sc.nextInt();

        // Tomar valores absolutos
        a = Math.abs(a);
        b = Math.abs(b);

        // Algoritmo de Euclides para el MCD
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }

        // Mostrar resultado
        System.out.println("El MCD es: " + a);

        sc.close();
    }
}
