package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio8 {
     public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        System.out.println("Introduce cuantos terminos de Fibonacci quieres: ");
        int numero=teclado.nextInt();

        if (numero<=0) {
            System.out.println("Introduce un numero mayor que 0");
        }
         else {
            int a=0; //primer termino
            int b=1; //segundo termino

            if (numero>=1) {
                System.out.println(a); //mostramos el primer término
            }
            if (numero>=2) {
                System.out.println(" " +b); //mostramos el segundo término
            }

            for (int i=3;i<=numero;i++) { //empezamos en 3 porque ya mostramos 1 y 2
                int siguiente = a+b; //la regla: suma de los dos anteriores
                System.out.println(" " +siguiente);
                a=b; //desplazamos: el anterior ahora es b
                b=siguiente; //y b pasa a ser el nuevo término
            }
            System.out.println(); //salto de línea final
        }
        teclado.close();
    }
}
