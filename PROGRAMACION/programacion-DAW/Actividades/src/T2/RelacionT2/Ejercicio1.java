package T2.RelacionT2;

import java.time.LocalDateTime; // hora 

public class Ejercicio1 {
    public static void main(String[] args) {

        //obtenemos la fecha y hora actuales 
        LocalDateTime ahora=LocalDateTime.now();

        //guardamos la hora actual 
        int hora=ahora.getHour();

        //condicionales
        if (hora>=6 && hora<=12) {
            System.out.println("Buenos días");
         } 
         else if (hora>=13 && hora<=20) {
            System.out.println("Buenas tardes");
        } 
        else {
            System.out.println("Buenas noches");
        }

        System.out.println("Son las "+hora);
    }
    
}
