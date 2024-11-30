import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResizeImage {

    public static Image resizeImage(String origin_path, int targetWidth, int targetHeight) throws IOException{
        BufferedImage originalImage = ImageIO.read(new File(origin_path));

        BufferedImage resizedImage = new BufferedImage(targetWidth,targetHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = resizedImage.createGraphics();

        graphics2d.drawImage(originalImage,0,0,targetWidth,targetHeight,null);
        graphics2d.dispose();

        return (Image) resizedImage;

    }

}
