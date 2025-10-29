package PROGRAMACION.ExamenT2;

import java.util.Scanner;

public class Ejercicio4 {

    // función para verificar si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // pedir al usuario que ingrese dos números mayores que 50
        int num1;
        int num2;

        do {
            System.out.println("Introduce el primer número (mayor que 50): ");
            num1 = teclado.nextInt();
        } while (num1 <= 50);

        do {
            System.out.println("Introduce el segundo número (mayor que 50): ");
            num2 = teclado.nextInt();
        } while (num2 <= 50);

        // imprimir los números primos entre num1 y num2
        System.out.println("Los números primos entre " + num1 + " y " + num2 + " son:");
        for (int i = num1; i <= num2; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    

    
}


