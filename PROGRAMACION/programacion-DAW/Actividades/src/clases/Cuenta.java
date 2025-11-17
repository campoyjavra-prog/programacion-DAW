package clases;

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
        System.out.println("Número de cuenta bancaria: "+this.numeroCuenta);
        System.out.println("Saldo de la cuenta: "+this.saldo);
        this.cliente.imprimePersona();
    }
}
