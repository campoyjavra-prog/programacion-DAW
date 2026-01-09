import java.util.Scanner;

public class Actividad2 { //ACTIVIDAD Escritura.java o RegistroUsuario o Tema5
    public static void main(String[] args) {
        // Create a scanner object
        Scanner myObj = new Scanner("Item 1,Item 2,Item 3");

        // Change delimiter
        myObj.useDelimiter(",");

        // Read the contents of the scanner
        while (myObj.hasNext()) {
            System.out.println(myObj.next());
        }

    }
}
