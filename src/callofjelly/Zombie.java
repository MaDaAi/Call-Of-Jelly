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
 * @filename Zombie
 * @description: a class meant for one enemy (zombie) which extends enemy, meant
 * to be one of the players & bases opponents.
 */
public abstract class Zombie extends Enemy {

    //FIELDS  
    private int zombieWidth = 67;
    private static int zombieHeight = 130;
    private static int zombieAttackCooldown = 60;

    private Image currentImage;
    private boolean facingRight = true; // for flipping the image 

    // Animation
    //the four different animations we can use
    private FrameAnimation zombieidle;
    private FrameAnimation zombiewalking;
    private FrameAnimation zombieattack;

    private FrameAnimation zombiestate; // tracks the current animation state
    private int timeDelay = 5; // variable used to slow down animations
    private int currentTime = 0; // tracks how much time has passed since last frame update

    // Constructor
    public Zombie(int posX, int posY, int speed, int attackDamage) {
        super("Zombie", 1, posX, posY, speed, attackDamage, true);
        setHitBox(new Rectangle(posX, posY, zombieWidth, zombieHeight));
        this.setPointValue(1); // set zombie value to 1 point
        this.zombieidle = new FrameAnimation("zombieidle", 8, true);
        this.zombiewalking = new FrameAnimation("zombiewalking", 8, true);
        this.zombieattack = new FrameAnimation("zombieattack", 6, false);
        this.zombiestate = this.zombieidle;  // defaults to idle
        this.currentImage = this.zombieidle.getNextFrame();
    }

    @Override
    public void target(int targetX, int targetY) {
        // If alien isnt alive then exit the method 
        if (!isAlive()) {
            return;
        }

        if (this.zombiestate != this.zombiewalking) {//only change animation if not already walking
            this.zombiestate = this.zombiewalking; // UPDATES TO WALKING STATE *************
            this.zombiewalking.setCurrentFrame(0);
        }

        if (getPosX() > targetX) { //we are to the right of the target
            setPosX(getPosX() - getSpeed());//so we move to the left
            this.facingRight = true;
            setZombieWidth(-120);
        } else if (getPosX() < targetX) { //we are to the left of the target
            setPosX(getPosX() + getSpeed());//so we move to the right
            this.facingRight = false;
            setZombieWidth(-120);
        }
    }

    @Override
    public String getEnemyType() {
        return "Zombie";
    }

    @Override
    // Movement logic for alien
    public void move(Player player, Base base) {
        if (!getHitBox().intersects(base.getHitBox())) { // if zombie isn't interacting with base
            target(player.getPosX(), player.getPosY()); // then keep targeting the player 
        }

        if (this.getHitBox().intersects(player.getHitbox())) { // if hitbox is interacting with player hitbox
            this.zombiestate = this.zombieattack; // play attacking animation
        }

        if (this.getHitBox().intersects(base.getHitBox())) { // if hitbox is coliding with base
            stop(); // set speed to 0
            this.zombiestate = this.zombieattack; // play the attacking animation
        }
    }

    @Override
    // Attack logic for zombie
    public void attack(Player player, Base base) {
        // Checks if the attack cooldown is greater than 0, if so it exits the method
        if (getHitCooldown() > 0) {
            return;
        }
        // Resets the frame
        this.zombieattack.setCurrentFrame(0);
        // Checks if the hitbox of the alien is overlapping the player 
        if (getHitBox().intersects(player.getHitbox())) {
            stop(); // Set the speed to 0 (wont move)
            this.zombiestate = this.zombieattack;
            player.takeDamage(getAttackDamage()); // Player takes damage 
            // resets the cooldown timer to make the zombie wait before hitting again
            setHitCooldown(60);
        } else {
            // If the alien isnt colliding then it is still moving 
            setSpeed(4);
        }
        // If zombie colliding with the base 
        if (getHitBox().intersects(base.getHitBox())) {
            this.zombiestate = this.zombieattack;
            // Base takes damage
            base.takeDamage(getAttackDamage());
            // resets the cooldown timer to make the zombie wait before hitting again
            setHitCooldown(60);
        }
    }

    // Method to set the speed to 0 essentialy stopping movement 
    private void stop() {
        setSpeed(0); // stop the zombie from moving
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
            this.currentImage = this.zombiestate.getNextFrame();
        }

        // Calculate the x pos with camera 
        int screenX = getPosX() - cameraX;

        // If facing right
        if (facingRight) {
            g2.drawImage(this.currentImage, screenX + 90, this.getPosY() - 30, getZombieWidth(), 160, null);
        } // If facing left
        else {
            g2.drawImage(this.currentImage, screenX - 30, this.getPosY() - 30, getZombieWidth() * -1, 160, null);
        }

        //Testing purposes
//        g2.setColor(Color.red);
//        g2.drawRect(screenX, getPosY(), getHitBox().width, getHitBox().height);
    }

    public void setZombieWidth(int zombieWidth) {
        this.zombieWidth = zombieWidth;
    }

    public int getZombieWidth() {
        return zombieWidth;
    }

    public static void setZombieHeight(int zombieHeight) {
        Zombie.zombieHeight = zombieHeight;
    }

    public static int getZombieHeight() {
        return zombieHeight;
    }
}
