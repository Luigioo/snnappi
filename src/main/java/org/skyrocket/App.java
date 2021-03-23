package org.skyrocket;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


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
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        Canvas canvas = new Canvas(640,480);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        final long startTime = System.nanoTime();

        new AnimationTimer(){

            @Override
            public void handle(long l) {
                double t = (l-startTime)/1000000000.0;
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                gc.setFill( new Color(0.85, 0.85, 1.0, 1.0) );
                gc.fillRect(0,0,640,480);

                gc.setFill(Color.BLACK);

                gc.fillRect(x-10,y-10,x+10,y+10);

            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}