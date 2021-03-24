package org.skyrocket.layer;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

import java.util.LinkedList;
import java.util.List;

public final class LayerManager {

    static Group root;
    static Canvas canvas;
    static List<Layered> layers = new LinkedList<>();

    private LayerManager(){};

    public static void init(Group r, Canvas c){
        LayerManager.root = r;
        LayerManager.canvas = c;
    }

    public static void reOrder(){
        layers.sort((l1, l2)->{
            if(l1.getLayer()==l2.getLayer()){
                return 0;
            }else{
                return l1.getLayer()>l2.getLayer() ? 1 : -1;
            }
        });
        //canvas.toFront();
        for(Layered l:layers){
            ((Node) l).toFront();
        }
    }

    public static void add(Layered l){
        root.getChildren().add((Node)l);
        layers.add(l);
    }

    public static void remove(Layered l){
        root.getChildren().remove((Node)l);
        layers.remove(l);
    }







}
