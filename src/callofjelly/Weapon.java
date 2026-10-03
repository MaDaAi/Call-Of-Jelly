/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import callofjelly.SFX.EmptyGunSFX;
import callofjelly.SFX.ReloadSFX;
import callofjelly.SFX.ShootSFX;
import java.util.ArrayList;

/**
 *
 * @author Mansoor, Vedant, Zunair
 * @date Jan 5, 2026
 * @filename Weapon
 * @description: Class that manages the weapons function which includes
 * shooting, reloading, ammo, and creating the bullets itself. It also tracks
 * mag size, bullet count, reload timing, damage, and bullet speed for the
 * player's weapon system.
 */
public class Weapon {
    
    // fields 
    private String name;
    private int magSize;
    private int currentBulletCount;
    private boolean isReloading;
    private long reloadTime;
    private long reloadStart;
    private int damage;
    private double bulletSpeed;
    private int reloadFrameCount;
    private int reloadTimeinFrames;
    
    //constructor 
    public Weapon(String name, int damage, int magSize, int reloadTime, double bulletSpeed) {
        this.name = name;
        this.damage = damage;
        this.magSize = magSize;
        this.currentBulletCount = magSize;
        this.bulletSpeed = bulletSpeed;
        this.reloadTime = reloadTime;
        this.isReloading = false;
        this.reloadStart = 0;
        this.reloadTimeinFrames = (int) (reloadTime * 60);

    }// end of constructor 

    public boolean shoot(int playerX, int playerY, int targetX, int targetY, ArrayList<Projectile> projectileList) {

        if (isReloading) { // if reloading then can't shoot
            return false; // can't shoot when reloading
        }

        if (currentBulletCount <= 0) { // if no bullets 
            EmptyGunSFX.play(); // play the empty Gun sound 
            return false; // can't shoot when no bullets 
        }

        int gunLocX = playerX + 25; // Half of 117 width
        int gunLocY = playerY + 25;

        // calcualte the angle 
        int xDistance = targetX - gunLocX;
        int yDistance = targetY - gunLocY;
        double angle = (Math.atan2(yDistance, xDistance));

        // create projectile object and set speed, damage, and add to projectile  
        Projectile projectile = new Projectile(gunLocX, gunLocY, angle);
        projectile.setDamage(damage);
        projectile.setSpeed(bulletSpeed);
        projectileList.add(projectile); // add to arraylist

        currentBulletCount--; // remove bullet every time after shoot
        ShootSFX.play(); // play the shooting sound

        return true;
    }// end of shoot

    public boolean startReload() {
        // if already reloading or if bulletCount is max then return false
        if (isReloading == true || currentBulletCount >= magSize) {
            return false;
        }

        isReloading = true; // set to true
        reloadTimeinFrames = 0;// start at 0 frames
        ReloadSFX.play();

        return true;

    }// end of startReload

    // method for updating every frame
    public void update() {

        if (isReloading == true) {

            reloadTimeinFrames++; // count up every frame

            if (reloadTimeinFrames >= reloadTime) { // if the time in frames counts up to the set time
                finishReload(); // finisih the reload 
            }
        }
    }// end of update 

    public void finishReload() {
        currentBulletCount = magSize; // full mag
        isReloading = false; // set reloading to false 
        reloadTimeinFrames = 0; // reset the frames again
    }// end of finishReload 

    public void upgradeDamage(int multiplier) { // for the buy station upgrade 
        this.damage = damage * multiplier;
    }

    public void upgradeMagSize(int upgrade) {
        this.magSize = magSize + upgrade;
        this.currentBulletCount = currentBulletCount + upgrade;
    }

    public String ammoDisplay() {
        return currentBulletCount + "/" + magSize;
    }

    public String getName() {
        return name;
    }

    public int getMagSize() {
        return magSize;
    }

    public int getCurrentBulletCount() {
        return currentBulletCount;
    }

    public boolean isIsReloading() {
        return isReloading;
    }

    public long getReloadTime() {
        return reloadTime;
    }

    public long getReloadStart() {
        return reloadStart;
    }

    public int getDamage() {
        return damage;
    }

    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public void setMagSize(int magSize) {
        this.magSize = magSize;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setReloadTime(long reloadTime) {
        this.reloadTime = reloadTime;
    }

}// end of class
