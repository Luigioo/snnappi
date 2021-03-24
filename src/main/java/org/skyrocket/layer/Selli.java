package org.skyrocket.layer;

import javafx.scene.shape.Ellipse;

public class Selli extends Ellipse implements Layered {

    public int layer = 0;

    public Selli() {
    }

    public Selli(double radiusX, double radiusY) {
        super(radiusX, radiusY);
    }

    public Selli(double centerX, double centerY, double radiusX, double radiusY) {
        super(centerX, centerY, radiusX, radiusY);
    }

    @Override
    public int getLayer() {
        return layer;
    }
}
