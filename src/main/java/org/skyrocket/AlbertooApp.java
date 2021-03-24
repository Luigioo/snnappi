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
    private RenderManager RM;

    public AlbertooApp(GraphicsContext gc, Group r)
    {
        this.gc = gc;
        this.root = r;
    }

    public void init()//this will only be called once
    {
        friendMinion m1 = new friendMinion(gc, 1);
        friendMinion m2 = new friendMinion(gc, 2);
        Renderable renderable = new Renderable()
        {
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
            return 0;
        }

        @Override
        public double getWidth() {
            return 89.5;
        }

        @Override
        public double getHeight() {
            return 139;
        }
    };
        RM = new RenderManager(gc, renderable);
        root.getChildren().add(m1.rectangle);
        root.getChildren().add(m2.rectangle);
//        for(int i = 0; i < minion.getNumber(); i++)
//        {
//            FMINION.add(new )
//        }
    }

    public void update()//this will be called in each second
    {
        RM.render();
    }
}
