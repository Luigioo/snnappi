package org.skyrocket.layer;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Srect extends Rectangle implements Layered{
    public int layer = 0;

    public Srect() {
    }

    public Srect(double width, double height) {
        super(width, height);
    }

    public Srect(double width, double height, Paint fill) {
        super(width, height, fill);
    }

    public Srect(double x, double y, double width, double height) {
        super(x, y, width, height);
    }


    @Override
    public int getLayer() {
        return layer;
    }
}
