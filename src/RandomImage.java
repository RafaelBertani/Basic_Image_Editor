import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RandomImage {

    public static void draw_random_image() throws IOException {
        int width = 640;
        int height = 320;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a = (int) (Math.random() * 256); // alpha
                int r = (int) (Math.random() * 256); // red
                int g = (int) (Math.random() * 256); // green
                int b = (int) (Math.random() * 256); // blue
                int pixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, pixel);
            }
        }

        File outputfile = new File("random_image.png");
        ImageIO.write(img, "PNG", outputfile);
    }

    public static Image return_blank_image(int height, int width){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int a = 255;
        int r = 255;
        int g = 255;
        int b = 255;
        int pixel = (a << 24) | (r << 16) | (g << 8) | b;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, pixel);
            }
        }
        return (Image) img;
    }

    public static Image paint_pixel(Image img, int x, int y, Color c){
        BufferedImage buffered_image = (BufferedImage) img;
        int pixel = (c.getAlpha() << 24) | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue();
        buffered_image.setRGB(x,y,pixel);
        return (Image) buffered_image;
    }

}


