/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author Zunair, Mansoor, Vedant
 * @date Dec 17, 2025
 * @filename Waves
 * @description This is the Waves class, a class that will contain code for
 * waves and spawning logic used in the game.
 */
public class Waves {
    
    //FIELDS 
    // Wave counter
    private int waveNumber = 0;

    // Spawn positions
    private int spawnLeftX = -200;
    private int spawnRightX = 4000;
    private int zombieSpawnY = 732;
    private int bruteSpawnY = 630;
    private int alienSpawnY = 765;

    //ArrayList<Enemy> enemies -> array list for all of the enemies 
    //Array list of <Enemy>(Enenmy objects) with enemies representing all enemies in the current wave 
    public void startNextWave(ArrayList<Enemy> enemies) {
        //Increases the wave number 
        waveNumber++;

        // Removes any leftover enemies (removes all items from the list) 
        enemies.clear();

        // Rules of the wave
        // 1-3: Number of the zombies increase
        // 4-6: Number of the Brutes increase with the zombies being there (9 Zombies (ZombieM))
        // 7-9: Number of the aliens increase with the zombies and brutes being there (9 zombies and 6 brutes (BruteM)) (6 Aliens (AlienM))
        // 10 and onward: every mob will increase differently 
        // zombie: 9 + (waveNumber - 9)x2
        // Brute & Alien: 6 + (waveNumber -9)
        // Going to calculate how many spawn each wave
        int zombiesSpawn = 0;
        int brutesSpawn = 0;
        int aliensSpawn = 0;

        // if wave number is from 1-3 then ...
        if (waveNumber >= 1 && waveNumber <= 3) {
            // Waves 1-3: Zombies only (2, 4, 6)
            zombiesSpawn = waveNumber * 2;

            // if wave number is from 4-6 then ...
        } else if (waveNumber >= 4 && waveNumber <= 6) {
            // Waves 4-6: Zombies fixed at 9, brutes increase (2, 4, 6)
            zombiesSpawn = 9;
            brutesSpawn = (waveNumber - 3) * 2; // Wave 4: 2, Wave 5: 4, Wave 6: 6
            // if wave number is from 7-9 then ...  
        } else if (waveNumber >= 7 && waveNumber <= 9) {
            // Waves 7-9: All enemy types, zombies and brutes fixed, aliens increase
            zombiesSpawn = 9;
            brutesSpawn = 6;
            aliensSpawn = (waveNumber - 6) * 2; // Wave 7: 2, Wave 8: 4, Wave 9: 6
            // Anything greater than 9   
        } else {
            // Wave 10+: All enemies keep increasing by Wavenumber - 9
            int increase = waveNumber - 9; // How many waves beyond wave 9
            zombiesSpawn = 9 + (increase * 2);
            brutesSpawn = 6 + increase;
            aliensSpawn = 6 + increase;
        }

        // Spawn enemies
        spawnZombies(enemies, zombiesSpawn);
        spawnBrutes(enemies, brutesSpawn);
        spawnAliens(enemies, aliensSpawn);
    }

    // METHODS FOR SPAWNING IN ZOMBIES
    private void spawnZombies(ArrayList<Enemy> enemies, int zombiesSpawn) {
        // counters for left and right spawns (Used to offset the spawns of enemies)
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < zombiesSpawn; i++) {
            int spawnX;

            // Alternate between left (Even) and right (Odd)
            if (i % 2 == 0) {
                // Spawn on left side with increasing offset
                spawnX = spawnLeftX - leftCount * 220;
                leftCount++;
            } else {
                // Spawn on right side with increasing offset
                spawnX = spawnRightX + rightCount * 220;
                rightCount++;
            }
            // Adding in new zombie objects to an array 
            enemies.add(new Zombie(spawnX, zombieSpawnY, 4, 5) {
            });
        }
    }

    // METHODS FOR SPAWNING IN BRUTES 
    private void spawnBrutes(ArrayList<Enemy> enemies, int brutesSpawn) {
        // Counters for left and right spawn positions (Used to offset the spawns of enemies)
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < brutesSpawn; i++) {
            int spawnX;

            // Alternate between left (Even) and right (Odd)
            if (i % 2 == 0) {
                spawnX = spawnLeftX - leftCount * 220;
                leftCount++;
            } else {
                spawnX = spawnRightX + rightCount * 220;
                rightCount++;
            }
            // Adding in new Brute objects to an array 
            enemies.add(new Brute(spawnX, bruteSpawnY, 2, 10) {
            });
        }
    }

    // METHODS FOR SPAWNING IN ALIENS  
    private void spawnAliens(ArrayList<Enemy> enemies, int aliensSpawn) {
        // Counters for left and right spawn positions (Used to offset the spawns of enemies)
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < aliensSpawn; i++) {
            int spawnX;

            // Alternate between left (Even) and right (Odd)
            if (i % 2 == 0) {
                spawnX = spawnLeftX - leftCount * 220;
                leftCount++;
            } else {
                spawnX = spawnRightX + rightCount * 220;
                rightCount++;
            }
            // Adding in new alien objects to an array 
            enemies.add(new Alien(spawnX, alienSpawnY, 6, 3) {
            });
        }
    }

    // Checks if the wave is done through using the number of enemies left on the field 
    public boolean isWaveComplete(ArrayList<Enemy> enemies) {
        // Loops through each enemy in our list (it will start at 0 and keep looping until the last enemy in the list)
        for (int i = 0; i < enemies.size(); i++) {
            // Checks if the enemy that its checking is alive or not
            if (enemies.get(i).isAlive()) {
                // Even if one enemy is alive then it will return false
                // to show that the wave isnt complete
                return false;
            }
        }
        // Once we get to this point and if the code runs this then it signals that 
        // all the enemies are dead and it will start a new wave
        return true;
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
