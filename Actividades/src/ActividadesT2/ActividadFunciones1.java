package ActividadesT2;

import java.util.Scanner;

public class ActividadFunciones1 {
     final static double PI=3.14159;
    public static void main(String[] args) {
        //Leer de teclado la altura y el radio
        Scanner teclado=new Scanner(System.in);
        double altura;
        double radio;
        //Leer parámetros
        System.out.println("Escribe la altura: ");
        altura= Double.parseDouble(teclado.nextLine());
        System.out.println("Escribe el radio: ");
        radio=Double.parseDouble(teclado.nextLine());
        imprimeCilindro(altura, radio);

        teclado.close();
    }
    public static void imprimeCilindro(double altura,double radio){
        System.out.println("El ÁREA del cilindro es: "+(altura*radio*PI));
        System.out.println("El VOLUMEN del cilindro es: "+(altura*radio*PI));
    }
    
}
