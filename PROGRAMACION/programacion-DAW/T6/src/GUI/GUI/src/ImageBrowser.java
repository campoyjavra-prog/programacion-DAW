import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class ImageBrowser extends JFrame {
    private ImageIcon icono;

    public ImageBrowser() {
        initComponents();
    }

    public void initComponents() {
        // Pedir URL
        String urlTexto = JOptionPane.showInputDialog(
                null,
                "Introduce la URL de la imagen: ", // https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQeUzja2WA4kb-noAwFgY8GO092pgQ75VyGe_x6cc9P1IIPtqZ_n9YtmwGcgn4A
                "Cargar Imagen", JOptionPane.QUESTION_MESSAGE);

        // Crear ventana
        setTitle("Imagen cargada");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en ventana

        try {
            if (urlTexto != null && !urlTexto.trim().isEmpty()) {
                URL url = new URL(urlTexto);
                icono = new ImageIcon(url);
            }
            // Si el usuario cancela se intenta leer desde FICHERO
            else if (urlTexto == null || urlTexto.isEmpty()) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = fileChooser.getSelectedFile();
                    icono = new ImageIcon(archivo.getAbsolutePath());
                } else {
                    urlTexto = null; // Si cancela también el fileChooser
                }
            }

            // Añadimos una comprobación de que el icono no sea null antes de escalarlo
            // ya que si el usuario también cancela el JFileChooser, icono sería null
            // e intentaría invocar icono.getImage() provocando NullPointerException.
            if (icono != null) {
                Image imagenEscalada = icono.getImage()
                        .getScaledInstance(550, 350, Image.SCALE_SMOOTH);
                JLabel label = new JLabel(new ImageIcon(imagenEscalada));
                add(label);
            } else {
                // Lanzamos excepción para que la capture el catch y muestre el mensaje de error
                throw new Exception("No se ha seleccionado ninguna imagen");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "URL no válida o no se pudo cargar la imagen", // CORREGIDO: Null en mayúscula a null
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageBrowser();
    }
}
