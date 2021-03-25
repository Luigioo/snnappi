package org.skyrocket;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import org.skyrocket.render.RenderManager;
import org.skyrocket.render.Renderable;

import java.util.ArrayList;


public class AlbertooApp extends App{

    private GraphicsContext gc;
    private Group root;
    private ArrayList<friendMinion> FMINION = new ArrayList<friendMinion>();
    private RenderManager RM, RM2;

    public AlbertooApp(GraphicsContext gc, Group r)
    {
        this.gc = gc;
        this.root = r;
    }

    public void init()//this will only be called once
    {
        friendMinion m1 = new friendMinion(gc, 1);
        friendMinion m2 = new friendMinion(gc, 2);
        Renderable renderableSquare = new Renderable() {
            @Override
            public double getX() {
                return 300;
            }

            @Override
            public double getY() {
                return 300;
            }

            @Override
            public double getAngle() {
                return 270;
            }

            @Override
            public double getWidth() {
                return 89.5;
            }

            @Override
            public double getHeight() {
                return 139;
            }

            @Override
            public double getCenterX(){return 0;}

            @Override
            public double getCenterY(){return 0;}

            @Override
            public double getRadiusX(){return 0;}

            @Override
            public double getRadiusY(){return 0;}
        };
        Renderable renderableEllipse = new Renderable() {
            @Override
            public double getX() {
                return 0;
            }

            @Override
            public double getY() {
                return 0;
            }

            @Override
            public double getAngle() {
                return 45;
            }

            @Override
            public double getWidth() {
                return 0;
            }

            @Override
            public double getHeight() {
                return 0;
            }

            @Override
            public double getCenterX() {
                return 200;
            }

            @Override
            public double getCenterY() {
                return 200;
            }

            @Override
            public double getRadiusX() {
                return 100;
            }

            @Override
            public double getRadiusY() {
                return 200;
            }
        };
        RM = new RenderManager(gc, renderableSquare);
        RM2 = new RenderManager(gc, renderableEllipse);
        root.getChildren().add(m1.rectangle);
        root.getChildren().add(m2.rectangle);
//        for(int i = 0; i < minion.getNumber(); i++)
//        {
//            FMINION.add(new )
//        }
    }

    public void update()//this will be called in each second
    {
        RM.renderSquare();
        RM2.renderEllipse();
    }
}
