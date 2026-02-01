import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GenerarImagenPrueba {
    public static void main(String[] args) {
        int width = 100;
        int height = 100;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Mitad izquierda ROJA, mitad derecha AZUL
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x < width / 2) {
                    img.setRGB(x, y, Color.RED.getRGB());
                } else {
                    img.setRGB(x, y, Color.BLUE.getRGB());
                }
            }
        }

        try {
            File f = new File("prueba.jpg");
            ImageIO.write(img, "jpg", f);
            System.out.println("Imagen prueba.jpg creada.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
