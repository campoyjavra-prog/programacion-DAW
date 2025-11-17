package T2.ActividadesT2;

import java.util.Scanner;

public class ActividadCondiconal2 {
    public static void main(String[] args) {
        //Introdue la nota
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la nota: ");
        int nota=teclado.nextInt();

       // Convertir la nota en un rango de categorías para el switch
        int categoria;

        if (nota >= 0 && nota < 5) {
            categoria = 1; // Suspenso
        } else if (nota == 5) {
            categoria = 2; // Aprobado (nota 5)
        } else if (nota >= 6 && nota < 7) {
            categoria = 3; // Bien (nota entre 6 y 7)
        } else if (nota >= 7 && nota < 9) {
            categoria = 4; // Notable
        } else if (nota >= 9 && nota <= 10) {
            categoria = 5; // Sobresaliente
        } else {
            categoria = 0; // Nota incorrecta
        }

        // Usar switch con las categorías
        switch (categoria) {
            case 1:
                System.out.println("Suspenso");
                break;
            case 2:
                System.out.println("Aprobado");
                break;
            case 3:
                System.out.println("Bien");
                break;
            case 4:
                System.out.println("Notable");
                break;
            case 5:
                System.out.println("Sobresaliente");
                break;
            case 0:
                System.out.println("Nota incorrecta");
                break;
            default:
                System.out.println("Error");
                break;
        }

        teclado.close();
    }    
}
