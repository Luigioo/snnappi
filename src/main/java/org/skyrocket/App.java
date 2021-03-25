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
import org.skyrocket.render.Simage;


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

        Simage test = new Simage("Daoyan.jpg");

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
                    //gc.drawImage(test.blockImg, 0, 0);
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