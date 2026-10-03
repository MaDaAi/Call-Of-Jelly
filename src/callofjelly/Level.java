/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Mansoor, Vedant, Zunair
 * @date Jan 5, 2026
 * @filename Levels
 * @description: methods that can be put here to allow for an easier time for
 * implementing new maps
 */
public class Level {

    // fields
    private int playerX = 960; // player X position 
    private int playerY = 720; // player Y position
    private int playerCameraX = 960; // Player camera X position

    private int cameraX = 0; //  used to adjust the postion ( side scrolling)
    private int cameraDir; //-1 left, 1 right, 0 stop
    private int cameraSpeed = 10; //speed of camera

    private int pointCount;
    private int zombieKill;
    private int bruteKill;
    private int alienKill;

    //For creating a wave timer
    //To check if theres a wave happening right now
    private boolean waveInProgress = true;
    //The delay between each wave
    private int waveDelay = 300;
    //Is going to count down each wave 
    private int waveTimer = 0;

    // Creating objects
    Player player = new Player(playerX, playerY, 117, 148, 100);
    Weapon currentWeapon = new Weapon("A.R", 1, 30, 90, 20.0);
    Waves waves = new Waves();
    ArrayList<Enemy> enemies = new ArrayList<>();
    Base base = new Base(1732, 641, 551, 197, 200);
    ArrayList<Projectile> projectileList = new ArrayList();

    public Level() {
        waves.startNextWave(enemies); // start the waves here
    }

    public void interacting(int keyCode) {
        // or if buy station menu is open 
        if (keyCode == 65) {      // A
            setCameraDir(-1);
            player.setXDirection(-1);
            player.setState(player.getWalking());
        }// end of A
        if (keyCode == 68) {      // D
            setCameraDir(1);
            player.setXDirection(1);
            player.setState(player.getWalking());
        }// end of D

        if (keyCode == 82) { // R
            currentWeapon.startReload();
        }// end of R
    }

    public void bulletDamage() {
        currentWeapon.setDamage(currentWeapon.getDamage() * 2);// double the damage
        pointCount = pointCount - 150; // deduct point count
    }

    public void shoot(int mouseX, int mouseY) {
        //shooting mechanics 
        boolean shotFired;
        // Use player's world position for mouse comparison 
        boolean mouseRightSide = mouseX > player.getPosX();//if mouseX is more right then the player
        boolean mouseLeftSide = mouseX < player.getPosX();//if mouseX is more left then the player

        //shooting restrictions at idle
        if (player.getState() == player.getIdle()) {//if the player is idle
            if (mouseRightSide) {//if the mouse is on the right side of the player
                player.setWidthPlayer(player.getWidth());//Sets players width to a positive value 
                player.setFacingRight(true);//make player face right
                shotFired = currentWeapon.shoot(player.getPosX(), player.getPosY(), mouseX, mouseY, projectileList);//shoot since shoot method is true 
            } else if (mouseLeftSide) {//if mouse is on the left side of the player
                player.setWidthPlayer(-player.getWidth());//Sets players width to a negative value 
                player.setFacingRight(false);//make player face left
                shotFired = currentWeapon.shoot(player.getPosX(), player.getPosY(), mouseX, mouseY, projectileList);//shoot since shoot method is true
            }
        }

        //shooting restrictions at walking (Doesnt let you shoot without facing in the same direction as your shooting while walking)
        if (player.getState() == player.getWalking()) {//if player walking
            if (mouseRightSide && player.getFacingRight()) {//if the mouse is on the right side of the player and the player is facing right
                shotFired = currentWeapon.shoot(player.getPosX(), player.getPosY(), mouseX, mouseY, projectileList);//shoot
            } else if (mouseLeftSide && !player.getFacingRight()) {//if mouse is on the left side of the player and the player is facing left
                shotFired = currentWeapon.shoot(player.getPosX(), player.getPosY(), mouseX, mouseY, projectileList);//shoot
            }
        }
    }// end of shoot

    //method to update projectile
    public void updateProjectile(int screenWidth, int screenHeight) {
        for (int projectileCounter = 0; projectileCounter < projectileList.size(); projectileCounter++) {
            Projectile currentP = projectileList.get(projectileCounter);
            // move the projectile and check if it is off screen
            boolean offScreen = currentP.move(cameraX, screenWidth, screenHeight);

            // if the bullet moves offscreen
            if (offScreen == true) {
                projectileList.remove(currentP); // remove it
            }
        }//end of projectile loop
    }// end of updateProjecitle()

    //method to update the camera
    public void updateCamera() {
        // Update camera based on direction
        cameraX = cameraX + (cameraDir * cameraSpeed);

        // to prevent going out of bounds
        if (cameraX < 0) {
            cameraX = 0;
        }
        if (cameraX > 2000) {
            cameraX = 2000;
        }

        // Update players position with the camera (player stays at screen X=960, the camera is moving)
        playerX = cameraX + 960;
        player.setPosX(playerX);
    }// end of updateCamera()

    // method to update player
    public boolean updatePlayer(boolean aKey, boolean dKey) {

        // Sync hitbox 
        player.updateHitbox();

        player.move(aKey, dKey);//moves the player
        currentWeapon.update(); // update firing

        return true; // update player
    }// end of updatePlayer() 

