package org.skyrocket.board;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import org.skyrocket.Card;

import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.LayerManager;
import org.skyrocket.mouse.Input;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BoardManager {

    static List<Block> blocks = new ArrayList<>();
    static List<EnemyBlock> enemyBlocks = new ArrayList<>();
    static Block selectedBlock = null;
    static Block moveBlock = null;
    static EnemyBlock targetBlock = null;

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
        enemyBlocks.add(new EnemyBlock(747,196,48,86));
        enemyBlocks.add(new EnemyBlock(747,408,48,86));
        enemyBlocks.add(new EnemyBlock(895,196,48,86));
        enemyBlocks.add(new EnemyBlock(895,408,48,86));
        enemyBlocks.add(new EnemyBlock(1043,196,48,86));
        enemyBlocks.add(new EnemyBlock(1043,408,48,86));
        for(EnemyBlock e:enemyBlocks){
            e.e.setStroke(Color.RED);
            e.e.setStrokeWidth(2);
            e.e.setFill(Color.TRANSPARENT);
            e.e.layer = -1;
            LayerManager.add(e.e);
            Input.add(e.e);
        }

    }

    public static void releaseCard(Card c){
        if(selectedBlock!=null){
            selectedBlock.place(c);
            selectedBlock = null;
            HandManager.consumeCard(c);
        }else{
            //go-back-to-hand animation
//            Anime a = new Anime().add(new AniValue(c.r.xProperty(), 100));
            c.returnHandAnimation();
        }
    }


    public static void attack(Block attacker, EnemyBlock enemy){
        System.out.println("fight!");
    }




}
