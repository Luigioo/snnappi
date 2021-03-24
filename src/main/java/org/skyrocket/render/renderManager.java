package org.skyrocket.render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.skyrocket.Card;

public class renderManager {

    private Card c;
    private Image i;
    private GraphicsContext gc;

    public renderManager(GraphicsContext gc, Card c)
    {
        this.c = c;
        this.gc = gc;
        i = new Image("kuang.png");
    }

    public ImageView render(double angle)
    {
        ImageView iv = new ImageView(i);
        iv.setX(c.getRect().getX() - 50);
        iv.setY(c.getRect().getY() - 50);
        iv.setFitWidth(c.getRect().getWidth() + 100);
        iv.setFitHeight(c.getRect().getHeight() + 100);
        gc.drawImage(iv.getImage(), iv.getX(), iv.getY());
        return iv;
    }
}
