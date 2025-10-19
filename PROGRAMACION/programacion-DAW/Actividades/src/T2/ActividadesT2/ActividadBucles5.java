package T2.ActividadesT2;

import java.util.Scanner;
// double media=(numero1+numero2)/2.0;
public class ActividadBucles5 {
    public static void main(String[] args) {
        //Generar el número aleatorio
        int aleatorio=(int)(Math.random()*(100-1+1))+1;
        int intentos=0;
        int numero=0;
        boolean encontrado=false;
        Scanner teclado = new Scanner(System.in);
        //Crearemos el bucle para ir viendo lo que el usuario va introduciendo
        do { 
            //Vamos a leer el número
            System.out.print("Introduce un número: ");
            numero=teclado.nextInt();
            if(numero>aleatorio){
                System.out.println("El número es menor al que has introducido");
            }
            else if(numero<aleatorio){
                System.out.println("El número es mayor al que has introducido");
            }
            else{
                System.out.println("Has acertado con el número");
                encontrado=true;
            }
            intentos++;
           
        } while (!encontrado);
        System.out.println("Has utilizado "+intentos+" para acertar.");
        teclado.close();
    }
    
}