import java.util.ArrayList;

public class Agenda2 {
    public static void main(String[] args) {
        ArrayList<Persona4> lista = new ArrayList<>();
        lista.add(new Persona4("Domingo","AVENIDA","666666666"));
        lista.add(new Persona4("Aurora","adfadfasf","666666666"));
        lista.add(new Persona4("Marggio","PORTAL ... ","666666666"));
        lista.add(new Persona4("José Miguel","CALLE...","666666666"));
        lista.add(new Persona4("Pedro","OTRA","666666666"));

        //Ordenar la lista de personas
        lista.sort((p1, p2) -> p2.getNombre().compareTo(p1.getNombre()));

        //Mostar las personas
        for(int i=0;i<lista.size();i++){
            lista.get(i).imprimePersona();
        }
    }   
}

