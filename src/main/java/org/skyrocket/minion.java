package org.skyrocket;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class minion{

    protected double xPosition;
    protected double yPosition;
    protected double tempX;
    protected double tempY;
    protected boolean isDead;

    //此处写特效 ps 剧毒

    protected int OriginalDmg, Damage;
    protected int OriginalHealth, Health;
    protected int MaxHealth;

    public GraphicsContext gc;
    public Rectangle rectangle = new Rectangle();
    private Image i = new Image("src/main/resources/daoyan.jpg");

    public minion(GraphicsContext gc)
    {
        this.gc = gc;

        //Setting the properties of the rectangle
        rectangle.setX(150);
        rectangle.setY(75);
        rectangle.setWidth(100);
        rectangle.setHeight(150);

        //Setting the height and width of the arc
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(20);
        rectangle.setFill(new ImagePattern(i));
    }

    public abstract void init();

    public abstract void update();



    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getTempX() {
        return tempX;
    }

    public void setTempX(double tempX) {
        this.tempX = tempX;
    }

    public double getTempY() {
        return tempY;
    }

    public void setTempY(double tempY) {
        this.tempY = tempY;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getOriginalDmg() {
        return OriginalDmg;
    }

    public void setOriginalDmg(int originalDmg) {
        OriginalDmg = originalDmg;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getOriginalHealth() {
        return OriginalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        OriginalHealth = originalHealth;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }

}
