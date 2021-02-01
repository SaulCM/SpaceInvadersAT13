package org.fundacionjala.at13.spaceinvaders;
public class Alien { 
    //The variables are named after the x and y axis of the cartesian plane
    int xPos;
    int yPos;
    boolean isAlive;
    public Alien(int x, int y){
        this.xPos = x;
        this.yPos = y;
        isAlive = true;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int x) {
        this.xPos = x;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public void moveRight(){
        this.xPos+=1;
    }

    public void moveLeft(){
        this.xPos-=1;;
    }

    public void moveDown(){
        this.yPos+=1;;
    }

    public bullet shoot(){
        bullet bulletShot=new bullet(xPos, yPos, "Alien");
        return bulletShot;
    }

    public boolean isAlive(){
        return isAlive;
    }
    public void die(){
        this.isAlive = false;
    }
}