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

    final static double mid = 640;
    final static double gap = 80;
    final static double posy = 535;
    public static void init(){
        cards.add(new Card(Color.BLUE));
        cards.add(new Card(Color.PINK));
        cards.add(new Card(Color.LIGHTGREEN));
        cards.add(new Card(Color.LIGHTYELLOW));

//        for (int i = 0; i < cards.size(); i++)
//        {
//            cards.get(i).render(gc);
//        }

        int icrLayer = 99;
        for(Card c:cards){
            c.r.setStroke(Color.GRAY);
            c.r.setFill(Color.TRANSPARENT);
            c.r.setStrokeWidth(2);
            c.r.layer = icrLayer--;
            LayerManager.add(c.r);
        }

    }

    public static void arrangeCards(){

        double length = cards.size();
        double posnow = mid-gap*length/2.0;
        for(Card c:cards){
            c.setY(posy);
            c.setX(posnow);
            posnow+=gap;

        }
    }

    public static double getPosXCard(Card c){
        double i = cards.indexOf(c);
        return (i-cards.size()/2.0)*gap+mid;
    }
    public static double getPosYCard(Card c){
        return posy;
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
