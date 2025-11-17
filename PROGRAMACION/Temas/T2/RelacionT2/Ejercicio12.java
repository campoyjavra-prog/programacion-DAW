package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio12 {

    //método que calcula el Máximo Común Divisor (MCD)
    public static int mcd(int a, int b) {

        //usamos el algoritmo de Euclides
        while (b != 0) {        //mientras el segundo número no sea 0
            int resto = a % b;  //calculamos el resto de dividir a entre b
            a = b;              //el segundo número pasa a ser el primero
            b = resto;          //el resto pasa a ser el segundo
        }
        //cuando b vale 0, el MCD es a
        return a;
    }

    //método que calcula el Mínimo Común Múltiplo (MCM)
    public static int mcm(int a, int b) {

        //usamos el valor absoluto porque el MCM siempre es positivo
        int producto=a*b;
        if (producto<0) {
            producto=-producto;  //si el producto es negativo, lo pasamos a positivo
        }

        //fórmula: MCM = |a * b| / MCD(a, b)
        int resultado=producto / mcd(a, b);
        return resultado;
    }

    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        //pedimos los dos números al usuario
        System.out.print("Introduce el primer número: ");
        int num1=teclado.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2=teclado.nextInt();

        //calculamos el MCD y el MCM
        int resultadoMCD=mcd(num1, num2);
        int resultadoMCM=mcm(num1, num2);

        //mostramos los resultados
        System.out.println("\n El Máximo Común Divisor (MCD) de " + num1 + " y " + num2 + " es: " +resultadoMCD);
        System.out.println("El Mínimo Común Múltiplo (MCM) de " + num1 + " y " + num2 + " es: " +resultadoMCM);

        teclado.close();
       
    }

}
