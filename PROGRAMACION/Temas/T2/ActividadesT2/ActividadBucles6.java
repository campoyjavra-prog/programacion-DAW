package T2.ActividadesT2;

import java.util.Scanner;

public class ActividadBucles6 {
    public static void main(String[] args) {
        int opcion;
        int numero1,numero2;
        boolean salida=false;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("**** CALCULADORA DAW ****");
            System.out.println("1- Hacer la suma");
            System.out.println("2- Hacer la resta");
            System.out.println("3- Hacer la multiplicación");
            System.out.println("Introduce una opción o -1 para salir: ");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: System.out.println("Introduzca los números: ");
                        numero1=teclado.nextInt();
                        numero2=teclado.nextInt();
                        System.out.println("La suma es: "+(numero1+numero2));
                        break;
                
                case 2: System.out.println("Introduzca los números: ");
                        numero1=teclado.nextInt();
                        numero2=teclado.nextInt();
                        System.out.println("La resta es: "+(numero1-numero2));
                        break;
                
                case 3: System.out.println("Introduzca los números: ");
                        numero1=teclado.nextInt();
                        numero2=teclado.nextInt();
                        System.out.println("La multiplicacion es: "+(numero1*numero2));
                        break;
                default: //Caso -1
                        salida=true;
                        break;
                
            }
        } while (!salida);
        teclado.close();
    }
}
