package org.skyrocket.board;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import org.skyrocket.Card;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.Selli;
import org.skyrocket.mouse.Input;


public class Block{
    Selli e;

    boolean preview = false; //when dragging a card over
    boolean placed = false; //when a card is successfully dropped

    Color previewColor = Color.LIGHTPINK;

    public Block(double centerX, double centerY, double radiusX, double radiusY){
        e = new Selli(centerX,centerY,radiusX,radiusY);

        e.mouseEnter=()->{
//            System.out.println("ola");
            if(HandManager.selected!=null&&!placed){
                e.setFill(previewColor);
                preview = true;
                BoardManager.selectedBlock = this;
            }
        };
        e.mouseExit=()->{
//            System.out.println("yoha");
            if(preview){
                e.setFill(Color.TRANSPARENT);
                preview = false;
                BoardManager.selectedBlock = null;
            }
        };
        e.addEventFilter(MouseEvent.MOUSE_PRESSED, event->{
            System.out.println("pressed");
            if(placed){
                BoardManager.moveBlock = this;

            }

        });
        e.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
            Input.setpos(event.getX(), event.getY());
        });
        e.addEventFilter(MouseEvent.MOUSE_RELEASED,e->{
            System.out.println("olaa");
            if(BoardManager.moveBlock!=null){
                BoardManager.moveBlock = null;
                if(BoardManager.targetBlock!=null){
                    BoardManager.attack(this, BoardManager.targetBlock);
                }
            }
//            if(HandManager.selected==this){
//                HandManager.arrangeCards();
//                HandManager.selected = null;
//                BoardManager.releaseCard(this);
//            }
        });

    }

    public void place(Card c){
        e.setFill(c.r.getFill());
        preview = false;
        placed = true;
    }

}
