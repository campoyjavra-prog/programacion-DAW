package clases;

public class Fecha {
    private int dia;
    private int mes;
    private int anyo;

    //constuctor
    public Fecha(){

    }
    public Fecha(int dia, int mes, int anyo){
        this.dia=dia;
        this.mes=mes;
        this.anyo=anyo;
    }

    //Métodos get y set
    public int getAnyo() {
        return anyo;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void imprimeFecha(){
        System.out.println("Imprime fecha");
    }
}
