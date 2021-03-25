package org.skyrocket.render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class RenderManager {

    private Image i, i2;
    private GraphicsContext gc;
    private Renderable r;

    public RenderManager(GraphicsContext gc, Renderable r)
    {
        this.gc = gc;
        this.r = r;
        i = new Image("kuangg.png", r.getWidth(), 400, false, false);
        i2 = new Image("Daoyan.jpg");
    }

    public void renderSquare()
    {
        drawRotatedImage(gc, i, r.getAngle(), r.getX(), r.getY());
    }

    public void renderEllipse()
    {drawEllipse(gc, i2, r.getCenterX(), r.getCenterY(), r.getRadiusX(), r.getRadiusY());}

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate rtt = new Rotate(angle, px, py);
        gc.setTransform(rtt.getMxx(), rtt.getMyx(), rtt.getMxy(), rtt.getMyy(), rtt.getTx(), rtt.getTy());
    }

    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }

    public void drawEllipse(GraphicsContext gc, Image image, double getCenterX, double getCenterY, double getRadiusX, double getRadiusY) {

    }
}
