import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SinCity {
    public static void main(String[] args) {

        // REGLA 2: Patrón de lectura ImageIO.read(new File(...))
        // Usamos ruta relativa "prueba.jpg" generada previamente
        try {
            BufferedImage imagen = ImageIO.read(new File("prueba.jpg"));

            // REGLA 3: Patrón de recorrido Doble bucle (x, y)
            for (int x = 0; x < imagen.getWidth(); x++) {
                for (int y = 0; y < imagen.getHeight(); y++) {

                    // REGLA 4: Manipulación de píxeles: Leer color
                    Color c = new Color(imagen.getRGB(x, y));

                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();

                    // REGLA 5: Fórmula Filtro ROJO (Sin City)
                    // Condición: (r > g * 1.5) && (r > b * 1.5) && (r > 60)
                    if ((r > g * 1.5) && (r > b * 1.5) && (r > 60)) {
                        // Si cumple, se deja el color original. NO HACEMOS NADA.
                        // Opcionalmente podemos reestablecerlo: imagen.setRGB(x, y, c.getRGB());
                    } else {
                        // Si no cumple, se pasa a gris.
                        // REGLA 5: Fórmula Escala de Grises
                        int gris = (int) (r * 0.3 + g * 0.59 + b * 0.11);

                        // Creamos el nuevo color gris
                        Color nuevoColor = new Color(gris, gris, gris);

                        // REGLA 4: Escribir píxel
                        imagen.setRGB(x, y, nuevoColor.getRGB());
                    }
                }
            }

            // Guardamos el resultado
            File salida = new File("prueba_sincity.jpg");
            ImageIO.write(imagen, "jpg", salida);
            System.out.println("Imagen procesada guardada en: prueba_sincity.jpg");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
