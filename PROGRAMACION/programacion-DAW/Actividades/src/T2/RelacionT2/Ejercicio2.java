package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        System.out.println("Introduzca el número de horas trabajadas durante la semana: ");

        Scanner teclado=new Scanner(System.in);
        int horas=teclado.nextInt(); //guardar horas
        int sueldo; //guardar sueldo
        int horasExtra = horas-40;

        //condicionales
        if (horas<=40) {
            sueldo=horas*12;
        } 
        else {
             sueldo=(40*12)+(horasExtra*16);
        }

        System.out.println("El sueldo de la semana es de " + sueldo + " euros");

        teclado.close(); 
    }
}
