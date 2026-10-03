/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Zunair, Mansooor, Vedant
 * @date Dec 16, 2025
 * @filename Entity
 * @description This is the entity class, a parent class for the enemy and
 * player classes.
 */
public abstract class Entity {
    // All the fields of every single entity 

    private String entityName;
    private int currentHealth;
    private int maxHealth;
    private int posX;
    private int posY;
    private int speed;
    private boolean alive;
    private Rectangle hitBox;

    private int width;
    private int height;
    private Image image;

    // The constructor (alive and current health aren't part of parameter because these are known fields)
    public Entity(String entityName, int MaxHealth, int posX, int posY, int speed) {
        this.entityName = entityName;
        this.maxHealth = MaxHealth;
        this.currentHealth = MaxHealth; // the current health is still max because no dmg taken
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.alive = true;
        this.width = width;
        this.height = height;
        this.hitBox = new Rectangle(posX, posY, width, height);
    }// end of constructor

    //GETTERS & SETTERS 
    // getter for alive 
    public boolean isAlive() {
        //safe guard to not allow extra hits
        if (currentHealth <= 0) {//if health is less than 0 or equal to
            return false;
        }
        return alive;

    }// end of isAlive()

    // setter for alive
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    //Used in other areas to check if theres been a collision with any of the entities with another object
    public Rectangle getHitBox() {
        return hitBox;
    }

    // hitbox setter // Check Again
    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    // method for when the entity takes damage
    public void takeDamage(int damage) {
        currentHealth = currentHealth - damage; // the currentHealth is the currenthealth - damage -> Makes sure that it updates the current health after taking damage
        if (currentHealth <= 0) {
            currentHealth = 0;
            alive = false; // entity isn't alive
        }//end of if
    }// end of takeDamage()

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getEntityName() {
        return entityName;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        hitBox.x = posX; // Update hitbox position when X changes
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        hitBox.y = posY; // Update hitbox position when Y changes
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}// end of Entity Class
