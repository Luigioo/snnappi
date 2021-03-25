package org.skyrocket;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.skyrocket.board.BoardManager;
import org.skyrocket.hand.HandManager;
import org.skyrocket.layer.LayerManager;
import org.skyrocket.mouse.Input;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();
        stage.setTitle("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.setResizable(false);
        Canvas canvas = new Canvas(1280,720);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        final long startTime = System.nanoTime();

//        scene.setOnMouseClicked(
//                e -> {
//                    System.out.println("x: "+e.getX()+" y: "+e.getY());
//                    System.out.println();
//                });
        LayerManager.init(root, canvas);

        HandManager.init();
        HandManager.arrangeCards();

        BoardManager.init();

        LayerManager.reOrder();
//        Card c = new Card();
//        LayerManager.add(c.r);
//        Card cb = new Card();
//        LayerManager.add(cb.r);
//        cb.r.setFill(Color.PINK);
//        cb.setXpos(20);
//        cb.r.layer = -1;
//        LayerManager.reOrder();
//        root.getChildren().sort((node1, node2)->{
//            if(node1 instanceof Layered && node2 instanceof Layered){
//                Layered l1 = (Layered)node1, l2 = (Layered)node2;
//                return l1.getLayer()>l2.getLayer()?-1:1;
//            }else if(node2 instanceof Layered){
//                //only true when node1 is canvas
//                //canvas is below all
//                return 1;
//            }else{
//                return -1;
//            }
//        });
//        root.getChildren().add(cb.r);
//        root.getChildren().add(c.r);
        AlbertooApp a = new AlbertooApp(gc, root);

        new AnimationTimer(){

            @Override
            public void handle(long l) {
                //set background
                gc.setFill( Color.LIGHTGREY );
                gc.fillRect(0,0,1280,720);

                //get relative time
                double t = (l-startTime)/1000000000.0;
                Input.update();
//                double x = 232 + 128 * Math.cos(t);
//                double y = 232 + 128 * Math.sin(t);
//
//                gc.setFill(Color.BLACK);
//
//                gc.fillRect(x-10,y-10,x+10,y+10);
                a.update();


            }
        }.start();

        a.init();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}