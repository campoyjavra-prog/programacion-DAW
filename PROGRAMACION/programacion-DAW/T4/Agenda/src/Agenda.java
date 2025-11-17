public class Agenda {
    public static void main(String[] args) throws Exception {
        //Necesito tener un vector de personas
        Persona4[] lista = new Persona4[5];
        lista[0]=new Persona4("Domingo","AVENIDA","666666666");
        lista[1]=new Persona4("Aurora","adfadfasf","666666666");
        lista[2]=new Persona4("Marggio","PORTAL ... ","666666666");
        lista[3]=new Persona4("José Miguel","CALLE...","666666666");
        lista[4]=new Persona4("Pedro","OTRA","666666666");
        
        //Imprimir las personas
        for(int i=0;i< lista.length;i++){
            lista[i].imprimePersona();
        }
    }
}
