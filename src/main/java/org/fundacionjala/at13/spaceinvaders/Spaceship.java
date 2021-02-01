package org.fundacionjala.at13.spaceinvaders;

public class Spaceship {

    private int posX;
    private int posY;
    private final int LOWER_lIMIT = 0;
    private final int UPPER_lIMIT = 50;
    

    public Spaceship(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLOWER_lIMIT() {
        return this.LOWER_lIMIT;
    }

    public int getUPPER_lIMIT() {
        return this.UPPER_lIMIT;
    }

    public void moveToRight(){
        if (this.posX<Constants.SPACE_SIZE_WIDTH-1) {
            this.posX += 1;
        }else{

        }
    }

    public void moveToLeft(){
        if (this.posX > 0) {
            this.posX -=1 ;           
        }else{
            
        }
    }
    public bullet shoot(){     
        bullet bulletShot = new bullet(this.posX, this.posY, "Spaceship"); 
        return bulletShot;
    }
}