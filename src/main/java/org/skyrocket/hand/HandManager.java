package org.skyrocket.hand;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.skyrocket.Card;
import org.skyrocket.layer.LayerManager;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public final class HandManager {

    static List<Card> cards = new LinkedList<>();

    public static Card selected = null;
    private static GraphicsContext gc;
    public static void init(){
        cards.add(new Card(new Image("Daoyan.jpg")));
        cards.add(new Card(Color.PINK));
        cards.add(new Card(Color.LIGHTGREEN));
        cards.add(new Card(Color.LIGHTYELLOW));

        for (int i = 0; i < cards.size(); i++)
        {
            cards.get(i).render(gc);
        }

        int icrLayer = 99;
        for(Card c:cards){
            c.r.setStroke(Color.GRAY);
            c.r.setStrokeWidth(2);
            c.r.layer = icrLayer--;
            LayerManager.add(c.r);
        }

    }

    public static void arrangeCards(){
        double mid = 640;
        double gap = 80;

        double length = cards.size();
        double posnow = mid-gap*length/2.0;
        for(Card c:cards){
            c.setY(535.0);
            c.setX(posnow);
            posnow+=gap;

        }

    }

    public static void add(Card c){
        cards.add(c);
    }

    public static void consumeCard(Card c) {
        cards.remove(c);
        LayerManager.remove(c.r);
        arrangeCards();
    }
}
