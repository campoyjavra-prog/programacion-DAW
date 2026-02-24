import javax.swing.JOptionPane;

public class App4 {
    public static void main(String[] args) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION, // botones: YES y NO
                JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("El usuario dijo Sí");
        } else {
            System.out.println("El usuario dijo No");
        }
    }
}