package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio11 {
    //operaciones basicas con funciones
    public static double sumar(double a, double b) { return a+b; }
    public static double restar(double a, double b) { return a-b; }
    public static double multiplicar(double a, double b) { return  a*b; }
    public static double dividir(double a, double b) {

        if (b==0) {
            System.out.println("Error: division por cero. Devuelvo 0.");
            return 0;
        }
        return a/b;
    }

    //procedimiento menu
    public static void mostrarMenu() {
        System.out.println("Seleccione operacion:");
        System.out.println("1- Sumar");
        System.out.println("2- Restar");
        System.out.println("3- Multiplicar");
        System.out.println("4- Dividir");
        System.out.println("5- Salir del menu");
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion=teclado.nextInt();

            if (opcion==5) {
                System.out.println("FIN");
                break;
            }

            //pedimos numeros hasta que uno sea -1
            System.out.println("Introduce el primer operando (o -1 para salir): ");
            double a=teclado.nextDouble();
            if (a==-1) {
                System.out.println("Operacion cancelada por entrada -1.");
                break;
            }

            System.out.println("Introduce el segundo operando (o -1 para salir): ");
            double b=teclado.nextDouble();
            if (b==-1) {
                System.out.println("Operación cancelada por entrada -1.");
                break;
            }

            double resultado=0;
            if (opcion==1) {
                resultado=sumar(a,b);
            }
            else if (opcion==2) {
                resultado=restar(a,b);
            } 
            else if (opcion==3) {
                resultado=multiplicar(a,b);
            }
            else if (opcion==4) {
                resultado=dividir(a,b);
            }
            else {
                System.out.println("Opcion no valida.");
            }

            System.out.println("Resultado: " +resultado);
            System.out.println(); //linea en blanco antes de repetir
        }
        teclado.close();
    }
}
