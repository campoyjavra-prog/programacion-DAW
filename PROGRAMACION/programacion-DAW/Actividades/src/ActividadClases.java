import java.util.ArrayList;

public class ActividadClases {
    
    //Main
    public static void main(String[] args) {
        System.out.println("CREACIÓN DE CLASE VEHÍCULO Y OBJETOS");
        //Objetos de la clase vehículo
        Vehiculo moto = new Vehiculo(false,"Honda",2);
        Vehiculo coche = new Vehiculo(true,"Toyota",4);
        //Usando los objetos
        moto.start();
        moto.turnLeft();
        moto.forward(100);
        
        coche.start();
        coche.turnRight();
        coche.forward(120);

        coche.forward(12);
        
    }
}
//Datos miembros de la clase
class Vehiculo{
    boolean useFlag;
    String model;
    int numTires;

    //Constructor
    public Vehiculo(boolean useF,String modelo,int numT){
        useFlag=useF;
        model=modelo;
        numTires=numT;
    }

    //Métodos de la clase
    public void start(){
        System.out.println("Arranca");
    }
    public void turnLeft(){
        System.out.println("Moverse a la izquierda");
    }  
    public void turnRight(){
        System.out.println("Moverse a la derecha");
    }
    public void stop(){
        System.out.println("Pararse");
    }
    public void forward(int speed){
        System.out.println("Moverse hacia delante a una velocidad "+speed);
    }
    public static void imprimirDatos(){
        System.out.println("Estás en un concesionario");
    }
}
