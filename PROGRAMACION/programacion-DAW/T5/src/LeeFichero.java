import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class LeeFichero{

    public static void main(String[] args) {
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;

        try{
            System.out.println("Directorio actual: " + new File(".").getAbsolutePath());
            archivo = new File ("./PROGRAMACION/programacion-DAW/T5/numeros.txt");
            reader = new FileReader(archivo);
            buffer = new BufferedReader(reader);

            String linea;
            while ((linea=buffer.readLine()) != null) {
                System.out.println(linea);
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }finally{
            try{
                if (null != reader) {
                    reader.close();
                }
            }catch(Exception e2 ){
                e2.printStackTrace();
            }
        }
    }
}
