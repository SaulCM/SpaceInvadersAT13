package org.fundacionjala.at13.spaceinvaders;
import java.lang.Math;

public class Player{
    
    private int shootColdown=1;

    public Player(){
        
    }

    public String makeAMove(){
        int random = (int)(Math.random()*100);
        //50% probability to move left or right
            if(random < 50){
                return "Left";
            }else{
                return "Right";
            }  
    }
}