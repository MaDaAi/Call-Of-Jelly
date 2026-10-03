/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly.SFX;

import callofjelly.GameResources;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author mans5320, zunair, vedant
 * @date Jan 3 2026
 * @filename ShootSFX
 * @description a class specifically meant for the Shoot sound
 */
public class ShootSFX {

    //Fields 
    private static boolean allowCSFX = true;
    private static AudioInputStream ShootMusic;
    private static Clip ShootEffect; // Clip used to play title music

    public static void play() {
        if (BasicSFXstuff.getSFXtogglevalue() == 0) {// If the toggleValue is 0 
            try {
                //First we load in the sound effects/music.
                ShootMusic = GameResources.openAudio("/callofjelly/audio/shoot.wav");//imports our sound
                ShootEffect = AudioSystem.getClip();// Create a Clip to hold and control audio playback
                ShootEffect.open(ShootMusic);//Open and load the audio into the clip
                ShootEffect.start(); //plays the clip 

            } catch (Exception e) {
                System.out.println(e + "Shoot file not found");
            }
        }

    }

    //getters
    public static boolean isAllowCSFX() {
        return allowCSFX;
    }

    public static AudioInputStream getShootMusic() {
        return ShootMusic;
    }

    public static Clip getShootEffect() {
        return ShootEffect;
    }

    //setters
    public static void setAllowCSFX(boolean allowCSFX) {
        ShootSFX.allowCSFX = allowCSFX;
    }

    public static void setShootMusic(AudioInputStream ShootMusic) {
        ShootSFX.ShootMusic = ShootMusic;
    }

    public static void setShootEffect(Clip ShootEffect) {
        ShootSFX.ShootEffect = ShootEffect;
    }
}
