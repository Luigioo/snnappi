package org.skyrocket.layer;

import javafx.scene.shape.Ellipse;
import org.skyrocket.mouse.Interactable;

public class Selli extends Ellipse implements Layered, Interactable {

    public int layer = 0;
    public Runnable mouseEnter;
    public Runnable mouseExit;
    boolean isOn = false;
    boolean isPreOn = false;

    public Selli() {
    }

    public Selli(double radiusX, double radiusY) {
        super(radiusX, radiusY);
    }

    public Selli(double centerX, double centerY, double radiusX, double radiusY) {
        super(centerX, centerY, radiusX, radiusY);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public boolean isOn(double x, double y){
        double fociLength = this.getRadiusX()*this.getRadiusX()-this.getRadiusY()*this.getRadiusY();
        fociLength = Math.abs(fociLength);
        fociLength = Math.sqrt(fociLength);
        if(getRadiusY()>getRadiusX()){
            double distance = distanceBetween(getCenterX(), getCenterY()-fociLength, x, y);
            distance += distanceBetween(getCenterX(), getCenterY()+fociLength, x, y);
            return distance<getRadiusY()*2;
        }else if(getRadiusX()>getRadiusY()){
            double distance = distanceBetween(getCenterX()-fociLength, getCenterY(), x, y);
            distance += distanceBetween(getCenterX()+fociLength, getCenterY(), x, y);
            return distance<getRadiusX()*2;
        }else{
            double distance = distanceBetween(getCenterX(), getCenterY(), x,y);
            return distance<getRadiusY()*2;
        }

    }

    public void inputUpdate(double x, double y){
        this.isPreOn = this.isOn;
        this.isOn = isOn(x, y);
        if(isOn&&!isPreOn){
            mouseEnter.run();
        }else if(!isOn&&isPreOn){
            mouseExit.run();
        }
    }



    private double distanceBetween(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }


}
