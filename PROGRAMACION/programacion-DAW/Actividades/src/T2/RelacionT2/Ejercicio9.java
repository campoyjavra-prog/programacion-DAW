package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio9 {

     //función recursiva que devuelve el término k-ésimo (0-based)
    public static int fibonacci(int k) {
        if (k==0) { //caso base 0->0
            return 0;
        }
        else if (k==1) { //caso base 1->1
            return 1;
        }
         else { //llamado recursivo: sumamos los dos anteriores
            
            return fibonacci(k-1)+fibonacci(k-2);
        }
    }

    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        System.out.println("Introduce cuántos términos de Fibonacci quieres: ");
        int n=teclado.nextInt();

        if (n<=0) {
            System.out.println("Introduce un número mayor que 0.");
        } else {
            for (int i=0;i<n;i++) {
                System.out.println(fibonacci(i) + " ");
            }
            System.out.println();
        }
        teclado.close();
    }
}
