/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * @author vedant, Mansoor, Zunair
 * @date Jan 5, 2026
 * @filename Brute
 * @description: a class meant for one enemy (brute) which extends enemy, meant
 * to be one of the bases opponents.
 */
public abstract class Brute extends Enemy { 

    //Fields
    private Image currentImage;
    private int bruteWidth = 185;
    private int bruteHeight = 234;
    private int bruteAttackCooldown = 100;

    //the four different animations we can use
    private FrameAnimation bruteidle;
    private FrameAnimation brutewalking;
    private FrameAnimation bruteattack;

    // for image flipping 
    private boolean facingRight = true;

    private FrameAnimation brutestate; // tracks the current animation state
    private int timeDelay = 5; // variable used to slow down animations
    private int currentTime = 0; // tracks how much time has passed since last frame update

    // Constructor     
    public Brute(int posX, int posY, int speed, int attackDamage) {
        super("Brute", 3, posX, posY, speed, attackDamage, true);
        setHitBox(new Rectangle(posX, posY, bruteWidth, bruteHeight));
        this.setPointValue(3); // set brute value to 3 point
        this.bruteidle = new FrameAnimation("bruteidle", 10, true);
        this.brutewalking = new FrameAnimation("brutewalking", 6, true);
        this.bruteattack = new FrameAnimation("bruteattack", 7, true);
        this.brutestate = this.bruteidle;  // defaults to idle

        this.currentImage = this.bruteidle.getNextFrame();
    }

    @Override
    public void target(int targetX, int targetY) {
        // If brute isnt alive then exit the method 
        if (!isAlive()) {
            return;
        }

        if (this.brutestate != this.brutewalking) {//only change animation if not already walking
            this.brutestate = this.brutewalking; // UPDATES TO WALKING STATE *************
            this.brutewalking.setCurrentFrame(0);
        }

        if (getPosX() > targetX) { //we are to the right of the player
            setPosX(getPosX() - getSpeed());//so we move to the left
            this.facingRight = true;
            setBruteWidth(-500);
        }
        if (getPosX() < targetX) { //we are to the left of the player
            setPosX(getPosX() + getSpeed());//so we move to the right
            this.facingRight = false;
            setBruteWidth(-500);
        }
    }

    @Override
    public String getEnemyType() {
        return "Brute";
    }

    @Override
    // Movement logic for brute
    public void move(Player player, Base base) {
        target(base.getX(), base.getY()); // only target base
        if (this.getHitBox().intersects(base.getHitBox())) { // If brute collides base 
            this.brutestate = this.bruteattack;
        }
    }

    @Override
    // Attack logic for brute
    public void attack(Player player, Base base) {
        // Checks if the attack cooldown is greater than 0, if so it exits the method
        if (getHitCooldown() > 0) {
            return;
        }
        // If brute hitbox collide base hitbox then ...
        if (getHitBox().intersects(base.getHitBox())) {
            stop(); // Stop mocing 
            base.takeDamage(getAttackDamage()); // Base takes damage
            // resets the cooldown timer to make the alien wait before hitting again            
            setHitCooldown(bruteAttackCooldown);
        } else {
            setSpeed(2);
        }
    }

    @Override
    public void draw(Graphics2D g2, int cameraX) {
        if (currentImage == null) {
            return;
        }

        this.currentTime = this.currentTime + 1;
        if (this.currentTime > this.timeDelay) {
            //if enough time has passed
            this.currentTime = 0;
            //move to next frame
            this.currentImage = this.brutestate.getNextFrame();
        }

        // Calculating screen position
        int screenX = getPosX() - cameraX;

        if (facingRight) {
            g2.drawImage(this.currentImage, screenX + 260, this.getPosY() - 256, this.getBruteWidth(), 500, null);
        } else {
            g2.drawImage(this.currentImage, screenX - 90, this.getPosY() - 256, this.getBruteWidth() * -1, 500, null);
        }

        // visually drawing the hitbox (Testing purposes)
//        g2.setColor(Color.red);
//        g2.drawRect(screenX, getPosY(), getHitBox().width, getHitBox().height);
    }

    private void stop() {
        setSpeed(0); // stop the zombie from moving 
    }

    public void setBruteWidth(int bruteWidth) {
        this.bruteWidth = bruteWidth;
    }

    public int getBruteHeight() {
        return bruteHeight;
    }

    public int getBruteWidth() {
        return bruteWidth;
    }

    public void setBruteHeight(int bruteHeight) {
        this.bruteHeight = bruteHeight;
    }

}
