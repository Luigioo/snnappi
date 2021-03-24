package org.skyrocket.render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.skyrocket.Card;

public class renderManager{

    private Card c;
    private Image i;
    private GraphicsContext gc;
    private renderable renderable;

    public renderManager(GraphicsContext gc)
    {
        this.gc = gc;
        i = new Image("kuang.png");
        renderable = new renderable() {
            @Override
            public double getX() {
                return 400;
            }

            @Override
            public double getY() {
                return 400;
            }

            @Override
            public double getAngle() {
                return 0;
            }

            @Override
            public double getWidth() {
                return 100;
            }

            @Override
            public double getHeight() {
                return 200;
            }
        };
        render(renderable);
    }


    public ImageView render(renderable r)
    {
        ImageView iv = new ImageView(i);
        iv.setX(r.getX() - 10);
        iv.setY(r.getY() - 10);
        iv.setFitWidth(r.getWidth() + 40);
        iv.setFitHeight(r.getHeight() + 40);
        iv.setRotate(r.getAngle());
        gc.drawImage(iv.getImage(), iv.getX(), iv.getY());
        return iv;
    }
}
