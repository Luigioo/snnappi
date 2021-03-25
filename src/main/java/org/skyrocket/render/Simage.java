package org.skyrocket.render;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageWriter;

public class Simage {

    static Image cardMask;
    static Image blockMask;
    static Image blockTrans = new Image("blockTransReal.png"); //transparent mask

    public WritableImage cardImg;
    public WritableImage blockImg; //172*400

    public Simage(String path){
        //generate two versions of this image
        Image source = new Image(path,1000, 400, true, true);

        PixelReader pr = source.getPixelReader();
        PixelReader prb = blockTrans.getPixelReader();
//        cardImg = new WritableImage(172,400);
        blockImg = new WritableImage(172,400);
        PixelWriter pw = blockImg.getPixelWriter();
        double xoffset = (source.getWidth()-172.0)/2.0;

        for (int readY = 0; readY < 400; readY++) {
            for (int readX = 0; readX < 172; readX++) {
//                System.out.println(prb.getColor(readX, readY).getBrightness());
                if(prb.getColor(readX, readY).getBrightness()<0.1){
                    //total black
                    pw.setColor(readX, readY, Color.TRANSPARENT);
                }else{
                    pw.setColor(readX, readY, pr.getColor(readX+(int)xoffset, readY));
                }
            }
        }

    }

}
