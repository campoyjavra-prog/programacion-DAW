package T2.ActividadesT2;

import java.util.Scanner;

public class ActividadCondiconal2 {
    public static void main(String[] args) {
        //Introdue la nota
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la nota: ");
        int nota=teclado.nextInt();

        if(nota>=0 && nota <5){
            System.out.println("Suspenso");
        }
        else if (nota>=5 && nota<7){
            System.out.println("Aprobado");
        }
        else if(nota>=7 && nota <9){
            System.out.println("Notable");
        }
        else if(nota>=9 && nota <=10){
            System.out.println("Sobresaliente");
        }
        else{
            System.out.println("Nota incorrecta");
        }

        switch(nota){
            
            case 1: System.out.println("Suspenso");break;
            case 2: System.out.println("Aprobado");break;
            case 3: System.out.println("Notable");break;
            case 4: System.out.println("Sobresaliente");break;

            default:System.out.println("Nota incorrecta");break;
        }
        teclado.close();
    }    
}