    // Seperating like enemies
    private void enemySeperation() {
        for (int i = 0; i < enemies.size(); i++) {
            // gets enemies at position i 
            Enemy enemy1 = enemies.get(i);
            // If enemy isnt alive then go move past this index 
            if (!enemy1.isAlive()) {
                continue;
            }
            // counter a = i + 1; a is smaller than enemies.size; a++
            // Compares enemy1 with all enemies that will come after ts 
            // Also doesnt allow it to compare the same set again through the i+1
            for (int a = i + 1; a < enemies.size(); a++) {
                // gets enemy at index a and stores it in enemy2
                Enemy enemy2 = enemies.get(a);
                // Skip the rest is enemy2 isnt alive 
                if (!enemy2.isAlive()) {
                    continue;
                }
                // If everything goes right then enemy1 and enemy 2 seperate
                enemy1.seperate(enemy2);
            }
        }
    }// end of enemySeperation()

    public boolean updateEnemy() {
        for (int index = 0; index < enemies.size(); index++) {
            Enemy enemy = enemies.get(index);

            if (enemy.isAlive() == false) { // if enemy is already dead then skip to the next itreation (enemy) 
                continue;
            }

            // update enemy positions 
            enemy.update(player, base);

            // if collison happens between projectile and enemy and enemy dies
            if (enemy.enemyCollison(projectileList) == true) {
                enemiesDisplay(enemy); // update the kill and point count 
                enemies.remove(index); // remove enemy from list after updating
            } else {
                enemy.attack(player, base); // attack if the enemy is alive
            } // end of checking collison if
        }// end of enemies for

        enemySeperation(); // call enemySeperation outside of loop so it only seperates once 

        return true;
    }// end of updateEnemy()

    // Kill count
    private void enemiesDisplay(Enemy enemy) { // method for adding the enemies 

        pointCount = pointCount + enemy.getPointValue(); // update the point count by the enemy's point value
        //check if we are alr at max(1 billion)
        if (pointCount >= 1000000000) {
            pointCount = 1000000000; // cap it at 1 billion
        }
        String enemyType = enemy.getEnemyType(); // get enemy's type
        if (enemyType.equals("Zombie")) { // if enemy is zombie then increment kill counter
            zombieKill++;

        } else if (enemyType.equals("Brute")) { // if enemy is brute then increment kill counter
            bruteKill++;

        } else if (enemyType.equals("Alien")) { // if enemy is alien then increment kill counter
            alienKill++;

        }

    }

    //Updating waves 
    public void updateWaves() {
        if (waves.isWaveComplete(enemies) && waveInProgress) {
            waveInProgress = false; // Shows that the wave is now done
            waveTimer = waveDelay;// It now changes the timer to start 
        }
        if (!waveInProgress) { // When waves isnt in progress
            //Reduces each frame (directly lowers the timer because the "seconds" are affected through the use of frames)
            waveTimer--;
            if (waveTimer <= 0) { // When waves is smaller than or equal to 0 
                waves.startNextWave(enemies); // Next wave starts
                waveInProgress = true; // Sets waveInProgress to true
            }
        }
    }// end of updateWaves()

    public void drawProjectile(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int projectileCounter = 0; projectileCounter < projectileList.size(); projectileCounter++) {
            projectileList.get(projectileCounter).draw(g2, cameraX); // Pass cameraX for drawing offset
        }//end of projectile loop
    }

    public void drawEnemy(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int index = 0; index < enemies.size(); index++) {
            Enemy enemy = enemies.get(index);
            if (enemy.isAlive()) {
                enemy.draw(g2, cameraX); // Pass cameraX for drawing offset IDK WHAT THIS IS ***** 
            }
        }
    }

    public String formatPoints() {
        return formatNumber(getPointCount());
    }

    public String formatNumber(int number) {//an exact way of getting number withtout rounding
        //%d is the integer
        //.  decimal point
        //%02 decimal places 2 places (hundreths0
        //k/m/b k = thousand, m = million, b = billion
        if (number >= 1000000000 || number < 0) {//it will go neg if you get past i think like 2. some billion so just have the less than 0 as a safe guard, if its more or equal to a billion too.
            //for Billions
             return String.valueOf("GG");//returnigng something to say in the stats for gg because 1B is a big enough level cap a lil easter egg
        } else if (number >= 1000000) {
            //for millions
            int wholePart = number / 1000000;
            int decimalPart = (number % 1000000) / 10000;//getting first 2 decimal places
            return String.format("%d.%02dM", wholePart, decimalPart);//returnigng something to say in the stats

        } else if (number >= 1000) {
            //for thousands
            int wholePart = number / 1000;
            int decimalPart = (number % 1000) / 10;//getting first 2 decimal places
            return String.format("%d.%02dK", wholePart, decimalPart);//returnigng something to say in the stats
        } else {
            //less than 1000 no formating needed
            return String.valueOf(number);//returnigng something to say in the stats
        }
    }


    public String formatZombieKills() {//format kills for the type
        return formatNumber(getZombieKill());//formating it
    }

    public String formatBruteKills() {//format kills for the type
        return formatNumber(getBruteKill());//formating it
    }

    public String formatAlienKills() {//format kills for the type
        return formatNumber(getAlienKill());//formating it
    }



    // Getters & Setters
    public int getCameraDir() {
        return cameraDir;
    }

    public void setCameraDir(int cameraDir) {
        this.cameraDir = cameraDir;
    }

    public int getCameraX() {
        return cameraX;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public Player getPlayer() {
        return player;
    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public Waves getWaves() {
        return waves;
    }

    public Base getBase() {
        return base;
    }

    public int getZombieKill() {
        return zombieKill;
    }

    public int getBruteKill() {
        return bruteKill;
    }

    public int getAlienKill() {
        return alienKill;
    }

    public int getWaveTimer() {
        return waveTimer;
    }

}// end of level class
