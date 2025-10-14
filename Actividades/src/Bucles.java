import java.util.Scanner;

public class Bucles {
    public static void main(String[] args){
        // Codigo basico de bucle
        for (int i=0;i<5;i++){   // Conozco cuantas se van a ejecutar
            System.out.println(i);
        }

        // Bucle while


        // Bucle do-while
            int k=0;
            do{
                System.out.println(k);
                k++;
            }while(k>5);

        //COSAS QUE NO QUIERO VER EN VUESTROS CODIGOS
        for (int i=0;i<5;i++){
            System.out.println(i);
            if (i==3) break; { // Faltan el 4 y 5 al romper en 3
                
            }
        }
        //HACERLO MEJOR CON UN BUCLE WHILE
        int j=0;
        boolean continua=true;
        while (j<5 && continua) {
            System.out.println(j);
            if (j==3) continua=false; {
                j++;
                
            }
        }
        
        Scanner teclado = new Scanner(System.in);
        int numero=0;
        do{
            System.out.print("Escribe un numero entre 1 y 5");
            numero=teclado.nextInt();
        }while(numero<1 ||numero>5);

        // Bucles anidados




    }
}
