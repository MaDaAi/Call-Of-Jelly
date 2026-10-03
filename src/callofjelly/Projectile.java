/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author vedant, Mansoor, Zunair
 * @date Jan 5, 2026
 * @filename Projectile
 * description: A class for creating the projectile and moving them
 */
public class Projectile {
    // fields 
    private double x;
    private double y;
    private double speed; 
    private double angle; 
    private Rectangle hitbox; 
    private int damage;
    
    //Constructor 
    public Projectile(int x, int y, double angle){
        this.x = x;
        this.y = y;
        this.speed = 20; // setting speed
        this.angle = angle;
        this.hitbox = new Rectangle((int)this.x, (int)this.y, 5, 5); 
        this.damage = 1;
    }//end of constructor
    
    //method for drawing projectile
    public void draw(Graphics2D g2, int cameraX){
        //creating circle for projectile 
        Color bulletColor = new Color(175, 155, 96); // adding color 
        g2.setColor(bulletColor);
        
        // Calculate the x pos with camera 
        int screenX = (int)(this.x - cameraX);
        
        // drawing bullet 
        g2.fillOval(screenX, (int)this.y, 10, 10);
        g2.setColor(Color.black);
        g2.drawOval(screenX, (int)this.y, 10, 10);
    }//end of drawing method
    
    // method for bullet 
    // made into a boolean method so that if the projectile goes off screen
    public boolean move(int cameraX, int screenWidth, int screenHeight){
        // x component and y component 
        double xSpeed = (Math.cos(this.angle) * this.speed); // cos
        double ySpeed = (Math.sin(this.angle) * this.speed); // sin
        this.x = (this.x + xSpeed); // updates the x position 
        this.y = (this.y + ySpeed); // updates the y position
        
        //updates the hitbox 
        this.hitbox = new Rectangle((int)this.x, (int)this.y, 5, 5);
        
        // Calculate the x pos with camera for checking if its off screen 
        int screenX = (int)(this.x - cameraX);
        
        // if the projectile is off screen 
        if (screenX < 0 || screenX > screenWidth || this.y < 0 || this.y > screenHeight){
            return true;
        }
        
        return false;
    }//end of movement method

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
    
    
}