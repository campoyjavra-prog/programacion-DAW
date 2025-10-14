package ACTIVIDADES14;

import java.util.Scanner;

public class Actividad9 {
    public static void main(String[] args) {
        int opcion;
        int numero1, numero2;
        boolean salida = false;
        Scanner teclado = new Scanner(System.in);

        System.out.println("**** CALCULADORA DAW ****");

        do {
            System.out.println("\n1 - Hacer la suma");
            System.out.println("2 - Hacer la resta");
            System.out.println("3 - Hacer la multiplicación");
            System.out.println("-1 - Salir");
            System.out.print("Introduce una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca los números (introduce -1 para salir):");
                    numero1 = teclado.nextInt();
                    if (numero1==-1) {
                        salida=true;
                        break;
                    }
                    numero2 = teclado.nextInt();
                    if (numero2==-1) {
                        salida=true;
                        break;
                    }
                    System.out.println("La suma es: " + (numero1+numero2));
                    break;

                case 2:
                    System.out.println("Introduzca los números (introduce -1 para salir):");
                    numero1=teclado.nextInt();
                    if (numero1==-1) {
                        salida=true;
                        break;
                    }
                    numero2=teclado.nextInt();
                    if (numero2==-1) {
                        salida=true;
                        break;
                    }
                    System.out.println("La resta es: " +(numero1-numero2));
                    break;

                case 3:
                    System.out.println("Introduzca los números (introduce -1 para salir):");
                    numero1 = teclado.nextInt();
                    if (numero1 == -1) {
                        salida = true;
                        break;
                    }
                    numero2 = teclado.nextInt();
                    if (numero2 == -1) {
                        salida = true;
                        break;
                    }
                    System.out.println("La multiplicación es: " + (numero1*numero2));
                    break;

                case -1:
                    salida = true;
                    System.out.println("Saliendo de la calculadora...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (!salida);

        teclado.close();
    }
}