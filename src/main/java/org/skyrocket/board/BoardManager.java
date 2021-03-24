package org.skyrocket.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import org.skyrocket.layer.LayerManager;
import org.skyrocket.mouse.Input;

import java.util.LinkedList;
import java.util.List;

public final class BoardManager {

    static List<Block> blocks = new LinkedList<>();

    public static void init(){
        blocks.add(new Block(147,196,48,86));
        blocks.add(new Block(147,408,48,86));
        blocks.add(new Block(295,196,48,86));
        blocks.add(new Block(295,408,48,86));
        blocks.add(new Block(443,196,48,86));
        blocks.add(new Block(443,408,48,86));
        for(Block b:blocks){
            b.e.setStroke(Color.BLACK);
            b.e.setStrokeWidth(2);
            b.e.setFill(Color.TRANSPARENT);
            b.e.layer = -1;
            LayerManager.add(b.e);
            Input.add(b.e);
        }
    }




}
