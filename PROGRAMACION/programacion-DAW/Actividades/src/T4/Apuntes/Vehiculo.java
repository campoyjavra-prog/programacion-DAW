package T4.Apuntes;

public class Vehiculo {

    boolean usedFlag;
    String model;
    int numTires;

    // Constructor

    public Vehiculo(boolean used, String theModel, int tires){

        usedFlag = used;
        model = theModel;
        numTires = tires;

    }

    // Metodos de la clase 

    public void start (){
        System.out.println("Arranca");
    }

    public void turnLeft (){
        System.out.println("Moverse a la izquierda");
    }

    public void turnRight (){
        System.out.println("Moverse a la derecha");
    }

    public void stop (){
        System.out.println("Pararse");
    }

    public void forward (int speed){
        System.out.println("El vehiculo se mueve a "+speed+"km/h");
    }

    public static void imprimirDatos(){
        
    }

    // Main
    public static void main(String[] args) {

        System.out.println("OPERACION DE CLASE VEHICULO CLASE Y OBJETOS");

        // Objetos de la clase vehiculo

        Vehiculo moto = new Vehiculo(false, "Honda", 2);
        Vehiculo coche = new Vehiculo(true, "Toyota", 4);

        // Usando los objetos
        moto.start();
        moto.turnLeft();
        moto.forward(100);
        System.out.println(moto.model);

        coche.start();
        coche.turnRight();
        coche.forward(120);
        System.out.println(coche.model);

        imprimirDatos();

    }
}
