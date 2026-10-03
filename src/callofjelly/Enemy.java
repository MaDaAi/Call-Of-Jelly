/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * @author Zunair, Mansooor, Vedant
 * @date Dec 17, 2025
 * @filename Enemy
 * @description This is the Enemy class, a class that will contain code for
 * enemies found in the game (Zombies, Brutes, and aliens) classes. We also have
 * code created for preventing overlapping of the same enemy, enemy collisions,
 * etc.
 */
public abstract class Enemy extends Entity {

    // Fields
    private int attackDamage;     // The amount of damage delt in one hit
    private int HitCooldown;      // The wait inbetween attacks 
    private int pointValue;       // Points you get from killing an enemy 

    // Constructor
    public Enemy(String entityName, int maxHealth, int posX, int posY, int speed, int attackDamage, boolean hurts) {
        super(entityName, maxHealth, posX, posY, speed); // Didnt hard code so we can change in later sub classes
        this.attackDamage = attackDamage;
        this.pointValue = 0; // keep it zero and then set it in the individual classes 
    }//End of Enemy constructor

    //Abstraction
    public abstract String getEnemyType(); // Gets the enemy type

    public abstract void move(Player player, Base base); // Movement for enemies

    public abstract void attack(Player player, Base base); // Attacking for enemies

    public abstract void target(int targetX, int targetY); // Targetting methods for enemies (Who & what they target to attack)

    public abstract void draw(Graphics2D g, int cameraX); // Updated to accept cameraX

    public void update(Player player, Base base) {
        // If enemy is dead then exit this method 
        if (isAlive() == false) {
            return;
        }

        // Call move to update the enemies position 
        move(player, base); // call move method

        // updating the hitbox position
        Rectangle hitBox = getHitBox();
        hitBox.x = getPosX();
        hitBox.y = getPosY();

        // If the enemy is on attack cooldown then lower the cooldown by 1 each frame 
        if (HitCooldown > 0) { // if hit cooldown is active then decrease it back to zero
            HitCooldown--;
        }
    }

    public void seperate(Enemy other) {
        // If this object is the same as other object then your comparing the same thing, so then you exit this method 
        if (this == other) {
            return;
        }

        // if the enemy's are same then dont seperate 
        if (!this.getEnemyType().equals(other.getEnemyType())) {
            return;
        }

        //getting/setting the hitboxes 
        Rectangle thisHitBox = this.getHitBox();
        Rectangle otherHitBox = other.getHitBox();

        boolean isTouching = thisHitBox.intersects(otherHitBox); // a boolean for if the hitboxes are colliding (same enemy)

        if (isTouching == true) { // if they are colliding 
            //Calculating the middle of each of the hitboxes
            int thisCenterX = this.getPosX() + (thisHitBox.width / 2);
            int otherCenterX = other.getPosX() + (otherHitBox.width / 2);

            //Gotta calculate the distance from the center of each other
            int overLapX = Math.abs(thisCenterX - otherCenterX);
            // Calculating the minimum distance from the center of 1 zombie to another (What they should be moved to)
            int minDistance = (thisHitBox.width + otherHitBox.width) / 2;
            //How much are they overlapping
            int overLapAmnt = minDistance - overLapX;

            //If overLapAmnt is bigger than 0
            if (overLapAmnt > 0) {
                // How far you push each enemy 
                int pushDistance = (overLapAmnt + 2) / 2;

                //Moving each of the enemies apart based on where they are in the moment
                // If this is smaller than other
                if (thisCenterX < otherCenterX) {
                    // This will be pushed left
                    this.setPosX(this.getPosX() - pushDistance);
                    // Other will be pushed right
                    other.setPosX(other.getPosX() + pushDistance);
                } else {
                    // This will be pushed right
                    this.setPosX(this.getPosX() + pushDistance);
                    // Other will be pushed left
                    other.setPosX(other.getPosX() - pushDistance);
                }

                // Updating Hitboxs
                thisHitBox.x = this.getPosX();
                otherHitBox.x = other.getPosX();
            }
        }
    }

    // method for checking collison between enemy and projectile, hence the projectile arraylist as parameter
    public boolean enemyCollison(ArrayList<Projectile> projectileList) {
        // if enemy isn't alive then return false since no collsion 
        if (!isAlive()) {
            return false;
        }

        // Checks through each bullet in the list starting from the last one (Going backwards to remove the bullets without skipping over any)
        // You skip if going forward because after one is removed then everything shifts and then it skips the one that comes after what was removed because it has already gone over that index 
        for (int i = projectileList.size() - 1; i >= 0; i--) {
            // Getting the current projectile 
            Projectile currentProjectile = projectileList.get(i);
            //Does the bullets hitbox collide with this enemy's hitbox 
            if (currentProjectile.getHitbox().intersects(this.getHitBox())) { // if the hitboxes intersect 
                this.takeDamage(currentProjectile.getDamage()); // dealing damage to enemy by bullet damage
                // Delete this bullet from the game (It hit something so it doesn't have a use anymore)
                projectileList.remove(i);
                // if enemy was alive before damage and isnt alive now after damage
                if (!this.isAlive()) { // if this enemy isnt alive
                    return true; // enemy was killed by collision 
                }// end of if
            }// end of if
        }// end of for
        return false; // enemy isn't killed by collision
    }

    // Getters & Setters
    public int getHitCooldown() {
        return HitCooldown;
    }

    public void setHitCooldown(int HitCooldown) {
        this.HitCooldown = HitCooldown;
    }

    //allows the enemy to attack an entity like the base or player
    public void attack(Entity target) {
        //call the targets takeDamage method to reduce its health through using the attackDamage of the mob 
        target.takeDamage(attackDamage);
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
}
