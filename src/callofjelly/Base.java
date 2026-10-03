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
 * @filename Base
 * @description: a class meant to represent the base/tower that the player has
 * to defend, has hitbox meant for buy station and for the enemies, and health
 */
public class Base extends Entity {

    // Constructor
    public Base(int x, int y, int width, int height, int maxHealth) {
        super("Base", maxHealth, x, y, 0);

        // Setting a hitbox 
        setHitBox(new Rectangle(x, y, width, height));

    }

    // Draw method (Testing purposes)
    public void draw(Graphics2D g2, int cameraX) {
//        g2.setColor(Color.red);
//        g2.drawRect(getHitBox().x - cameraX, getHitBox().y, getHitBox().width, getHitBox().height);
        //this.hitBox = new Rectangle (x + cameraX, y, width, height);
    }

    //Getters & Setter 
    public int getX() {
        return getPosX();
    }

    public int getY() {
        return getPosY();
    }

}
