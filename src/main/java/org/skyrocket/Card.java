package org.skyrocket;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;

public class Card extends Sprite{

    Rectangle2D mesh;
    Rectangle r;

    double xpos = 0;
    double ypos = 0;

    double width = 91;
    double height = 175;

    public Card(){
        mesh = new Rectangle2D(0,0,91,175);
        r = new Rectangle(0,0,width,height);
        r.setFill(Color.BLUE);

        r.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e->{
                    System.out.println("aaahhahaha");
                    setXpos(xpos+10);
                });
    }

    @Override
    public void render(GraphicsContext gc) {
//        gc.setFill(Color.BLACK);
//        gc.fillRect(xpos, ypos, width, height);
    }

    @Override
    public void update() {
        super.update();
    }

    public void setXpos(double x){
        xpos = x;
        r.setX(x);
        r.setRotate(r.getRotate()+1);

    }
}
