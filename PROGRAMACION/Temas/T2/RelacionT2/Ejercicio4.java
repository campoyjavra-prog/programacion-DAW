package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio4 {
     public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        System.out.println("Nota primer examen: ");
        double nota1=teclado.nextDouble();

        System.out.println("Nota segundo examen: ");
        double nota2=teclado.nextDouble();

        double media=(nota1+nota2)/2; //media
       

        if (media>=5) {
            System.out.println("Tu media es de: " +media);
        } 
        else {
            System.out.println("Cual ha sido el resultado de la recuperacion? (apto o no apto): ");

            String recuperacion=teclado.next(); //se guarda para saber si es apto o no
            
            if (recuperacion.equalsIgnoreCase("apto")){
                System.out.println("Aprobado con un 5");
            } else {
                System.out.println("Suspenso con una media de " +media);
            }
        }
        teclado.close();
    }
}
