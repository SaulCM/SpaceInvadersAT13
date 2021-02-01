package org.fundacionjala.at13.spaceinvaders;
import java.util.ArrayList;
import java.lang.Math; 
//import org.fundacionjala.at13.spaceinvaders.*;

public class Space{

    private static final int SPACE_SIZE_HEIGHT = 10;
    private static final int SPACE_SIZE_WIDTH = 15;
    private static final String FONT_SPACE = "-";
    private static final String FONT_ALIEN = "V";
    private static final String FONT_SPACESHIP = "A";
    private static final String FONT_BULLET = "|";

    private static Player player;
    private static AlienGroup alienGroup;
    private static Spaceship spaceship;
    private static int alienMovingTurnCount = 1;
    private static int alienShootTurnCount = 1;
    private static int playerShootTurnCount = 1;
    private static ArrayList<bullet> bullets;
    static String [][] space = new String[Constants.SPACE_SIZE_HEIGHT][Constants.SPACE_SIZE_WIDTH];

    public Space(){
        alienGroup = new AlienGroup();
        spaceship = new Spaceship(Constants.SPACESHIP_COL_STARTING_POS , Constants.SPACESHIP_ROW_STARTING_POS);
        player = new Player();
        bullets = new ArrayList<bullet>();
    }

    public void start(){
        
        while(gameOver()==false){
            try {
                updateSpace();
                showSpace();
                Thread.sleep(Constants.TIME_UNIT);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }   
        }
        System.out.println("GAME OVER");
    }

    public void createdSpace(){
        for (int row = 0; row < space.length ; row++) {
            for (int col = 0; col <space[row].length ; col++) {
                space[row][col] = this.FONT_SPACE;
            }
        }
    }

    public void showSpace(){
        System.out.println("\n\n* * * SPACE INVADERS * * *\n");
        for (int row = 0; row < space.length ; row++) {
            for (int col = 0; col <space[row].length ; col++) {
                System.out.print(space[row][col]);
            }
            System.out.println();
        }
        System.out.println("\n Lives: \n\n\n");
    }

    public void updateSpace(){
        createdSpace();
        updateAliens();
        updateSpaceship();
        aliensShoot();
        playerPlays();
        checkBulletCollitions();
        updateBullets();
        moveBullets();
        moveAliens();
    }

    public boolean gameOver(){
        if (alienGroup.gotToTheSpaceship()) {
            return true;
        } else {
            return false;
        }
    }

    public void updateAliens(){
        ArrayList<Alien>aliens=alienGroup.getAliens();
        for (Alien alien : aliens) {
            int col=alien.getXPos();
            int row=alien.getYPos();
            if(alien.isAlive() == true){
                space[row][col] = this.FONT_ALIEN;
            }
        }
    }
    
    public void moveAliens(){
        //Every 10 time units aliens move
        if(alienMovingTurnCount%Constants.ALIEN_MOVING_TURN==0){
            alienGroup.moveAliens();
            alienMovingTurnCount+=1; 
        }else{
            this.alienMovingTurnCount+=1;
        }
    }
    
    public void aliensShoot(){
        if (alienShootTurnCount%Constants.ALIEN_BULLET_TURN==0) {
            bullets.add(alienGroup.alienGroupShoot());
            alienShootTurnCount += 1;
        } else {
            alienShootTurnCount += 1;
        }
    }

    public void playerPlays(){
        playerMoves();
        playerShoot();
    }

    public void updateSpaceship(){
            int col=spaceship.getPosX();
            space[Constants.SPACE_SIZE_HEIGHT-1][col]=FONT_SPACESHIP; 
    }

    public void updateBullets(){  
        for (bullet bullet : bullets) {
            if(bullet.bulletExist){
                int row = bullet.getPosY();
                int col = bullet.getPosX(); 
                space[row][col]=FONT_BULLET;
            }
        }
    }

    public void moveBullets(){
        for (bullet bullet : bullets) {
            bullet.bulletAdvance();
        }

    }

    public void playerMoves(){
        
        String direction = "";
        int random = (int)(Math.random()*5);
        if(random == 2){
            direction = player.makeAMove();
            if (direction.equals("Right")) {
                spaceship.moveToRight();
            } else {
                spaceship.moveToLeft();
            }
        }
    }

    public void playerShoot(){
        
        if (playerShootTurnCount%Constants.PLAYER_BULLET_TURN==0) {
            bullets.add(spaceship.shoot());
            playerShootTurnCount += 1;
        } else {
            playerShootTurnCount += 1;
        }
    }

    public void checkBulletCollitions(){
        ArrayList<Alien> aliens = alienGroup.getAliens();
        for (int i = 0; i < bullets.size(); i++) {
            bullet bulletPos = bullets.get(i);
            if(bulletPos.exist()){
                checkBulletOnBulletCollition();
                checkBulletOnAlienCollition();
                checkBulletOnSpaceshipCollition();
            }
        }
    }

    public void checkBulletOnBulletCollition(){

    }

    public void checkBulletOnAlienCollition(){

    }

    public void checkBulletOnSpaceshipCollition(){

    }
}