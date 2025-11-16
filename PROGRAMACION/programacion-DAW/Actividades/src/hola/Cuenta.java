package hola;


public class Cuenta {
    String numeroCuenta;
    double saldo;
    Persona cliente;

    public Cuenta(){

    }
    public Cuenta(String numeroCuenta,double saldo,Persona p){
        this.numeroCuenta=numeroCuenta;
        this.saldo=saldo;
        this.cliente=p;
    }

    //get y set

    public void imprimeCuenta(){
        System.out.println("Imprime la cuenta");
    }
    
}
