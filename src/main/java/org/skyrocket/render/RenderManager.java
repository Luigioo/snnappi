package org.skyrocket.render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import org.skyrocket.Card;

public class RenderManager {

    private Card c;
    private Image i;
    private GraphicsContext gc;
    private Renderable r;

    public RenderManager(GraphicsContext gc, Renderable r)
    {
        this.gc = gc;
        this.r = r;
        i = new Image("kuangg.png");
    }

    public void render()
    {
        drawRotatedImage(gc, i, r.getAngle(), r.getX(), r.getY());
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        System.out.println("Px is: " + px + " Py is: " + py);
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        gc.clearRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.scale( r.getHeight()/i.getHeight(), r.getHeight()/i.getHeight());
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }
}
