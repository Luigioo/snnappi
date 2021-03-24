package org.skyrocket.board;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.Selli;


public class Block{
    Selli e;
    public Block(double centerX, double centerY, double radiusX, double radiusY){
        e = new Selli(centerX,centerY,radiusX,radiusY);

        e.addEventFilter(MouseEvent.MOUSE_ENTERED, event->{
            System.out.println("enter");
            if(HandManager.selected!=null){
                e.setFill(HandManager.selected.r.getFill());
            }
        });
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
