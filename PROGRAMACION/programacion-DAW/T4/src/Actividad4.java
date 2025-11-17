import clases.*;

public class Actividad4 {
    public static void main(String[] args) {
        //Crear una fehca
        Fecha fechaNacimiento=new Fecha(15,8,1985);
        Ciudad ciudadNacimiento=new Ciudad(4800,"Albox",4);
        Ciudad ciudadResidencia=new Ciudad(4600,"Huércal Overa",3);

        Persona3 individuo=new Persona3("adfadfadf","DOMINGO","LÓPEZ OLLER",'H');
        individuo.setCiudadNacimiento(ciudadNacimiento);
        individuo.setCiudadResidencia(ciudadResidencia);
        individuo.setFechaNacimiento(fechaNacimiento);

        individuo.imprimePesona();
    }
}
