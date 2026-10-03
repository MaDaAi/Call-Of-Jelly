/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * @author vedant, Mansoor, Zunair
 * @date Jan 5, 2026
 * @filename Alien
 * @description: a class meant for one enemy (alien) which extends enemy, meant
 * to be one of the players opponents.
 */
public abstract class Alien extends Enemy{
    // Fields 
    private Image currentImage; //this will be the image that represents the player
    
    private static int alienHeight = 96;
    private static int alienAttackCooldown = 45;
    private int currentTime = 0; // tracks how much time has passed since last frame update
    private int timeDelay = 5; // variable used to slow down animations
    
    private int widthAlien = 97;
    private boolean facingRight = true;
    
    //Animations
    private FrameAnimation alienidle;
    private FrameAnimation alienwalking;
    private FrameAnimation alienattack;
    

    private FrameAnimation alienstate; // tracks the current animation state
    
    // Constructor
    public Alien(int posX, int posY, int speed, int attackDamage) {
        super("Alien", 2, posX, posY, speed, attackDamage, true);
        // Creating aliens hitbox
        setHitBox(new Rectangle(posX, posY, alienHeight, widthAlien));
        this.setPointValue(2); // set alien value to 2 point
        this.alienidle = new FrameAnimation("alienidle", 2, true);
        this.alienwalking = new FrameAnimation("alienwalking", 5, true);
        this.alienattack = new FrameAnimation("alienattack", 5, true);
        this.alienstate = this.alienidle;  // defaults to idle

        this.currentImage = this.alienidle.getNextFrame();
    }
    
    @Override
    public void target(int targetX, int targetY) {
        // If alien isnt alive then exit the method 
        if (!isAlive()) {
            return;
        }
        
        if (this.alienstate != this.alienwalking) {//only change animation if not already walking
            this.alienstate = this.alienwalking; // UPDATES TO WALKING STATE *************
            this.alienwalking.setCurrentFrame(0);
        }
        
        if (getPosX() > targetX) { //we are to the right of the player
            setPosX(getPosX()- getSpeed());//so we move to the left
            this.facingRight = false;
            setWidthAlien(156);
        }
        if (getPosX() < targetX) { //we are to the left of the player
            setPosX(getPosX() + getSpeed());//so we move to the right
            this.facingRight = true;
            setWidthAlien(-156);
        }
    }
    
    @Override
    public String getEnemyType(){ // get enemyType
        return "Alien";
    }
    
    @Override
    // Movement logic for alien
    public void move(Player player, Base base){
        target(player.getPosX(), player.getPosY()); // only targets player therefor only following the player
        this.alienstate = this.alienwalking;
        if (this.getHitBox().intersects(player.getHitbox())) {
            alienstate = alienattack;
        }
    }
    
    @Override
    // Attack logic for alien
    public void attack(Player player, Base base){
        // Checks if the attack cooldown is greater than 0, if so it exits the method
        if (getHitCooldown() > 0){
            return;
        }
        
        // Checks if the hitbox of the alien is overlapping the player 
        if(getHitBox().intersects(player.getHitbox())){
            //Stops moving the alien
            stop();
            // The player takes damage
            player.takeDamage(getAttackDamage());
            // resets the cooldown timer to make the alien wait before hitting again
            setHitCooldown(alienAttackCooldown); 
        }else{
            // If the alien isnt colliding then it is still moving 
            setSpeed(6);
        }
    }
    
    @Override
    public void draw(Graphics2D g2, int cameraX) {
        // Checks if the image is null 
        if (currentImage == null) {
           return;
        }
        
        // Used for tracking the frames
        this.currentTime = this.currentTime + 1;
        // Checks if it has been enough frames before it updates the animation
        if (this.currentTime > this.timeDelay) {
            //if enough time has passed
            this.currentTime = 0;
            //move to next frame
            this.currentImage = this.alienstate.getNextFrame();
        }

        // Calculating the screen position
        int screenX = getPosX() - cameraX;
        
        // If facing right
        if (facingRight) {
            g2.drawImage(this.currentImage, screenX + 156, this.getPosY() - 50 , getWidthAlien(), 160, null);
        } 
        // If facing left 
        else {
            g2.drawImage(this.currentImage, screenX, this.getPosY() - 50 , getWidthAlien(), 160, null);
        }
        
//      Testing purposes (Hitboxes)
//        g2.setColor(Color.red);
//        g2.drawRect(screenX, getPosY(), getHitBox().width, getHitBox().height);
    }

    private void stop() {
        setSpeed(0); // stop the zombie from moving 
    }
    
    public void setWidthAlien(int widthAlien) {
        this.widthAlien = widthAlien;
    }

    public static int getAlienHeight() {
        return alienHeight;
    }

    public int getWidthAlien() {
        return widthAlien;
    }
}