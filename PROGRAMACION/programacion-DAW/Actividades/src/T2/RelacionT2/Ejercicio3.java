package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio3 {
     public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);

        System.out.println("Introduce día de nacimiento: ");
        int dia=teclado.nextInt();

        System.out.println("Introduce mes de nacimiento: ");
        int mes=teclado.nextInt();

        String signo = ""; //guardar signo

        //condicionales
        if ((dia>=21 && mes==3) || (dia<=20 && mes==4)) {
            signo="Aries";
        } 
        else if ((dia>=21 && mes==4) || (dia<=20 && mes==5)) {
            signo="Tauro";
        } 
        else if ((dia>=21 && mes==5) || (dia<=20 && mes==6)) {
            signo="Geminis";
        }
         else if ((dia>=21 && mes==6) || (dia<=22 && mes==7)) {
            signo="Cancer";
        }
         else if ((dia>=23 && mes==7) || (dia<=22 && mes==8)) {
            signo="Leo";
        }
         else if ((dia>=23 && mes==8) || (dia<=22 && mes==9)) {
            signo="Virgo";
        }
         else if ((dia>=23 && mes==9) || (dia<=22 && mes==10)) {
            signo="Libra";
        }
         else if ((dia>=23 && mes==10) || (dia<=21 && mes==11)) {
            signo="Escorpio";
        
        } else if ((dia>=22 && mes==11) || (dia<=21 && mes==12)) {
            signo="Sagitario";
        }
         else if ((dia>=22 && mes==12) || (dia<=19 && mes==1)) {
            signo="Capricornio";
        } 
        else if ((dia>=20 && mes==1) || (dia<=18 && mes==2)) {
            signo="Acuario";
        }
         else if ((dia>=19 && mes==2) || (dia<=20 && mes==3)) {
            signo="Piscis";
        }

        System.out.println("El signo del zodiaco es: " + signo);
        teclado.close();
    }
}
