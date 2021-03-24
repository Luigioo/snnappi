package org.skyrocket.board;

import javafx.scene.paint.Color;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.Selli;

public class EnemyBlock {

    Selli e;

    Color prehitcol = Color.RED;

    public EnemyBlock(double centerX, double centerY, double radiusX, double radiusY){
        e = new Selli(centerX,centerY,radiusX,radiusY);

        e.mouseEnter=()->{
            System.out.println("enemy enter");
            if(BoardManager.moveBlock!=null){
                System.out.println("hit me?");
                BoardManager.targetBlock = this;
                e.setFill(prehitcol);
            }
        };
        e.mouseExit=()->{
            if(BoardManager.targetBlock==this){
                BoardManager.targetBlock = null;
                e.setFill(Color.TRANSPARENT);
            }
        };

    }


}
