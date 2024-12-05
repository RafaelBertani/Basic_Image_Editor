import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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

    // public static Image paint_pixel(Image img, int x, int y, Color c){
    //     BufferedImage buffered_image = (BufferedImage) img;
    //     int pixel = (c.getAlpha() << 24) | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue();
    //     buffered_image.setRGB(x,y,pixel);
    //     return (Image) buffered_image;
    // }

    public static Image paint_pixel(Image img, int x, int y, Color c, int pixels, int format, boolean spray){
        BufferedImage buffered_image = (BufferedImage) img;
        int pixel = (c.getAlpha() << 24) | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue();

        if(pixels<2){
            buffered_image.setRGB(x,y,pixel);
        }
        else{
 
            if(format==1 && spray==false){ //circle
                try {
                    int pixel_x=0;
                    int pixel_y=0;
                    for(int r=0;r<pixels/2;r++){
                        for(double a=0;a<2*Math.PI;a+=(1/(2*Math.PI*r))){
                            pixel_x=(int)(x+r*Math.cos(a));
                            pixel_y=(int)(y+r*Math.sin(a));
                            if(pixel_x>=0 && pixel_x<buffered_image.getWidth() && pixel_y>=0 && pixel_y<buffered_image.getHeight()){
                               buffered_image.setRGB(pixel_x,pixel_y,pixel);
                            }
                        }
                    }   
                } catch (Exception e) {
                    e.printStackTrace();
                }                
            }
            else if(spray==false){ //square
                try {
                    for(int i=x-pixels/2;i<x+pixels/2;i++){
                        for(int j=y-pixels/2;j<y+pixels/2;j++){
                            if(i>=0 && i<buffered_image.getWidth() && j>=0 && j<buffered_image.getHeight()){
                                buffered_image.setRGB(i,j,pixel);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(format==1 && spray==true){ //circle spray
                try {
                    int pixel_x=0;
                    int pixel_y=0;
                    for(int r=0;r<pixels/2;r++){
                        for(double a=0;a<2*Math.PI;a+=(1/(2*Math.PI*r))){
                            pixel_x=(int)(x+r*Math.cos(a));
                            pixel_y=(int)(y+r*Math.sin(a));
                            if(pixel_x>=0 && pixel_x<buffered_image.getWidth() && pixel_y>=0 && pixel_y<buffered_image.getHeight()){
                                if( spray && (new Random().nextInt(300-1) + 1)==1 ){
                                    buffered_image.setRGB(pixel_x,pixel_y,pixel);
                                }
                            }
                        }
                    }   
                } catch (Exception e) {
                    e.printStackTrace();
                }                
            }
            else if(spray==true){ //square spray
                try {
                    for(int i=x-pixels/2;i<x+pixels/2;i++){
                        for(int j=y-pixels/2;j<y+pixels/2;j++){
                            if(i>=0 && i<buffered_image.getWidth() && j>=0 && j<buffered_image.getHeight()){
                                if( spray && (new Random().nextInt(300-1) + 1)==1 ){
                                    buffered_image.setRGB(i,j,pixel);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return (Image) buffered_image;
    }

}


