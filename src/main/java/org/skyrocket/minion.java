package org.skyrocket;

import javafx.scene.canvas.GraphicsContext;

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

    public minion(GraphicsContext gc)
    {
        this.gc = gc;
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
