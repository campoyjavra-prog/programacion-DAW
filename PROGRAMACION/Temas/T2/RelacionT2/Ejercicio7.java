package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        int positivos=0; //contador positivos
        int negativos=0; //contador de negativos

        while (true) { //bucle infinito 0 cerrar
            System.out.println("Introduce un número (0 para cerrar): ");
            int num=teclado.nextInt();

            if (num==0) {
                break; //salimos del bucle cuando el usuario pone 0
            } 
            else if (num>0) {
                positivos++; //aumentamos contador positivos
            } 
            else {
                negativos++; //aumentamos contador negativos
            }
        }
        System.out.println("Has introducido " + positivos + " números positivos y " + negativos + " números negativos.");
        teclado.close();
    }
}
