package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio10 {
     // Devuelve el número de dígitos pares en n
    public static int contarPares(int n) {
        n = Math.abs(n); // trabajamos con el valor absoluto por si hay negativo
        int contador = 0;
        if (n == 0) {
            return 1; // el número 0 tiene un dígito que es par
        }
        while (n > 0) {
            int digito = n % 10;
            if (digito % 2 == 0) {
                contador++;
            }
            n = n / 10;
        }
        return contador;
    }

    // Devuelve el número de dígitos impares en n
    public static int contarImpares(int n) {
        n = Math.abs(n);
        int contador = 0;
        if (n == 0) {
            return 0; // 0 no tiene dígitos impares
        }
        while (n > 0) {
            int digito = n % 10;
            if (digito % 2 != 0) {
                contador++;
            }
            n = n / 10;
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();

        int pares = contarPares(numero);
        int impares = contarImpares(numero);

        System.out.println("El " + numero + " contiene " + pares + " dígitos pares y " + impares + " dígitos impares.");

        sc.close();
    }
}
