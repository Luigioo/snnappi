package org.skyrocket;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.skyrocket.render.renderManager;

import java.util.ArrayList;


public class AlbertooApp extends App{

    private GraphicsContext gc;
    private Group root;
    private ArrayList<friendMinion> FMINION = new ArrayList<friendMinion>();

    public AlbertooApp(GraphicsContext gc, Group r)
    {
        this.gc = gc;
        this.root = r;
    }

    public void init()//this will only be called once
    {
        friendMinion m1 = new friendMinion(gc, 1);
        friendMinion m2 = new friendMinion(gc, 2);

        Card c = new Card(Color.BLUEVIOLET);
        c.render(gc);
        c.setX(500);
        c.setY(500);

        renderManager rM = new renderManager(gc, c);
        root.getChildren().add(m1.rectangle);
        root.getChildren().add(m2.rectangle);
        root.getChildren().add(rM.render(90));
//        for(int i = 0; i < minion.getNumber(); i++)
//        {
//            FMINION.add(new )
//        }
    }

    public void update()//this will be called in each second
    {

    }
}
