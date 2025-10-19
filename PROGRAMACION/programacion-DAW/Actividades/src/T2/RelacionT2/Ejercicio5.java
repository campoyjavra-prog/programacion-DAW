package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);
        int horario;

        do {
            System.out.println("Introduce un numero (del 1 al 5 para dias, 6 para todo el horario y el 7 para salir): ");
            horario=teclado.nextInt();

            if (horario==1) {
                System.out.println("- Lunes: Matematicas, Programación, Ingles");
            }
             else if (horario==2) {
                System.out.println("- Martes: Fisica, Programacion, Historia");
            }
             else if (horario==3) {
                System.out.println("- Miercoles: Matematicas, Lengua, Programacion");
            }
             else if (horario==4) {
                System.out.println("- Jueves: Ingles, Programacion, Educación Fisica");
            }
             else if (horario==5) {
                System.out.println("- Viernes: Matematicas, Programacion, Filosofia");
            }
             else if (horario==6) {
                System.out.println("HORARIO COMPLETO");
                System.out.println("- Lunes: Matematicas, Programacion, Ingles");
                System.out.println("- Martes: Fisica, Programacion, Historia");
                System.out.println("- Miercoles: Matematicas, Lengua, Programacion");
                System.out.println("- Jueves: Ingles, Programacion, Educacion Fisica");
                System.out.println("- Viernes: Matematicas, Programacion, Filosofia");
            }
             else if (horario==7) {
                System.out.println("Programa cerrado...");
            }
             else {
                System.out.println("Opcion no valida");
            }

        } while (horario!=7); //repite hasta poner 7
        teclado.close();
    }
}
