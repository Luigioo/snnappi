package org.skyrocket.board;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.Selli;


public class Block{
    Selli e;

    boolean preview = false;
    Color previewColor = Color.LIGHTPINK;
    public Block(double centerX, double centerY, double radiusX, double radiusY){
        e = new Selli(centerX,centerY,radiusX,radiusY);

//        e.addEventFilter(MouseEvent.MOUSE_ENTERED, event->{
//            System.out.println("enter");
//            if(HandManager.selected!=null){
//                e.setFill(HandManager.selected.r.getFill());
//            }
//        });
        e.mouseEnter=()->{
            System.out.println("ola");
            if(HandManager.selected!=null){
                e.setFill(previewColor);
                preview = true;
            }
        };
        e.mouseExit=()->{
            System.out.println("yoha");
            if(preview){
                e.setFill(Color.TRANSPARENT);
                preview = false;
            }
        };
//        e.addEventFilter(MouseEvent.ANY,e->{
//            System.out.println("oola");
//        });
//        e.setOnDragOver(e->{
//            System.out.println("ola");
//        });
//        e.setOnDragDropped(event->{
//            System.out.println("dropped");
//        });

    }
}
