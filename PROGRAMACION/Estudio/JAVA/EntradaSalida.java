package JAVA;

public class EntradaSalida {
    public static void main(String[] args) {
        //Instrucciones de salida por pantalla 
        int valor=7;
        System.out.println(valor); 
        //Usar printf
        double precio=13.41234;
        System.out.printf("El precio del producto %s tiene un valor de %5.2f y se han comprado %d","Tablet", precio,valor);
        //Incluir un icono 
        System.out.println("Que ganas tengo de unas vacaciones \u26F1");
        //Formato reciente de System\
        System.out.println("El precio del producto "+"Tablet "+"tiene un valor de "+precio+" y se han comprado "+valor);
    }
}
