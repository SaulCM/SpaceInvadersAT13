package org.fundacionjala.at13.spaceinvaders;
import org.fundacionjala.at13.spaceinvaders.*;
import java.util.ArrayList;
import java.lang.Math;
public class AlienGroup{

    private int GROUP_LEFT_LIMIT=5;
    private int GROUP_RIGHT_LIMIT=9;
    private int GROUP_DOWN_LIMIT=2;
    private boolean directionIsTowardsRight=true;

    ArrayList<Alien>alienGroup;

    public AlienGroup(){
        alienGroup=new ArrayList<Alien>();
        addAliens();
    }

    public void addAliens(){
        for (int row = 0; row <= this.GROUP_DOWN_LIMIT; row++) {
            for (int col = this.GROUP_LEFT_LIMIT; col <= this.GROUP_RIGHT_LIMIT; col++) {
                Alien alien=new Alien(col,row);
                alienGroup.add(alien);
            }
        }
    }

    public void moveAliens(){
        if (gotToTheSpaceship()==false) {
            if(directionIsTowardsRight==false){
                if (this.GROUP_LEFT_LIMIT == 0) {
                    aliensMoveDown();
                    directionIsTowardsRight=true;
                    this.GROUP_DOWN_LIMIT+=1;
                } else {
                    aliensMoveLeft();
                    this.GROUP_RIGHT_LIMIT-=1;
                    this.GROUP_LEFT_LIMIT-=1;
                }
            }
            else{
                if (this.GROUP_RIGHT_LIMIT == Constants.SPACE_SIZE_WIDTH-1) {
                    aliensMoveDown();
                    this.GROUP_DOWN_LIMIT+=1;
                    directionIsTowardsRight=false;
                } else {
                    aliensMoveRight();
                    this.GROUP_RIGHT_LIMIT+=1;
                    this.GROUP_LEFT_LIMIT+=1;
                }

            }

        }
    }
    
    public void aliensMoveRight(){
        for (Alien alien : alienGroup) {
            alien.moveRight();
        }
    }

    public void aliensMoveLeft(){
        for (Alien alien : alienGroup) {
            alien.moveLeft();
        }
    }

    public void aliensMoveDown(){
        for (Alien alien : alienGroup) {
            alien.moveDown();
        }
    }
    
    public ArrayList getAliens(){
        return alienGroup;
    }

    public boolean gotToTheSpaceship(){
        if(this.GROUP_DOWN_LIMIT>=Constants.SPACE_SIZE_HEIGHT-2){
            return true;
        } else { 
            return false; 
        }
    }

    public void calculateGroupRightlimit(){

    }

    public void setGroupRightLimit(){

    }

    public bullet alienGroupShoot(){

            int maxAliens = alienGroup.size()-1;  
            int alienTurnToShoot = (int)(Math.random() * maxAliens);
            bullet bulletShot = alienGroup.get(alienTurnToShoot).shoot();
            return bulletShot;
    }
}