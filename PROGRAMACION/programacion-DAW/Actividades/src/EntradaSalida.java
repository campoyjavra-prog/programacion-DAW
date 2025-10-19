import java.util.Scanner;

public class EntradaSalida {
    public static void main(String[] args){
       /*  // Instrucciones de salida por pantalla
        int valor=7;
        System.out.println(valor);

        // Usar printf
        double precio=13.35479;
        System.out.printf("El precio del producto %s tiene un valor de %5.2f y se han comprado %d","Tablet",precio, valor); 
        // Incluir un Icono
        System.out.println("Que ganas tengo de unas vacaciones \u26F1");

        // Formato reciente de System
        System.out.println("El precio del producto "+"Tablet" +"tiene un valor de" +precio+" y se han comprado"+valor+ "unidades");
        // Formato salida texto
        System.out.printf("%15s, %-15s","Rafa","Informatico");

        // Formato tabla
        System.out.println("|----------|----------|----------|");
        System.out.printf("|%-10s|%-10s|%-10s|\n","Producto","Cantidad","Valor");
        System.out.println("|----------|----------|----------|");
        System.out.printf("|%-10s|%d|%f|\n","Producto",valor ,precio);
        
        System.out.println("|----------|----------|----------|");
        System.out.println("|"+"Producto"+" |"+"Cantidad"+"  |"+"Precio"+"  |"); 
        System.out.println("|----------|----------|----------|");
        System.out.println("|" + "Tablet" + "  |" + valor + "  |" + precio + "  |"); */

        // Operaciones con entrada por teclado
        Scanner teclado=new Scanner(System.in); 
       /*  System.out.println("Introduce: Nombre Apellido Edad Profesion");
        // Lee Nombre
        String nombre=teclado.next();
        // Leer Apellido
        String apellido=teclado.next();
        // Leer Edad
        int edad=teclado.nextInt();
        // Leer profesion
        String profesion=teclado.next();

        System.out.println("El usuario se llama "+nombre+" "+apellido+". Tiene "+edad+" años y trabaja de "+profesion+""); */

        /*  Primer intento
        System.out.println("Introduce tu nombre y apellidos:");
         String nombre=teclado.next();
         String apellidos=teclado.next();
        System.out.println("Su nombre es "+nombre+" "+apellidos+"");
        System.out.println("Introduce tu edad:");
         int edad=teclado.nextInt();
        System.out.println(" Tiene "+edad+" años");
        System.out.println("Introduce tu profesión:");
         String profesion=teclado.next();
        System.out.println("Trabaja de "+profesion+""); */

        /* Segundo intento  
        System.out.println("Introduce tu nombre y apellidos:");
         String nombre=teclado.next();
         String apellido1=teclado.next();
         String apellido2=teclado.next();
        System.out.println("Introduce tu edad:");
         int edad=teclado.nextInt();
        System.out.println("Introduce tu profesión:");
         String profesion=teclado.next();
        
        System.out.println("El usuario se llama "+nombre+" "+apellido1+" "+apellido2+". Tiene "+edad+" años y trabaja de "+profesion+""); */

        /*Don Domingo Opcion 1 para limpiar buffer
        System.out.println("Introduce tu nombre y apellidos:");
         String nombre=teclado.next();
         String apellido1=teclado.next();
         String apellido2=teclado.next();
        System.out.println("Introduce tu edad:");
         int edad=teclado.nextInt();
         teclado.nextLine(); // Limpiar el buffer para el salto de linea
        System.out.println("Introduce tu profesión:");
         String profesion=teclado.next();
        
        System.out.println("El usuario se llama "+nombre+" "+apellido1+" "+apellido2+". Tiene "+edad+" años y trabaja de "+profesion+"");*/ 

        /*Don Domingo Opcion 2 para limpiar el buffer*/
        System.out.println("Introduce tu nombre y apellidos:");
         String nombre=teclado.nextLine();
         String apellido1=teclado.nextLine();
         String apellido2=teclado.nextLine();
        System.out.println("Introduce tu edad:");
         int edad=Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce tu profesión:");
         String profesion=teclado.nextLine();
        
        System.out.println("El usuario se llama "+nombre+" "+apellido1+" "+apellido2+". Tiene "+edad+" años y trabaja de "+profesion+""); 
        
        



        teclado.close();

    }
    
}
