package PROGRAMACION.ExamenT2;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        //Variables a utilizar
        int entradas = 0;
        int dia = 0;
        boolean si = true;
        boolean no = true;
        String n;
        String s;
        boolean diaValido = true;
        boolean tarjeta = true;
        int precio = 0;
        String grupales;
        String individuales;
        boolean grupal = true;
        boolean individual= true;

        

        //Hacer numero de entradas y dias de la semana
        System.out.println("Venta de entradas CineCampa");
        System.out.println("Introduce el numero de entradas: ");
        entradas=teclado.nextInt();
        System.out.println("Introduce el número del dia de la semana: ");
        dia=teclado.nextInt();
        
        

        
        System.out.println("Número de entradas: "+entradas);

        switch (dia) {
            case 1:
                System.out.println("Día de la semana: Lunes");
                
                break;
            case 2:
                System.out.println("Día de la semana: Martes");
                
                break;
            case 3:
                System.out.println("Día de la semana: Miercoles");
                
                break;
            case 4:
                System.out.println("Día de la semana: Jueves");
                
                break;
            case 5:
                System.out.println("Día de la semana: Viernes");
                
                break;
            case 6:
                System.out.println("Día de la semana: Sabado");
                
                break;
            case 7:
                System.out.println("Día de la semana: Domingo");
                
                break;

        
            default:
              break;
        }

        //Si el usuario pone s o n imprimir Aquí tiene sus entradas. Gracias por su compra. 
        System.out.println("¿Tiene tarjeta CineCampa? (s/n): ");
        s=teclado.nextLine();
        n=teclado.nextLine();  

        if (si=true){
            System.out.println("¿Tiene tarjeta CineCampa? (s/n): s");
            System.out.println("Aquí tiene sus entradas. Gracias por su compra.");
        } 
        else{
            System.out.println("¿Tiene tarjeta CineCampa? (s/n): n");
            System.out.println("Aquí tiene sus entradas. Gracias por su compra.");
        }

        //Entradas individuales o grupales e insertar el numero de estas

        System.out.println("Las entradas son grupales o inviduales: ");
        grupales=teclado.nextLine();
        individuales=teclado.nextLine();

        if (grupal=true){
            System.out.println("Entradas grupales");

        }
        else if (individual=true) {
            System.out.println("Entradas individuales");
        }

        //Introducir el precio de entrada segun el dia y el tipo
        
        //Sumar todas las variables y dar un total (aplicar descuento si es necesario * 0.9) e imprimir A pagar y el dinero correspondiente


    }
}
