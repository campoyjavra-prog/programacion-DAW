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
        teclado.close();
    } */ 

    /*  //Haz un programa que solicita el día, mes y año y comprueba si es válido. Para el año hay que ver si el 29 es válido por ser bisiesto. Un año es bisiesto si: (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Inserta el dia: ");
        int dia = teclado.nextInt();
        System.out.print("Inserta el mes: ");
        int mes = teclado.nextInt();
        System.out.print("Inserta el año: ");
        int año = teclado.nextInt();

        boolean fechaValida = true;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia < 1 || dia > 31){
                    fechaValida = false;
                }
                break;
        
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia < 1 || dia > 30){
                    fechaValida = false;
                }
                break;
            
            case 2:
                if (dia < 1 || dia > 28){
                    fechaValida = false;
                }
                else if (dia == 29){
                    if ( (!(año % 4 == 0 && año % 100 != 0) || (año % 400 == 0))) {
                        fechaValida = false;

                    }

                }

                break;
            default:
                fechaValida = false;
        }

        if (fechaValida) {
            System.out.println("Fecha correcta");
        }
        else {
            System.out.println("Fecha incorrecta");
        }

    teclado.close();

    } */

    //BUCLES

    /*  // 1)Desarrolla un programa que muestre los números entre 50 y 200 que son múltiplos de 2 y 3
    public static void main(String[] args) {

   System.out.println("Estos son todos los numeros entre el 50 y 200 que son multiplos de 2 y 3: ");

   for (int i = 50; i <= 200; i++){
        if (i % 2 == 0 && i % 3 == 0){
            System.out.println(i);
        }
   }
 } */

    /*  // 2) Desarrolla un programa que calcule el factorial del número introducido. Ej: 4!= 4*3*2*1
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca un numero: ");
        int numero = teclado.nextInt();

        long factorial = 1;
        for (int i = 1; i <= numero; i++){
            factorial = factorial * i;
        }

        System.out.println("El factorial del numero "+numero+ " es: "+factorial);
    } */

    /*  // 3) Desarrolla un programa que muestre la edad máxima y mínima de un grupo de alumnos que se introduzca hasta escribir -1
    public static void main(String[] args) {
        int maxima = -1;
        int minima = 1000000000;
        int contadorPersona = 0;

        Scanner teclado = new Scanner(System.in);
        

        int edad;
        do {
        System.out.println("Introduce una edad o -1 para salir: ");
        edad = teclado.nextInt();
        if (edad!=-1){
            contadorPersona++;
        }
        if (edad > maxima){
            maxima = edad;
        }
        if (edad < minima && edad != -1){ 
            minima = edad;
        }
        } while (edad != -1);

        System.out.println("El número de personas: "+contadorPersona);
        System.out.println("El máximo es: "+maxima);
        System.out.println("El mínimo es: "+minima);
    } */

    /*  // 4) Continúa el programa anterior para que calcule la suma, media, número de alumnos y cuántos son mayores de edad
    public static void main(String[] args) {
        int maxima = -1;
        int minima = 1000000000;
        int contadorPersona = 0;
        int mayor18 = 0;
        int suma = 0;

        Scanner teclado = new Scanner(System.in);
        

        int edad;
        do {
        System.out.println("Introduce una edad o -1 para salir: ");
        edad = teclado.nextInt();
        if (edad!=-1){
            contadorPersona++;
        }
        if (edad > maxima){
            maxima = edad;
        }
        if (edad < minima && edad != -1){ 
            minima = edad;
        }
        if (edad>=18){
            mayor18++;
        }
        if (edad != -1){
            suma = suma + edad;
        }

        } while (edad != -1);

        System.out.println("El número de personas: "+contadorPersona);
        System.out.println("El máximo es: "+maxima);
        System.out.println("El mínimo es: "+minima);  
        System.out.println("El número de mayores de 18: "+mayor18);
        System.out.println("Suma de edades: "+suma);
        System.out.println("Media de edades: "+(suma/contadorPersona));
    } */
    
    /* */ // Desarrolla un programa que trate de adivinar un número entre 1 y 100 generado aleatorio, que vaya indicando si has introducido un número mayor o menor al correcto y el número de intentos.
    public static void main(String[] args) {
      
    }
}


