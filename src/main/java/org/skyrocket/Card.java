package org.skyrocket;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import org.skyrocket.board.BoardManager;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.Srect;
import org.skyrocket.mouse.Input;

public class Card extends Sprite {

    final double width = 91;
    final double height = 175;
    public Srect r = new Srect(0,0,width,height);

    double selectPointX = -1;
    double selectPointY = -1;

    public Card(Color c){
        r.setFill(c);
//
        r.addEventFilter(MouseEvent.MOUSE_PRESSED,e->{
            selectPointX = e.getX()-r.getX();
            selectPointY = e.getY()-r.getY();
            HandManager.selected = this;
        });
//        r.setOnDragDetected(e->{
//            System.out.println("drag dec");
//            Dragboard db = r.startDragAndDrop(TransferMode.COPY_OR_MOVE);
//            ClipboardContent content = new ClipboardContent();
//            content.putString("something");
//            db.setContent(content);
//            e.consume();
//        });
//        r.setOnDragDone(e->{
//            System.out.println("drag done");
//            e.consume();
//        });
        r.addEventFilter(MouseEvent.MOUSE_DRAGGED,e->{
//            System.out.println("aaahhahaha");
            Input.setpos(e.getX(), e.getY());
            setPos(e.getX()-selectPointX, e.getY()-selectPointY);
        });
        r.addEventFilter(MouseEvent.MOUSE_RELEASED,e->{
            if(HandManager.selected==this){
                HandManager.arrangeCards();
                HandManager.selected = null;
                BoardManager.releaseCard(this);
            }
        });
    }
    public Card(Image image){
        r.setFill(new ImagePattern(image));
    }

//    public void render(GraphicsContext gc) {
//        gc.setFill(Color.BLACK);
//        gc.fillRect(xpos, ypos, width, height);
//    }

    public void update() {
        super.update();
    }

    public void setPos(double x, double y){
        setX(x);
        setY(y);
    }

    public void setX(double x){
        r.setX(x);
    }
    public void setY(double y){
        r.setY(y);
    }

}
