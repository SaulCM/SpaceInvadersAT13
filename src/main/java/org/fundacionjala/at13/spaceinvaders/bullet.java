package org.fundacionjala.at13.spaceinvaders;

public class bullet{

    public int posX;
    public int posY;
    public boolean bulletExist;
    public String type;

    public bullet(int x, int y, String type){
        this.type=type;
        this.posX = x;
        this.posY = y;
        bulletExist = true;
    }
    public String shooter(){
        return type;
    }
    public boolean isCollapsedBullet(int positionX1, int positionY1, int positionX2, int positionY2){
        if(positionX1 == positionX2 && positionY1 == positionY2){
            System.out.println("The bullet has collapsed");
            bulletExist = true;
            return true;
        }
        return false;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public String getType(){
        return this.type;
    }

    public boolean checkCollition(int x, int y){
        if(x == this.posX && y == this.posY){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean exist(){
        return this.bulletExist;
    }
    public void bulletAdvance(){
        if (type.equals("Alien")) {
            if(this.posY >= Constants.SPACE_SIZE_HEIGHT-1){
                this.bulletExist = false;
            }else{
                this.posY += 1; 
            }            
        } else {
            if(type.equals("Spaceship")){
                if(this.posY <= 0){
                    this.bulletExist = false;
                }
                else{
                    this.posY -= 1;
                }
            }
        }
    }
    public void ceaseToExist(){
        this.bulletExist=false;
    }

}