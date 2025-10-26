package JAVA;

import java.text.ListFormat.Style;
import java.util.Scanner;

public class ActividadesT2 {

    //USO DE FUNCIONES DEFINIDAS

    /*  //Realiza un programa que genera 2 números y nos diga el cociente, la media, la potencia y la raíz cuadrada. Usa tipos adecuados
    public static void main(String[] args) {
        //Crear variables
        //Crear las operaciones
        //Imprimir las cuentas
        
       //Sacamos dos nuemros aleatorios entre el 1 y el 53
       int min=1; 
       int max=53;

       int numero1=(int)(Math.random()*(max-min+1))+min;
       int numero2=(int)(Math.random()*(max-min+1))+min;

       //Operaciones
       double cociente=numero1/numero2;
       double media=(numero1+numero2)/2.0;
       int potencia=(int) Math.pow(numero1,numero2);
       double raiz1 = Math.sqrt(numero1);
       double raiz2 = Math.sqrt(numero2);

       //Imprimir
       System.out.println("El primer numero aleatorio es: "+numero1);
       System.out.println("El segundo numero aleatorio es: "+numero2);
       System.out.println("El cociente entre los dos numero es: "+cociente);
       System.out.println("La media entre los dos numeros es: "+media);
       System.out.println("La potencia entre los dos numeros es: "+potencia);
       System.out.println("La raiz cuadrada del primer numero es: "+raiz1);
       System.out.println("La raiz cuadrada del segundo numero es: "+raiz2);
    } */

    //CONDICIONAL

    /* //Haz el programa JAVA del siguiente diagrama de flujo
    public static void main(String[] args) {
        //Leer a,b,c
       Scanner teclado = new Scanner(System.in);
       System.out.println("Introduce los valores de a,b y c:");
       int a = teclado.nextInt();
       int b = teclado.nextInt();
       int c = teclado.nextInt();

       //Crear formula
       double formula = Math.pow(b,2)-4*a*c;

       //Condicionales
       if (formula<0){
        System.out.println("No hay soluciones");
       }
       else if (formula == 0){
        double x1 = -b/2.0*a;
        System.out.println("La unica solucion es: "+x1);
       }
       else{
        double x1 = (-b+Math.sqrt(formula))/(2.0*a);
        double x2 = (-b-Math.sqrt(formula))/(2.0*a);

        System.out.println("La primera solucion es: "+x1);
        System.out.println("La segunda solucion es: "+x2);
       }
       teclado.close();

    } */

    /* //Haz un programa que nos pide una nota y nos indica la calificación (sobresaliente, notable, bien, aprobado, suspenso, nota incorrecta). Usa if-else y switch
    public static void main(String[] args) {
        //Leer nota
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la nota obtenida: ");
        int nota = teclado.nextInt();
        int categoria;
        //Procesar la nota
        if (nota >= 9 && nota <= 10){
            categoria = 1;
        }
        else if (nota >= 7 && nota < 9){
            categoria = 2;
        }
        else if (nota >= 6 && nota < 7){
            categoria = 3;
        }
        else if (nota >= 5 && nota <= 10){
            categoria = 4;
        }
        else if (nota >= 0 && nota <= 5){
            categoria = 5;
        }
        else {
            categoria = 0;
        }

        switch (categoria) {
            case 1:
                System.out.println("Tienes un SOBRESALIENTE ");
                break;

            case 2:
                System.out.println("Tienes un NOTABLE ");
                break;

            case 3:
                System.out.println("Tienes un BIEN ");
                break;
            
            case 4:
                System.out.println("Tienes un APROBADO ");
                break;

            case 5:
                System.out.println("Tienes un SUSPENSO ");
                break;
            
            case 0:
                System.out.println("Nota incorrecta ");
                break; 
        
            default:
                System.out.println("ERROR");
                break;
        }
    } */ 

    /* */ //Haz un programa que solicita el día, mes y año y comprueba si es válido. Para el año hay que ver si el 29 es válido por ser bisiesto. Un año es bisiesto si: (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)


}
