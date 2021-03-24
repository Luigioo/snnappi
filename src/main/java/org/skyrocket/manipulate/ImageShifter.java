package org.skyrocket.manipulate;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.ImagePattern;

public class ImageShifter {
    private Image i;
    private Rectangle r;

    public ImageShifter(Rectangle r, Image i)
    {
        this.i = i;
        this.r = r;
    }

    public Rectangle resize(int multi, int x, int y, double xPos, double yPos)
    {
        Rectangle r = new Rectangle();
        r.setX(xPos);
        r.setY(yPos);
        r.setHeight(x);
        r.setHeight(y);
        r.setFill(new ImagePattern(i));
        return r;
    }


}
