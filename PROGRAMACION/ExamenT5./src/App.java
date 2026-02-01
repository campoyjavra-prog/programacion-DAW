import java.io.File;

public class App {
    public static void main(String[] args) {
        System.out.println("Directorio actual: " + new File(".").getAbsolutePath());
    }
}
