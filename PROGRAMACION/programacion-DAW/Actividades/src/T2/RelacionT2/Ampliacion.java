package T2.RelacionT2;

import java.util.Scanner;

public class Ampliacion {

     //eétodo que comprueba si un número es primo
    public static boolean primo(int n) {

        //numero menor o igual a 1 no es primo
        if (n<=1) {
            return false;
        }

        //comprobamos si tiene divisores distintos de 1 y el mismo
        for (int i=2;i<n;i++) {
            //si el número es divisible por i, entonces no es primo
            if (n%i==0) {
                return false;
            }
        }

        // si no encontramos ningun divisor, el numero es primo
        return true;
    }

    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        // pedimos un numero al usuario
        System.out.print("Introduce un número: ");
        int numero=teclado.nextInt();

        //llamamos al metodo primo y mostramos el resultado
        if (primo(numero)) {
            System.out.println(numero+ " es un número primo.");
        } else {
            System.out.println(numero+ " no es un número primo.");
        }

        //mostramos los 100 primeros numeros primos
        System.out.println("\nLos 100 primeros números primos son:");
        int contador=0;   //lleva la cuenta de cuantos primos hemos encontrado
        int num=2;        //empezamos en 2, el primer numero primo

        while (contador < 100) {   //mientras no tengamos 100 primos
            if (primo(num)) {    
                System.out.print(num + " ");  
                contador++;                  
            }
            num++;  //pasamos al siguiente numero
        }

        teclado.close();
    }
}
