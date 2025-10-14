package ActividadesT2;

import java.util.Scanner;

public class ActividadBucles4 {
    public static void main(String[] args) {

        //Leer edades hasta -1 y entonces sacar el valor máximo y mínimo
        int maximo=-1;
        int minimo=1000000;
        int contadorPersona=0;
        int suma=0;
        int mayor18=0;
        Scanner teclado = new Scanner(System.in);
        int edad;
        do { 
            System.out.print("Introduce una edad o -1 para salir: ");
            edad=teclado.nextInt();
            if(edad!=-1) contadorPersona++;//Nueva persona
            
            if(edad>maximo){ 
                maximo=edad;
            }
            if(edad<minimo && edad!=-1){
                minimo=edad;
            }
            if(edad>=18){
                mayor18++;
            }
            if(edad!=-1){
                suma+=edad; 
            }
        } while (edad!=-1);
        System.out.println("El número de personas: "+contadorPersona);
        System.out.println("El máximo es: "+maximo);
        System.out.println("El mínimo es: "+minimo);
        System.out.println("El número de mayores de 18: "+mayor18);
        System.out.println("Suma de edades: "+suma);
        System.out.println("Media de edades: "+(suma/contadorPersona));

        teclado.close();
    }
}

